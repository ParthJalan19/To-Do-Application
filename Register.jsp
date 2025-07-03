<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>Register User</title>
<style>
h1
{
	text-align:center;
}
</style>
</head>

<body>
<h1 id="demo"></h1>
<h1>registration form</h1>
<c:if test="${notification != null}">
<script>
function gologin()
{
	open("/todoapp/login.jsp");
}
gologin();
</script>
</c:if>

<div class="registration_form">
<form action="<%= request.getContextPath() %>/register">
firstname : <input type="text" name="fname" /><br>
lastname : <input type="text" name="lname" /><br>
username : <input type="text" name="uname" /><br>
password : <input type="password" name="pw" /><br>
<input type="submit" value="register" />
</form>
<div>

</body>
</html>