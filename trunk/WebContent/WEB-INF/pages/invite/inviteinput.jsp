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
<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="js/CalendarControl.js" type="text/javascript"></script>
<link href="js/CalendarControl.css" rel="stylesheet" type="text/css">
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		// validate signup form on keyup and submit
		$("#form1").validate({
			rules : {
				"inviteJob.name" : {
					required : true,
					minlength : 2
				},
				"inviteJob.sex" : {
					required : true
				},
				"inviteJob.birthday" : {
					date : true,
					required : true

				},
				"inviteJob.position" : {
					required : true
				},
				"inviteJob.profession" : {
					required : true

				},
				"inviteJob.experience" : {
					required : true

				},
				"inviteJob.education" : {
					required : true

				},
				"inviteJob.graduatedsSchool" : {
					required : true

				},
				"inviteJob.telphone" : {
					number : true,
					required : true

				},
				"inviteJob.address" : {
					required : true

				},
				"inviteJob.registTime" : {
					required : true,
					date : true
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
												<td width="95%" class="STYLE1"><span class="STYLE3">您当前的位置</span>：[首页]-[编辑招聘]</td>
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
									<td align=left colspan=2 height=26><span class="STYLE3">编辑招聘
									</span>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
								
									</td>
								</tr>

							</table> <!--头部表格结束  --> <!--信息表格  -->
						<form action="invite/save"  id="form1" method="post">
						
						
						<input type="hidden" name="id" value="<s:property value="inviteJob.id" />" />
						<s:if test="%{inviteJob!=null}">
						    <input type="hidden" name="inviteJob.id" value="<s:property value="inviteJob.id" />" />
							<input type="hidden" name="inviteJob.isEmploied" value="<s:property value="inviteJob.isEmploied" />" />
						</s:if>
						<s:else>
						<input type="hidden" name="inviteJob.isEmploied" value="-1" />
						</s:else>
						
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
			<tr class="STYLE6" >
								<td align=left   height=26  width="25%" >姓名</td>
								<td><input type="text" name="inviteJob.name" value="<s:property value="inviteJob.name"/>"/></td>
			</tr>
			<tr class="STYLE6" >
								<td align=left   height=26>性别</td>
								<td><s:if test="%{null!=inviteJob.sex&&inviteJob.sex==\"男\"}">
									<input type="radio" name="inviteJob.sex" value="男" checked="checked" />男
	            				  <input type="radio" name="inviteJob.sex" value="女" /> 女
	            				  </s:if> <s:else>
									<input type="radio" name="inviteJob.sex" value="男" />    男
	           						 <input type="radio" name="inviteJob.sex" value="女" checked="checked" /> 女 
	           						 </s:else>
           						 </td>
			</tr>
			<s:if test="%{null!=inviteJob}">
			<tr class="STYLE6" >
								<td align=left  height=26>年龄</td>
								<td><s:property value="inviteJob.age"/></td>
			</tr>
			</s:if>
			<tr class="STYLE6" >
								<td align=left  height=26>出生日期</td>
								<td>
				<input type="text" name="inviteJob.birthday" value="<s:property value="inviteJob.birthday"/>"  onfocus="showCalendarControl(this);"/>
				</td>
			</tr>
			
				<tr class="STYLE6" >
								<td align=left   height=26>应聘职位</td>
								<td>	
							
   									<s:select theme="simple"  name="inviteJob.position"  list="#{'项目经理':'项目经理','开发':'开发','测试':'测试'}"  listKey="key"  listValue="value" headerKey="%{inviteJob.position}" headerValue="%{inviteJob.position}"></s:select>
   									</td>		
			
			</tr>
			
			<tr class="STYLE6" >
								<td align=left   height=26>所学专业</td>
								<td><input type="text" name="inviteJob.profession"  value="<s:property value="inviteJob.profession"/>"/></td>
			</tr>

			<tr class="STYLE6" >
								<td align=left   height=26>工作经验</td>
								<td><input type="text" name="inviteJob.experience"  value="<s:property value="inviteJob.experience"/>"/></td>
			</tr>
		<tr class="STYLE6" >
								<td align=left   height=26>教育程度</td>
								<td>
								<s:select theme="simple"  name="inviteJob.education"  list="#{'高中以下':'高中以下','高中':'高中','专科':'专科','本科':'本科','硕士':'硕士','博士及以上':'博士及以上'}"  listKey="key"  listValue="value" headerKey="%{inviteJob.education}" headerValue="%{inviteJob.education}"></s:select>
							</td>
			</tr>
			
			<tr class="STYLE6" >
								<td align=left   height=26>毕业学校</td>
								<td><input type="text" name="inviteJob.graduatedsSchool"  value="<s:property value="inviteJob.graduatedsSchool"/>"/></td>
			</tr>
			
			<tr class="STYLE6" >
								<td align=left   height=26>电话号码</td>
								<td><input type="text" name="inviteJob.telphone"  value="<s:property value="inviteJob.telphone"/>"/></td>
			</tr>
			<tr class="STYLE6" >
								<td align=left  height=26>住址</td>
								<td><input type="text" name="inviteJob.address"  value="<s:property value="inviteJob.address"/>"/></td>
			</tr>
			<tr class="STYLE6" >
								<td align=left  height=26>申请时间</td>
								<td><input type="text"   onfocus="showCalendarControl(this);" name="inviteJob.registTime"  value="<s:property value="inviteJob.registTime"/>"/></td>
			</tr>
			
			<tr class="STYLE6" >
								<td align=left  height=26>备注</td>
								<td>
								<textarea name="inviteJob.remark"  cols=50" rows="5"  ><s:property value="inviteJob.remark" /></textarea>
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
