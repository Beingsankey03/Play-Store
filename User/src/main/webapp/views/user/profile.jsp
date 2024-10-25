<!-- File: WEB-INF/views/user/profile.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
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

        /* Styling the profile container */
        h2, h3 {
            color: #333;
            text-align: center;
        }

        p {
            color: #333;
            text-align: center;
            font-size: 16px;
        }

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

        form div {
            margin-bottom: 15px;
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="password"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }

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

        p {
            color: #4CAF50;
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

    <!-- User Profile Section -->
    <h2>Welcome, ${user.username}!</h2>
    <p>Email: ${user.email}</p>

    <!-- Update Profile Form -->
    <h3>Update Profile</h3>
    <form action="<%= request.getContextPath() %>/users/update" method="post">
        <input type="number" name="id" value="${user.id}" hidden/> <!-- Hidden input for ID -->
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}" required/>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${user.password}" required/>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="${user.email}" required/>
        </div>
        <div>
            <button type="submit">Update</button>
        </div>
    </form>

    <p>${message}</p> <!-- Displays success message after profile update -->

    <!-- Footer -->
    <footer>
        @All rights reserved by VenkatKVR
    </footer>

</body>
</html>
