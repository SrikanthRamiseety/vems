$(function() {
	
	$("#password").keyup(function() {
		var password = $("#password").val();
		
		var desc = new Array();
		desc[0] = "";
		desc[1] = "Weak";
		desc[2] = "Better";
		desc[3] = "Medium";
		desc[4] = "Strong";
		desc[5] = "Strongest";

		var score = 0;
		
		// if password bigger than 6 give 1 point
		if (password.length > 6)
			score++;

		// if password has both lower and uppercase characters give 1 point
		if ((password.match(/[a-z]/)))
			score++;
		if (password.match(/[A-Z]/))
			score++;
		// if password has at least one number give 1 point
		if (password.match(/\d+/))
			score++;

		// if password has at least one special caracther give 1 point
		if (password.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/))
			score++;

		// if password bigger than 12 give another 1 point
		if (password.length > 12)
			score++;
		if(score>5)
			score=5;
		
		document.getElementById("passwordDescription").innerHTML = desc[score];
		document.getElementById("passwordStrength").className = "strength"
				+ score;
	});

	$("#a").click(function() {
		var con = confirm("All unsaved data will be lost. Do u want to continue?");
		if (con) {
			document.getElementById("passwordDescription").innerHTML = '';
			$("#passwordStrength").prop("class","strength0");
			$("input").each(function() {
				$(this).val('');
				$(".alert").remove();
				$(".item").prop("class", "item form-group");
			});
			
			
			$("select").each(function() {
				$(this).val('');
				
			});
			
			
			
		}
		
		
		
	});
});
