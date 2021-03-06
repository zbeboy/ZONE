//# sourceURL=roster_release.js
require(["jquery", "lodash", "tools", "handlebars", "nav.active", "sweetalert2", "messenger", "jquery.address", "jquery.simple-pagination"],
    function ($, _, tools, Handlebars, navActive, Swal) {

        /*
         ajax url.
         */
        var ajax_url = {
            data: web_path + '/web/campus/roster/release/paging',
            add: '/web/campus/roster/release/add',
            edit: '/web/campus/roster/release/edit',
            del: web_path + '/web/campus/roster/release/delete',
            review: '/web/campus/roster/review/list',
            register: '/web/campus/roster/data/add',
            data_edit: '/web/campus/roster/data/edit',
            data_del: web_path + '/web/campus/roster/data/delete',
            data_look: '/web/campus/roster/data/look',
            authorize: '/web/campus/roster/authorize/add',
            page: '/web/menu/campus/roster'
        };

        navActive(ajax_url.page);

        /*
         参数
         */
        var param = {
            pageNum: 0,
            length: 2,
            displayedPages: 3,
            orderColumnName: 'releaseTime',
            orderDir: 'desc',
            extraSearch: JSON.stringify({
                title: ''
            })
        };

        /*
        web storage key.
        */
        var webStorageKey = {
            TITLE: 'CAMPUS_ROSTER_TITLE_SEARCH',
            PAGE_NUM: 'CAMPUS_ROSTER_PAGE_NUM'
        };

        /*
         参数id
         */
        var param_id = {
            title: '#search_title'
        };

        var tableData = '#tableData';

        /*
         清空参数
         */
        function cleanParam() {
            $(param_id.title).val('');
        }

        /**
         * 刷新查询参数
         */
        function refreshSearch() {
            if (typeof (Storage) !== "undefined") {
                sessionStorage.setItem(webStorageKey.TITLE, $(param_id.title).val());
                sessionStorage.setItem(webStorageKey.PAGE_NUM, "0");
            }
        }

        /*
         搜索
         */
        $('#search').click(function () {
            refreshSearch();
            init();
        });

        /*
         重置
         */
        $('#reset_search').click(function () {
            cleanParam();
            refreshSearch();
            init();
        });

        $('#refresh').click(function () {
            init();
        });

        $(param_id.title).keyup(function (event) {
            if (event.keyCode === 13) {
                refreshSearch();
                init();
            }
        });

        /*
         发布
         */
        $('#release').click(function () {
            $.address.value(ajax_url.add);
        });

        /*
        权限分配
        */
        $('#authorize').click(function () {
            $.address.value(ajax_url.authorize);
        });

        /**
         * 列表数据
         * @param data 数据
         */
        function listData(data) {
            var template = Handlebars.compile($("#roster-template").html());
            Handlebars.registerHelper('qrCodeUrl', function () {
                return new Handlebars.SafeString(Handlebars.escapeExpression(web_path + '/' + this.qrCodeUrl));
            });
            $(tableData).html(template(data));
        }

        /*
         编辑
         */
        $(tableData).delegate('.edit', "click", function () {
            $.address.value(ajax_url.edit + '/' + $(this).attr('data-id'));
        });

        /*
         删除
         */
        $(tableData).delegate('.del', "click", function () {
            del($(this).attr('data-id'), $(this).attr('data-name'));
        });

        /*
         统计
        */
        $(tableData).delegate('.review', "click", function () {
            $.address.value(ajax_url.review + '/' + $(this).attr('data-id'));
        });

        /*
         登记
        */
        $(tableData).delegate('.data_add', "click", function () {
            $.address.value(ajax_url.register + '/' + $(this).attr('data-id'));
        });

        /*
         数据编辑
        */
        $(tableData).delegate('.data_edit', "click", function () {
            $.address.value(ajax_url.data_edit + '/' + $(this).attr('data-id'));
        });

        /*
         数据删除
        */
        $(tableData).delegate('.data_del', "click", function () {
            dataDel($(this).attr('data-id'));
        });

        /*
        数据查看
        */
        $(tableData).delegate('.data_look', "click", function () {
            $.address.value(ajax_url.data_look + '/' + $(this).attr('data-id'));
        });

        /**
         * 删除
         * @param id
         * @param name
         */
        function del(id, name) {
            Swal.fire({
                title: "确定删除 '" + name + "' 吗？",
                text: "花名册删除！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: '#d33',
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                preConfirm: function () {
                    sendDelAjax(id);
                }
            });

        }

        /**
         * 删除ajax
         * @param id
         */
        function sendDelAjax(id) {
            $.ajax({
                type: 'POST',
                url: ajax_url.del,
                data: {id: id},
                success: function (data) {
                    Messenger().post({
                        message: data.msg,
                        type: data.state ? 'success' : 'error',
                        showCloseButton: true
                    });

                    if (data.state) {
                        init();
                    }
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

        /**
         * 删除
         * @param id
         */
        function dataDel(id) {
            Swal.fire({
                title: "确定删除登记吗？",
                text: "花名册登记删除！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: '#d33',
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                preConfirm: function () {
                    sendDataDelAjax(id);
                }
            });

        }

        /**
         * 删除ajax
         * @param id
         */
        function sendDataDelAjax(id) {
            $.ajax({
                type: 'POST',
                url: ajax_url.data_del,
                data: {id: id},
                success: function (data) {
                    Messenger().post({
                        message: data.msg,
                        type: data.state ? 'success' : 'error',
                        showCloseButton: true
                    });

                    if (data.state) {
                        init();
                    }
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

        init();
        initSearchInput();

        /**
         * 初始化数据
         */
        function init() {
            initSearchContent();
            tools.dataLoading();
            $.get(ajax_url.data, param, function (data) {
                tools.dataEndLoading();
                createPage(data);
                listData(data);
            });
        }

        /*
        初始化搜索内容
       */
        function initSearchContent() {
            var title = null;
            var pageNum = null;
            var params = {
                title: ''
            };
            if (typeof (Storage) !== "undefined") {
                title = sessionStorage.getItem(webStorageKey.TITLE);
                pageNum = sessionStorage.getItem(webStorageKey.PAGE_NUM);
            }
            if (title !== null) {
                params.title = title;
            } else {
                params.title = $(param_id.title).val();
            }

            if (pageNum !== null) {
                param.pageNum = pageNum;
            } else {
                param.pageNum = 0;
            }
            param.extraSearch = JSON.stringify(params);
        }

        /*
        初始化搜索框
        */
        function initSearchInput() {
            var title = null;
            if (typeof (Storage) !== "undefined") {
                title = sessionStorage.getItem(webStorageKey.TITLE);
            }
            if (title !== null) {
                $(param_id.title).val(title);
            }
        }

        /**
         * 创建分页
         * @param data 数据
         */
        function createPage(data) {
            $('#pagination').pagination({
                pages: data.page.totalPages,
                displayedPages: data.page.displayedPages,
                currentPage: data.page.pageNum,
                hrefTextPrefix: '',
                prevText: '<',
                nextText: '>',
                cssStyle: '',
                listStyle: 'pagination',
                onPageClick: function (pageNumber, event) {
                    // Callback triggered when a page is clicked
                    // Page number is given as an optional parameter
                    if (typeof (Storage) !== "undefined") {
                        sessionStorage.setItem(webStorageKey.PAGE_NUM, pageNumber);
                    }
                    nextPage(pageNumber);
                }
            });
        }

        /**
         * 下一页
         * @param pageNumber 当前页
         */
        function nextPage(pageNumber) {
            param.pageNum = pageNumber;
            tools.dataLoading();
            $.get(ajax_url.data, param, function (data) {
                tools.dataEndLoading();
                listData(data);
            });
        }

    });