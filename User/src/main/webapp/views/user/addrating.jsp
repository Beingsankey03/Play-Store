<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Rate App</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

.container {
	max-width: 500px;
	margin: auto;
	background-color: white;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.stars {
	display: flex;
	justify-content: center;
	margin-bottom: 20px;
}

.star {
	font-size: 40px;
	cursor: pointer;
	color: lightgray;
}

.star.selected {
	color: gold;
}

button {
	background-color: #ff4d4d;
	color: white;
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #ff6666;
}
</style>
<script>
        function selectStar(starIndex) {
            const stars = document.querySelectorAll('.star');
            stars.forEach((star, index) => {
                if (index <= starIndex) {
                    star.classList.add('selected');
                } else {
                    star.classList.remove('selected');
                }
            });
            document.getElementById('rating').value = starIndex + 1; // Set the rating value
        }
    </script>
</head>
<body>
	<div class="container">
		<h2>Rate the App</h2>
		<div class="stars">
			<span class="star" onclick="selectStar(0)">&#9733;</span> <span
				class="star" onclick="selectStar(1)">&#9733;</span> <span
				class="star" onclick="selectStar(2)">&#9733;</span> <span
				class="star" onclick="selectStar(3)">&#9733;</span> <span
				class="star" onclick="selectStar(4)">&#9733;</span>
		</div>
		<form action="${pageContext.request.contextPath}/users/rateApp"
			method="post">
			<input type="hidden" id="rating" name="rating" value="0" />
			<button type="submit">Submit Rating</button>
		</form>
	</div>
</body>
</html>
