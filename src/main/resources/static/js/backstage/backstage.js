requirejs.config({
    map: {
        '*': {
            'css': web_path + '/webjars/require-css/css.min.js' // or whatever the path to require-css is
        }
    },
    // pathsオプションの設定。"module/name": "path"を指定します。拡張子（.js）は指定しません。
    paths: {
        "csrf": web_path + "/js/util/csrf",
        "tools": web_path + "/js/util/tools",
        "ajax.loading.view": web_path + "/js/util/ajax.loading.view",
        "nav.active": web_path + "/js/util/nav.active",
        "bootstrap": web_path + "/plugins/bootstrap/js/bootstrap.bundle.min",
        "bracket": web_path + "/plugins/bracket/js/bracket.min",
        "perfect-scrollbar.jquery": web_path + "/plugins/perfect-scrollbar/js/perfect-scrollbar.jquery.min",
        "peity": web_path + "/plugins/peity/jquery.peity.min",
        "moment": web_path + "/plugins/moment/moment.min",
        "moment-with-locales": web_path + "/plugins/moment/moment-with-locales.min",
        "jquery.showLoading": web_path + "/plugins/loading/js/jquery.showLoading.min",
        "jquery.address": web_path + "/plugins/jquery-address/jquery.address-1.6.min",
        "jquery.simple-pagination": web_path + "/plugins/jquery-simple-pagination/jquery.simplePagination.min",
        "dropify": web_path + "/plugins/file-uploads/js/dropify.min",
        "sweetalert2": web_path + "/plugins/sweetalert2/sweetalert2.all.min",
        "select2": web_path + "/plugins/select2/js/select2.min",
        "select2-zh-CN": web_path + "/plugins/select2/js/i18n/zh-CN.min"
    },
    // shimオプションの設定。モジュール間の依存関係を定義します。
    shim: {
        "tools": {
            deps: ["jquery"]
        },
        "bootstrap": {
            deps: ["jquery"]
        },
        "peity": {
            deps: ["jquery"]
        },
        "perfect-scrollbar.jquery": {
            deps: ["jquery"]
        },
        "bracket": {
            deps: ["jquery", "perfect-scrollbar.jquery", "peity"]
        },
        "messenger": {
            deps: ["jquery"]
        },
        "jquery.showLoading": {
            deps: ["jquery"]
        },
        "jquery.address": {
            deps: ["jquery"]
        },
        "jquery.simple-pagination": {
            deps: ["jquery", "css!" + web_path + "/plugins/jquery-simple-pagination/simplePagination.min"]
        },
        "dropify": {
            deps: ["jquery", "css!" + web_path + "/plugins/file-uploads/css/dropify.min"]
        },
        "sweetalert2": {
            deps: ["jquery", "css!" + web_path + "/plugins/sweetalert2/sweetalert2.min"]
        },
        "select2-zh-CN": {
            deps: ["jquery", "select2"]
        }
    }
});

/*
 捕获全局错误
 */
requirejs.onError = function (err) {
    console.log(err.requireType);
    if (err.requireType === 'timeout') {
        console.log('modules: ' + err.requireModules);
    }
    throw err;
};

