//# sourceURL=internship_distribution_list.js
require(["jquery", "handlebars", "nav.active", "sweetalert2", "responsive.bootstrap4", "check.all", "jquery.address", "messenger"],
    function ($, Handlebars, navActive, Swal) {

        var page_param = {
            paramInternshipReleaseId: $('#paramInternshipReleaseId').val()
        };

        /*
        参数
        */
        var param = {
            studentUsername: '',
            staffUsername: '',
            studentNumber: '',
            staffNumber: '',
            username: '',
            assigner: '',
            internshipReleaseId: page_param.paramInternshipReleaseId
        };

        /*
        web storage key.
        */
        var webStorageKey = {
            STUDENT_USERNAME: 'INTERNSHIP_DISTRIBUTION_CONDITION_STUDENT_USERNAME_SEARCH_' + page_param.paramInternshipReleaseId,
            STAFF_USERNAME: 'INTERNSHIP_DISTRIBUTION_CONDITION_STAFF_USERNAME_SEARCH_' + page_param.paramInternshipReleaseId,
            STUDENT_NUMBER: 'INTERNSHIP_DISTRIBUTION_CONDITION_STUDENT_NUMBER_SEARCH_' + page_param.paramInternshipReleaseId,
            STAFF_NUMBER: 'INTERNSHIP_DISTRIBUTION_CONDITION_STAFF_NUMBER_SEARCH_' + page_param.paramInternshipReleaseId,
            USERNAME: 'INTERNSHIP_DISTRIBUTION_CONDITION_USERNAME_SEARCH_' + page_param.paramInternshipReleaseId,
            ASSIGNER: 'INTERNSHIP_DISTRIBUTION_CONDITION_ASSIGNER_SEARCH_' + page_param.paramInternshipReleaseId
        };

        /*
         ajax url
         */
        function getAjaxUrl() {
            return {
                data: web_path + '/web/internship/teacher_distribution/data',
                del: web_path + '/web/internship/teacher_distribution/delete',
                comparison_del: web_path + '/web/internship/teacher_distribution/comparison_del',
                copy_data: web_path + '/web/internship/teacher_distribution/copy',
                add: '/web/internship/teacher_distribution/add',
                edit: '/web/internship/teacher_distribution/edit',
                batch_distribution_url: '/web/internship/teacher_distribution/distribution',
                exclude_internship_release_data_url: web_path + '/web/internship/teacher_distribution/exclude',
                export_data_url: web_path + '/web/internship/teacher_distribution/export',
                page: '/web/menu/internship/teacher_distribution'
            };
        }

        // 刷新时选中菜单
        navActive(getAjaxUrl().page);

        // 预编译模板
        var template = Handlebars.compile($("#operator_button").html());

        var tableElement = $('#dataTable');

        var myTable = tableElement.DataTable({
            autoWidth: false,
            drawCallback: function (oSettings) {
                $('#checkall').prop('checked', false);
                // 调用全选插件
                $.fn.check({checkall_name: "checkall", checkbox_name: "check"});
            },
            searching: false,
            "processing": true, // 打开数据加载时的等待效果
            "serverSide": true,// 打开后台分页
            "aaSorting": [[4, 'asc']],// 排序
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
                {"data": null},
                {"data": null},
                {"data": "studentRealName"},
                {"data": "studentUsername"},
                {"data": "studentNumber"},
                {"data": "staffRealName"},
                {"data": "staffUsername"},
                {"data": "staffNumber"},
                {"data": "assigner"},
                {"data": "username"},
                {"data": null}
            ],
            columnDefs: [
                {
                    targets: 0,
                    orderable: false,
                    render: function (a, b, c, d) {
                        return '';
                    }
                },
                {
                    targets: 1,
                    orderable: false,
                    render: function (a, b, c, d) {
                        return '<input type="checkbox" value="' + c.studentId + '" name="check"/>';
                    }
                },
                {
                    targets: 10,
                    orderable: false,
                    render: function (a, b, c, d) {

                        var context =
                            {
                                func: [
                                    {
                                        "name": "编辑",
                                        "css": "edit",
                                        "type": "primary",
                                        "id": c.studentId
                                    },
                                    {
                                        "name": "删除",
                                        "css": "del",
                                        "type": "danger",
                                        "id": c.studentId
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
            "dom":  "<'row'<'col-lg-2 col-md-12'l><'#global_button.col-lg-10 col-md-12'>r>" +
                "t" +
                "<'row'<'col-sm-5'i><'col-sm-7'p>>",
            initComplete: function () {
                tableElement.delegate('.edit', "click", function () {
                    edit($(this).attr('data-id'), page_param.paramInternshipReleaseId);
                });

                tableElement.delegate('.del', "click", function () {
                    student_del($(this).attr('data-id'), page_param.paramInternshipReleaseId);
                });

                // 初始化搜索框中内容
                initSearchInput();
            }
        });

        var global_button = '<button type="button" id="add" class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i>添加</button>' +
            '  <button type="button" id="copy" class="btn btn-outline-primary btn-sm"><i class="fa fa-copy"></i>数据拷贝</button>' +
            '  <button type="button" id="dels" class="btn btn-outline-danger btn-sm"><i class="fa fa-trash-o"></i>批量删除</button>' +
            '  <button type="button" id="comparison_dels" class="btn btn-outline-danger btn-sm"><i class="fa fa-trash-o"></i>比对删除</button>' +
            '  <button type="button" id="distributions" class="btn btn-outline-warning btn-sm"><i class="fa fa-reply-all"></i>批量分配</button>' +
            '  <button type="button" id="refresh" class="btn btn-light btn-sm"><i class="fa fa-refresh"></i>刷新</button>';
        $('#global_button').append(global_button);

        /*
         参数id
         */
        function getParamId() {
            return {
                studentUsername: '#search_student_username',
                staffUsername: '#search_staff_username',
                studentNumber: '#search_student_number',
                staffNumber: '#search_staff_number',
                username: '#search_username',
                assigner: '#search_assigner'
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
            param.studentUsername = $(getParamId().studentUsername).val();
            param.staffUsername = $(getParamId().staffUsername).val();
            param.studentNumber = $(getParamId().studentNumber).val();
            param.staffNumber = $(getParamId().staffNumber).val();
            param.username = $(getParamId().username).val();
            param.assigner = $(getParamId().assigner).val();
            if (typeof(Storage) !== "undefined") {
                sessionStorage.setItem(webStorageKey.STUDENT_USERNAME, param.studentUsername);
                sessionStorage.setItem(webStorageKey.STAFF_USERNAME, param.staffUsername);
                sessionStorage.setItem(webStorageKey.STUDENT_NUMBER, param.studentNumber);
                sessionStorage.setItem(webStorageKey.STAFF_NUMBER, param.staffNumber);
                sessionStorage.setItem(webStorageKey.USERNAME, param.username);
                sessionStorage.setItem(webStorageKey.ASSIGNER, param.assigner);
            }
        }

        /*
        初始化搜索内容
       */
        function initSearchContent() {
            var studentUsername = null;
            var staffUsername = null;
            var studentNumber = null;
            var staffNumber = null;
            var username = null;
            var assigner = null;
            if (typeof(Storage) !== "undefined") {
                studentUsername = sessionStorage.getItem(webStorageKey.STUDENT_USERNAME);
                staffUsername = sessionStorage.getItem(webStorageKey.STAFF_USERNAME);
                studentNumber = sessionStorage.getItem(webStorageKey.STUDENT_NUMBER);
                staffNumber = sessionStorage.getItem(webStorageKey.STAFF_NUMBER);
                username = sessionStorage.getItem(webStorageKey.USERNAME);
                assigner = sessionStorage.getItem(webStorageKey.ASSIGNER);
            }
            if (studentUsername !== null) {
                param.studentUsername = studentUsername;
            }

            if (staffUsername !== null) {
                param.staffUsername = staffUsername;
            }

            if (studentNumber !== null) {
                param.studentNumber = studentNumber;
            }

            if (staffNumber !== null) {
                param.staffNumber = staffNumber;
            }

            if (username !== null) {
                param.username = username;
            }

            if (assigner !== null) {
                param.assigner = assigner;
            }
        }

        /*
        初始化搜索框
        */
        function initSearchInput() {
            var studentUsername = null;
            var staffUsername = null;
            var studentNumber = null;
            var staffNumber = null;
            var username = null;
            var assigner = null;
            if (typeof(Storage) !== "undefined") {
                studentUsername = sessionStorage.getItem(webStorageKey.STUDENT_USERNAME);
                staffUsername = sessionStorage.getItem(webStorageKey.STAFF_USERNAME);
                studentNumber = sessionStorage.getItem(webStorageKey.STUDENT_NUMBER);
                staffNumber = sessionStorage.getItem(webStorageKey.STAFF_NUMBER);
                username = sessionStorage.getItem(webStorageKey.USERNAME);
                assigner = sessionStorage.getItem(webStorageKey.ASSIGNER);
            }
            if (studentUsername !== null) {
                $(getParamId().studentUsername).val(studentUsername);
            }

            if (staffUsername !== null) {
                $(getParamId().staffUsername).val(staffUsername);
            }

            if (studentNumber !== null) {
                $(getParamId().studentNumber).val(studentNumber);
            }

            if (staffNumber !== null) {
                $(getParamId().staffNumber).val(staffNumber);
            }

            if (username !== null) {
                $(getParamId().username).val(username);
            }

            if (assigner !== null) {
                $(getParamId().assigner).val(assigner);
            }
        }

        /*
         清空参数
         */
        function cleanParam() {
            $(getParamId().studentUsername).val('');
            $(getParamId().staffUsername).val('');
            $(getParamId().studentNumber).val('');
            $(getParamId().staffNumber).val('');
            $(getParamId().username).val('');
            $(getParamId().assigner).val('');
        }

        $(getParamId().studentUsername).keyup(function (event) {
            if (event.keyCode === 13) {
                initParam();
                myTable.ajax.reload();
            }
        });

        $(getParamId().staffUsername).keyup(function (event) {
            if (event.keyCode === 13) {
                initParam();
                myTable.ajax.reload();
            }
        });

        $(getParamId().studentNumber).keyup(function (event) {
            if (event.keyCode === 13) {
                initParam();
                myTable.ajax.reload();
            }
        });

        $(getParamId().staffNumber).keyup(function (event) {
            if (event.keyCode === 13) {
                initParam();
                myTable.ajax.reload();
            }
        });

        $(getParamId().username).keyup(function (event) {
            if (event.keyCode === 13) {
                initParam();
                myTable.ajax.reload();
            }
        });

        $(getParamId().assigner).keyup(function (event) {
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

        $('#export_xls').click(function () {
            initParam();
            var searchParam = JSON.stringify(getParam());
            var exportFile = {
                fileName: $('#export_file_name').val(),
                ext: 'xls'
            };
            window.location.href = encodeURI(getAjaxUrl().export_data_url + "?extra_search=" + searchParam + "&exportFile=" + JSON.stringify(exportFile));
        });

        $('#export_xlsx').click(function () {
            initParam();
            var searchParam = JSON.stringify(getParam());
            var exportFile = {
                fileName: $('#export_file_name').val(),
                ext: 'xlsx'
            };
            window.location.href = encodeURI(getAjaxUrl().export_data_url + "?extra_search=" + searchParam + "&exportFile=" + JSON.stringify(exportFile));
        });

        /*
         添加
         */
        $('#add').click(function () {
            $.address.value(getAjaxUrl().add + "/" + page_param.paramInternshipReleaseId);
        });

        /*
         批量删除
         */
        $('#dels').click(function () {
            var studentIds = [];
            var ids = $('input[name="check"]:checked');
            for (var i = 0; i < ids.length; i++) {
                studentIds.push($(ids[i]).val());
            }

            if (studentIds.length > 0) {
                var msg;
                msg = Messenger().post({
                    message: "确定删除选中的学生吗?",
                    actions: {
                        retry: {
                            label: '确定',
                            phrase: 'Retrying TIME',
                            action: function () {
                                msg.cancel();
                                dels(studentIds, init_page_param.internshipReleaseId);
                            }
                        },
                        cancel: {
                            label: '取消',
                            action: function () {
                                return msg.cancel();
                            }
                        }
                    }
                });
            } else {
                Messenger().post("未发现有选中的学生!");
            }
        });

        /*
         比对删除
         */
        $('#comparison_dels').click(function () {
            // 需要当前实习id,要被排除的实习id
            $.get(getAjaxUrl().exclude_internship_release_data_url, {id: page_param.paramInternshipReleaseId}, function (data) {
                var html = excludeInternshipReleaseData(data);
                $('#excludeInternships').html(html);
                $('#excludeInternshipModal').modal('show');
            });
        });

        /*
         数据拷贝
         */
        $('#copy').click(function () {
            // 与比对删除数据相同
            $.get(getAjaxUrl().exclude_internship_release_data_url, {id: page_param.paramInternshipReleaseId}, function (data) {
                var html = copyInternshipReleaseData(data);
                $('#copyInternships').html(html);
                $('#copyInternshipModal').modal('show');
            });
        });

        $('#excludeInternshipModalMiss').click(function () {
            $('#exclude_internship_error_msg').addClass('hidden').removeClass('text-danger').text('');
            $('#excludeInternshipModal').modal('hide');
        });

        $('#copyInternshipModalMiss').click(function () {
            $('#copy_internship_error_msg').addClass('hidden').removeClass('text-danger').text('');
            $('#copyInternshipModal').modal('hide');
        });

        /**
         * 要排除的实习数据
         * @param data json数据
         */
        function excludeInternshipReleaseData(data) {
            var template = Handlebars.compile($("#exclude-internship-template").html());

            Handlebars.registerHelper('value', function () {
                return new Handlebars.SafeString(Handlebars.escapeExpression(this.internshipReleaseId));
            });

            Handlebars.registerHelper('name', function () {
                return new Handlebars.SafeString(Handlebars.escapeExpression(this.internshipTitle));
            });

            return template(data);
        }

        /**
         * 要拷贝的实习数据
         * @param data json数据
         */
        function copyInternshipReleaseData(data) {
            var template = Handlebars.compile($("#copy-internship-template").html());

            Handlebars.registerHelper('value', function () {
                return new Handlebars.SafeString(Handlebars.escapeExpression(this.internshipReleaseId));
            });

            Handlebars.registerHelper('name', function () {
                return new Handlebars.SafeString(Handlebars.escapeExpression(this.internshipTitle));
            });

            return template(data);
        }

        // 确定对比删除
        $("#saveExcludeInternship").click(function () {
            var excludeInternships = $('input[name="excludeInternship"]:checked');
            if (excludeInternships.length <= 0) {
                $('#exclude_internship_error_msg').removeClass('hidden').addClass('text-danger').text('请至少选择一个实习');
            } else {
                $('#exclude_internship_error_msg').addClass('hidden').removeClass('text-danger').text('');
                var r = [];
                for (var i = 0; i < excludeInternships.length; i++) {
                    r.push($(excludeInternships[i]).val());
                }
                $.post(getAjaxUrl().comparison_del, {
                    id: page_param.paramInternshipReleaseId,
                    excludeInternships: r.join(",")
                }, function (data) {
                    if (data.state) {
                        $('#excludeInternshipModal').modal('toggle');
                        myTable.ajax.reload();
                    } else {
                        $('#exclude_internship_error_msg').removeClass('hidden').addClass('text-danger').text(data.msg);
                    }
                });
            }
        });

        // 确定数据拷贝
        $("#saveCopyInternship").click(function () {
            var copyInternships = $('input[name="copyInternship"]:checked');
            if (copyInternships.length <= 0) {
                $('#copy_internship_error_msg').removeClass('hidden').addClass('text-danger').text('请至少选择一个实习');
            } else {
                $('#copy_internship_error_msg').addClass('hidden').removeClass('text-danger').text('');
                var r = [];
                for (var i = 0; i < copyInternships.length; i++) {
                    r.push($(copyInternships[i]).val());
                }
                $.post(getAjaxUrl().copy_data, {
                    id: page_param.paramInternshipReleaseId,
                    copyInternships: r.join(",")
                }, function (data) {
                    if (data.state) {
                        $('#copyInternshipModal').modal('toggle');
                        myTable.ajax.reload();
                    } else {
                        $('#copy_internship_error_msg').removeClass('hidden').addClass('text-danger').text(data.msg);
                    }
                });
            }
        });

        /*
         删除
         */
        function student_del(studentId, internshipReleaseId) {
            var msg;
            msg = Messenger().post({
                message: "确定删除该学生吗?",
                actions: {
                    retry: {
                        label: '确定',
                        phrase: 'Retrying TIME',
                        action: function () {
                            msg.cancel();
                            del(studentId, internshipReleaseId);
                        }
                    },
                    cancel: {
                        label: '取消',
                        action: function () {
                            return msg.cancel();
                        }
                    }
                }
            });
        }

        /*
         批量分配
         */
        $('#distributions').click(function () {
            $.address.value(getAjaxUrl().batch_distribution_url + "/" + page_param.paramInternshipReleaseId);
        });

        /**
         * 编辑
         * @param studentId
         * @param internshipReleaseId
         */
        function edit(studentId, internshipReleaseId) {
            $.address.value(getAjaxUrl().edit + "/" + internshipReleaseId + '/' + studentId);
        }

        function del(studentId, internshipReleaseId) {
            sendDelAjax(studentId, internshipReleaseId, '删除');
        }

        function dels(studentIds, internshipReleaseId) {
            sendDelAjax(studentIds.join(","), internshipReleaseId, '批量删除');
        }

        /**
         * 删除 ajax
         * @param studentId
         * @param internshipReleaseId
         * @param message
         */
        function sendDelAjax(studentId, internshipReleaseId, message) {
            Messenger().run({
                successMessage: message + '学生成功',
                errorMessage: message + '学生失败',
                progressMessage: '正在' + message + '学生....'
            }, {
                url: web_path + getAjaxUrl().del,
                type: 'post',
                data: {studentIds: studentId, id: internshipReleaseId},
                success: function (data) {
                    if (data.state) {
                        myTable.ajax.reload();
                    }
                },
                error: function (xhr) {
                    if ((xhr != null ? xhr.status : void 0) === 404) {
                        return "请求失败";
                    }
                    return true;
                }
            });
        }
    });