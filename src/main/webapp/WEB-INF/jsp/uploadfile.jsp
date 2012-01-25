<%-- 
    Document   : uploadfile
    Created on : Jan 25, 2012, 11:13:03 AM
    Author     : mark.connolly
--%>

<%@page contentType="text/html;charset=UTF-8"%>

<%@page pageEncoding="UTF-8"%>

<%@ page session="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>

<META http-equiv="Content-Type" content="text/html;charset=UTF-8">


	<link rel="stylesheet" type="text/css" media="screen" href="http://localhost:8084/resources/css/style.css"/>
	<title>Admin</title>


<body>
	<jsp:include page="menu.jsp" />
	<h1 id="banner">Admin - File Uploader</h1>
	<hr/>


<title>Upload Example</title>

<script language="JavaScript">

function Validate(){

   return true;

}

</script>

</head>

<body>

<form:form modelAttribute="uploadItem" name="frm" method="post"

enctype="multipart/form-data" onSubmit="return Validate();">

<fieldset><legend>Upload File</legend>

<table>

<tr>

<td><form:label for="fileData" path="fileData">File</form:label><br />

</td>

<td><form:input path="fileData" id="image" type="file" /></td>

</tr>

<tr>

<td><br />

</td>

<td><input type="submit" value="Upload" /></td>

</tr>

</table>

</fieldset>

</form:form>

</body>

</html>
