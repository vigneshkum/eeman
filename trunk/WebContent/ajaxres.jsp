<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getem</title>
<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="js/getem.js" type="text/javascript"></script>
</head>
<body>

	<div id="main">
		<input id="emid" name=""  type="hidden" /><input id="emname" name=""  type="text" />
		<input id="getemployee" type="button" value="选择员工" onclick="getdivajax()" /><br />
		<div id="selem" style="display: none;">
		<select onchange="getemajax()"
			id="divget" name="divget" style="width: 200px;"
			class="td150">
		</select> 
		<select
			id="divselect" name="divselect" style="width: 200px;" class="td150">
		</select> 
		<input id="selectem" type="button" value="确定" onclick="getselect()" />
	</div>
	</div>
</body>
</html>