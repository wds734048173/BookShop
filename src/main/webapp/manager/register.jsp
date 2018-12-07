<%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/3
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>注册界面</title>
    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="author" content="Vincent Garreau" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" media="screen" href="/manager/css/style.css">
    <link rel="stylesheet" type="text/css" href="/manager/css/reset.css"/>
</head>
<body>

<div id="particles-js">
    <div class="login">
        <div class="login-top">
            注册
        </div>
        <div class="login-center clearfix">

            <div class="login-center-input">
                <input type="text" name="" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
                <div class="login-center-input-text">用户名</div>
            </div>
        </div>
        <div class="login-center clearfix">

            <div class="login-center-input">
                <input type="password" name=""value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
                <div class="login-center-input-text">密码</div>
            </div>
        </div>
        <div class="login-center clearfix">

            <div class="login-center-input">
                <input type="password" name=""value="" placeholder="请再次输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请再次输入您的密码'"/>
                <div class="login-center-input-text">密码</div>
            </div>
        </div>
        <div class="login-center clearfix">

            <div class="login-center-input">
                <input type="email" name=""value="" placeholder="请输入您的邮箱" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的邮箱'"/>
                <div class="login-center-input-text">邮箱</div>
            </div>
        </div>
        <div class="login-center clearfix">

            <div class="login-center-input">
                <input type="tel" name=""value="" placeholder="请输入您的手机号" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的手机号'"/>
                <div class="login-center-input-text">手机号</div>
            </div>
        </div>

        <br>

        <div class="login-button" onclick="window.location.href='/manager/login.jsp'" >注册

        </div>


    </div>
    <div class="sk-rotating-plane"></div>
</div>
</body>
</html>
