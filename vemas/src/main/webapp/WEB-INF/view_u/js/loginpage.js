$(function() {
	$("#forgotpwd")
			.click(
					function() {
						var email = $("#email").val(), email_illegalChars = /[\(\)\<\>\,\;\:\\\/\"\[\]]/, email_filter = /^.+@.+\..{2,3}$/;

						if(email.length <= 0) {
							alert("Please enter a valid Email ID to continue.");
						} else if (!email_filter.test(email)
								|| email.match(email_illegalChars)) {
							alert("Please enter a valid Email ID.");
						} else {
							window.location.href = "forgotpwdform.jsp?email="
									+ email;
						}
					});

	/*
	 * $(".pass").keyup(function() { alert("hi"); $("#invalid").hide(); });
	 */
});