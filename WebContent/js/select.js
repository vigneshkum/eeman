/*
 * 多选
 * liuk
 */

function selectall() {

	var allbox = document.getElementsByName('ids');

	if (document.getElementById('checkcan').checked == true)

		document.getElementById('checkcan').checked = false;

	for (i = 0; i < allbox.length; i++) {

		if (allbox[i].type == "checkbox" && allbox[i] != null)

			allbox[i].checked = true;

	}

}

function cancelselectall() {

	var allbox = document.getElementsByName('ids');

	if (document.getElementById('checkall').checked == true)

		document.getElementById('checkall').checked = false;

	for (i = 0; i < allbox.length; i++) {

		if (allbox[i].type == "checkbox" && allbox[i] != null)

			allbox[i].checked = false;

	}

}

function selectfan() {

	if (document.getElementById('checkall').checked == true)

		document.getElementById('checkall').checked = false;

	if (document.getElementById('checkcan').checked == true)

		document.getElementById('checkcan').checked = false;

	var allbox = document.getElementsByName('ids');

	for (i = 0; i < allbox.length; i++) {

		if (allbox[i].type == "checkbox" && allbox[i] != null) {

			if (allbox[i].checked == true)

				allbox[i].checked = false;

			else

				allbox[i].checked = true;

		}

	}

}
