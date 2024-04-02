<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Login Form</title>
   
   </head>
   <style>
   @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

body {
  height: 100vh;
  width: 100%;
  background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
}

.show-btn {
  background: #fff;
  padding: 10px 20px;
  font-size: 20px;
  font-weight: 500;
  color: #3498db;
  cursor: pointer;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.show-btn, .container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}




.container {
  background: #fff;
  width: 410px;
  padding: 30px;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
}




.container .close-btn:hover {
  color: #3498db;
}

.container .text {
  font-size: 35px;
  font-weight: 600;
  text-align: center;
}

.container form .data {
  height: 45px;
  width: 100%;
  margin: 40px 0;
}

form .data label {
  font-size: 18px;
}

form .data input {
  height: 100%;
  width: 100%;
  padding-left: 10px;
  font-size: 17px;
  border: 1px solid silver;
}

form .data input:focus {
  border-color: #3498db;
  border-bottom-width: 2px;
}

form .forgot-pass {
  margin-top: -8px;
}

form .forgot-pass a {
  color: #3498db;
  text-decoration: none;
}

form .forgot-pass a:hover {
  text-decoration: underline;
}

form .btn {
  margin: 30px 0;
  height: 45px;
  width: 100%;
  position: relative;
  overflow: hidden;
}

form .btn .inner {
  height: 100%;
  width: 300%;
  position: absolute;
  left: -100%;
  z-index: -1;
  background: -webkit-linear-gradient(right, #56d8e4, #9f01ea, #56d8e4, #9f01ea);
  transition: all 0.4s;
}

form .btn:hover .inner {
  left: 0;
}

form .btn button {
  height: 100%;
  width: 100%;
  background: none;
  border: none;
  color: #fff;
  font-size: 18px;
  font-weight: 500;
  text-transform: uppercase;
  letter-spacing: 1px;
  cursor: pointer;
}

form .signup-link {
  text-align: center;
}

form .signup-link a {
  color: #3498db;
  text-decoration: none;
}

form .signup-link a:hover {
  text-decoration: underline;
}
   
   </style>
   <body>
      <div class="container">
         <div class="text">
            Login Form
         </div>
         <form action="../loginServlet" method="POST">
            <div class="data">
               <label>UserName</label>
               <input name="userName" type="text" required>
            </div>
            <div class="data">
               <label>Password</label>
               <input name="password"type="password" required>
            </div>
            <div class="forgot-pass">
               <a href="#">Forgot Password?</a>
            </div>
            <div class="btn">
               <div class="inner"></div>
               <button type="submit">login</button>
            </div>
            <div class="signup-link">
               Not a member? <a href="register.jsp">Signup now</a>
            </div>
         </form>
      </div>
   </body>
</html>
    