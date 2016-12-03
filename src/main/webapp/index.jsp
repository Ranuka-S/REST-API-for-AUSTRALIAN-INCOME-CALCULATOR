<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<h2>AUSTRALIAN TAKE HOME INCOME CALCULATOR</h2>

	<form method="post" id="income-form">
		<label>Your Income before TAX</label> <input type="text" name="amount"id="amount">
		
		<label>Per</label> <select name="frequency" id="frequency">
			<option value="WEEKLY">Weekly</option>
			<option value="FORTNIGHTLY">Fortnihtly</option>
			<option value="MONTHLY">Monthly</option>
			<option value="ANNUALLY">Annually</option>
		</select>

		<button>Calculate my income</button>
		<br></br><label id="response"></label>
	</form>

	<script type="text/javascript">
		$('#income-form').submit(function(event) {

			event.preventDefault();
			var data = {};
			data.amount = parseInt($('#amount').val());
			data.frequency = $('#frequency').val();
			var requestData = JSON.stringify(data);

			$.ajax({
				url : "/AusIncomeCalculator/AUSTax/post",
				type : "POST",
				data : requestData,
				contentType : "application/json; charset=utf-8",
				success : function(responseData) {
					$('#response').text(responseData);
				},
				error : function(responseData, textStatus, errorThrown) {
					alert("Failed error...dedjfhf" + errorThrown);
				}
			});

		});
	</script>
</body>
</html>
