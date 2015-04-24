$(function() {

	$(".edit").click(function() {
		var email = $(this).attr("id");
		$.post("editcontact.vms?email=" + email, show);
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

	$("#saveexit").click(function() {
		$.ajax({
			url : "saveall.vms",
			type : "post",
			success : function(response) {
				alert("Your data has been saved successfully.")
				window.location.href = "addvendor.vms";
			}
		});
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

							$
									.ajax({
										url : "common/deletecontacts.vms?ids=" + ids,
										type : "post",
										success : function(response) {
											window.location.href = "contactmanager.jsp";
											/* $("#showcontacts").html(response); */
										}
									});
							/*
							 * $.post("vendor/deletecontacts?ids=" + ids, show);
							 * function show(data) {
							 * $("#showcontacts").html(data); } alert("It is
							 * sent to servlet: "+ids);
							 */
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
								$("#save_vendor").show();
							});
						}
					});

	$("#savevendor").click(function() {
		$.ajax({
			url : "savevendor.vms",
			type : "post",
			success : function(response) {
				alert("Your data saved successfully.")
				window.location.href = "addvendor.jsp";
			}
		});
	});
	
	$(".contact_info").keyup(function() {
		$("#save_vendor").hide();
	});
	
	$("#maintainVendorInfo").click(function() {
		window.location.href = "addvendor.jsp";
	});

});