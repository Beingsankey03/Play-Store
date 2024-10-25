<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <style>
        /* General body styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            min-height: 100vh;
        }

        /* Header styling */
        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            font-size: 24px;
        }

        /* Styling the form container */
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
            margin: auto;
        }

        /* Form header */
        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        /* Styling each input field */
        form div {
            margin-bottom: 15px;
            text-align: left;
        }

        /* Styling the input labels */
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }

        /* Input fields */
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }

        /* Styling the submit button */
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        button:hover {
            background-color: #45a049;
        }

        /* Error message styling */
        p {
            color: red;
            margin-top: 20px;
            font-size: 14px;
        }

        /* Footer styling */
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <header>
        PlayStore Project
    </header>

    <!-- Login Form -->
    <h2>User Login</h2>
    <form action="<%= request.getContextPath() %>/users/login" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
    <p>${error}</p> <!-- Displays error message if credentials are invalid -->

    <!-- Footer -->
    <footer>
        @All rights reserved by VenkatKVR
    </footer>

</body>
</html>
