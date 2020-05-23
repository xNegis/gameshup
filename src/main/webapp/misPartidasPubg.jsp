<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="aiss.model.google.drive.FileItem"%>
<%@ page import="java.util.List" %>
<%@include file="cabecera.html"%>

<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>GameShup : MIS PARTIDAD PUBG</title>
</head>
<body>
<h1>Tus partidas guardadas PUBG</h1>
<% List<FileItem> files = (List) request.getAttribute("filtradas");%>
<div class="container">

    <p class="message">${message}</p>

    <table id="files">
        <tr style="border-radius: 10px;">
            <th>Name</th>
            <th>Last modification date</th>
            <th>Delete</th>
        </tr>

		<%
	for(int i=0;i<files.size();i++){ %>
            <tr>
            
                <td><%=files.get(i).getTitle()%></td>
                <td><%=files.get(i).getModifiedDate()%></td>
                <td> 
                    <a href="/googleDriveFileDelete?id=<%=files.get(i).getId()%>"><img src="./images/delete.png" width="30px"></a>
                </td>
                 <td> 
                    <a href="/googleDriveFileUpdate?id=<%=files.get(i).getId()%>"><img src="./images/edit.png" width="30px"></a>
                </td>
            </tr>
<% } %>
    </table>
    <p>
        <button type="button" onClick="javascript:window.location.href = '/'" class="button">Back</button>
</div>
</body>

