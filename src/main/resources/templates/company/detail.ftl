<div class="bjui-pageContent">
    <form action="/company/save_edit?callback=?" class="datagrid-edit-form" data-toggle="validate" data-data-type="jsonp">
        <div class="bjui-row col-2">
            <label class="row-label">单位名称</label>
            <div class="row-input required">
                <input name="obj.name" value="B-JUI" data-rule="required" type="text">
            </div>
            <label class="row-label">单位地址</label>
            <div class="row-input required">
                <input name="obj.name" value="B-JUI" data-rule="required" type="text">
            </div>
            <label class="row-label">单位电话</label>
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
            <label class="row-label">可申报人数</label>
            <div class="row-input required">
                <input name="obj.name" value="B-JUI" data-rule="required" type="text">
            </div>
            <label class="row-label">可申报类型</label>
            <div class="row-input required">
                <select name="obj.regname" data-toggle="selectpicker" data-rule="required" data-width="100%">
                    <option value=""></option>
                    <option value="学籍" selected="">学籍</option>
                    <option value="非学籍">非学籍</option>
                </select>
            </div>
            <label class="row-label">可申报年级</label>
            <div class="row-input">
                <select data-toggle="selectpicker" multiple="">
                    <option value="">全部</option>
                    <option value="1">一年级</option>
                    <option value="2">二年级</option>
                    <option value="3">三年级</option>
                    <option value="4">四年级</option>
                    <option value="5">五年级</option>
                    <option value="6">六年级</option>
                    <option value="7">七年级</option>
                    <option value="8">八年级</option>
                    <option value="9">九年级</option>
                </select>
            </div>
            <label class="row-label">单位级别</label>
            <div class="row-input">
                <select data-toggle="selectpicker">
                    <option value="">全部</option>
                    <option value="1">下拉选项1</option>
                    <option value="2" selected="">下拉选项2</option>
                    <option value="3">下拉选项3</option>
                    <option value="4">下拉选项4</option>
                </select>
            </div>
            <label class="row-label">房产校验内容</label>
            <div class="row-input required">
                <input name="obj.regfee" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">户籍校验内容</label>
            <div class="row-input required">
                <input name="obj.regfee" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">备注</label>
            <div class="row-input">
                <textarea cols="60" rows="4" data-rule="required"></textarea>
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
