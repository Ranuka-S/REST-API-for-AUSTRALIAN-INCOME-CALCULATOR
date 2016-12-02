<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<h2>AUSTRALIAN TAKE HOME INCOME CALCULATOR</h2>

<form method="post" id="income-form">
<label>Your Income before TAX</label>
<input type="text" name="amount" id="amount">
<label>Per</label>
<select name="frequency" id="frequency">
	<option value="WEEKLY">Weekly</option>
	<option value="FORTNIGHTLY">Fortnihtly</option>
	<option value="MONTHLY">Monthly</option>
	<option value="ANNUALLY">Annually</option>
</select>
	<br></br>
<label>Your after TAX income</label>
<label id="response"></label>
<button>Calculate my income</button>
</form>



<script type="text/javascript">
$('#income-form').submit(function(event){

event.preventDefault();
   var data= {};
   data.amount = parseInt($('#amount').val());
   data.frequency = $('#frequency').val();
alert(JSON.stringify(data));
var requestData=JSON.stringify(data);
/* stop form from submitting normally */

$.ajax({
	  url: "http://localhost:8080/AusIncomeCalculator/AUSTax/post",
	  type:"POST",
	  data: requestData,
	  contentType:"application/json; charset=utf-8",
	  dataType:"text/plain",
	  success: function(){
	    alert('success');
	  }
	});

/* Send the data using post with element id name and name2*/
/* var posting = $.post( '/AUSTax/post', requestData); */

/* Alerts the results */
/* posting.done(function( response ) {
  alert('success');
}); */
});

</script>
</body>
</html>
