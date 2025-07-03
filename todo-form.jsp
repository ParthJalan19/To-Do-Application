
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>user management application</title>
</head>

<body>
<h1>
Add new Todo
</h1>
<form action="insert" method="post">
<input type="text" name="uname" value="${param.uname}" />
	<fieldset>
 <label> Todo number</label>
 <input type="text" 
 name ="id" required="required" min="5"/>
 </fieldset>
 
 <fieldset>
 <label> Todo title </label>
 <input type="text"
 name ="title" required="required" min="5"/>
 </fieldset>
 
 <fieldset>
 <label> Todo Status</label>
 <select name="isDone">
 <option value="false">in progress </option>
 <option value="true">completed</option>
 </select>
 </fieldset>
 
 <fieldset>
 <label> Todo target date</label>
 <input type="date" 
 name="target" required="required" />
 
 </fieldset>
 <button type="submit" > save</button>
 </form>
</html>