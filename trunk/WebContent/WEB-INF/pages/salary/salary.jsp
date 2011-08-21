
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

<script type="text/javascript">
	
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
 a {
	color: #36F;
	text-decoration: none;
}

 a:hover {
	color: #F3C;
}
.STYLE7 {
	BACKGROUND-COLOR: #f7f8fa;
	color: #ff0000;
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
												<td width="95%" class="STYLE1"><span class="STYLE3">您当前的位置</span>：[首页]-[员工工资计算]</td>
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
									<td align=left colspan=2 height=26><span class="STYLE3"><s:if test="%{null==pay}"> 工资计算 </s:if>
			<s:else>工资报表  </s:else>
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
						
				
				
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
				
			 <tr class="STYLE6">
					<td colspan="3" height="26">员工姓名：
					<a href="employee/get?id=<s:property value='pay.employee.id'/>"><s:property value="pay.employee.name" /></a>
					</td>
				</tr>
			 <tr class="STYLE6">
					<td colspan="3" height="26">工资编号：
					<a href="salary/get?id=<s:property value="pay.id" />"><s:property value="pay.id" /></a>
					</td>
				</tr>
			 <tr class="STYLE6">
					<td width=150 height="26">基本工资￥：</td>
					<td width="100" class="STYLE7 ">+</td>
					<td><s:property value="pay.basePay" />
					</td>
				</tr>
			 <tr class="STYLE6">
					<td height="26">加班费￥：</td>
					<td class="STYLE7 ">+</td>
					<td><s:property value="pay.extraPay" />
					</td>
				</tr>
				 <tr class="STYLE6">
					<td height="26">考勤费￥：</td>
					<td class="STYLE7 ">-</td>
					<td><s:property value="pay.attendPay" />
					</td>
				</tr>
			 <tr class="STYLE6">
					<td height="26">旷工费￥：</td>
					<td class="STYLE7 ">-</td>
					<td><s:property value="pay.absentPay" />
					</td>
				</tr>
			 <tr class="STYLE6">
					<td height="26">保险费￥：</td>
					<td class="STYLE7 ">-</td>
					<td><s:property value="pay.insurancePay" />
				</td>
				</tr>
				<s:iterator value="pay.employee.rewards">
				 <tr class="STYLE6">
				 <td height="26"><s:property value="title" />(<s:property value="type" />)￥:</td>
					<td class="STYLE7 ">
					<s:if test="%{'奖励'==type}">
					+
					</s:if><s:else>
					-
					</s:else>
					</td>
					
					<td><s:property value="penalty" />
				</td>
				</tr>
				</s:iterator>
			 <tr class="STYLE6">
					<td height="26">实发工资￥：</td>
					<td class="STYLE7 ">=</td>
					<td class="STYLE7"><s:property value="salarynum" />
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
