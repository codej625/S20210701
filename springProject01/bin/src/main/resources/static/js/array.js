		var send_array = Array();
		var send_cnt = 0;
		var chkbox = $(".checkSelect");

		for (i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked == true) {
				send_array[send_cnt] = chkbox[i].value;
				send_cnt++;
			}
		}

		$("#array").val(send_array);
