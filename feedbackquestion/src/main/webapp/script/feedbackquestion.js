$(document).ready(function() {
	$('#addRegister').click(function() {

		var user = {
			userName: $("#userName").val(),
			userAge: $("#userAge").val(),
			userEmail: $("#userEmail").val(),
		};


		$.ajax({
			type: "post",
			datatype: "text",
			contenttype: "application/json",
			data: { userData: JSON.stringify(user) },
			url: "/submitRegistration",
			success: function(data) {
				location.href = data;

			},
		});
	});
});

$(document).ready(function() {
	$.ajax({
		type: "get",
		datatype: "json",
		contenttype: "application/json",
		url: "/giveFeedback",
		success: function(data) {
			var feedbackForm = $("#feedbackForm");
			for (var i = 0; i < data.length; i++) {
				var questionIndex = i + 1;
				var question = data[i];
				var questionId = 'p' + questionIndex;
				// Create question element
				var questionElement = $("<p>").attr("id", questionId).text(question.questionValue);
				feedbackForm.append(questionElement);
				for (var j = 1; j <= 4; j++) {
					var optionIndex = j;
					var optionId = 'op' + questionIndex + optionIndex;
					var optionTextId = 'p' + questionIndex + optionIndex;
					var optionField = 'option' + String.fromCharCode(64 + j);
					// Create option elements
					var optionLabel = $("<label>").attr("for", optionId).text(question[optionField]);
					var optionInput = $("<input>").attr({
						type: "radio",
						name: "feedback" + questionIndex,
						id: optionId,
						value: question[optionField]
					});
					var lineBreak = $("<br>");
					feedbackForm.append(optionInput, optionLabel, lineBreak);
				}
			}
		},
	});
	$(document).ready(function() {
		$('#submitFeedback').click(function() {
			var userAnswers = {};
			for (var i = 1; i <= 5; i++) {
				var answer = "";
				for (var j = 1; j <= 4; j++) {
					var optionId = 'op' + i + j;
					if (document.getElementById(optionId).checked) {
						answer = document.getElementById(optionId).value;
						break;
					}
				}
				if (answer === "") {
					alert("Please fill all the values");
					return;
				}
				userAnswers['answer' + i] = answer;
			}
			alert(JSON.stringify(userAnswers));

			$.ajax({
				type: "post",
				datatype: "text",
				contenttype: "application/json",
				url: "/submitFeedback",
				data: { userAnswers: JSON.stringify(userAnswers) },
				success: function(data) {
					location.href = data;
					


				},
			});
		});
	});
});

