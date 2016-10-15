<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ModifyEmployee" METHOD="get">
Name:
<input type="text" name="name" value=<%=request.getAttribute("name") %>>
Phone : 
<input type="text" name="phone" value=<%=request.getAttribute("phone") %>>
<input type="submit" value="Submit"> 
</form>
</body>
</html>