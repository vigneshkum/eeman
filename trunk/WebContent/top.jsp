<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<title></title>
<style type="text/css">
<!--
html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td
	{
	background: transparent;
	margin: 0;
	padding: 0;
}

body {
	font-size: 12px;
	font-family: "微软雅黑"
}

.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}

.STYLE2 {
	font-size: 9px
}

.STYLE3 {
	color: #033d61;
	font-size: 12px;
}

#bananer {
	height: 70px;
	width: 100%;
	background: url("images/main_05.png") repeat-x;
}

#nav {
	height: 28px;
	width: 100%;
	background-image: url("images/main_36.gif");
}

#logo {
	height: 50px;
	background: no-repeat url("images/logo.png");
}

#mininav {
	padding-left: 400px;
}

#mininav li {
	float: left;
	height: 20px;
	line-height: 20px;
	list-style: none;
}

#mininav li a {
	font-size: 9px;
	color: #FFF;
	height: 20px;
	padding: 0px 15px;
}

#menu li {
	float: left;
	height: 28px;
	line-height: 28px;
	list-style: none;
}

#menu li  a {
	color: #36F;
	height: 28px;
	padding: 0px 15px;
	background: no-repeat url(images/main_34.gif);
	text-decoration: none;
}

#menu li a:hover {
	color: #F3C;
}
-->
</style>
<script type="text/javascript">

</script>
<base target="main" />
</head>

<body>
	<div>
		<div id="bananer">
			<div id="logo"></div>
			<div align="right">
				<ul id="mininav">
					<li><a href="indexinfo.jsp;">首页</a>
					</li>
					<li><a href="javascript:history.go(1);">前进</a>
					</li>
					<li><a href="javascript:history.go(-1);">后退</a>
					</li>
					<li><a href="javascript:parent.document.location.href='index.jsp';">刷新</a>
					
					</li>

				</ul>
				<span class="STYLE1"><span class="STYLE2">■</span> 今天是： <script
						language="JavaScript" type="text/javascript">				var enabled = 0; today = new Date();
				var day; var date;
				if(today.getDay()==0) day = " 星期日"
				if(today.getDay()==1) day = " 星期一"
				if(today.getDay()==2) day = " 星期二"
				if(today.getDay()==3) day = " 星期三"
				if(today.getDay()==4) day = " 星期四"
				if(today.getDay()==5) day = " 星期五"
				if(today.getDay()==6) day = " 星期六"
				date = (today.getFullYear()) + "年" + (today.getMonth() + 1 ) + "月" + today.getDate() + "日" + day +"";
				document.write(date);
				</script>
				</span>
			</div>
		</div>
		<div id="nav">
			<ul id="menu">
				<% String username="";
				username=session.getAttribute("username").toString();
				
				%>
				<li><a href="javascript:void;">当前用户：<%=username %></a>
				</li>
				<li><a href="logout_check">退出</a>
				</li>
				<li><a href="indexinfo.jsp">系统状态</a>
				</li>
				<li><a href="notice/getall">最新通知</a>
				</li>
				<li><a href="employee/getall">员工管理</a>
				</li>
				<li><a href="dept/getall">部门管理</a>
				</li>
				<li><a href="salary/getall">工资管理</a>
				</li>
				<li><a href="train/getall">培训信息</a>
				</li>
				<li><a href="invite/getall">招聘管理</a>
				</li>
				<li><a href="user/getall">用户管理</a>
				</li>
					<li><a href="permission/getall">角色管理</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
