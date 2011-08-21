
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="blue.liuk.service.NoticeService"%>
<%@page import="blue.liuk.model.Notice"%>
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
<%@ page import="java.util.*,java.io.*,javax.servlet.*,javax.servlet.http.*,java.lang.*" %>
<%
class EnvServlet
{
	public long timeUse=0;
	public Hashtable htParam=new Hashtable();
	private Hashtable htShowMsg=new Hashtable();
	public void setHashtable()
	{
		Properties me=System.getProperties();
		Enumeration em=me.propertyNames();
		while(em.hasMoreElements())
		{
			String strKey=(String)em.nextElement();
			String strValue=me.getProperty(strKey);
			htParam.put(strKey,strValue);
		}
	}	
	public void getHashtable(String strQuery)
	{
		Enumeration em=htParam.keys();
		while(em.hasMoreElements())
		{
			String strKey=(String)em.nextElement();
			String strValue=new String();
			if(strKey.indexOf(strQuery,0)>=0)
			{
				strValue=(String)htParam.get(strKey);
				htShowMsg.put(strKey,strValue);
			}
		}
	}
	public String queryHashtable(String strKey)
	{
		strKey=(String)htParam.get(strKey);
		return strKey;
	}
	
}
%>
<%
	EnvServlet env=new EnvServlet();
	env.setHashtable();
	String action=new String(" ");
	String act=new String("action");
	if(request.getQueryString()!=null&&request.getQueryString().indexOf(act,0)>=0)action=request.getParameter(act);
%>
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
												<td width="95%" class="STYLE1"><span class="STYLE3">您当前的位置</span>：[首页]-[系统状态]</td>
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
									<td align=left colspan=2 height=26><span class="STYLE3">当前系统信息
									</span>
									</td>
								</tr>
								<tr style="BACKGROUND-COLOR: #f7f8fa">
									<td align=left colspan=2 height=26>
									
									<h3>欢迎进入企业员工管理系统</h3>
									<!--sth  -->
									</td>
								</tr>

							</table> <!--头部表格结束  --> <!--信息表格  -->
							 <table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
          <tr class="STYLE5" height="26" >
            <td width="130">&nbsp;服务器名</td>
            <td colspan="3" height="26">&nbsp;<%= request.getServerName() %>(<%=request.getRemoteAddr()%>)</td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td>&nbsp;服务器操作系统</td>
            <td colspan="3">&nbsp;<%=env.queryHashtable("os.name")%> <%=env.queryHashtable("os.version")%> 
              <%=env.queryHashtable("sun.os.patch.level")%></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td>&nbsp;服务器操作系统类型</td>
            <td>&nbsp;<%=env.queryHashtable("os.arch")%></td>
            <td>&nbsp;服务器操作系统模式</td>
            <td>&nbsp;<%=env.queryHashtable("sun.arch.data.model")%>位</td>
          </tr>     
          <tr class="STYLE5" height="26" >
            <td>&nbsp;服务器所在地区</td>
            <td>&nbsp;<%=env.queryHashtable("user.country")%></td>
            <td>&nbsp;服务器语言</td>
            <td>&nbsp;<%=env.queryHashtable("user.language")%></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td>&nbsp;服务器时区</td>
            <td>&nbsp;<%=env.queryHashtable("user.timezone")%></td>
            <td>&nbsp;服务器时间</td>
            <td>&nbsp;<%=new java.util.Date()%> </td>
          </tr>
		  <tr class="STYLE5" height="26" >
            <td>&nbsp;服务器解译引擎</td>
            <td width="170">&nbsp;<%= getServletContext().getServerInfo() %></td>
            <td width="130">&nbsp;服务器端口</td>
            <td width="170">&nbsp;<%= request.getServerPort() %></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td height="26">&nbsp;当前用户</td>
            <td height="26" colspan="3">&nbsp;<%=env.queryHashtable("user.name")%></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td>&nbsp;用户目录</td>
            <td colspan="3">&nbsp;<%=env.queryHashtable("user.dir")%></td>
          </tr>
         
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
           <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;名称</td>
            <td width="50%" height="26">&nbsp;英文名称</td>
            <td width="20%" height="26">&nbsp;版本</td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;JAVA运行环境名称</td>
            <td width="50%" height="26">&nbsp;<%=env.queryHashtable("java.runtime.name")%></td>
            <td width="20%" height="26">&nbsp;<%=env.queryHashtable("java.runtime.version")%></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;JAVA运行环境说明书名称</td>
            <td width="50%" height="26">&nbsp;<%=env.queryHashtable("java.specification.name")%></td>
            <td width="20%" height="26">&nbsp;<%=env.queryHashtable("java.specification.version")%></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;JAVA虚拟机名称</td>
            <td width="50%" height="26">&nbsp;<%=env.queryHashtable("java.vm.name")%></td>
            <td width="20%" height="26">&nbsp;<%=env.queryHashtable("java.vm.version")%></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;JAVA虚拟机说明书名称</td>
            <td width="50%" height="26">&nbsp;<%=env.queryHashtable("java.vm.specification.name")%></td>
            <td width="20%" height="26">&nbsp;<%=env.queryHashtable("java.vm.specification.version")%></td>
          </tr>
		  <%
		  	float fFreeMemory=(float)Runtime.getRuntime().freeMemory();
			float fTotalMemory=(float)Runtime.getRuntime().totalMemory();
			float fPercent=fFreeMemory/fTotalMemory*100;
		  %>
          <tr class="STYLE5" height="26" >
		  	<td height="26">&nbsp;JAVA虚拟机剩余内存：</td>
            <td height="26" colspan="2"><%=fFreeMemory/1024/1024%>M 
            </td>
          </tr>
          <tr class="STYLE5" height="26" >
		  	<td height="26">&nbsp;JAVA虚拟机分配内存</td>
            <td height="26" colspan="2"><%=fTotalMemory/1024/1024%>M 
            </td>
          </tr>
        </table>
		<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="b5d6e6">
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;参数名称</td>
            <td width="70%" height="26">&nbsp;参数路径</td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;java.class.path </td>
            <td width="70%" height="26">&nbsp;<%=env.queryHashtable("java.class.path").replaceAll(env.queryHashtable("path.separator"),env.queryHashtable("path.separator")+"<br>&nbsp;")%>		
			</td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;java.home</td>
            <td width="70%" height="26">&nbsp;<%=env.queryHashtable("java.home")%></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;java.endorsed.dirs</td>
            <td width="70%" height="26">&nbsp;<%=env.queryHashtable("java.endorsed.dirs")%></td>
          </tr>
          <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;java.library.path</td>
            <td width="70%" height="26">&nbsp;<%=env.queryHashtable("java.library.path").replaceAll(env.queryHashtable("path.separator"),env.queryHashtable("path.separator")+"<br>&nbsp;")%>
			</td>
          </tr>
		  <tr class="STYLE5" height="26" >
            <td width="30%">&nbsp;java.io.tmpdir</td>
            <td width="70%" height="26">&nbsp;<%=env.queryHashtable("java.io.tmpdir")%></td>
          </tr>
        </table>
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
									<td>
									
									</td>
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




