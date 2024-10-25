<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.model.App"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Playstore - Admin Dashboard</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.header {
	background-color: #e63946;
	color: white;
	padding: 20px;
	text-align: center;
	border-bottom: 4px solid #d62828;
}

.nav {
	display: flex;
	justify-content: space-around;
	background-color: #f1a6a6;
	padding: 15px 0;
}

.nav a {
	color: white;
	text-decoration: none;
	font-weight: bold;
}

.container {
	margin: 20px;
}

.search-bar {
	margin-bottom: 20px;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #e63946;
	border-radius: 8px;
	outline: none;
	transition: border-color 0.3s ease;
}

input[type="text"]:focus {
	border-color: #d62828;
	box-shadow: 0 0 8px rgba(230, 57, 70, 0.3);
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
	color: #007bff;
	transition: color 0.3s ease;
}

.actions a:hover {
	color: #0056b3;
}

.actions a.delete {
	color: red;
}

.actions button {
	background: none;
	border: none;
	color: red;
	cursor: pointer;
	padding: 0;
}
</style>
</head>
<body>

	<div class="header">
		<h1>Playstore - Admin Dashboard</h1>
	</div>

	<div class="nav">
		<a href="/owners/getAllApplications">View App Data</a> <a
			href="/owners/create">Add New App</a> <a href="/owners/logout">Logout</a>
	</div>

	<div class="container">
		<h2>App List</h2>

		<div class="search-bar">
			<form action="/owners/searchApplications" method="get">
				<input type="text" name="name"
					placeholder="Search by Application name or Category...">
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
					<th>Edit</th>
					<th>Delete</th>
					<th>Visibility</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<App> apps = (List<App>) request.getAttribute("applications");
				if (apps != null) {
					for (App app : apps) {
				%>
				<tr>
					<td><%=app.getName()%></td>
					<td><%=app.getCategory()%></td>
					<td><%=app.getDescription()%></td>
					<td><%=app.getVersion()%></td>
					<td><%=app.getReleaseDate()%></td>
					<td class="actions"><a
						href="/owners/getApplication/<%=app.getAppId()%>">✏️</a></td>
					<td class="actions">
						<form action="/owners/deleteApplication/<%=app.getAppId()%>"
							method="post"
							onsubmit="return confirm('Are you sure you want to delete this application?');">
							<button type="submit" class="delete">🗑️</button>
						</form>
					</td>
					<td class="actions"><a
						href="/owners/updateComment/<%=app.getAppId()%>">🔓</a></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
	<footer>
		<p>&copy; 2024 Playstore. All rights reserved.</p>
	</footer>

</body>
</html>
