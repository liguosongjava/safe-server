<div class="bjui-pageHeader" style="background-color:#fefefe; border-bottom:none;">
    <form data-toggle="ajaxsearch" data-options="{searchDatagrid:$.CurrentNavtab.find('#datagrid-test-filter')}">
        <fieldset>
            <legend style="font-weight:normal;">单位搜索：</legend>
            <div style="margin:0; padding:1px 5px 5px;">
                <span>地区名称：</span>
                <input type="text" name="company.regionName" class="form-control" size="15">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <span>单位名称：</span>
                <input type="text" name="company.name" class="form-control" size="15">
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
        dataUrl: '/company/list_data',
        dataType: 'json',
        jsonPrefix: 'company',
        editMode: {dialog:{width:'800',height:450,title:'编辑单位信息',mask:true}},
        editUrl: '/company/edit?id={id}',
        delUrl: '/company/delete',
        delPK:'id',
        paging: {pageSize:60},
        showCheckboxcol: true,
        linenumberAll: true,
    }">
        <thead>
        <tr>
            <th data-options="{name:'regionName',align:'center'}">所属地区</th>
            <th data-options="{name:'name',align:'center',width:100}">单位名称</th>
            <th data-options="{name:'phone',align:'center',width:100}">单位电话</th>
            <th data-options="{name:'declareNum',align:'center',width:100}">可申报人数</th>
            <th data-options="{name:'address',align:'center',width:150}">单位地址</th>
            <th data-options="{name:'companyLevel',align:'center'}">单位级别</th>
            <th data-options="{name:'createCustomerName'}">创建人</th>
            <th data-options="{name:'remark'}">备注</th>
            <th data-options="{name:'createTime',align:'center',width:200}">创建时间</th>
            <th data-options="{name:'id',width:100,render:function(value){return '<a style=\'cursor: pointer;\' onclick=\'see_detail(id)\'>详情</a>'}}">操作</th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/javascript">
    function see_detail(value) {
        alert(value);
        BJUI.dialog({
            id: 'see_company_detail',
            width: 800,
            height: 500,
            url: '/company/detail?id='+value,
            title: '单位详情'
        })
    }
</script>