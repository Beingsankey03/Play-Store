<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Application</title>
    <style>
        /* Global Styles */
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Card Container */
        .form-container {
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 400px;
            width: 100%;
        }

        /* Header Styles */
        h2 {
            text-align: center;
            color: #e63946;
            margin-bottom: 20px;
        }

        /* Form Styles */
        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-top: 10px;
            color: #333;
            font-weight: bold;
        }

        input, textarea, button {
            margin-top: 5px;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #e63946;
            border-radius: 8px;
            outline: none;
        }

        input:focus, textarea:focus {
            border-color: #d62828;
            box-shadow: 0 0 8px rgba(230, 57, 70, 0.3);
        }

        textarea {
            resize: none;
        }

        button {
            background-color: #e63946;
            color: white;
            border: none;
            margin-top: 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #d62828;
        }

        /* Mobile Responsiveness */
        @media (max-width: 600px) {
            .form-container {
                padding: 20px;
            }

            input, textarea, button {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Edit Application</h2>
       
        <form action="${pageContext.request.contextPath}/owners/updateApp/${app.id}" method="post">
        
            <input type="hidden" name="id" value="${app.id}">
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${app.name}" required>

            <label for="category">Category:</label>
            <input type="text" id="category" name="category" value="${app.category}" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="3" required>${app.description}</textarea>

            <label for="genre">Genre:</label>
            <input type="text" id="genre" name="genre" value="${app.genre}" required>

            <label for="rating">Rating (0-5):</label>
            <input type="number" step="0.1" id="rating" name="rating" value="${app.rating}" min="0" max="5" required>

            <label for="releaseDate">Release Date:</label>
            <input type="date" id="releaseDate" name="releaseDate" value="${app.releaseDate}" required>

            <label for="version">Version:</label>
            <input type="text" id="version" name="version" value="${app.version}" required>

            <button type="submit">Update Application</button>
        </form>
    </div>

</body>
</html>
