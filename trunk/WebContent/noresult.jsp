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
		<div>
			<h2 class="error">没有符合条件的结果！</h2>
			<s:property value="fieldErrors" />
		</div>
		<a href="javascript:history.go(-1);">返回</a> <a href="index.jsp">Index</a>
		<s:debug></s:debug>
	</div>

</body>
</html>