
<?xml version="1.0" encoding="UTF-8" ?>
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
		$("#emform").validate({
			rules : {
				"employee.name" : {
					required : true,
					minlength : 2
				},
				"employee.bankacc" : {
					required : true,
						creditcard: true
				},
				"employee.birthday" : {
					date : true,
					required : true

				},
				"employee.nationality" : {
					required : true

				},
				"employee.politics" : {
					required : true

				},
				"employee.birthplace" : {
					required : true

				},
				"employee.telphone" : {
					number : true,
					required : true

				},
				"employee.address" : {
					required : true

				},
				"employee.graduatedSchool" : {
					required : true

				},
				"employee.specialize" : {
					required : true

				},
				"employee.education" : {
					required : true

				},
				"employee.workType" : {
					required : true

				},
				"employee.firstWorkTime" : {
					required : true,
					date : true
				},
				"employee.regedisTtime" : {
					required : true,
					date : true
				},
				"employee.regedistName" : {
					required : true

				},
				"employee.identifycation" : {
					number : true,
					required : true,
					rangelength:[18,18] 

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
	margin-bottom: 0px;

		font-size: 13px;
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
												<td width="95%" class="STYLE1"><span class="STYLE3">您当前的位置</span>：[首页]-[员工管理]</td>
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
							<!--内容开始  -->
							<!--头部表格  -->
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								<tr class="STYLE5">
									<td align=left colspan=2 height=26><span class="STYLE3">员工信息编辑
									</span>
									</td>
								</tr>
						
								
							</table>
							<s:if test="%{employee!=null}">
					
			
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								<tr class="STYLE5">
									<td align=left colspan=2 height=26>
								<form action="employee/itrain" >
								<input type="hidden" name="id" value="<s:property value="employee.id" />" />
								<input type="submit"  value="编辑培训" />
								</form>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
									
									</td>
								</tr>
								
							</table>
								</s:if>
						<!--头部表格结束  -->
						<!--信息表格  -->
						
						<form id="emform" action="employee/save" method="post">
				<input type="hidden" name="id"
					value="<s:property value="employee.id" />" />
				<s:if test="%{employee!=null}">
					<input type="hidden" name="employee.id"
						value="<s:property value="employee.id" />" />
				</s:if>
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								
			

								<tr class="STYLE6">
						<td width="200">姓名</td>
						<td><input type="text" name="employee.name"
							value="<s:property value="employee.name" />" />
						
							<s:property value="errors.'employee.name'}" />
							
						</td>
					</tr>

	
		<tr class="STYLE6">
		<td>部门</td>
		<td>
			<s:select theme="simple"  label="部门" list="des" listKey="id" listValue="name"  name="deid" headerKey="%{employee.department.id}" headerValue="%{employee.department.name}"></s:select>
		</td>
		
		</tr>
				<tr class="STYLE6">
						<td>性别</td>
						<td><s:if test="%{null!=employee&&employee.sex==\"男\"}">
								<input type="radio" name="employee.sex" value="男"
									checked="checked" />
            男
            <input type="radio" name="employee.sex" value="女" />
            女</s:if> <s:else>
								<input type="radio" name="employee.sex" value="男" />
            男
            <input type="radio" name="employee.sex" value="女"
									checked="checked" />
            女 </s:else>
						</td>
					</tr>
					

					
					<tr class="STYLE6">
						<td>银行帐号</td>
						<td><input type="text" name="employee.bankacc"
							value="<s:property value="employee.bankacc" />" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>身份证</td>
						<td><input type="text" name="employee.identifycation"
							value="<s:property value="employee.identifycation" />" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>出生日期</td>
						<td>
						<input onfocus="showCalendarControl(this);" name="employee.birthday" type="text" value="<s:property value="employee.birthday"/>" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>民族</td>
						<td><input type="text" name="employee.nationality"
							value="<s:property value="employee.nationality" />" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>是否结婚</td>
						<td><s:if test="%{null!=employee&&1==employee.isMarried}">
								<input type="radio" name="employee.isMarried" value="1"
									checked="checked" />
            是
            <input type="radio" name="employee.isMarried" value="0" />
            否</s:if> <s:else>
								<input type="radio" name="employee.isMarried" value="1" />
            是
            <input type="radio" name="employee.isMarried" value="0"
									checked="checked" />
            否 </s:else>
						</td>
					</tr>
					<tr class="STYLE6">
						<td>政治面貌</td>
						<td>
							<s:select theme="simple"  name="employee.politics"  list="#{'党员':'党员','团员':'团员','其他':'其他'}"  listKey="key"  listValue="value" headerKey="%{employee.politics}" headerValue="%{employee.politics}"></s:select>
						</td>
					</tr>


					<tr class="STYLE6">
						<td>籍贯</td>
						<td><input type="text" name="employee.birthplace"
							value="<s:property value="employee.birthplace" />" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>电话</td>
						<td><input type="text" name="employee.telphone"
							value="<s:property value="employee.telphone" />" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>住址</td>
						<td><input type="text" name="employee.address"
							value="<s:property value="employee.address" />" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>毕业学校</td>
						<td><input type="text" name="employee.graduatedSchool"
							value="<s:property value="employee.graduatedSchool" />" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>所学专业</td>
						<td><input type="text" name="employee.specialize"
							value="<s:property value="employee.specialize" />" />
						</td>
					</tr>
				
					
					<tr class="STYLE6">
		<td>文化程度</td>
		<td>
			<s:select theme="simple"  name="employee.education"  list="#{'高中以下':'高中以下','高中':'高中','专科':'专科','本科':'本科','硕士':'硕士','博士及以上':'博士及以上'}"  listKey="key"  listValue="value" headerKey="%{employee.education}" headerValue="%{employee.education}"></s:select>
		</td>
		
		</tr>

				<tr class="STYLE6">

						<td>工种</td>
						<td>
							<s:select theme="simple"  name="employee.workType"  list="#{'技术':'技术','文职':'文职','管理':'管理','后勤':'后勤','其它':'其他'}"  listKey="key"  listValue="value" headerKey="%{employee.workType}" headerValue="%{employee.workType}"></s:select>
						</td>

					</tr>
					<tr class="STYLE6">

						<td>开始工作时间</td>
						<td>
					<input onfocus="showCalendarControl(this);" name="employee.firstWorkTime" type="text" value="<s:property value="employee.firstWorkTime"/>" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>登记时间</td>
						<td>
						<input onfocus="showCalendarControl(this);" name="employee.regedisTtime" type="text" value="<s:property value="employee.regedisTtime"/>" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>登记人</td>
						<td><input type="text" name="employee.regedistName"
							value="<s:property value="employee.regedistName" />" />
						</td>
					</tr>
				<tr class="STYLE6">
						<td>备注信息</td>
						<td><input type="text" name="employee.remark"
							value="<s:property value="employee.remark" />" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td colspan="2"><input type="reset" name="重置" value="重置" />
						<input type="submit" name="提交" value="提交" />
						</td>

					</tr>
								
              </table></form>
              <!--信息表格结束  -->
             <!-- 内容结束 -->  
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
<s:debug></s:debug>
</body>
</html>
