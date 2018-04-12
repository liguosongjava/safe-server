<div class="bjui-pageHeader" style="background-color:#fefefe; border-bottom:none;">
    <form data-toggle="ajaxsearch" data-options="{searchDatagrid:$.CurrentNavtab.find('#datagrid-test-filter')}">
        <fieldset>
            <legend style="font-weight:normal;">用户搜索：</legend>
            <div style="margin:0; padding:1px 5px 5px;">
                <span>用户名称：</span>
                <input type="text" name="customer.name" class="form-control" size="15">
                <span>地区名称：</span>
                <input type="text" name="customer.regionName" class="form-control" size="15">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <span>单位名称：</span>
                <input type="text" name="customer.companyName" class="form-control" size="15">
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
        dataUrl: '/customer/list_data',
        dataType: 'json',
        jsonPrefix: 'customer',
        editMode: {dialog:{width:'800',height:450,title:'编辑用户信息',mask:true}},
        editUrl: '/customer/edit?id={id}',
        delUrl: '/customer/delete',
        delPK:'id',
        paging: {pageSize:60},
        showCheckboxcol: true,
        linenumberAll: true,
    }">
        <thead>
        <tr>
            <th data-options="{name:'name',align:'center',width:100}">用户名</th>
            <th data-options="{name:'loginNo',align:'center',width:200}">登录账号</th>
            <th data-options="{name:'regionName',align:'center',width:150}">所属地区</th>
            <th data-options="{name:'companyName',align:'center',width:150}">所属单位</th>
            <th data-options="{name:'sex',items:[{'true':'男'},{'false':'女'}],align:'center',width:60}">性别</th>
            <th data-options="{name:'createCustomerName',align:'center',width:100}">创建人</th>
            <th data-options="{name:'createTime',align:'center',type:'date',pattern:'yyyy-MM-dd HH:mm:ss',width:200}">创建时间</th>
            <th data-options="{name:'id',width:100,render:function(value){return '<a style=\'cursor: pointer;\' onclick=\'see_detail(value)\'>详情</a>'}}">操作</th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/javascript">
    function see_detail(value) {
        alert(value);
        BJUI.dialog({
            id: 'see_customer_detail',
            width: 800,
            height: 500,
            url: '/customer/detail',
            title: '用户详情'
        })
    }
</script>