//# sourceURL=system_config.js
require(["jquery", "tools", "handlebars", "nav.active", "sweetalert2", "responsive.bootstrap4", "jquery.address", "messenger"],
    function ($, tools, Handlebars, navActive, Swal) {

        /*
         参数
        */
        var param = {
            dataKey: ''
        };

        var edit_param = {
            dataKey: '',
            dataValue: ''
        };

        var edit_param_id = {
            dataKey: '#editDataKey',
            dataValue: '#editDataValue'
        };

        var button_id = {
            edit: {
                id: '#edit',
                text: '保存',
                tip: '保存中...'
            }
        };

        /*
        web storage key.
       */
        var webStorageKey = {
            DATA_KEY: 'SYSTEM_CONFIG_DATA_KEY_SEARCH'
        };

        /*
         ajax url
         */
        function getAjaxUrl() {
            return {
                data: web_path + '/web/system/config/data',
                update: web_path + '/web/system/config/update',
                page: '/web/menu/system/config'
            };
        }

        navActive(getAjaxUrl().page);

        // 预编译模板
        var template = Handlebars.compile($("#operator_button").html());

        var tableElement = $('#dataTable');

        var myTable = tableElement.DataTable({
            autoWidth: false,
            searching: false,
            "processing": true, // 打开数据加载时的等待效果
            "serverSide": true,// 打开后台分页
            "aaSorting": [[2, 'asc']],// 排序
            "ajax": {
                "url": getAjaxUrl().data,
                "dataSrc": "data",
                "data": function (d) {
                    // 添加额外的参数传给服务器
                    initSearchContent();
                    var searchParam = getParam();
                    d.extra_search = JSON.stringify(searchParam);
                }
            },
            "columns": [
                {"data": "dataKey"},
                {"data": "dataValue"},
                {"data": null}
            ],
            columnDefs: [
                {
                    targets: 2,
                    orderable: false,
                    render: function (a, b, c, d) {

                        var context = {
                            func: [
                                {
                                    "name": "编辑",
                                    "css": "edit",
                                    "type": "primary",
                                    "id": c.dataKey,
                                    "value": c.dataValue
                                }
                            ]
                        };

                        return template(context);
                    }
                }

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
            "dom": "<'row'<'col-lg-2 col-md-12'l><'#global_button.col-lg-4 col-md-12'><'col-lg-6 col-md-12'<'#mytoolbox'>>r>" +
                "t" +
                "<'row'<'col-sm-5'i><'col-sm-7'p>>",
            initComplete: function () {
                tableElement.delegate('.edit', "click", function () {
                    edit($(this).attr('data-id'), $(this).attr('data-value'));
                });

                // 初始化搜索框中内容
                initSearchInput();
            }
        });

        var html = '<div class="row ">' +
            '<div class="col-md-9 pd-t-2"><input type="text" id="search_key" class="form-control form-control-sm" placeholder="参数" /></div>' +
            '<div class="col-md-3 pd-t-2 text-right "><div class="btn-group" role="group"><button type="button" id="search" class="btn btn-outline-secondary btn-sm"><i class="fa fa-search"></i>搜索</button>' +
            '  <button type="button" id="reset_search" class="btn btn-outline-secondary btn-sm"><i class="fa fa-repeat"></i>重置</button></div></div>' +
            '</div>';
        $('#mytoolbox').append(html);

        var global_button = '<button type="button" id="refresh" class="btn btn-light btn-sm"><i class="fa fa-refresh"></i>刷新</button>';
        $('#global_button').append(global_button);

        /*
         参数id
         */
        function getParamId() {
            return {
                dataKey: '#search_key'
            };
        }

        /*
         得到参数
         */
        function getParam() {
            return param;
        }

        /*
         初始化参数
         */
        function initParam() {
            param.dataKey = $(getParamId().dataKey).val();
            if (typeof(Storage) !== "undefined") {
                sessionStorage.setItem(webStorageKey.DATA_KEY, param.dataKey);
            }
        }

        function initDataParam() {
            edit_param.dataKey = $(edit_param_id.dataKey).val();
            edit_param.dataValue = $(edit_param_id.dataValue).val();
        }

        /*
        初始化搜索内容
         */
        function initSearchContent() {
            var dataKey = null;
            if (typeof(Storage) !== "undefined") {
                dataKey = sessionStorage.getItem(webStorageKey.DATA_KEY);
            }
            if (dataKey !== null) {
                param.dataKey = dataKey;
            }
        }

        /*
       初始化搜索框
        */
        function initSearchInput() {
            var dataKey = null;
            if (typeof(Storage) !== "undefined") {
                dataKey = sessionStorage.getItem(webStorageKey.DATA_KEY);
            }
            if (dataKey !== null) {
                $(getParamId().dataKey).val(dataKey);
            }
        }

        /*
         清空参数
         */
        function cleanParam() {
            $(getParamId().dataKey).val('');
        }

        $(getParamId().dataKey).keyup(function (event) {
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

        /*
         编辑
         */
        function edit(dataKey, dataValue) {
            $(edit_param_id.dataKey).val(dataKey);
            $(edit_param_id.dataValue).val(dataValue);
            $('#editModal').modal('show');
        }

        $(button_id.edit.id).click(function () {
            initDataParam();
            sendEditAjax();
        });

        function sendEditAjax() {
            tools.buttonLoading(button_id.edit.id, button_id.edit.tip);
            $.ajax({
                type: 'POST',
                url: getAjaxUrl().update,
                data: edit_param,
                success: function (data) {
                    tools.buttonEndLoading(button_id.edit.id, button_id.edit.text);
                    var globalError = $('#globalEditError');
                    if (data.state) {
                        globalError.text('');
                        $('#editModal').modal('hide');
                        $(edit_param_id.academicTitleId).val('');
                        $(edit_param_id.academicTitleName).val('');
                        myTable.ajax.reload();
                        Swal.fire('保存成功', data.msg, 'success');
                    } else {
                        globalError.text(data.msg);
                    }
                },
                error: function (XMLHttpRequest) {
                    tools.buttonEndLoading(button_id.edit.id, button_id.edit.text);
                    Messenger().post({
                        message: 'Request error : ' + XMLHttpRequest.status + " " + XMLHttpRequest.statusText,
                        type: 'error',
                        showCloseButton: true
                    });
                }
            });
        }
    });