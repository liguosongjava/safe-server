<div class="bjui-pageContent">
    <form action="/customer/save_edit?callback=?" class="datagrid-edit-form" data-toggle="validate" data-data-type="jsonp">
        <div class="bjui-row col-2">
            <label class="row-label">用户名称</label>
            <div class="row-input required">
                <input name="obj.name" value="B-JUI" data-rule="required" type="text">
            </div>
            <label class="row-label">所属地区</label>
            <div class="row-input">
                <input name="obj.name" value="" data-toggle="findgrid" data-options="{
                    group: 'obj',
                    include: 'name, description:desc',
                    dialogOptions: {title:'查找职业'},
                    gridOptions: {
                        local: 'local',
                        dataUrl: '../../json/datagrid/profession.json',
                        columns: [
                            {name:'name', label:'名称', width:100},
                            {name:'desc', label:'描述'},
                            {name:'date', label:'创建日期'}
                        ]
                    }
            }" placeholder="点放大镜按钮查找" type="text">
            </div>
            <label class="row-label">所属单位</label>
            <div class="row-input required">
                <input name="obj.name" value="B-JUI" data-rule="required" type="text">
            </div>
            <label class="row-label">性别</label>
            <div class="row-input required">
                <input name="custom.isshow" id="j_custom_sex1" data-toggle="icheck" value="true" data-rule="checked" data-label="男  " type="radio">
                <input name="custom.isshow" id="j_custom_sex2" data-toggle="icheck" value="false" data-label="女" type="radio">
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
