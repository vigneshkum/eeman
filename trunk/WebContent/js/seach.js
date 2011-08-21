
/*
 * 搜索参数
 * liuk 
 * 2010年12月30日 10:48:11
 */
$("#pagenav a").click(function(){
		//获取页码URL
		var  pageurl=$(this).attr("href");

		//获取页码参数
		var  para=pageurl.substr(pageurl.indexOf("?")+1);
		//	alert(para);
		//获取当前页面地址，包含搜索参数
		var thisurl=window.location.href;
		if(thisurl.lastIndexOf("?")!=-1){
		thisurl+="&timesimp="+ new Date().getTime();}
		else{thisurl+="?timesimp="+ new Date().getTime();	}
		var desurl; 

		//pagelist 过滤掉已经存的页码
		
		if(thisurl.lastIndexOf("pagelist")!=-1){
		thisurl=thisurl.substr(0,thisurl.lastIndexOf("pagelist")-1);
		}
		//加上页码参数
		desurl=thisurl+"&"+para;

		$(this).attr("href",desurl);
	});