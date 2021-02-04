//# sourceURL=system_mailbox.js
require(["jquery", "nav.active", "responsive.bootstrap4"], function ($, navActive) {

    /*
    参数
    */
    var param = {
        acceptMail: ''
    };

    /*
     web storage key.
    */
    var webStorageKey = {
        ACCEPT_MAIL: 'SYSTEM_MAILBOX_ACCEPT_MAIL_SEARCH'
    };

    function getAjaxUrl() {
        return {
            mailboxes: web_path + '/web/system/mailbox/paging',
            page: '/web/menu/system/mailbox'
        }
    }

    navActive(getAjaxUrl().page);

    var tableElement = $('#dataTable');

    var myTable = tableElement.DataTable({
        autoWidth: false,
        searching: false,
        stateSave: true,// 打开客户端状态记录功能。这个数据是记录在cookies中的，打开了这个记录后，即使刷新一次页面，或重新打开浏览器，之前的状态都是保存下来的
        stateSaveCallback: function (settings, data) {
            localStorage.setItem('SYSTEM_MAILBOX_' + settings.sInstance, JSON.stringify(data))
        },
        stateLoadCallback: function (settings) {
            return JSON.parse(localStorage.getItem('SYSTEM_MAILBOX_' + settings.sInstance))
        },
        "processing": true, // 打开数据加载时的等待效果
        "serverSide": true,// 打开后台分页
        "aaSorting": [[1, 'desc']],// 排序
        "ajax": {
            "url": getAjaxUrl().mailboxes,
            "dataSrc": "data",
            "data": function (d) {
                // 添加额外的参数传给服务器
                initSearchContent();
                var searchParam = getParam();
                d.extra_search = JSON.stringify(searchParam);
            }
        },
        "columns": [
            {"data": "acceptMail"},
            {"data": "sendTimeNew"},
            {"data": "sendCondition"}
        ],
        "language": {
            "sProcessing": "处理中...",
            "sLengthMenu": "显示 _MENU_ 项结果",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "<",
                "sNext": ">",
                "sLast": "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        },
        "dom": "<'row'<'col-lg-2 col-md-12'l><'#global_button.col-lg-2 col-md-12'><'col-lg-8 col-md-12'<'#mytoolbox'>>r>" +
            "t" +
            "<'row'<'col-sm-5'i><'col-sm-7'p>>",
        initComplete: function () {
            // 初始化搜索框中内容
            initSearchInput();
        }
    });

    var html = '<div class="row ">' +
        '<div class="col-md-9 pd-t-2"><input type="text" id="search_email" class="form-control form-control-sm" placeholder="邮箱" /></div>' +
        '<div class="col-md-3 pd-t-2 text-right "><div class="btn-group" role="group"><button type="button" id="search" class="btn btn-outline-secondary btn-sm"><i class="fa fa-search"></i>搜索</button>' +
        ' <button type="button" id="reset_search" class="btn btn-outline-secondary btn-sm"><i class="fa fa-repeat"></i>重置</button></div></div>' +
        '</div>';
    $('#mytoolbox').append(html);

    var global_button = '<button type="button" id="refresh" class="btn btn-light btn-sm"><i class="fa fa-refresh"></i>刷新</button>';
    $('#global_button').append(global_button);

    function getParamId() {
        return {
            acceptMail: '#search_email'
        };
    }

    /*
     得到参数
     */
    function getParam() {
        return param;
    }

    function initParam() {
        param.acceptMail = $(getParamId().acceptMail).val();
        if (typeof (Storage) !== "undefined") {
            sessionStorage.setItem(webStorageKey.ACCEPT_MAIL, param.acceptMail);
        }
    }

    /*
        初始化搜索内容
         */
    function initSearchContent() {
        var acceptMail = null;
        if (typeof (Storage) !== "undefined") {
            acceptMail = sessionStorage.getItem(webStorageKey.ACCEPT_MAIL);
        }
        if (acceptMail !== null) {
            param.acceptMail = acceptMail;
        }
    }

    /*
   初始化搜索框
    */
    function initSearchInput() {
        var acceptMail = null;
        if (typeof (Storage) !== "undefined") {
            acceptMail = sessionStorage.getItem(webStorageKey.ACCEPT_MAIL);
        }
        if (acceptMail !== null) {
            $(getParamId().acceptMail).val(acceptMail);
        }
    }

    function cleanParam() {
        $(getParamId().acceptMail).val('');
    }

    $(getParamId().acceptMail).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            myTable.ajax.reload();
        }
    });

    $('#search').click(function () {
        initParam();
        myTable.ajax.reload();
    });

    $('#reset_search').click(function () {
        cleanParam();
        initParam();
        myTable.ajax.reload();
    });

    $('#refresh').click(function () {
        myTable.ajax.reload();
    });
});