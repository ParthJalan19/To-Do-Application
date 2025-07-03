<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<body>
<h1 style="text-align:center;">Todo</h1>


<p>welcome ${param.uname} </p>
<a href="todo-form.jsp?uname=${param.uname}">Add new Todo</a>
<table>
<tr>
<th>title</th>
<th>target date</th>
<th>status</th>
</tr>
<c:forEach var="todo" items="${listTodo}">
<tr>
<td><c:out value="${todo.title}" /></td>
<td><c:out value="${todo.target}" /></td>
<td><c:out value="${todo.status}" /></td>
</tr>
</c:forEach>
</table>

</body>
</html>