<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <fieldset>
        <legend>Login info</legend>
        <%
            if (session.getAttribute("Notifications") == "signup") {
                out.println("User Registered Successfully!");
            }
            else if (session.getAttribute("Notifications") == "error login") {
                out.println("Username or Password incorrect!");
            }
            else {
                out.println("If haven't account first creat it...");
            }
            session.removeAttribute("Notifications");
        %>
        <form action="login-controller" method="post">
            Enter username: <label><input type="text" name="uname"></label><br>
            Enter password: <label><input type="password" name="pass"></label><br>
            <input type="submit" value="Login" name="flag">
            <input type="submit" value="Signup">
        </form>
    </fieldset>
</body>
</html>