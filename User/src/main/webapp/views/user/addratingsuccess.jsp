<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Rating Submitted</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.container {
	margin: 100px auto;
	width: 50%;
	background-color: white;
	padding: 20px;
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

button {
	background-color: #ff4d4d;
	color: white;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 4px;
}

button:hover {
	background-color: #e60000;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Rating Submitted Successfully!</h2>
		<p>Your review has been added.</p>
		<a href="${pageContext.request.contextPath}/users/getAllApplications">
			<button>Go Back to Home</button>
		</a>
	</div>
</body>
</html>
