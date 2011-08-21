<%@page import="blue.liuk.model.User"%>
<%@page import="org.apache.struts2.components.Else"%>
<%@page import="org.apache.struts2.components.ElseIf"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>

<title></title>
<style type="text/css" media="screen">


.submit input,.button,input.button,.button-primary,input.button-primary,.button-secondary,input.button-secondary,.button-highlighted,input.button-highlighted,#postcustomstuff .submit input
	{
	font-size: 12px !important;
}

* {
	margin: 0;
	padding: 0;
}



body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
padding-top: 30px;
	font-size: 13px;
	font-family: "微软雅黑"
}
 a {
	color: #36F;
	text-decoration: none;
}

 a:hover {
	color: #F3C;
}
form {
	margin-left: 8px;
	padding: 16px 16px 40px 16px;
	font-weight: normal;
	background: #fff;
	border: 1px solid #e5e5e5;
}

form .forgetmenot {
	font-weight: normal;
	float: left;
	margin-bottom: 0;
}

.button-primary {
	font-family: "Lucida Grande", Verdana, Arial, "Bitstream Vera Sans",sans-serif;
	padding: 3px 10px;
	border: none;
	font-size: 12px;
	border-width: 1px;
	border-style: solid;
	cursor: pointer;
	text-decoration: none;
	margin-top: -3px;
}

#login form p {
	margin-bottom: 0;
}

label {
	color: #777;
	font-size: 13px;
}

form .forgetmenot label {
	font-size: 11px;
	line-height: 19px;
}

form .submit,.alignright {
	float: right;
}

form p {
	margin-bottom: 24px;
}

h1 a {
	background: url(../images/logo-login.gif) no-repeat top center;
	width: 326px;
	height: 67px;
	text-indent: -9999px;
	overflow: hidden;
	padding-bottom: 15px;
	display: block;
}

#nav {
	text-shadow: rgba(255, 255, 255, 1) 0 1px 0;
}

#backtoblog {
	position: absolute;
	top: 0;
	left: 0;
	border-bottom: #c6c6c6 1px solid;
	background: #d9d9d9;
	background: -moz-linear-gradient(bottom, #d7d7d7, #e4e4e4);
	background: -webkit-gradient(linear, left bottom, left top, from(#d7d7d7),
		to(#e4e4e4) );
	height: 30px;
	width: 100%;
}

#backtoblog a {
	text-decoration: none;
	display: block;
	padding: 8px 0 0 15px;
}

#login {
	width: 320px;
	margin: 7em auto;
}

#login_error,.message {
	margin: 0 0 16px 16px;

	padding: 12px;
	
	color:#ff0000;
}

#nav {
	margin: 0 0 0 8px;
	padding: 16px;
}

body form .input {
	font-size: 24px;
	width: 97%;
	padding: 3px;
	margin-top: 2px;
	margin-right: 6px;
	margin-bottom: 16px;
	border: 1px solid #e5e5e5;
	background: #fbfbfb;
}

input {
	color: #555;
}

.clear {
	clear: both;
}

#pass-strength-result {
	font-weight: bold;
	border-style: solid;
	border-width: 1px;
	margin: 12px 0 6px;
	padding: 6px 5px;
	text-align: center;
}
</style>
<link rel="stylesheet" type="text/css" href="/sss_1/css/unity.css" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script language="javascript"type="text/javascript"> 
        if (top.location !== self.location) { 
            top.location=self.location; } 
    </script>
<base href="<%=basePath%>" />
<body class="body_background">
	<center>
		<%
			String errorcode = request.getParameter("error");
			String info = "";
			if ("1".equals(errorcode)) {
				info = "请登陆后操作";
			} else if ("2".equals(errorcode)) {
				info = "请不要重复登陆" + "<a href=\"index.jsp\">返回主页</a>";
			} else if ("0".equals(errorcode)) {
				info = "登陆失败,密码错误码？";
			} else if ("3".equals(errorcode)) {
				info = "成功退出";
			} else if ("4".equals(errorcode)) {
				info = "登陆成功," + ((User) request.getSession().getAttribute("user")).getUsername() + "欢迎回来<a href=\"" + response.encodeURL("index.jsp")
						+ "\">进入主页</a>";
			} else if ("10".equals(errorcode)) {
				info = "用户已经被禁用";
			} else {
				info = "你干什么呢？";
			}
		%>
		<h3 class="message" ><%=info%></h3>
			<h1>企业员工管理系统</h1>
		<div id="login">
	
		
			<form name="loginform" id="loginform" action="login_check"
				method="post">
				<p>
					<label>用户名<br> <input type="text" name="username"
						id="user_login" class="input" value="" size="20" tabindex="10">
					</label>
				</p>
				<p>
					<label>密码<br> <input type="password" name="password"
						id="user_pass" class="input" value="" size="20" tabindex="20">
					</label>
				</p>
				<p class="forgetmenot">
					<label><input name="rememberme" type="checkbox"
						id="rememberme" value="forever" tabindex="90"> 记住我的登录信息</label>
				</p>
<p class="submit"> 
		<input type="submit"  id="wp-submit" class="button-primary" value="登录" tabindex="100"> 
		
	</p> 
			</form>
		</div>
	</center>

</body>
</html>