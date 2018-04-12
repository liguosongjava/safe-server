<div class="bjui-pageContent">
    <form action="/totalData/save_edit" class="datagrid-edit-form" data-toggle="ajaxform" data-data-type="json"
          data-reload-navtab="true">
        <div class="bjui-row col-2">
            <label class="row-label">所属地区</label>
            <div class="row-input required">
                <input name="totalData.regionName" readonly="true" value="" data-rule="所属地区:required;" type="text">
            </div>
            <label class="row-label">所属单位</label>
            <div class="row-input required">
                <input type="hidden" name="totalData.companyId" value="">
                <input name="totalData.companyName" value="" data-toggle="findgrid" data-options="{
                    group: 'totalData',
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
            <label class="row-label">申报类型</label>
            <div class="row-input required">
                <select name="totalData.declareType" data-toggle="selectpicker" data-rule="required"
                        data-width="226">
                    <option value="1">学籍</option>
                    <option value="0">非学籍</option>
                </select>
            </div>
            <label class="row-label">申报年级</label>
            <div class="row-input required">
                <select data-toggle="selectpicker" name="totalData.declareGrade" data-rule="required"
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
            <label class="row-label">学籍号</label>
            <div class="row-input required">
                <input name="totalData.schoolNo" value="" data-rule="单位电话:required;" type="text">
            </div>
            <label class="row-label">原就读学校</label>
            <div class="row-input required">
                <input name="totalData.originalSchool" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">准考证号</label>
            <div class="row-input required">
                <input name="totalData.examinationNo" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">登记表号</label>
            <div class="row-input required">
                <input name="totalData.registerNo" value="" data-rule="单位电话:required;" type="text">
            </div>
            <label class="row-label">学生身份证号</label>
            <div class="row-input required">
                <input id="student_id_no" name="totalData.hrIdNo" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">学生姓名</label>
            <div class="row-input required">
                <input name="totalData.hrName" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">性别</label>
            <div class="row-input required">
                <select name="totalData.hrSex" readonly="true" data-toggle="selectpicker" data-rule="required"
                        data-width="226">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </div>
            <label class="row-label">出生年月日</label>
            <div class="row-input required">
                <input name="totalData.birthday" readonly="true" value="" data-rule="出生年月日:required;" type="text">
            </div>
            <label class="row-label">户籍地址</label>
            <div class="row-input required">
                <input name="totalData.hrAddress" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">发证机关(派出所)</label>
            <div class="row-input required">
                <input name="totalData.hrIssuingCompany" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">居委会</label>
            <div class="row-input required">
                <input name="totalData.hrJuweiHui" readonly="true" value="" data-rule="单位电话:required;" type="text">
            </div>
            <label class="row-label">村委/街道</label>
            <div class="row-input required">
                <input name="totalData.hrVillageStreet" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">父亲</label>
            <div class="row-input required">
                <input name="totalData.hrFather" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">母亲</label>
            <div class="row-input required">
                <input name="totalData.hrMother" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">房产证号</label>
            <div class="row-input required">
                <input id="certificates_no"  name="totalData.hpCertificatesNo" value="" data-rule="单位电话:required;" type="text">
            </div>
            <label class="row-label">房产查询号</label>
            <div class="row-input required">
                <input name="totalData.hpQueryNo" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">权属人身份证号</label>
            <div class="row-input required">
                <input name="totalData.hpHasIdNo" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">产权人姓名</label>
            <div class="row-input required">
                <input name="totalData.hpHasName" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">共有人</label>
            <div class="row-input required">
                <input name="totalData.hpSharePeople" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">房产街道</label>
            <div class="row-input required">
                <input name="totalData.hpHouseStreet" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">发证时间</label>
            <div class="row-input required">
                <input name="totalData.hpObtainTime" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">房产证地址</label>
            <div class="row-input required">
                <input name="totalData.hpHouseAddress" readonly="true" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">家庭住址</label>
            <div class="row-input required">
                <input name="totalData.homeAddress" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">监护人姓名</label>
            <div class="row-input required">
                <input name="totalData.guardianName" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">监护人类型</label>
            <div class="row-input required">
                <input name="company.guardianType" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">监护人联系电话</label>
            <div class="row-input required">
                <input name="totalData.guardianPhone" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">监护人工作单位</label>
            <div class="row-input required">
                <input name="totalData.guardianUnit" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">登记表编号</label>
            <div class="row-input required">
                <input name="totalData.regFormNumber" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">有效证件证明地址</label>
            <div class="row-input required">
                <input name="totalData.certificateAddress" value="" data-rule="required" type="text">
            </div>

            <label class="row-label">房产主与该生关系</label>
            <div class="row-input required">
                <input name="totalData.fczRelation" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">户口簿主与该生的关系</label>
            <div class="row-input required">
                <input name="totalData.hkzRelation" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">户口迁入现址时间</label>
            <div class="row-input required">
                <input name="totalData.moveTime" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">毕业学校</label>
            <div class="row-input required">
                <input name="totalData.originalSchool" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">准考证号码</label>
            <div class="row-input required">
                <input name="totalData.examinationNo" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">语文成绩</label>
            <div class="row-input required">
                <input name="totalData.chineseFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">数学成绩</label>
            <div class="row-input required">
                <input name="totalData.mathFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">英语成绩</label>
            <div class="row-input required">
                <input name="totalData.englishFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">思想品德成绩</label>
            <div class="row-input required">
                <input name="totalData.sxpdFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">物理成绩</label>
            <div class="row-input required">
                <input name="totalData.physicsFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">化学成绩</label>
            <div class="row-input required">
                <input name="totalData.chemistryFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">历史成绩</label>
            <div class="row-input required">
                <input name="totalData.historyFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">体育成绩</label>
            <div class="row-input required">
                <input name="totalData.sportsFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">总分</label>
            <div class="row-input required">
                <input name="totalData.totalFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">总分(加)</label>
            <div class="row-input required">
                <input name="totalData.totalFractionAdd" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">地理等级</label>
            <div class="row-input required">
                <input name="totalData.geographyFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">生物等级</label>
            <div class="row-input required">
                <input name="totalData.biologyFraction" value="" data-rule="required" type="text">
            </div>
            <label class="row-label">到校注册时间</label>
            <div class="row-input required">
                <input name="totalData.registDate" id="student_regist_date" value="" data-toggle="datepicker" data-rule="required;date" type="text">
            </div>
            <label class="row-label"></label>
            <div class="row-input">
            </div>
            <label class="row-label">备注1</label>
            <div class="row-input">
                <textarea name="totalData.remarkOne" data-rule="required"></textarea>
            </div>
            <label class="row-label">备注2</label>
            <div class="row-input">
                <textarea name="totalData.remarkTwo" data-rule="required"></textarea>
            </div>
            <label class="row-label">备注3</label>
            <div class="row-input">
                <textarea name="totalData.remarkThree"  data-rule="required"></textarea>
            </div>
            <label class="row-label">备注4</label>
            <div class="row-input">
                <textarea name="totalData.remarkFour" data-rule="required"></textarea>
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
<script type="text/javascript">

    $(document).ready(function(){
        $("#student_id_no").blur(function(){
            var student_id_no = $("#student_id_no").val();
            if(student_id_no==''){
                BJUI.alertmsg('warn', "请输入学身份证号查询户籍信息");
                return;
            }
            $.ajax({
                url: "/totalData/query_household_register",
                method: "POST",
                data: {
                    student_id_no: student_id_no
                },
                timeout: 10000,
                dataType: "json",
                success: function (res) {
                    if (res.code == 200) {
                        //填充值
                        var dataObj = eval(res.hrdata);
                        $("input[name='totalData.hrName']").val(dataObj.name);
                        $("input[name='totalData.hrAddress']").val(dataObj.address);
                        $("input[name='totalData.hrIdNo']").val(dataObj.idNo);
                        $("input[name='totalData.hrSex']").val(dataObj.sex);
                        $("input[name='totalData.hrIssuingCompany']").val(dataObj.issuingCompany);
                        $("input[name='totalData.hrJuweiHui']").val(dataObj.juweiHui);
                        $("input[name='totalData.hrVillageStreet']").val(dataObj.villageStreet);
                        $("input[name='totalData.hrFather']").val(dataObj.father);
                        $("input[name='totalData.hrMother']").val(dataObj.mother);
                        $("input[name='totalData.birthday']").val(dataObj.birthday);
                    } else {
                        BJUI.alertmsg('warn', res.msg);
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    BJUI.alertmsg('error', "系统异常请联系管理员");
                },
                complete: function (XMLHttpRequest,status) {
                    if(status == 'timeout') {
                        xhr.abort();    // 超时后中断请求
                        BJUI.alertmsg('error', "网络超时，请刷新重试");
                    }
                }
            });
        });
        $("#certificates_no").blur(function(){
            var certificatesNo = $("#certificates_no").val();
            if(certificatesNo==''){
                BJUI.alertmsg('warn', "请输入房产证号查询房产信息");
                return;
            }
            $.ajax({
                url: "/totalData/query_house_property",
                method: "POST",
                data: {
                    certificates_no: certificatesNo
                },
                timeout: 10000,
                dataType: "json",
                success: function (res) {
                    if (res.code == 200) {
                        //填充值
                        var dataObj = eval(res.hpdata);
                        $("input[name='totalData.hpQueryNo']").val(dataObj.queryNo);
                        $("input[name='totalData.hpCertificatesNo']").val(dataObj.certificatesNo);
                        $("input[name='totalData.hpHasIdNo']").val(dataObj.hasIdNo);
                        $("input[name='totalData.hpHasName']").val(dataObj.hasName);
                        $("input[name='totalData.hpSharePeople']").val(dataObj.sharePeople);
                        $("input[name='totalData.hpHouseStreet']").val(dataObj.houseStreet);
                        $("input[name='totalData.hpHouseAddress']").val(dataObj.houseAddress);
                        $("input[name='totalData.hpObtainTime']").val(dataObj.obtainTime);
                    } else {
                        BJUI.alertmsg('warn', res.msg);
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    BJUI.alertmsg('error', "系统异常请联系管理员");
                },
                complete: function (XMLHttpRequest,status) {
                    if(status == 'timeout') {
                        xhr.abort();    // 超时后中断请求
                        BJUI.alertmsg('error', "网络超时，请刷新重试");
                    }
                }
            });
        });
    });
</script>