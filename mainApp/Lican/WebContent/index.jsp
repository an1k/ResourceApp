<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<h2>${requestScope.message}</h2>
<form action="FileUploadController" method="post" enctype="multipart/form-data">
Select file to upload: <input type="file" name="file" size="30"/><br/>
<input type="Submit" value="Upload">

</form>
</body>
</html>