<%@ page import="com.example.reservations.mvc.model.Ticket" %>
<%@ page import="jdk.nashorn.internal.ir.Flags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Panel</title>
</head>
<body>
<%
    response.setHeader("cache-control", "no-store"); //Http 1.1  for Back Button

    if (session.getAttribute("username") == null) { // for manually change address in browser
        response.sendRedirect("Login.jsp");
    }
%>
<h1>Welcome Dear ${username} to panel page</h1>
<h2>
    <%
        if (session.getAttribute("Flag") == "add") {
            out.println("your ticket successfully buy" + "<br>");
            Ticket ticket = (Ticket) session.getAttribute("Key_Ticket");
            out.println("Your Destination: " + ticket.To());
            session.removeAttribute("Flag");
            session.removeAttribute("Key_Ticket");
        }
        else if (session.getAttribute("Flag") == "update") {
            out.println("your ticket successfully Change" + "<br>");
            Ticket ticket = (Ticket) session.getAttribute("Key_Ticket");
            out.println("Your Destination: " + ticket.To());
        }

    %>
</h2>
<p>
    for final tickets booked please submit <b>payment</b> button <br>
    for change tickets booked please submit <b>change</b> button <br>
    for removed ticket booked and go to first page please submit <b>remove</b> button <br>
    and for logout please submit <b>logout</b> button
</p>
<form action="login-panel-controller" method="get">
    <label><input type="submit" value="payment" name="button1"></label>
    <label><input type="submit" value="change" name="button2"></label>
    <label><input type="submit" value="remove" name="button3"> </label>
    <label><input type="submit" value="logout"></label>
</form>
</body>
</html>
