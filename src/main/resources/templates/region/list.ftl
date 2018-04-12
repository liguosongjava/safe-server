<div class="bjui-pageHeader" style="background-color:#fefefe; border-bottom:none;">
    <form data-toggle="ajaxsearch" data-options="{searchDatagrid:$.CurrentNavtab.find('#datagrid-test-filter')}">
        <fieldset>
            <legend style="font-weight:normal;">地区搜索：</legend>
            <div style="margin:0; padding:1px 5px 5px;">
                <span>地区名称：</span>
                <input type="text" name="region.name" class="form-control" size="15">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <div class="btn-group">
                    <button type="submit" class="btn-green" data-icon="search">开始搜索！</button>
                    <button type="reset" class="btn-orange" data-icon="times">重置</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered" id="datagrid-test-filter" data-toggle="datagrid" data-options="{
        height: '100%',
        width:'100%',
        showToolbar: true,
        filterThead:false,
        columnMenu:false,
        fieldSortable:false,
        toolbarItem: 'add,edit,del',
        dataUrl: '/region/list_data',
        dataType: 'json',
        jsonPrefix: 'region',
        editMode: {dialog:{width:'600',height:300,title:'编辑地区信息',mask:true}},
        editUrl: '/region/edit?id={id}',
        delUrl: '/region/delete',
        delPK:'id',
        paging: {pageSize:60},
        showCheckboxcol: true,
        linenumberAll: true
    }">
        <thead>
        <tr>
            <th data-options="{name:'name',align:'center',width:250}">地区名称</th>
            <th data-options="{name:'createCustomer',align:'center',width:250}">创建人</th>
            <th data-options="{name:'remark',width:350}">备注</th>
            <th data-options="{name:'createTime',align:'center',width:150}">创建时间</th>
        </tr>
        </thead>
    </table>
</div>