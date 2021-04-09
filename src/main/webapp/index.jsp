<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reservation Platform</title>
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
    <h2 style="text-align: center; border: 2px solid firebrick">Flight Schedule</h2>
    <table>
        <tr>
            <th style="background-color: darkred; color: white">Flight number</th>
            <th style="background-color: darkred; color: white">From</th>
            <th style="background-color: darkred; color: white">To</th>
        </tr>
        <tr><th>1</th><th>Mashhad</th><th>Tehran</th></tr>
        <tr><th>2</th><th>Mashhad</th><th>Tabriz</th></tr>
        <tr><th>3</th><th>Mashhad</th><th>Shiraz</th></tr>
        <tr><th>4</th><th>Mashhad</th><th>Isfahan</th></tr>
        <tr><th>5</th><th>Mashhad</th><th>Yazd</th></tr>
        <tr><th>6</th><th>Mashhad</th><th>Kish</th></tr>
        <tr><th>7</th><th>Mashhad</th><th>Rasht</th></tr>
    </table>
    <pre>
        <form action="index-controller" method="get">
            Enter flight number: <label><input type="text" name="num" value=""></label> <input type="submit">
        </form>
    </pre>
    <hr>
</body>
</html>