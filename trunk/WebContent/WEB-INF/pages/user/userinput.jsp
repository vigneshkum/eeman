<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<script src="js/CalendarControl.js" type="text/javascript"></script>
<link href="js/CalendarControl.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="js/CalendarControl.js" type="text/javascript"></script>
<link href="js/CalendarControl.css" rel="stylesheet" type="text/css">
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/messages_cn.js" type="text/javascript"></script>
<script src="js/getem.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		// validate signup form on keyup and submit
		$("#form1").validate({
			rules : {
				"role.name" : {
					required : true
				},
				"role.description" : {
					required : true
				}
				
			}
		});
	});
</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;	font-size: 13px;
	font-family: "微软雅黑"
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}

.STYLE5 {
	BACKGROUND-COLOR: #f7f8fa
}

.STYLE6 {
	BACKGROUND-COLOR: #f7f8fa
}
-->
</style>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" background="images/tab_05.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="30"><img src="images/tab_03.gif"
							width="12" height="30" />
						</td>
						<td><table width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td width="46%" valign="middle"><table width="100%"
											border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="2%"><div align="center"></div>
												</td>
												<td width="95%" class="STYLE1"><span class="STYLE3">您当前的位置</span>：[首页]-[编辑用户信息]</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						<td width="16"><img src="images/tab_07.gif" width="16"
							height="30" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
			
			<table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="8" background="images/tab_12.gif">&nbsp;</td>
						<td>
							<!--内容开始  --> <!--头部表格  -->
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								<tr class="STYLE5">
									<td align=left colspan=2 height=26><span class="STYLE3">编辑用户
									</span>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
									<!--sth  -->
									</td>
								</tr>

							</table> <!--头部表格结束  --> <!--信息表格  -->
							<form action="user/save" method="POST">

										<input type="hidden" name="user.id" value="<s:property value="user.id" />"  />
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">

						

								<tr class="STYLE6" height=26>
									<td>用户名(不可以修改)</td>
									<td><s:property value="user.username"  /> </td>
								
								</tr>
								<tr class="STYLE6"  height=26>
									<td>是否启用</td>
									<td>
					<input type="radio" name="user.enable"  value="1"  checked="checked" />启用
					<input type="radio" name="user.enable"  value="0"  />禁用
					</td>
								
								</tr>
								
								
								<tr class="STYLE6">
					<td>所属员工</td>
					<td>
					<div id="main">
		<input id="emid" name="employeeid"  type="hidden" value="<s:property value="user.employee.id" />"  /><input id="emname"  type="text" value="<s:property value="user.employee.name" />" />
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
					</td>
				</tr>
				
								
								<tr class="STYLE6">
									<td>描述</td>
									<td>
						<textarea name="user.description" cols="100" rows="10"  ><s:property value="user.description" /></textarea>
					</td>	
								</tr>
								
									<tr class="STYLE6">
 												<td colspan="2"><input value="修改" type="submit" />
									</tr>
								
							</table> <!--信息表格结束  --> <!-- 内容结束 -->
							</form>
						</td>
						<td width="8" background="images/tab_15.gif">&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="35" background="images/tab_19.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="35"><img src="images/tab_18.gif"
							width="12" height="35" />
						</td>
						<td><table width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td><div id="nav">
											<s:if test="%{pagelist.pageNum!=1}">
												<s:a
													href="%{pagelist.url}%{pagelist.para}pagelist.pageNum=%{pagelist.pagePreNum}">上一页</s:a>
											</s:if>
											<s:if test="%{pagelist.pageTotalCount>1}">
												<s:iterator value="pagelist.pageNums" status="st">
													<s:if test="%{pagelist.pageNum==#st.index+1}">
														<s:property />
													</s:if>
													<s:else>
														<s:a
															href="%{pagelist.url}%{pagelist.para}pagelist.pageNum=%{#st.index+1}">
															<s:property />
														</s:a>
													</s:else>
												</s:iterator>
											</s:if>
											<s:if test="%{pagelist.pageNum!=pagelist.pageTotalCount}">
												<s:a
													href="%{pagelist.url}%{pagelist.para}pagelist.pageNum=%{pagelist.pageNextNum}">下一页</s:a>
											</s:if>
										</div></td>
									<td class="STYLE4">&nbsp;&nbsp;</td>
								</tr>
							</table>
						</td>
						<td width="16"><img src="images/tab_20.gif" width="16"
							height="35" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
