<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/output.css" rel="stylesheet">
</head>
<body>

<%@ include file="navbar.jsp"%>


<div class="max-w-md mx-auto mb-5 mt-10 bg-white p-4 rounded-lg shadow-md ">
<div class="text-right text-[12px] ">
    <span class="text-gray-600">Already have an account? <a href="./login.jsp" class="hover:text-indigo-500 text-black">Sign Up</a> </span>
  </div>
<form class="max-w-sm mx-auto mt-10">
  <div class="mb-5">
    <label for="userName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">User Name</label>
    <input type="text" id="userName" name="userName" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your username" required />
  </div>
  <div class="mb-5">
    <label for="firstName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">First Name</label>
    <input type="text" id="firstName" name="firstName" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your first name" required />
  </div>
  <div class="mb-5">
    <label for="lastName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Last Name</label>
    <input type="text" id="lastName" name="lastName" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your last name" required />
  </div>
  <div class="mb-5">
    <label for="phoneNumber" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Phone Number</label>
    <input type="tel" id="phoneNumber" name="phoneNumber" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your phone number" required />
  </div>
  <div class="mb-5">
    <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
    <input type="email" id="email" name="email" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your email" required />
  </div>
  <div class="mb-5">
    <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
    <div class="relative">
      <input type="password" id="password" name="password" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 pr-10 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your password" required />
      <button type="button" class="absolute inset-y-0 right-0 flex items-center pr-3 focus:outline-none" onclick="togglePasswordVisibility()">
        <svg class="h-5 w-5 text-gray-400 dark:text-gray-300" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor">
          <path d="M10 12a2 2 0 100-4 2 2 0 000 4z" />
          <path fill-rule="evenodd" d="M10 4a8 8 0 100 16 8 8 0 000-16zM2 10a8 8 0 1116 0 8 8 0 01-16 0z" clip-rule="evenodd" />
        </svg>
      </button>
    </div>
  </div>
  <div class="mb-5">
    <label for="repeatPassword" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Repeat Password</label>
    <input type="password" id="repeatPassword" name="repeatPassword" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Repeat your password" required />
  </div>
  <div class="mb-5">
    <label for="city" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">City</label>
    <input type="text" id="city" name="city" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your city" required />
  </div>
  <div class="mb-5">
    <label for="province" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Province</label>
    <input type="text" id="province" name="province" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your province" required />
  </div>
  <div class="mb-5">
    <label for="country" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Country</label>
    <input type="text" id="country" name="country" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your country" required />
  </div>
  <div class="mb-5">
    <label for="postalCode" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Postal Code</label>
    <input type="text" id="postalCode" name="postalCode" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" placeholder="Your postal code" required />
  </div>
  <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Register New Account</button>
</form>


</div>

<%@ include file="footer.jsp"%>


</body>
<script>
  function togglePasswordVisibility() {
    var passwordInput = document.getElementById('password');
    var repeatPasswordInput = document.getElementById('repeatPassword');
    if (passwordInput.type === 'password') {
      passwordInput.type = 'text';
      repeatPasswordInput.type = 'text';
    } else {
      passwordInput.type = 'password';
      repeatPasswordInput.type = 'password';
    }
  }
</script>
</html>