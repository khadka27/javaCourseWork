<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Profile</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f7f7f7;
}

.container {
	display: flex;
	min-height: 100vh;
	/* Ensure container stretches to at least full viewport height */
}

.sidebar {
	width: 30%;
	background-color: #2c3e50;
	color: #fff;
	padding: 20px;
	display: flex;
	flex-direction: column;
}

.avatar {
	width: 80px;
	height: 80px;
	border-radius: 50%;
	margin-bottom: 20px;
}

.profile-Detiles, .profile-edit {
	display: block;
}

.profile-edit {
	display: none;
}

.options {
	margin-top: 20px;
}

.options ul {
	list-style-type: none;
	padding: 0;
}

.options li {
	margin-bottom: 10px;
}

.options a {
	color: #fff;
	text-decoration: none;
	font-size: 16px;
}

.options a:hover {
	color: black;
	transform: scale(5); /* Zoom effect */
	transition: transform 0.3s;
}

.content {
	flex: 1;
	padding: 20px;
	margin-right: 200px;
}

.profile-heading {
	margin-bottom: 20px;
}

.profile-heading h2 {
	margin: 0;
	font-size: 24px;
	color: #333;
}

.profile-label {
	font-weight: bold;
	color: #333;
}

.profile-table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

.profile-table th, .profile-table td {
	padding: 10px;
	border-bottom: 1px solid #ddd;
	text-align: left;
}

.profile-edit input[type="text"] {
	width: calc(100% - 20px);
	/* Take up full width of parent with a little padding */
	padding: 8px;
	margin: 4px 0;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.profile-edit button {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top: 10px;
	margin-right: 10px;
}

.profile-edit button.cancel {
	background-color: #ff5555;
}

.profile-edit button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<img src="https://www.w3schools.com/howto/img_avatar.png"
				alt="Avatar" class="avatar">
			<div class="name">
				<p id="username"><%=(String) session.getAttribute("userName")%></p>
			</div>
			<div class="options">
				<ul>
					<li><a href="#" id="edit-profile">Edit Profile</a></li>
					<li><a href="#" id="edit-profile">Delete Account</a></li>
					<li><a href="#" id="edit-profile">Customer Care</a></li>
					<li><a href="#" id="edit-profile">Logout</a></li>
					<!-- Add more options as needed -->
				</ul>
			</div>
		</div>
		<div class="content">
			<div class="profile-heading">
				<h2>User Profile</h2>
			</div>
			<div class="profile-Detiles">
				<table class="profile-table">
					<tr>
						<th scope="row">First Name</th>
						<td><%=(String) session.getAttribute("firstName")%></td>
					</tr>
					<tr>
						<th scope="row">Last Name</th>
						<td><%=(String) session.getAttribute("lastName")%></td>
					</tr>
					<tr>
						<th scope="row">PhoneNumber</th>
						<td><%=(String) session.getAttribute("phoneNumber")%></td>
					</tr>
					<tr>
						<th scope="row">BirthDay</th>
						<td><%= session.getAttribute("birthday") != null ? ((java.time.LocalDate) session.getAttribute("birthday")).toString() : "" %></td>

					</tr>
					<tr>
						<th scope="row">Email</th>
						<td><%=(String) session.getAttribute("email")%></td>
					</tr>
					<tr>
						<th scope="row">City</th>
						<td><%=(String) session.getAttribute("city")%></td>
					</tr>
					<!-- Add more rows for other profile details -->
				</table>
			</div>
			<div class="profile-edit">
				<form action="../EditProfile" method="post">
					<table class="profile-table">
						<tr>
							<th scope="row">First Name</th>
							<td><input type="text" name="firstName"
								value="<%=(String) session.getAttribute("firstName")%>"></td>
						</tr>
						<tr>
							<th scope="row">Last Name</th>
							<td><input type="text" name="lastName"
								value="<%=(String) session.getAttribute("lastName")%>"></td>
						</tr>
						<tr>
							<th scope="row">Last Name</th>
							<td><input type="text" name="phoneNumber"
								value="<%=(String) session.getAttribute("phoneNumber")%>"></td>
						</tr>
						<tr>
							<th scope="row">Last Name</th>
							<td><%= session.getAttribute("birthday") != null ? ((java.time.LocalDate) session.getAttribute("birthday")).toString() : "" %></td>

						</tr>
						<tr>
							<th scope="row">Last Name</th>
							<td><input type="text" name="email"
								value="<%=(String) session.getAttribute("email")%>"></td>
						</tr>
						<tr>
							<th scope="row">Last Name</th>
							<td><input type="text" name="city"
								value="<%=(String) session.getAttribute("city")%>"></td>
						</tr>
						<!-- Add more rows for other editable fields -->
					</table>
					<button type="submit">Save</button>
					<button type="button" class="cancel" onclick="cancelEdit()">Cancel</button>
				</form>
			</div>
		</div>
	</div>

	<script>
		// Get DOM elements
		const editProfileLink = document.getElementById('edit-profile');
		const profileDetiles = document.querySelector('.profile-Detiles');
		const profileEdit = document.querySelector('.profile-edit');

		// Function to toggle between profile details and edit form
		function toggleProfileEdit() {
			profileDetiles.style.display = 'none';
			profileEdit.style.display = 'block';
		}

		// Event listener for clicking on the "Edit Profile" link
		editProfileLink.addEventListener('click', function(event) {
			event.preventDefault();
			toggleProfileEdit();
		});

		// Function to cancel edit and display profile details
		function cancelEdit() {
			profileDetiles.style.display = 'block';
			profileEdit.style.display = 'none';
		}
	</script>
</body>
</html>
