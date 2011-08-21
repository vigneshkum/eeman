
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
			<td>
			
			 <!--头部表格结束  --> <!--信息表格  -->
			<table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="8" background="images/tab_12.gif">&nbsp;</td>
						<td>
							<!--内容开始  -->
							<!--头部表格  -->
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
					
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
									员工详细信息
										</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
										</td>
								</tr>
							</table>
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								
								<tr class="STYLE5">
									<td align=left width="80"  height=26><span class="STYLE3">姓名
									</span>
									</td>
									<td><s:property value="employee.name" /></td>
								</tr>
								<tr class="STYLE5">
									<td align=left width="80"  height=26><span class="STYLE3">部门
									</span>
									</td>
										<td colspan=2><a href="dept/get?id=<s:property value="employee.department.id" />"><s:property
						value="employee.department.name" /> </a></td>
								</tr>
								<tr class="STYLE5">
								<td align=left  height=26><span class="STYLE3">工资信息
									</span></td>
									<td align=left  height=26><a
					href="salary/getbyemid?id=<s:property value="employee.id" />">查看</a>
									</td>
								</tr>
								<tr class="STYLE5">
								<td align=left  height=26></td>
									<td align=left  height=26>
									</td>
								</tr>
							</table>
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								<tr class="STYLE5">
									<td align=left colspan=2 height=26><span class="STYLE3">奖惩信息
									</span>
									</td>
								</tr>
								<s:iterator value="employee.rewards">
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>	
									<a href="reward/get?id=<s:property value="id" />"><s:property value="title" /> </a>
									</td>
								</tr>
							</s:iterator>
							<tr class="STYLE5">
									<td align=left colspan=2 height=26>
									</td>
								</tr>
							</table>
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								<tr class="STYLE5">
									<td align=left colspan=2 height=26><span class="STYLE3">培训信息
									</span> 
									</td>
								</tr>
								
								<s:iterator value="employee.trains">
								
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>	
									<a href="train/get?id=<s:property value="id" />"><s:property
									value="title" /></a>
									
									</td>
								</tr>
					
					</s:iterator>
					<tr class="STYLE5">
									<td align=left colspan=2 height=26>
									</td>
								</tr>
							</table>
						<!--头部表格结束  -->
						<!--信息表格  -->
				<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
								
								<tr class="STYLE6" >
									<td  width="200" height="26">员工个人信息：</td>
									<td><a href="employee/edit?id=<s:property value="employee.id" />">编辑</a></td>
								</tr>
								<tr class="STYLE6" >

						<td  width="200" height="26">ID</td>
						<td class="infotd"><s:property value="employee.id" />
						</td>
					</tr>

					<tr class="STYLE6" >
						<td  width="200" height="26">性别</td>
						<td><s:property value="employee.sex" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">帐号</td>
						<td><s:property value="employee.bankacc" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">年龄</td>
						<td><s:property value="employee.age" />
						</td>
					</tr>

					<tr class="STYLE6" >
						<td  width="200" height="26">身份证号</td>
						<td><s:property value="employee.identifycation" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">出生日期</td>
						<td><s:property value="employee.birthday" /></td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">民族</td>
						<td><s:property value="employee.nationality" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">是否结婚</td>
						<td><s:if test="%{null!=employee&&1==employee.isMarried}"> 是 </s:if>
							<s:else> 否 </s:else>
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">政治面貌</td>
						<td><s:property value="employee.politics" />
						</td>
					</tr>

					<tr class="STYLE6" >
						<td  width="200" height="26">籍贯</td>
						<td><s:property value="employee.birthplace" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">电话</td>
						<td><s:property value="employee.telphone" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">住址</td>
						<td><s:property value="employee.address" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">毕业学校</td>
						<td><s:property value="employee.graduatedSchool" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">所学专业</td>
						<td><s:property value="employee.specialize" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">文化程度</td>
						<td><s:property value="employee.education" />
						</td>
					</tr>

					<tr class="STYLE6" >

						<td  width="200" height="26">工种</td>
						<td><s:property value="employee.workType" />
						</td>

					</tr>
				<tr class="STYLE6" >

						<td  width="200" height="26">开始工作时间</td>
						<td><s:property value="employee.firstWorkTime" /></td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">登记时间</td>
						<td><s:property value="employee.regedisTtime" /></td>
					</tr>
				<tr class="STYLE6" >
						<td  width="200" height="26">登记人</td>
						<td><s:property value="employee.regedistName" />
						</td>
					</tr>
					<tr class="STYLE6" >
						<td  width="200" height="26">备注信息</td>
						<td><s:property value="employee.remark" />
						</td>
					</tr>
				</table>
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
