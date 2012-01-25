<%-- 
    Document   : uploadfileindex
    Created on : Jan 25, 2012, 11:12:22 AM
    Author     : mark.connolly
--%>

<%@page contentType="text/html;charset=UTF-8"%>

<%@page pageEncoding="UTF-8"%>

<%@ page session="true"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

    <head>

        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">

        <title>Welcome</title>

    </head>


    <link rel="stylesheet" type="text/css" media="screen" href="http://localhost:8084/resources/css/style.css"/>
    <title>Admin</title>
</head>

<body>
    <jsp:include page="menu.jsp" />
    <h1 id="banner">Admin - File Uploader</h1>
    <hr/>

    <h2><a href="uploadfile.jsp">Upload Example</a></h2>

    <br>

    <br>

    <br>

    <br>

    <%

        if (session.getAttribute("uploadFile") != null
                && !(session.getAttribute("uploadFile")).equals("")) {

    %>

    <h3>Uploaded File</h3>

    <br>

    <img src="<%= "http://localhost:8084/resources/images/" + session.getAttribute("uploadFile")%>" alt="Upload Image" />

    <%

            session.removeAttribute("uploadFile");

        }

    %>

</body>

</html>