// require(["module/name", ...], function(params){ ... });
require(["jquery", "requirejs-domready", "moment-with-locales", "handlebars", "ajax.loading.view", "nav.active",
        "bootstrap", "bracket", "csrf", "jquery.address"],
    function ($, domready, moment, Handlebars, loadingView, navActive) {
        domready(function () {
            Messenger.options = {
                extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
                theme: 'flat'
            };

            moment.locale('zh-cn');

            /*
             动态链接点击效果
             */
            $('.dy_href').click(function () {
                $.address.title($(this).text() + '-' + $('#webAppName').text());
                var href = $(this).attr('href');
                if (href !== 'javascript:;' && href !== '#') {
                    navActive(href.substring(1));
                }
            });

            /*
             init jquery address.
             */
            var isInitAddress = false;
            var isInitOnAddress = false;
            $.address.init(function (event) {
                // 插件初始化,一般这里调用 $('.nav a').address(); 实现链接单击监听
                $('.dy_href').address();
                isInitAddress = true;
            }).change(function (event) {
                // 当页面地址更改的时候调用,即#号之后的地址更改
                if (event.value !== '/' && event.value !== '/javascript:;' && event.value !== '/#') {
                    if (!isInitAddress) {
                        isInitOnAddress = false;
                    }
                    if (!isInitOnAddress) {
                        loadingView(event.value, '#page-wrapper', web_path);
                    } else {
                        isInitOnAddress = false;
                    }
                }
            });

            function initAddressRefresh() {
                if (!isInitAddress) {
                    var url = window.location.href;
                    if (url.lastIndexOf('#') > 0) {
                        isInitOnAddress = true;
                        loadingView(url.substring(url.lastIndexOf('#') + 1), '#page-wrapper', web_path);
                    }
                }
            }

            var ajax_url = {
                user_notify: web_path + '/user/data/notify',
                user_notify_detail: web_path + '/user/notify/detail',
                user_notify_reads: web_path + '/user/notify/reads',
                system_notify: web_path + '/user/system/notify'
            };

            var user_notify_param_id = {
                userNotifyIcon: '#userNotifyIcon',
                userNotifyData: '#userNotifyData',
                userNotifyReads: '#userNotifyReads'
            };

            var system_notify_param_id = {
                systemNotifyData: '#systemNotifyData'
            };

            var user_notify_param = {
                pageNum: 0,
                length: 4,
                displayedPages: 4,
                orderColumnName: 'createDate',
                orderDir: 'desc',
                extraSearch: JSON.stringify({
                    isSee: 0
                })
            };

            var modal_id = {
                userNotifyModal: '#userNotifyModal'
            };

            init();

            function init() {
                initUserNotify();
                initSystemNotify();
                initAddressRefresh();
            }

            // 轮询扫描通知
            setInterval(initUserNotify, 30000);

            function initUserNotify() {
                $.ajax({
                    type: 'GET',
                    url: ajax_url.user_notify,
                    data: user_notify_param,
                    success: function (data) {
                        if (data.page.totalSize > 0) {
                            $(user_notify_param_id.userNotifyIcon).addClass('square-8');
                        } else {
                            $(user_notify_param_id.userNotifyIcon).removeClass('square-8');
                        }

                        generateUserNotifyHtml(data);
                    },
                    error: function (XMLHttpRequest) {
                        Messenger().post({
                            message: 'Request error : ' + XMLHttpRequest.status + " " + XMLHttpRequest.statusText,
                            type: 'error',
                            showCloseButton: true
                        });
                    }
                });
            }

            function generateUserNotifyHtml(data) {
                if (data.page.totalSize <= 0) {
                    var html = '<p class="text-center pd-x-20 pd-y-15"><small>无任何消息</small></p>';
                    $(user_notify_param_id.userNotifyData).html(html);
                } else {
                    var template = Handlebars.compile($("#user-notify-template").html());

                    Handlebars.registerHelper('create_date', function () {
                        return new Handlebars.SafeString(moment(this.createDateStr, "YYYY-MM-DD HH:mm:ss").fromNow());
                    });

                    $(user_notify_param_id.userNotifyData).html(template(data));
                }
            }

            $(modal_id.userNotifyModal).on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); // Button that triggered the modal
                var id = button.data('id'); // Extract info from data-* attributes

                $.ajax({
                    type: 'GET',
                    url: ajax_url.user_notify_detail + '/' + id,
                    success: function (data) {
                        $('#userNotifyModalTitle').text(data.userNotify.notifyTitle).addClass('text-' + data.userNotify.notifyType);
                        $('#userNotifyModalSendUserInfo').text(data.userNotify.realName + ' 于(' + data.userNotify.createDateStr + ') 发送：');
                        $('#userNotifyModalContent').text(data.userNotify.notifyContent);
                        $('#userNotifyModal').modal('show');
                    },
                    error: function (XMLHttpRequest) {
                        Messenger().post({
                            message: 'Request error : ' + XMLHttpRequest.status + " " + XMLHttpRequest.statusText,
                            type: 'error',
                            showCloseButton: true
                        });
                    }
                });
            }).on('shown.bs.modal', function (event) {
                // 变为已读
                var button = $(event.relatedTarget); // Button that triggered the modal
                var id = button.data('id'); // Extract info from data-* attributes
                $.post(ajax_url.user_notify_reads, {userNotifyId: id});
            });

            $(user_notify_param_id.userNotifyReads).click(function () {
                var elements = $(user_notify_param_id.userNotifyData + ' > a');
                var ids = [];
                for (var i = 0; i < elements.length; i++) {
                    ids.push($(elements[i]).attr('data-id'));
                }
                if (ids.length > 0) {
                    $.post(ajax_url.user_notify_reads, {userNotifyId: ids.join(',')}, function (data) {
                        initUserNotify();
                    });
                }
            });

            function initSystemNotify() {
                $.ajax({
                    type: 'GET',
                    url: ajax_url.system_notify,
                    success: function (data) {
                        generateSystemNotifyHtml(data);
                    },
                    error: function (XMLHttpRequest) {
                        Messenger().post({
                            message: 'Request error : ' + XMLHttpRequest.status + " " + XMLHttpRequest.statusText,
                            type: 'error',
                            showCloseButton: true
                        });
                    }
                });
            }

            function generateSystemNotifyHtml(data) {
                var template = Handlebars.compile($("#system-notify-template").html());
                $(system_notify_param_id.systemNotifyData).html(template(data));
            }
        });
    });