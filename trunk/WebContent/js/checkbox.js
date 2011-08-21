/*
 * 表格全选操作
 * liuk 
 * 2011年5月19日 23:58:11
 */
function selectall() {

	var allbox = document.getElementsByName('ids');

	for (i = 0; i < allbox.length; i++) {
			allbox[i].checked = document.getElementById('checkall').checked;

	}

}