<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>Sprenium Home</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/css/bootstrap.min.css" />

    <script type="text/javascript" src="webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Spring Boot</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/thing">Things</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">

    <div id="welcomeMessage">
        <h1>Spring Boot Web JSP Example</h1>
        <h2>Message: ${message}</h2>
    </div>

</div>


</body>

</html>