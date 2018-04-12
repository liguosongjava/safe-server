<div class="bjui-pageHeader" style="background-color:#fefefe; border-bottom:none;">
    <form data-toggle="ajaxsearch" data-options="{searchDatagrid:$.CurrentNavtab.find('#datagrid-test-filter')}">
        <fieldset>
            <legend style="font-weight:normal;">数据搜索：</legend>
            <div style="margin:0; padding:1px 5px 5px;">
                <span>地区：</span>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" name="totalData.regionName" class="form-control" size="15">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <span>单位：</span>
                <input type="text" name="totalData.companyName" class="form-control" size="15">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <span>学生姓名：</span>
                <input type="text" name="totalData.studentName" class="form-control" size="15">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <span>学生身份证号：</span>
                <input type="text" name="totalData.studentIdNo" class="form-control" size="15">
            </div>
        </fieldset>
        <fieldset>
            <span>申报类型：</span>
            <select name="totalData.declareType" data-toggle="selectpicker" class="form-control" size="15">
                <option value="" selected>全部</option>
                <option value="1">学籍</option>
                <option value="2">非学籍</option>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span>申报年级：</span>
            <select data-toggle="selectpicker" name="totalData.declareGrade" class="form-control" size="15">
                <option value="" selected>全部</option>
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
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span>审批状态：</span>
            <select name="totalData.auditStatus" data-toggle="selectpicker" class="form-control" size="15">
                <option value="" selected>全部</option>
                <option value="0">待审核</option>
                <option value="1">审核成功</option>
                <option value="2">审核失败</option>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <div class="btn-group">
                <button type="submit" class="btn-green" data-icon="search">开始搜索！</button>
                <button type="reset" class="btn-orange" data-icon="times">重置</button>
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <div class="btn-group">
                <button type="button" class="btn btn-green" data-icon="sign-out">
                    <i class="fa fa-sign-out"></i> 导出</button>
                <button type="button" class="btn btn-green" data-icon="filter">
                    <i class="fa fa-filter"></i> 导出筛选</button>
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
        toolbarItem: 'add,edit,del,',
        dataUrl: '/totalData/list_data',
        dataType: 'json',
        jsonPrefix: 'totalData',
        editMode: {dialog:{width:'800',height:450,title:'编辑申报信息',mask:true}},
        editUrl: '/totalData/edit?id={id}',
        delUrl: '/totalData/delete',
        delPK:'id',
        paging: {pageSize:60},
        showCheckboxcol: true,
        linenumberAll: true,
    }">
        <thead>
        <tr>
            <th data-options="{name:'regionName',align:'center'}">地区</th>
            <th data-options="{name:'companyName',align:'center'}">单位</th>
            <th data-options="{name:'grade',align:'center'}">申报类型</th>
            <th data-options="{name:'grade',align:'center'}">申报年级</th>
            <th data-options="{name:'schoolNo',align:'center'}">学籍号</th>
            <th data-options="{name:'originalSchool',align:'center'}">原就读学校</th>
            <th data-options="{name:'examinationNo',align:'center'}">准考证号</th>
            <th data-options="{name:'registerNo',align:'center'}">登记表号</th>
            <th data-options="{name:'applyCustomerName',align:'center'}">申报人</th>
            <th data-options="{name:'applyTime',align:'center'}">注册时间</th>
            <th data-options="{name:'auditStatus',align:'center'}">审核状态</th>
            <th data-options="{name:'id',width:100,render:function(value,data){ return console.log(data.id), '<a style=\'cursor: pointer;\' onclick=\'see_detail('+data.id+')\'>详情</a>'}}">操作</th>
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
            title: '数据详情'
        })
    }
</script>