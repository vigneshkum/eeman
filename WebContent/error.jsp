<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Date"%>
<%@page import="blue.liuk.util.GetSth"%>
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
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;

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
	BACKGROUND-COLOR: #f7f8fa;
}
.error{
color:#ff0000;
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
												<td width="95%" class="STYLE1"><span class="STYLE3">您当前的位置</span>：[首页]-[错误信息]</td>
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
			<td><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="8" background="images/tab_12.gif">&nbsp;</td>
						<td>
							<!--内容开始  --> <!--头部表格  -->
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								<tr class="STYLE5">
									<td align=left colspan=2 height=26><span class="STYLE3">错误信息
									</span>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
									<!--sth  -->
									请尝试根据以下提示解决问题，如果仍有问题，请联系管理员
									</td>
								</tr>

							</table> <!--头部表格结束  --> <!--信息表格  -->
															
																<s:if test="hasFieldErrors()">
										<s:iterator value="fieldErrors">
											<s:iterator value="value" status="statu">
												<s:set name="msg" value="((#msg==null || #msg=='')?'':#msg+'\\\n')" />
												<s:set name="msg"
													value="#msg+value.get(#statu.getIndex()).toString()" />
											</s:iterator>
										</s:iterator>
									</s:if>
								
									<!--  //actionerror-->
									<s:if test="hasActionErrors()">
										<s:iterator value="actionErrors">
											<script language="JavaScript">
												alert("<s:property escape="false"/>")
											</script>
										</s:iterator>
									</s:if>
								
									<!--  //actionmessage-->
									<s:if test="hasActionMessages()">
										<s:iterator value="actionMessages">
											<script language="JavaScript">
												alert("<s:property escape="false"/>")
											</script>
										</s:iterator>
									</s:if>
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">

								<tr class="STYLE6">
									<td align=left colspan=8 height=26 class="error">
										
										<s:if test="#msg.length()>0">		<s:property escape="false" value="#msg"/></s:if>
									</td>
								</tr>
								<tr class="STYLE6" >
									<td align=left colspan=8 height=26  class="error">
									<s:property value="exception" />
									</td>
								</tr>
								<tr class="STYLE6">
									<td align=left colspan=8 height=26>
										<%=GetSth.fDate(new Date(),"yyyy-MM-dd") %>
									</td>
								</tr>
								<tr class="STYLE6">
									<td align=left colspan=8 height=26>
										<a href="javascript:history.go(-1);">返回</a>
									</td>
								</tr>
							
							</table> <!--信息表格结束  --> <!-- 内容结束 -->
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
									<td>员工管理系统 by：liuk</td>
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