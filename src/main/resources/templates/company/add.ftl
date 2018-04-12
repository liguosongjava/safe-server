<div class="bjui-pageContent">
    <form action="/company/save_edit" class="datagrid-edit-form" data-toggle="ajaxform" data-data-type="json"
          data-reload-navtab="true">
        <div class="bjui-row col-2">
            <label class="row-label">单位名称</label>
            <div class="row-input required">
                <input name="company.name" value="" data-rule="单位名称:required;" type="text">
            </div>
            <label class="row-label">单位地址</label>
            <div class="row-input required">
                <input name="company.address" value="" data-rule="单位地址:required;" type="text">
            </div>
            <label class="row-label">单位电话</label>
            <div class="row-input required">
                <input name="company.phone" value="" data-rule="单位电话:required;" type="text">
            </div>
            <label class="row-label">所属地区</label>
            <div class="row-input required">
                <input type="hidden" name="company.regionId" value="">
                <input name="company.regionName" value="" data-toggle="findgrid" data-options="{
                    group: 'company',
                    include: 'regionName:regionName, regionId:regionId',
                    dialogOptions: {title:'查找地区'},
                    gridOptions: {
                        local: 'local',
                        filterThead:false,
                        columnMenu:false,
                        dataUrl: '/region/find_region_data',
                        columns: [
                            {name:'regionId',label:'地区id'},
                            {name:'regionName', label:'地区名称',width:100},
                            {name:'regionRemark',label:'备注'}
                        ]
                    }
            }" placeholder="点放大镜按钮查找" data-rule="所属地区:required;" type="text">
            </div>
            <label class="row-label">可申报人数</label>
            <div class="row-input required">
                <input name="company.declareNum" value="" data-rule="申报人数:required;" type="text"
                       data-toggle="spinner" data-min="0" data-max="100000" data-step="1" data-rule="integer" >
            </div>
            <label class="row-label">可申报类型</label>
            <div class="row-input required">
                <select name="company.declareType" data-toggle="selectpicker" multiple="" data-rule="required"
                        data-width="226">
                    <option value="1">学籍</option>
                    <option value="0">非学籍</option>
                </select>
            </div>
            <label class="row-label">可申报年级</label>
            <div class="row-input required">
                <select data-toggle="selectpicker" name="company.declareGrade" multiple="" data-rule="required"
                        data-width="226">
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
            <div class="row-input required">
                <input name="company.companyLevel" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">房产校验内容</label>
            <div class="row-input required">
                <input name="company.houseCheck" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">户籍校验内容</label>
            <div class="row-input required">
                <input name="company.hregisterCheck" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">备注</label>
            <div class="row-input">
                <textarea name="company.remark" cols="60" rows="4" data-rule="required"></textarea>
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
