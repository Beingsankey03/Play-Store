<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Application Added Successfully</title>
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .message-container {
            text-align: center;
            animation: fadeIn 1s ease-in-out;
        }
        h1 {
            color: #4caf50;
            font-size: 2.5em;
            margin-bottom: 20px;
        }
        p {
            font-size: 1.2em;
            color: #555;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
        .success-icon {
            font-size: 50px;
            color: #4caf50;
        }
    </style>
</head>
<body>

    <div class="message-container">
        <div class="success-icon">✅</div>
        <h1>Congratulations!</h1>
        <p>New App has been Added Successfully...</p>
        <a href="/owners/getAllApplications">Go Back to Applications</a>
    </div>

</body>
</html>
