<%@include file="includes/header.jsp"%>
<%@page import="aiss.model.google.drive.FileItem"%>
<%@ page import="java.util.List" %>
<%List<FileItem> files = (List) request.getAttribute("filtradas");%>

<h1>Tus partidas guardadas PUBG</h1>

<div class="container">

    <p class="message">${message}</p>

    <table id="files">
        <tr>
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

<%@include file="includes/footer.jsp"%>
