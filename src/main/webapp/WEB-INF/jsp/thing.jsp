<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <title>Sprenium Things</title>

    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/css/bootstrap.min.css"/>

    <script type="text/javascript" src="webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Sprenium</a>
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

    <h1>
        These are my things
    </h1>

    <table id="thingTable" class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${things}" var="thing">
            <tr>
                <td><c:out value="${thing.name}"/></td>
                <td><c:out value="${thing.description}"/></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <button id="addNew" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#newThingModal">Add New</button>

    <!-- Modal -->
    <div id="newThingModal" class="modal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add New</h4>
                </div>
                <div class="modal-body">

                    <form:form method="post" modelAttribute="newThing" action="/thing/add">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-3">Name: </div>
                                <div class="col-sm-3">Description</div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3">
                                    <form:input path="name" type="text" />
                                </div>
                                <div class="col-sm-3">
                                    <form:input path="description" type="text" />
                                </div>
                                <div class="col-sm-3">
                                    <input id="newThingSubmit" type = "submit" value = "Submit" />
                                </div>
                            </div>
                        </div>
                    </form:form>

                </div>
            </div>

        </div>
    </div>

</div>


</body>

</html>