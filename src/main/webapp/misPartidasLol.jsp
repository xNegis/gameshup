<%@include file="includes/header.jsp"%>
<%@page import="aiss.model.google.drive.FileItem"%>
<%@ page import="java.util.List" %>
<%List<FileItem> files = (List) request.getAttribute("filtradas");%>

<h1>Tus partidas guardadas LoL</h1>

<div class="container">

    <p class="message">${message}</p>

    <table id="files">
        <tr style="border-radius: 10px;">
            <th>Name</th>
            <th>Last modification date</th>
            <th>Delete</th>
        </tr>
<%--         <c:forEach items="${requestScope.files.items}" var="file"> --%>
		<%
	for(int i=0;i<files.size();i++){ %>
            <tr>
            
                <td><%=files.get(i).getTitle()%></td>
                <td><%=files.get(i).getModifiedDate()%></td>
                <td> 
                <form  method="POST" action="/googleDriveFileDelete?id=<%=files.get(i).getId()%>">
               	<button id="vengoLolP" name="vengoLolP" style="background:none;border:none"><img src="./images/delete.png" width="30px"></button>
                </form>
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

<%@include file="includes/footer.jsp"%>
