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
												<td width="95%" class="STYLE1"><span class="STYLE3">您当前的位置</span>：[首页]-[招聘人员审核]</td>
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
									<td align=left colspan=2 height=26><span class="STYLE3">招聘人员审核
									</span>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
										1.输入审核人姓名2.输入审核说明
									</td>
								</tr>

							</table> <!--头部表格结束  --> <!--信息表格  -->
						<form action="invite/dovefify" method="post">
						
						
						<input type="hidden" name="id" value="<s:property value="inviteJob.id" />" />
					

							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
			<tr class="STYLE6" >
								<td align=left   height=26>招聘人员姓名</td>
								<td><s:property value="inviteJob.name"/></td>
			</tr>
			<tr class="STYLE6" >
								<td align=left   height=26>审核</td>
								<td>
								<s:if test="%{1==inviteJob.isEmploied}">
								<input  name="inviteJob.isEmploied" type="radio" checked="checked"  value="1"   />通过
								<input  name="inviteJob.isEmploied" type="radio"   value="0"   />不通过
								<input  name="inviteJob.isEmploied" type="radio"   value="-1"   />待审核
								</s:if>
								<s:elseif test="%{0==inviteJob.isEmploied}">
									<input  name="inviteJob.isEmploied" type="radio" value="1"   />通过
								<input  name="inviteJob.isEmploied" type="radio"   value="0" checked="checked"     />不通过
								<input  name="inviteJob.isEmploied" type="radio"   value="-1"   />待审核
								</s:elseif>
								<s:else>
									<input  name="inviteJob.isEmploied" type="radio" value="1"   />通过
								<input  name="inviteJob.isEmploied" type="radio"   value="0"   />不通过
								<input  name="inviteJob.isEmploied" type="radio"   value="-1" checked="checked"    />待审核
								</s:else>
										
								
								</td>
			</tr>
			
			
			<tr class="STYLE6" >
								<td align=left   height=26>审核人</td>
								<td><input type="text" name="inviteJob.verfifyName" value="<s:property value="inviteJob.verfifyName" />" /></td>
			</tr>
			
			<tr class="STYLE6" >
								<td align=left   height=26>审核操作用户</td>
								<td><input type="text" name="inviteJob.verfifyOperateName" value="<s:property value="inviteJob.verfifyOperateName" />" /></td>
			</tr>
				
			<tr class="STYLE6" >
								<td align=left   height=26>审核说明</td>
								<td>
								<textarea name="inviteJob.verfifyNote"  cols="100" rows="5"  ><s:property value="inviteJob.verfifyNote" /></textarea>
								</td>
			</tr>	
			
			<tr class="STYLE6" >
								<td align=left  height=26>备注</td>
								<td>
								<textarea name="inviteJob.remark"  cols=100" rows="5"  ><s:property value="inviteJob.remark" /></textarea>
								</td>
			</tr>
			
			<tr class="STYLE6" >
								<td align=left colspan=2  height=26><s:if test="%{inviteJob!=null}">
				<input type="submit" value="更新" />
				<br>
			</s:if>
			<s:else>
				<input type="submit" value="保存" />
				<br>
			</s:else></td>
								
			</tr>

		

							
							
							</table></form> <!--信息表格结束  --> <!-- 内容结束 -->
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
									<td></td>
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
