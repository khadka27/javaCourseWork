<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile Modal</title>
<style>
/* Modal styles */
.modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.4);
    display: none;
}

.modal-content {
    background-color: #fefefe;
    margin: 10% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
    max-width: 600px;
    text-align: center;
}

.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover, .close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}

/* Avatar styles */
.avatar-container {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    border: 2px solid #ccc;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0 auto 20px;
}

.avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    object-fit: cover;
}

/* Table styles */
table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    position: relative;
}

th {
    background-color: #f2f2f2;
}

/* Button styles */
.btn {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    margin-right: 10px;
}

.btn-secondary {
    background-color: #ccc;
}

/* Input styles */
.input-field {
    width: calc(100% - 16px); /* Adjust width for padding and border */
    border: 1px solid #ddd;
    padding: 6px;
    box-sizing: border-box;
    display: none; /* Initially hide input fields */
}
</style>
</head>
<body>

<!-- Modal -->
<div id="profileModel" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <div class="avatar-container">
            <img src="https://www.w3schools.com/howto/img_avatar.png" alt="Avatar" class="avatar">
        </div>
        <h2>User Profile</h2>
        <table id="profileTable">
            <tr>
                <th>Attribute</th>
                <th>Value</th>
            </tr>
            <!-- Repeat for other attributes -->
        </table>
        <div id="buttonGroup">
            <button class="btn" id="editBtn">Edit</button>
            <button class="btn btn-secondary" id="saveBtn" style="display: none;">Save</button>
            <button class="btn btn-secondary" id="closeBtn">Close</button>
            <button class="btn btn-secondary" id="backBtn" style="display: none;">Back</button>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        let editProfile = false;

        $("#editBtn").click(function() {
            if (editProfile) {
                $(".input-field").hide();
                $(".value").show();
                $("#editBtn").text("Edit");
                $("#saveBtn").hide();
            } else {
                $(".input-field").show();
                $(".value").hide();
                $("#editBtn").text("Back");
                $("#saveBtn").show();
            }
            editProfile = !editProfile;
        });

        $("#saveBtn").click(function() {
            // Add code to save changes
            $(".input-field").each(function() {
                let newValue = $(this).val();
                $(this).prev(".value").text(newValue);
            });
            $("#editBtn").trigger("click");
        });

        $(".close").click(function() {
            $("#profileModel").hide();
        });
    });
</script>
</body>
</html>
