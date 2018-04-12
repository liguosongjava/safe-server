<div class="bjui-pageContent">
    <form action="/customer/save_edit" class="datagrid-edit-form" data-toggle="ajaxform" data-data-type="json"
          data-reload-navtab="true">
        <div class="bjui-row col-2">
            <label class="row-label">用户名</label>
            <div class="row-input required">
                <input name="customer.name" value="" data-rule="用户名:required;" type="text">
            </div>
            <label class="row-label">登陆账号</label>
            <div class="row-input required">
                <input name="customer.loginNo" value="" data-rule="登陆账号:required;" type="text">
            </div>
            <label class="row-label">登陆密码</label>
            <div class="row-input required">
                <input name="customer.password" value="123456" data-rule="登陆密码:required;length(6~)" type="password">
            </div>
            <label class="row-label">性别</label>
            <div class="row-input required">
                <select name="customer.sex" data-toggle="selectpicker" data-rule="required"
                        data-width="226">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </div>
            <label class="row-label">所属地区</label>
            <div class="row-input required">
                <input name="customer.regionName" readonly="true" value="" data-rule="所属地区:required;" type="text">
            </div>
            <label class="row-label">所属单位</label>
            <div class="row-input required">
                <input type="hidden" name="customer.companyId" value="">
                <input name="customer.companyName" value="" data-toggle="findgrid" data-options="{
                    group: 'customer',
                    include: 'companyName:name,regionName:regionName,companyId:id',
                    dialogOptions: {title:'查找地区'},
                    gridOptions: {
                        local: 'local',
                        filterThead:false,
                        columnMenu:false,
                        dataUrl: '/company/list_data',
                        columns: [
                            {name:'regionName',label:'地区名称',width:100},
                            {name:'name', label:'单位名称',width:100},
                            {name:'createTime',label:'创建时间'}
                        ]
                    }
            }" placeholder="点放大镜按钮查找" data-rule="所属单位:required;" type="text">
            </div>
            <label class="row-label">可上报单位</label>
            <div class="row-input required">
                <input type="hidden" name="customer.companyId" value="">
                <input name="customer.companyName" value="" data-toggle="findgrid" data-options="{
                    group: 'customer',
                    multiple:true,
                    include: 'companyName:name,regionName:regionName,companyId:id',
                    dialogOptions: {title:'查找地区'},
                    gridOptions: {
                        local: 'local',
                        filterThead:false,
                        columnMenu:false,
                        dataUrl: '/company/list_data',
                        columns: [
                            {name:'regionName',label:'地区名称',width:100},
                            {name:'name', label:'单位名称',width:100},
                            {name:'createTime',label:'创建时间'}
                        ]
                    }
            }" placeholder="点放大镜按钮查找" data-rule="所属单位:required;" type="text">
            </div>
            <label class="row-label">可查看单位</label>
            <div class="row-input required">
                <input type="hidden" name="customer.companyId" value="">
                <input name="customer.companyName" value="" data-toggle="findgrid" data-options="{
                    group: 'customer',
                    include: 'companyName:name,regionName:regionName,companyId:id',
                    dialogOptions: {title:'查找地区'},
                    gridOptions: {
                        local: 'local',
                        filterThead:false,
                        columnMenu:false,
                        dataUrl: '/company/list_data',
                        columns: [
                            {name:'regionName',label:'地区名称',width:100},
                            {name:'name', label:'单位名称',width:100},
                            {name:'createTime',label:'创建时间'}
                        ]
                    }
            }" placeholder="点放大镜按钮查找" data-rule="所属单位:required;" type="text">
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>
