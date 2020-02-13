//# sourceURL=internship_review.js
require(["jquery", "lodash", "tools", "handlebars", "nav.active", "messenger", "jquery.address", "jquery.simple-pagination", "jquery-labelauty"],
    function ($, _, tools, Handlebars, navActive) {

        /*
         ajax url.
         */
        var ajax_url = {
            data: web_path + '/web/internship/review/internship/data',
            authorize: '/web/internship/review/authorize',
            audit: '/web/internship/review/audit',
            pass: '/web/internship/review/pass',
            fail: '/web/internship/review/fail',
            base_info_apply: '/web/internship/review/base_info_apply',
            base_info_fill: '/web/internship/review/base_info_fill',
            company_apply: '/web/internship/review/company_apply',
            company_fill: '/web/internship/review/company_fill',
            page: '/web/menu/internship/review'
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
                internshipTitle: '',
                dataRange: 0,
                internshipReleaseIsDel: 0
            })
        };

        var page_param = {
            paramUsersType: $('#paramUsersType').val()
        };

        /*
        web storage key.
        */
        var webStorageKey = {
            INTERNSHIP_TITLE: 'INTERNSHIP_APPLY_INTERNSHIP_TITLE_SEARCH',
            DATA_RANGE: 'INTERNSHIP_APPLY_DATA_RANGE_SEARCH'
        };

        /*
         参数id
         */
        var param_id = {
            internshipTitle: '#search_internship_title',
            dataRange: '#dataRange'
        };

        var tableData = '#tableData';

        /*
         清空参数
         */
        function cleanParam() {
            $(param_id.internshipTitle).val('');
        }

        /**
         * 刷新查询参数
         */
        function refreshSearch() {
            if (typeof(Storage) !== "undefined") {
                sessionStorage.setItem(webStorageKey.INTERNSHIP_TITLE, $(param_id.internshipTitle).val());
                sessionStorage.setItem(webStorageKey.DATA_RANGE, _.isUndefined($("input[name='dataRange']:checked").val()) ? '0' : '1');
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

        $(param_id.internshipTitle).keyup(function (event) {
            if (event.keyCode === 13) {
                refreshSearch();
                init();
            }
        });

        $(param_id.dataRange).click(function () {
            refreshSearch();
            init();
        });

        /**
         * 列表数据
         * @param data 数据
         */
        function listData(data) {
            var template = Handlebars.compile($("#internship-release-template").html());
            $(tableData).html(template(data));
        }

        /*
         审核权限
         */
        $(tableData).delegate('.authorize', "click", function () {
            $.address.value(ajax_url.authorize + '/' + $(this).attr('data-id'));
        });

        /*
         审核
        */
        $(tableData).delegate('.review', "click", function () {
            $.address.value(ajax_url.audit + '/' + $(this).attr('data-id'));
        });

        /*
         通过
        */
        $(tableData).delegate('.pass_apply', "click", function () {
            $.address.value(ajax_url.pass + '/' + $(this).attr('data-id'));
        });

        /*
        未通过
        */
        $(tableData).delegate('.fail_apply', "click", function () {
            $.address.value(ajax_url.fail + '/' + $(this).attr('data-id'));
        });

        /*
       基本信息修改申请
       */
        $(tableData).delegate('.basic_apply', "click", function () {
            $.address.value(ajax_url.base_info_apply + '/' + $(this).attr('data-id'));
        });

        /*
        基本信息修改填写中
        */
        $(tableData).delegate('.basic_fill', "click", function () {
            $.address.value(ajax_url.base_info_fill + '/' + $(this).attr('data-id'));
        });

        /*
        单位信息修改申请
       */
        $(tableData).delegate('.company_apply', "click", function () {
            $.address.value(ajax_url.company_apply + '/' + $(this).attr('data-id'));
        });

        /*
        单位信息修改填写中
       */
        $(tableData).delegate('.company_fill', "click", function () {
            $.address.value(ajax_url.company_fill + '/' + $(this).attr('data-id'));
        });

        init();
        initSearchInput();
        initLabelauty();

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
            var internshipTitle = null;
            var dataRange = null;
            var params = {
                internshipTitle: '',
                dataRange: 0,
                internshipReleaseIsDel: 0
            };
            if (typeof(Storage) !== "undefined") {
                internshipTitle = sessionStorage.getItem(webStorageKey.INTERNSHIP_TITLE);
                dataRange = sessionStorage.getItem(webStorageKey.DATA_RANGE);
            }
            if (internshipTitle !== null) {
                params.internshipTitle = internshipTitle;
            } else {
                params.internshipTitle = $(param_id.internshipTitle).val();
            }

            if (dataRange !== null) {
                params.dataRange = dataRange;
            } else {
                params.dataRange = _.isUndefined($("input[name='dataRange']:checked").val()) ? 0 : 1;
            }
            param.pageNum = 0;
            param.extraSearch = JSON.stringify(params);
        }

        /*
        初始化搜索框
        */
        function initSearchInput() {
            var internshipTitle = null;
            var dataRange = null;
            if (typeof(Storage) !== "undefined") {
                internshipTitle = sessionStorage.getItem(webStorageKey.INTERNSHIP_TITLE);
                dataRange = sessionStorage.getItem(webStorageKey.DATA_RANGE);
            }
            if (internshipTitle !== null) {
                $(param_id.internshipTitle).val(internshipTitle);
            }

            if (dataRange !== null && Number(dataRange) === 1) {
                $(param_id.dataRange).prop('checked', true);
            }
        }

        function initLabelauty() {
            $(".labelauty").labelauty();
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
            $.get(ajax_url.data, param, function (data) {
                tools.dataEndLoading();
                listData(data);
            });
        }

    });