$(function() {
	var duplicate = "${sessionScope.duplicateEntry}";
	alert(duplicate);
	$(".edit").click(function() {
		var email = $(this).attr("id");
		$.post("vendor/editcontact?email=" + email, show);
		function show(data) {
			$("#addcontactform").html(data);
		}
	});

	$("#deleteall").click(function(event) {
		var $that = $(this);

		$(":checkbox").each(function() {
			this.checked = $that.is(":checked");
		})
	});

	$(".delete").click(function() {
		if ($(".delete").length == $(".delete:checked").length) {
			$("#deleteall").prop("checked", $(this).is(":checked"));
		} else {
			$("#deleteall").prop("checked", false);
		}
	});

	$(".saveExit")
			.click(
					function() {
						alert("Contacts saved successfully.\nYou will now be redirected to add vendor page");
						window.location.replace("addvendor.jsp");
					});

	$("#deletebtn")
			.click(
					function() {
						var choice = confirm("Selected data will be deleted. Are you sure you want to continue?");
						if (choice) {
							var ids = new Array();
							var count = 0;
							$(":checkbox").each(function() {
								if ($(this).is(":checked")) {
									if ($(this).attr("id") != "deleteall")
										ids[count++] = $(this).attr("id");
								}
							})
							
							$.ajax({
								url:"vendor/deletecontacts?ids=" + ids,
								type:"post",
								success:function(response){
									window.location.href = "contactmanager.jsp";
									/*$("#showcontacts").html(response);*/
								}
							});
							/*$.post("vendor/deletecontacts?ids=" + ids, show);
							function show(data) {
								$("#showcontacts").html(data);
							}
							alert("It is sent to servlet: "+ids);*/
						}
					});

	$("#cancel")
			.click(
					function() {
						var choice = confirm("All unsaved data will be lost. Are you sure you want to continue?");

						if (choice) {
							window.location.replace("addvendor.jsp");
						}
					});

	$("#reset")
			.click(
					function() {
						var choice = confirm("All unsaved data will be lost. Are you sure you want to continue?");

						if (choice) {
							$("input").each(function() {
								$(this).val('');
								$(".alert").remove();
								$(".item").prop("class", "item form-group");
							});
						}
					});
});