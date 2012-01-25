<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
	<title>Admin</title>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<h1 id="banner">Admin</h1>
	<hr/>
	
	<p>Only admins can see this page</p>
	<p>
            Apps:
            
            <a href="http://localhost:8084/admin/manage_profile">Profile Manager</a>
            <br/>
            <a href="http://localhost:8084/admin/uploadfile">File Upload</a>
            
            
            
        </p>
</body>
</html>