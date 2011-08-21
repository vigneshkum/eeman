<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>new Division</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>" />
</head>
<body>
	<form action="dept/save" method="post" name="form1">
		<div id="main">
			<input type="hidden" name="id" value="<s:property value='dp.id'/>" />
			<s:if test="%{null!=dp}">
					<input type="hidden" name="dp.id"
						value="<s:property value="dp.id" />" />
				</s:if>
			修改部门<br />
			 部门名<input name="dp.name" type="text" value="<s:property value='dp.name'/>" /><br />
			  创建时间 <input  type="text"  name="dp.buildTime"  value="<s:property value='dp.buildTime'/>" /> <br /> 
			  备注<input name="dp.remark" type="text" value="<s:property value='dp.remark'/>" /><br />
			<input name="" type="submit" value="确定" /> 
			<input name="" type="button" value="重置" /><br /> <br />
			<s:debug></s:debug>
		</div>
	</form>
</body>
</html>