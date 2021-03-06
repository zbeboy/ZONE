//# sourceURL=users_notify.js
require(["jquery", "tools", "handlebars", "moment-with-locales", "bootstrap",
        "csrf", "jquery.simple-pagination"],
    function ($, tools, Handlebars, moment) {

        moment.locale('zh-cn');

        var ajax_url = {
            user_notify: web_path + '/users/notify/paging',
            user_notify_reads: web_path + '/users/notify/reads'
        };

        var param = {
            pageNum: 0,
            length: 10,
            displayedPages: 3,
            orderColumnName: 'createDate',
            orderDir: 'desc',
            extraSearch: JSON.stringify({
                isSee: 0,
                needCount: 1
            })
        };

        // 只在unRead请求后台更新状态
        var isReadModal = false;

        $('#userNotifyUnRead').click(function () {
            isReadModal = false;
            $('#userNotifyRead').removeClass('active');
            $(this).addClass('active');
            param.pageNum = 0;
            param.extraSearch = JSON.stringify({isSee: 0, needCount: 1});
            init();
        });

        $('#userNotifyRead').click(function () {
            isReadModal = true;
            $('#userNotifyUnRead').removeClass('active');
            $(this).addClass('active');
            param.pageNum = 0;
            param.extraSearch = JSON.stringify({isSee: 1, needCount: 1});
            init();
        });

        var tableData = $('#accordion');
        var initHtml = tableData.html();

        init();

        /**
         * 初始化数据
         */
        function init() {
            tools.dataLoading();
            $.get(ajax_url.user_notify, param, function (data) {
                tools.dataEndLoading();
                if (data.page.totalSize > 0) {
                    $('#unReadNotifyUnReadNum').text(data.unReadNum);
                    $('#readNotifyReadNum').text(data.readNum);
                    createPage(data);
                    listData(data);
                } else {
                    $('#unReadNotifyUnReadNum').text(data.unReadNum);
                    $('#readNotifyReadNum').text(data.readNum);
                    tableData.html(initHtml);
                    $('#pagination').empty();
                }

            });
        }

        /**
         * 创建分页
         * @param data 数据
         */
        function createPage(data) {
            $('#pagination').pagination({
                pages: data.page.totalPages,
                displayedPages: data.page.displayedPages,
                hrefTextPrefix: '',
                prevText: '<',
                nextText: '>',
                cssStyle: '',
                listStyle: 'pagination',
                onPageClick: function (pageNumber, event) {
                    // Callback triggered when a page is clicked
                    // Page number is given as an optional parameter
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
            $.get(ajax_url.user_notify, param, function (data) {
                tools.dataEndLoading();
                listData(data);
            });
        }

        /**
         * 列表数据
         * @param data 数据
         */
        function listData(data) {
            var template = Handlebars.compile($("#user-notify-template").html());

            tableData.html(template(data));
        }

        tableData.delegate('.userNotify', "click", function () {
            if (!isReadModal) {
                var id = $(this).attr('data-id');
                $.post(ajax_url.user_notify_reads, {userNotifyId: id});
            }
        });
    });