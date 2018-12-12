<%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/3
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link  type="text/css" href="/manager/css/pintuer.css" rel="stylesheet">
    <link href='//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css' rel='stylesheet'>
    <script type="text/javascript" src="/manager/js/jquery.js"></script>
    <script type="text/javascript" src="/manager/js/pintuer.js"></script>
    <script src="//cstaticdun.126.net/load.min.js"></script>
    <script> // 验证码组件初始化
    initNECaptcha({
        captchaId: 'eda6d7f57cf54b5d8f9b0ed24e5b6e66',
        element: '#captcha_div',
        mode: 'float', // 如果要用触发式，这里改为float即可 embeb
        width: '320px',
        onVerify: function(err, ret){
            if(!err){
                // ret['validate'] 获取二次校验数据
            }
        }
    }, function (instance) {
        // 初始化成功后得到验证实例instance，可以调用实例的方法
    }, function (err) {
        // 初始化失败后触发该函数，err对象描述当前错误信息
    })
    </script>
    <style type="text/css">
        .backgroundimage{
            width: 100%;
            height: 100%;
            background-image:url("img/icon-6.jpg") ;
            background-repeat: no-repeat;/*只显示一次*/
            background-size: cover;
            margin: auto;/*居中*/
        }
    </style>
</head>
<body>
<div class="backgroundimage">
<div  align="center" style="height: 300px;">
    <form action="/login.do?method=login" method="post">
        <div class="panel padding" style="width: 450px;text-align: left;background:rgba(255,255,37,0.03);">
            <div class="text-center">
                <br>
                <h2><strong>网上书店后端登录</strong></h2></div>
            <div class="" style="padding:50px;width: 420px;text-align: center">
                <div class="form-group">
                    <div class="field field-icon-right" >
                        <%--校验长度方法： data-validate="required:请填写账号,length#>=5:账号长度不符合要求"--%>
                        <input type="text" class="input" name="username" placeholder="登录账号" value="<%if(request.getAttribute("username")!=null)out.print(request.getAttribute("username"));%>"/>
                        <span class="icon icon-user"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="password" class="input"  name="password" placeholder="登录密码" value="<%if(request.getAttribute("password")!=null)out.print(request.getAttribute("password"));%>"/>
                        <span class="icon icon-key"></span>
                    </div>
                </div>
                <%--验证码--%>
                <div style="margin: 10px auto;" id="captcha_div"></div> <!-- 验证码容器元素定义 -->
                <%--验证码完--%>
                <span id="message" style="color: red;"><%if(request.getAttribute("message") != null)out.print(request.getAttribute("message"));%></span>
                <div class="form-group">
                    <div class="field">
                        <button class="button button-block bg-main text-big">立即登录</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field text-center">
                        <p class="text-muted text-center"> <a class="" href="/manager/updatePwd.jsp"><small>忘记密码了？</small></a> | <a class="" href="/manager/register.jsp">注册新账号</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</div>
</body>
</html>
