<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Signup</title>
</head>
<body>
<fieldset>
    <legend>Signup</legend>
    <form action="signup-controller" method="post">
        First Name: <label><input type="text" name="first_name"></label><br>
        Last Name: <label><input type="text" name="last_name"></label><br>
        Username: <label><input type="text" name="uname"></label><br>
        Password: <label><input type="password" name="pass"></label><br>
        <label><input type="submit"></label>
    </form>
</fieldset>
</body>
</html>
