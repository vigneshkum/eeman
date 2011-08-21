/*
 * ajsx通过部门获取员工
 * liuk 
 * 2010年12月30日 10:48:11
 */
jQuery(document).ready(function($){
	
	$("#divselect").dblclick(function(){
		alert($("#divselect").val());
		
	});
	$("#divget").dblclick(function(){
		//alert($("#divget").val());
		var divid=$("#divget").val();
		 document.getElementById("divid").value=divid;
	});
	
});
function getdivajax() {
	// jQuery(document).ready(function($){
	
	var url = "getdiv";
	
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
		success : function(msg) {
			$("#divget").get(0).length=0;
			for (i = 0; i < msg.divs.length; i++) {
				$("#divget").get(0).options.add(new Option(msg.divs[i].name,
						msg.divs[i].id));
				// alert("Data Saved: " + msg.data[i].name);
			}
		},
		error : function() {
			alert("errot");
		}
	});
	
}

function getemajax() {
	// jQuery(document).ready(function($){
	var value = document.getElementById("divid").value;
	var url = "getem?divid=";
	url = url + value;
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
		success : function(msg) {
		//	$("#divselect").get(0).lenght=0;
			document.getElementById("divselect").length=0;
			for (i = 0; i < msg.data.length; i++) {
				$("#divselect").get(0).options.add(new Option(msg.data[i].name,
						msg.data[i].id));
				// alert("Data Saved: " + msg.data[i].name);
			}
		},
		error : function() {
			alert("errot");
		}
	});
	
}
function getselect(){
	alert($("#divselect").val());
}