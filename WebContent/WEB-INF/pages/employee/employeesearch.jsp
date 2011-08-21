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
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript"> 

$().ready(function() {
	// validate signup form on keyup and submit
	$("#emseform").validate({
		rules: {
			"sname":{
				minlength:1},
			"minid":{
				min:1,
				number:true},
			"maxid":{
				min:1,
					number:true},
			"sminage":{
				range:[18,160],
				number:true},
				"smaxage":{
					range:[18,160],
					number:true},
				"sworkty":{
					
					},
					"sdiv":{
						number:true
						
						},
					"sedu":{
						
						
						},
					"sworkys":{
						number:true,
						range:[0,80]
						
						}
						
	        
		   }
		})
	;});
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
									<td align=left colspan=2 height=26><span class="STYLE3">员工管理
									</span>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
									
									</td>
								</tr>
								
							</table>
						<!--头部表格结束  -->
						<!--信息表格  -->
						
					<form action="employee/search" method="get" id="emseform">
				<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">

					<tr class="STYLE6">
						<td width="300">姓名</td>
						<td><input type="text" name="sname" value="" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>id范围</td>
						<td><input type="text" name="minid" />~<input type="text"
						name="maxid" />
						</td>
					</tr>
					<tr class="STYLE6">
						<td>年龄范围</td>
						<td><input type="text" name="sminage" value="" />~<input
						type="text" name="smaxage" value="" />
						</td>
					</tr>
				
					<tr class="STYLE6">

						<td>工种</td>
						<td>
							<s:select theme="simple"  name="sworkty"  list="#{'技术':'技术','文职':'文职','管理':'管理','后勤':'后勤','其它':'其他'}"  listKey="key"  listValue="value" headerKey="%{employee.workType}" headerValue="%{employee.workType}"></s:select>
						</td>

					</tr>
					<tr class="STYLE6">
		<td>部门</td>
		<td>
			<s:select theme="simple"  label="部门" list="des" listKey="id" listValue="name"  name="sdiv" headerKey="%{employee.department.id}" headerValue="%{employee.department.name}"></s:select>
		</td>
		
		</tr>
						<tr class="STYLE6">
		<td>文化程度</td>
		<td>
			<s:select theme="simple"  name="sedu"  list="#{'高中以下':'高中以下','高中':'高中','专科':'专科','本科':'本科','硕士':'硕士','博士及以上':'博士及以上'}"  listKey="key"  listValue="value" headerKey="%{employee.education}" headerValue="%{employee.education}"></s:select>
		</td>
		
		</tr>
					<tr class="STYLE6">
						<td>工作时长（单位：年)</td>
						<td><input type="text" name="sworkys" value="" />
						</td>
					</tr>
					<tr class="STYLE6">
						
						<td colspan="2"><input type="submit" value="查找" value="" />
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
