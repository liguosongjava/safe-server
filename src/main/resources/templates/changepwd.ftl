<div class="bjui-pageContent">
    <form action="../../json/ajaxDone.json" data-toggle="validate" method="post" data-close-current="true">
        <input type="hidden" name="user.id" value="">
        <input type="hidden" name="user.username" value="" id="j_userinfo_changepass_username">
        <input type="hidden" name="user.password" value="" id="j_userinfo_changepass_userpassword">
        <input type="hidden" name="user.oldpass" value="" id="j_userinfo_changepass_userpassword_old">
        <div class="bjui-row col-1">
            <label class="row-label">姓名:</label>
            <div class="row-input">${userName}</div>
            <label class="row-label">登陆账号:</label>
            <div class="row-input">${loginNo}</div>
            <label class="row-label">旧密码:</label>
            <div class="row-input">
                <input type="password" disabled="disabled" id="j_userinfo_changepass_oldpass" name="oldpassword" value="*******" >
            </div>
            <label class="row-label">新密码:</label>
            <div class="row-input required">
                <input type="password" id="j_userinfo_changepass_newpass" name="password" value="" data-rule="新密码:required;length(6~)">
            </div>
            <label class="row-label">确认密码:</label>
            <div class="row-input required">
                <input type="password" id="j_userinfo_changepass_confirmpass" name="" value="" data-rule="required;match(#j_userinfo_changepass_newpass)">
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
        <li><button type="submit" class="btn-default" data-icon="check">确认修改</button></li>
    </ul>
</div>