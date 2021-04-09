<%@ page import="com.example.reservations.mvc.model.Ticket" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Tickets Info</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            text-align: center;
        }
        table, tr, th {
            border: 2px solid darkred;
            height: 45px;
        }
    </style>
</head>
<body>
    <%
        Ticket ticket = (Ticket) session.getAttribute("Key_Ticket");
        String from = ticket.From();
        String to = ticket.To();
        Date at = ticket.Time();
        String type = ticket.Type();
        String price = ticket.Price();
    %>
    <h1 style ="text-align: center; color: white; background-color: darkred">Ticket Info</h1>
    <table>
        <tr>
            <th style="background-color: darkred; color: white">From</th>
            <th style="background-color: darkred; color: white">To</th>
            <th style="background-color: darkred; color: white">At</th>
            <th style="background-color: darkred; color: white">Type</th>
            <th style="background-color: darkred; color: white">Price</th>
        </tr>
        <tr>
            <th><%out.println(from);%></th>
            <th><%out.println(to);%></th>
            <th><%out.println(at);%></th>
            <th><%out.println(type);%></th>
            <th><%out.println(price);%></th>
        </tr>
    </table>
    <br><br>
    <form action="login.jsp" method="get">
        To confirm and pay press submit: <input type="submit">
    </form>
    <hr>
</body>
</html>
