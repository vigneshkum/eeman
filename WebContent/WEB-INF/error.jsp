<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>





	<div id="main">
		<h2 class="error">Sorry! Error !</h2>
		<p>请用一下内容联系管理员：Emial</p>
		<s:property value="exception" />
		<br />
		<br />
		<s:property value="errors" />
		<br />
		<s:debug></s:debug>
	</div>

</body>
</html>