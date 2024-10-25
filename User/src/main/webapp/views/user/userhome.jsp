<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.model.App"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Play Store - User Dashboard</title>
<style>
/* Styling the body and header */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.header {
	background-color: #ff4d4d;
	color: white;
	padding: 20px;
	text-align: center;
}

.nav {
	display: flex;
	justify-content: flex-end;
	background-color: #ff6666;
	padding: 15px 0;
}

.nav a {
	color: white;
	text-decoration: none;
	font-weight: bold;
	margin-right: 20px;
}

.container {
	margin: 20px;
}

.search-bar {
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 12px;
	text-align: left;
}

th {
	background-color: #ff9999;
	color: white;
}

.actions a {
	margin-right: 10px;
	text-decoration: none;
}

.actions a.add-review {
	color: green;
}

.actions a.add-rating {
	color: orange;
}

.actions a.download {
	color: #007bff;
}
/* Download Animation Styles */
#download-success {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: #4caf50;
	color: white;
	padding: 20px;
	border-radius: 10px;
	text-align: center;
	display: none; /* Hidden initially */
	animation: fadeOut 2s ease-in-out;
}

@
keyframes fadeOut { 0% {
	opacity: 1;
}
100
%
{
opacity
:
0;
}
}
</style>
</head>
<body>
	<div class="header">
		<h1>Play Store - User Dashboard</h1>
	</div>

	<div class="nav">
		<a href="/users/getAllApplications">View All Apps</a> <a
			href="/users/logout">Logout</a>

	</div>

	<div class="container">
		<h2>App List</h2>

		<c:if test="${not empty error}">
			<div style="color: red;">${error}</div>
		</c:if>

		<div class="search-bar">
			<form action="/users/searchApplications" method="get">
				<input type="text" name="name" placeholder="Search by app name..."
					style="width: 45%; padding: 10px" /> <input type="text"
					name="category" placeholder="Search by category..."
					style="width: 45%; padding: 10px" />
				<button type="submit">Search</button>
			</form>
		</div>

		<table>
			<thead>
				<tr>
					<th>App Name</th>
					<th>Category</th>
					<th>Description</th>
					<th>Version</th>
					<th>Release Date</th>
					<th>Add Review</th>
					<th>Add Rating</th>
					<th>Download</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<App> apps = (List<App>) request.getAttribute("applications");
				if (apps != null && !apps.isEmpty()) {
					for (App app : apps) {
				%>
				<tr>
					<td><%=app.getName()%></td>
					<td><%=app.getCategory()%></td>
					<td><%=app.getDescription()%></td>
					<td><%=app.getVersion()%></td>
					<td><%=app.getReleaseDate()%></td>
					<td class="actions"><a
						href="/users/addReview?appId=<%=app.getAppId()%>"
						class="add-review">✏️</a></td>

					<td class="actions">    <a href="${pageContext.request.contextPath}/users/addRating">Add Rating</a>
</td>
					<td class="actions"><a href="#" class="download"
						onclick="showDownloadSuccess()">⬇️</a></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="8">No applications found.</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<!-- Download Success Animation -->
	<div id="download-success">Download Successful! ✅</div>

	<footer>All rights reserved SANKET NADARGI</footer>

	<script>
        // JavaScript to show download animation
        function showDownloadSuccess() {
            const downloadSuccess = document.getElementById("download-success");
            downloadSuccess.style.display = "block";
            
            // Hide the animation after 4.5 seconds
            setTimeout(() => {
                downloadSuccess.style.display = "none";
            }, 4500);
        }
    </script>
</body>
</html>
