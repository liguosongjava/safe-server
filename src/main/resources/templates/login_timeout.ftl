<div class="main_box">
    <form id="login_form">
        <input value="" id="j_randomKey" type="hidden">
        <input name="jfinal_token" value="" type="hidden">
        <p class="text-center logo"><img src="images/logo.png" height="45"></p>
        <div class="login_msg text-center"><font color="red"></font></div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="sizing-addon-user"><span class="glyphicon glyphicon-user"></span></span>
                <input placeholder="登录账号" class="form-control" id="j_username" name="username" value="" aria-describedby="sizing-addon-user" type="text">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="sizing-addon-password"><span class="glyphicon glyphicon-lock"></span></span>
                <input placeholder="密码" class="form-control" id="j_password" name="password" aria-describedby="sizing-addon-password" type="password">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="sizing-addon-password"><span class="glyphicon glyphicon-exclamation-sign"></span></span>
                <input class="form-control" id="j_captcha" name="captcha" placeholder="验证码" aria-describedby="sizing-addon-password" type="text">
                <span class="input-group-addon code" id="basic-addon-code"><img id="captcha_img" src="/get_code?0.2983649230668656" alt="点击更换" title="点击更换" class="m"></span>
            </div>
        </div>
        <div class="form-group">
            <div class="checkbox">
                <label for="j_remember" class="m"><input id="j_remember" value="true" type="checkbox">&nbsp;记住登陆账号!</label>
            </div>
        </div>
        <div class="text-center">
            <button type="submit" id="login_ok" class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp;</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-default btn-lg">&nbsp;重&nbsp;置&nbsp;</button>
        </div>
        <div class="text-center">
            <hr>
            2018 - 2020 <a href="login">学籍管理系统</a>
        </div>
    </form>
</div>