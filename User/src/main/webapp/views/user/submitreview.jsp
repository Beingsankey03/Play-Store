<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review Submitted</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }

        .message-box {
            text-align: center;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
        }

        .message-box h2 {
            color: #4caf50;
        }

        a {
            text-decoration: none;
            color: #ff4d4d;
            font-weight: bold;
            margin-top: 20px;
            display: inline-block;
        }
    </style>
</head>
<body>
    <div class="message-box">
        <h2>${successMessage}</h2>
        <a href="userhome.jsp">Return to Home</a>
    </div>
</body>
</html>
