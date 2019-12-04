//# sourceURL=system_role_edit.js
require(["jquery", "lodash", "tools", "sweetalert2", "handlebars", "nav.active", "messenger", "bootstrap-treeview", "jquery.address"
], function ($, _, tools, Swal, Handlebars, nav_active) {

    /*
     ajax url.
     */
    var ajax_url = {
        application_json_data: web_path + '/web/system/role/application/json',
        role_application_data: web_path + '/web/system/role/application/data',
        update: web_path + '/web/system/role/update',
        check_name: web_path + '/web/system/role/check/edit/name',
        back: '/web/menu/system/role'
    };

    // 刷新时选中菜单
    nav_active(ajax_url.back);

    /*
     参数id
     */
    var param_id = {
        roleName: '#roleName',
        roleId: '#roleId'
    };

    var button_id = {
        save: {
            id: '#save',
            text: '保存',
            tip: '保存中...'
        }
    };

    /*
     参数
     */
    var param = {
        roleName: '',
        applicationIds: '',
        roleId: ''
    };

    /**
     * 初始化参数
     */
    function initParam() {
        param.roleName = $(param_id.roleName).val();
        param.roleId = $(param_id.roleId).val();
        param.applicationIds = getAllCheckedData();
    }

    var treeviewId = $('#treeview-checkable');

    /*
     初始化数据
     */
    init();

    /**
     * 初始化界面
     */
    function init() {
        initTreeView();
    }

    /*
     即时检验系名
     */
    $(param_id.roleName).blur(function () {
        initParam();
        var roleName = param.roleName;
        if (roleName.length <= 0 || roleName.length > 50) {
            tools.validErrorDom(param_id.roleName, '角色名为1~50个字符');
        } else {
            $.post(ajax_url.check_name, param, function (data) {
                if (data.state) {
                    tools.validSuccessDom(param_id.roleName);
                } else {
                    tools.validErrorDom(param_id.roleName, data.msg);
                }
            });
        }
    });

    /*
     保存数据
     */
    $('#save').click(function () {
        initParam();
        validRoleName();
    });

    /**
     * 添加时检验并提交数据
     */
    function validRoleName() {
        var roleName = param.roleName;
        if (roleName.length <= 0 || roleName.length > 50) {
            tools.validErrorDom(param_id.roleName, '角色名为1~50个字符');
        } else {
            $.post(ajax_url.check_name, param, function (data) {
                if (data.state) {
                    tools.validSuccessDom(param_id.roleName);
                    sendAjax();
                } else {
                    tools.validErrorDom(param_id.roleName, data.msg);
                }
            });
        }
    }

    /**
     * 发送数据到后台
     */
    function sendAjax() {
        tools.buttonLoading(button_id.save.id, button_id.save.tip);
        $.ajax({
            type: 'POST',
            url: ajax_url.update,
            data: param,
            success: function (data) {
                tools.buttonEndLoading(button_id.save.id, button_id.save.text);
                if (data.state) {
                    Swal.fire({
                        title: data.msg,
                        type: "success",
                        confirmButtonText: "确定",
                        preConfirm: function () {
                            $.address.value(ajax_url.back);
                        }
                    });
                } else {
                    Swal.fire('保存失败', data.msg, 'error');
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
     * 初始化tree view
     */
    function initTreeView() {
        $.get(ajax_url.application_json_data, function (data) {
            if (data.listResult != null) {
                treeViewData(data.listResult);
            }
        });
    }

    function treeViewData(data) {
        treeviewId.treeview({
            data: data,
            showIcon: false,
            showCheckbox: true,
            checkedIcon:'fa fa-check-circle-o',
            collapseIcon:'fa fa-minus',
            emptyIcon:'fa',
            expandIcon:'fa fa-plus',
            nodeIcon:'fa fa-stop',
            selectedIcon:'fa fa-stop',
            uncheckedIcon:'fa fa-circle-o',
            onNodeChecked: function (event, node) {
                checkAllParentNode(node);
                checkAllChildrenNode(node);
            },
            onNodeUnchecked: function (event, node) {
                uncheckAllChildrenNode(node);
                getAllParent(node);// 若任何子节点选中则取消选中该父节点
            }
        });

        selectedApplication();
    }

    /**
     * 选中应用
     */
    function selectedApplication() {
        initParam();
        var roleId = param.roleId;
        $.post(ajax_url.role_application_data, {roleId: roleId}, function (data) {
            var list = data.listResult;
            if (list.length > 0) {
                var unCheckeds = treeviewId.treeview('getUnchecked');
                for (var i = 0; i < list.length; i++) {
                    for (var j = 0; j < unCheckeds.length; j++) {
                        if (list[i].applicationId === unCheckeds[j].dataId) {
                            treeviewId.treeview('checkNode', [unCheckeds[j], {silent: true}]);
                            break;
                        }
                    }
                }
            }
        });
    }

    /**
     * 选中所有父节点
     * @param node
     */
    function checkAllParentNode(node) {
        if (node.hasOwnProperty('parentId') && node.parentId !== undefined) {
            var parentNode = treeviewId.treeview('getParent', node);
            checkAllParentNode(parentNode);
        }
        treeviewId.treeview('checkNode', [node.nodeId, {silent: true}]);
    }

    /**
     * 取消所有子节点的选中
     * @param node
     */
    function uncheckAllChildrenNode(node) {
        if (node.hasOwnProperty('nodes') && node.nodes != null) {
            var n = node.nodes;
            for (var i = 0; i < n.length; i++) {
                uncheckAllChildrenNode(n[i]);
            }
        }
        treeviewId.treeview('uncheckNode', [node.nodeId, {silent: true}]);
    }

    /**
     * 选中所有子节点
     * @param node
     */
    function checkAllChildrenNode(node) {
        if (node.hasOwnProperty('nodes') && node.nodes != null) {
            var n = node.nodes;
            for (var i = 0; i < n.length; i++) {
                checkAllChildrenNode(n[i]);
            }
        }
        treeviewId.treeview('checkNode', [node.nodeId, {silent: true}]);
    }

    var childrenArr = [];

    function getAllChildren(node) {
        if (node.hasOwnProperty('nodes') && node.nodes != null) {
            var n = node.nodes;
            for (var i = 0; i < n.length; i++) {
                getAllChildren(n[i]);
            }
        }
        childrenArr.push(node);
    }

    function getAllParent(node) {
        if (node.hasOwnProperty('parentId') && node.parentId !== undefined) {
            var parentNode = treeviewId.treeview('getParent', node);
            childrenArr = [];
            getAllChildren(parentNode);
            var parentNodeIsChecked = false;
            for (var i = 0; i < childrenArr.length; i++) {
                if (childrenArr[i].nodeId !== parentNode.nodeId && childrenArr[i].state.checked) {
                    parentNodeIsChecked = true;
                }
            }
            if (!parentNodeIsChecked) {
                treeviewId.treeview('uncheckNode', [parentNode.nodeId, {silent: true}]);
                getAllParent(parentNode);
            }

        }
    }

    /**
     * 获取所有选中节点的dataId
     * @returns {string}
     */
    function getAllCheckedData() {
        var applicationIds = '';
        var checkeds = treeviewId.treeview('getChecked');
        var temp = [];
        for (var i = 0; i < checkeds.length; i++) {
            temp.push(checkeds[i].dataId);
        }
        if (temp.length > 0) {
            applicationIds = temp.join(",");
        }
        return applicationIds;
    }

});