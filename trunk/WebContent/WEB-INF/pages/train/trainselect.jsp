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
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/messages_cn.js" type="text/javascript"></script>
<script src="js/checkbox.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
	
		$("#trainform").validate({
			rules : {
				"id" : {
					number : true,
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
												<td width="95%" class="STYLE1"><span class="STYLE3">您当前的位置</span>：[首页]-[培训信息]</td>
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
									<td align=left colspan=2 height=26><span class="STYLE3">培训信息
									</span>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
										<form action="train/get" method="get" id="trainform">
									<input type="text" name="id" /><input class="button" type="submit"
									value="ID" />
									</form>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
									<form action="train/getbytitle" method="get" id="emsinfo">
							<input type="text" name="title" /><input class="button"
				type="submit" value="主题" />
							</form>
									</td>
								</tr>

							</table> <!--头部表格结束  --> <!--信息表格  -->
						<form action="train/deletemore" >
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">

						

								<tr class="STYLE6">
									<td height=26><input type="checkbox" name="CheckboxGroup1"
										value="复选框" id="checkall"  onclick="selectall()" />
										 <!--信息表头  -->
										
									</td>
										<td>ID</td>
						<td>培训主题</td>
						<td>培训导师</td>
						<td>培训时间</td>
						
						<td>培训地址</td>
						<td>查看详情</td>
						<td>删除记录</td>
						<td>查看所有员工</td>
								</tr>

								<s:iterator value="trains">
									<tr class="STYLE6"   >
 												<!--信息循环  -->
 												<td height="26"><input type="checkbox" name="ids" 
								value="<s:property value="id" />" />
							</td>

							<td><s:property value="id" />
							</td>
							<td><s:property value="title" />
							</td>
							<td><s:property value="name" />
							</td>
							<td><s:property value="time" />
							</td>
							
							<td><s:property value="address" />
							</td>
							<td><a href="train/get?id=<s:property value="id"/>">查看详情</a>
							</td>
							<td><a href="train/delete?id=<s:property value="id" />">删除记录</a>
							</td>
							<td><a
								href="train/getems?id=<s:property value="id" />">参加人员</a>
							</td>
									</tr>
								</s:iterator>
								<tr class="STYLE6">
									<td height=26 colspan="16">
									<input type="submit" value="删除所选" />
									</td>
								
									
								</tr>
							</table> <!--信息表格结束  --> <!-- 内容结束 --></form> 
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
			<s:if test="%{pagelist.pageNum!=pagelist.pageTotalCount&&pagelist.pageNextNum>0}">
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

