<%@page import="blue.liuk.model.User"%>
<%@page import="org.apache.struts2.components.Else"%>
<%@page import="org.apache.struts2.components.ElseIf"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登陆</title>
<style type="text/css">
<!--
body {
		font-size: 13px;
	font-family: "微软雅黑";
background: #eee;
	margin: 0;
	padding: 0;
	color: #000;
}
 a {
	color: #36F;
	text-decoration: none;
}

 a:hover {
	color: #F3C;
}
#login_error,.message {
	margin: 0 0 16px 16px;

	padding: 12px;
	
	color:#ff0000;
}

/* ~~ 元素/标签选择器 ~~ */
ul, ol, dl { /* 由于浏览器之间的差异，最佳做法是在列表中将填充和边距都设置为零。为了保持一致，您可以在此处指定需要的数值，也可以在列表所包含的列表项（LI、DT 和 DD）中指定需要的数值。请注意，除非编写一个更为具体的选择器，否则您在此处进行的设置将会层叠到 .nav 列表。 */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* 删除上边距可以解决边距会超出其包含的 div 的问题。剩余的下边距可以使 div 与后面的任何元素保持一定距离。 */
	padding-right: 15px;
	padding-left: 15px; /* 向 div 内的元素侧边（而不是 div 自身）添加填充可避免使用任何方框模型数学。此外，也可将具有侧边填充的嵌套 div 用作替代方法。 */
}
a img { /* 此选择器将删除某些浏览器中显示在图像周围的默认蓝色边框（当该图像包含在链接中时） */
	border: none;
}
/* ~~ 站点链接的样式必须保持此顺序，包括用于创建悬停效果的选择器组在内。 ~~ */

/* ~~ 此容器包含所有其它 div，并依百分比设定其宽度 ~~ */
.container {
	width: 80%;
	max-width: 1260px;
	min-width: 780px;
	background: #FFF;
	border: 2px solid #ddd;
	margin: 200px auto 0px auto; 
}

.header {

}

.sidebar1 {
	float: left;
	width: 55%;
padding-top: 50px;
	padding-bottom: 10px;
	text-align:right;
}
.content {
	padding: 10px 0;
	width: 45%;
	float: left;
}
.sidebar2 {
	float: left;
	width: 60%;
	background: #93A5C4;
	padding: 10px 0;
}
/* ~~ 此分组的选择器为 .content 区域中的列表提供了空间 ~~ */
.content ul, .content ol {
	padding: 0 15px 15px 40px; /* 此填充反映上述标题和段落规则中的右填充。填充放置于下方可用于间隔列表中其它元素，置于左侧可用于创建缩进。您可以根据需要进行调整。 */
}
/* ~~ 导航列表样式（如果选择使用预先创建的 Spry 等弹出菜单，则可以删除此样式） ~~ */
ul.nav {
	list-style: none; /* 这将删除列表标记 */
	border-top: 1px solid #666; /* 这将为链接创建上边框 – 使用下边框将所有其它项放置在 LI 中 */
	margin-bottom: 15px; /* 这将在下面内容的导航之间创建间距 */
}
ul.nav li {
	border-bottom: 1px solid #666; /* 这将创建按钮间隔 */
}
ul.nav a, ul.nav a:visited { /* 对这些选择器进行分组可确保链接即使在访问之后也能保持其按钮外观 */
	padding: 5px 5px 5px 15px;
	display: block; /* 这将为链接赋予块属性，使其填满包含它的整个 LI。这样，整个区域都可以响应鼠标单击操作。 */
	text-decoration: none;
	background: #8090AB;
	color: #000;
}
ul.nav a:hover, ul.nav a:active, ul.nav a:focus { /* 这将更改鼠标和键盘导航的背景和文本颜色 */
	background: #6F7D94;
	color: #FFF;
}
/* ~~ 脚注 ~~ */
.footer {
	padding: 10px 0;
	border-top: 3px solid #999;
	position: relative;/* 这可以使 IE6 hasLayout 以正确方式进行清除 */
	clear: both; /* 此清除属性强制 .container 了解列的结束位置以及包含列的位置 */
}
/* ~~ 其它浮动/清除类 ~~ */
.fltrt {  /* 此类可用于在页面中使元素向右浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: right;
	margin-left: 8px;
}
.fltlft { /* 此类可用于在页面中使元素向左浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* 如果从 #container 中删除或移出了 #footer，则可以将此类放置在 <br /> 或空 div 中，作为 #container 内最后一个浮动 div 之后的最终元素 */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
form {
	margin-left: 8px;
	margin-right: 8px;
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

}
form   input {
	width:220px;
	height:25px;
	border: 1px solid #999;
}
form .submit  input {
	width:80px;
	height:30px;
	border: 1px solid #999;
	color: #777;
}
form p {
	
}

-->
</style>
<!--[if lte IE 7]>
<style>
.content { margin-right: -1px; } /* 此 1px 负边距可以放置在此布局中的任何列中，且具有相同的校正效果。 */
ul.nav a { zoom: 1; }  /* 缩放属性将为 IE 提供其需要的 hasLayout 触发器，用于校正链接之间的额外空白 */
</style>
<![endif]-->

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script language="javascript"type="text/javascript"> 
        if (top.location !== self.location) { 
            top.location=self.location; } 
        
 </script>
 <script type="text/javascript">
function check(obj){
 for(i=0;i<obj.length;i++)
 {
  if(obj.elements[i].value==''){
 //  alert("请填写完整");
	document.getElementById('errorinfo').innerHTML="用户名和密码不能为空";
   obj.elements[i].focus();
   return false;
   }
 }return true;
 
 }
</script>
<base href="<%=basePath%>" />
</head>
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
<body>
<div class="container">
  <div class="header"></div>
  <div class="sidebar1">
  <form name="loginform" id="loginform" action="login_check"

				method="post">  <div class="left1">
  <h1>企业员工管理系统</h1>
  
  </div>
  <h3 class="message"  id="errorinfo"><%=info%></h3></form>

  </div>
  <div class="content">
    <form name="loginform" id="loginform"  onsubmit="return check(this)"  action="login_check"

				method="post">
      <p>
        <label>用户名<br>
          <input type="text" name="username"

						id="user_login" class="input" value="" size="20" tabindex="10">
        </label>
      </p>
      <p>
        <label>密码<br>
          <input type="password" name="password"

						id="user_pass" class="input" value="" size="20" tabindex="20">
        </label>
      </p>
      
      <p class="submit">
        <input type="submit"  id="wp-submit" class="button-primary" value="登录" tabindex="100">
      </p>
    </form>
  </div>
  <div class="footer">
    <p>企业员工管理系统v1.0 liuk</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
</html>