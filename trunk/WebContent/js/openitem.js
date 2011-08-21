//框架中的url跳转
//liuk
//2011年5月3日 04:36:41
//0.1.1
jQuery(document).ready(function($){   
// 按钮事件
	
$('a.itemmenu').click(function(){
	var  pageurl=$(this).attr("title");
	$('#main').attr("src",pageurl)});

});