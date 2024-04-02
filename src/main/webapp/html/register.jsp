<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<title>Registration Form </title>
<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap')
	;

* {
	
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
margin-top: 100px;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 10px;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

.container {
	max-width: 700px;
	width: 100%;
	background-color: #fff;
	padding: 25px 30px;
	border-radius: 5px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
}

.container .title {
	font-size: 25px;
	font-weight: 500;
	position: relative;
}

.container .title::before {
	content: "";
	position: absolute;
	left: 0;
	bottom: 0;
	height: 3px;
	width: 30px;
	border-radius: 5px;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

.content form .user-details {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin: 20px 0 12px 0;
}

form .user-details .input-box {
	margin-bottom: 15px;
	width: calc(100%/ 2 - 20px);
}

form .input-box span.details {
	display: block;
	font-weight: 500;
	margin-bottom: 5px;
}

.user-details .input-box input {
	height: 45px;
	width: 100%;
	outline: none;
	font-size: 16px;
	border-radius: 5px;
	padding-left: 15px;
	border: 1px solid #ccc;
	border-bottom-width: 2px;
	transition: all 0.3s ease;
}

.user-details .input-box input:focus, .user-details .input-box input:valid
	{
	border-color: #9b59b6;
}

form .gender-details .gender-title {
	font-size: 20px;
	font-weight: 500;

}

form .category {
	display: flex;
	width: 80%;
	margin: 14px 0;
	justify-content: space-between;
	
}

form .category label {
	display: flex;
	align-items: center;
	cursor: pointer;
}

form .category label .dot {
	height: 18px;
	width: 18px;
	border-radius: 50%;
	margin-right: 10px;
	background: #d9d9d9;
	border: 5px solid transparent;
	transition: all 0.3s ease;
}

#dot-1:checked ~ .category label .one, #dot-2:checked ~ .category label .two{
	background: #9b59b6;
	border-color: #d9d9d9;
	
}

form input[type="radio"] {
	display: none;
}

form .button {
	height: 45px;
	margin: 35px 0
}

form .button input {
	height: 100%;
	width: 100%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

form .button input:hover {
	/* transform: scale(0.99); */
	background: linear-gradient(-135deg, #71b7e6, #9b59b6);
}

@media ( max-width : 584px) {
	.container {
		max-width: 100%;
	}
	form .user-details .input-box {
		margin-bottom: 15px;
		width: 100%;
	}
	form .category {
		width: 100%;
	}
	.content form .user-details {
		max-height: 300px;
		overflow-y: scroll;
	}
	.user-details::-webkit-scrollbar {
		width: 5px;
	}
}

@media ( max-width : 459px) {
	.container .content .category {
		flex-direction: column;
	}
}
</style>
<body>
  <div class="container">
    <div class="title">Registration</div>
    <div class="content">
      <form action="../RegisterServlet" method="POST">
        <div class="user-details">
          <div class="input-box">
            <span class="details">First Name</span>
            <input name="firstName" type="text" placeholder="Enter your first name" required>
          </div>
          <div class="input-box">
            <span class="details">Last Name</span>
            <input name="lastName"type="text" placeholder="Enter your last name" required>
          </div>
          <div class="input-box">
            <span class="details">Username</span>
            <input name="userName" type="text" placeholder="Enter your username" required>
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input name="email" type="text" placeholder="Enter your email" required>
          </div>
           <div class="input-box">
            <span class="details">Birthday</span>
            <input name="birthday" type="date" required>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input name="phoneNumber" type="text" placeholder="Enter your phone number" required>
          </div>
          <div class="input-box">
            <span class="details">Password</span>
            <input name="password" type="password" placeholder="Enter your password" required>
          </div>
          <div class="input-box">
            <span class="details">Confirm Password</span>
            <input name="repassword" type="password" placeholder="Confirm your password" required>
          </div>
          <div class="input-box">
            <span class="details">City</span>
            <input name="city" type="text" placeholder="Enter your city" required>
          </div>

          <div class="input-box">
            <span class="details">Province</span>
            <input name="province" type="text" placeholder="Enter your province" required>
          </div>
          
          
          <div class="input-box">
            <span class="details">Country</span>
            <input name="country"type="text" placeholder="Enter your country" required>
          </div>
          <div class="input-box">
            <span class="details">Postal Code</span>
            <input name="postalCode" type="text" placeholder="Enter your postal code" required>
          </div>
           <div class="gender-details">
          <input type="radio" name="gender" id="dot-1">
          <input type="radio" name="gender" id="dot-2">
          
          <span class="gender-title">Gender</span>
          <div class="category">
            <label name="gender" for="dot-1">
            <span class="dot one"></span>
            <span class="gender">Male</span>
          </label>
          <label name="gender"for="dot-2">
            <span class="dot two"></span>
            <span class="gender">Female</span>
          </label>
     
          </div>
        </div>
 
        </div>
        <div class="button">
          <input type="submit" value="Register">
        </div>
      </form>
    </div>
  </div>
</body>
</html>

</html>