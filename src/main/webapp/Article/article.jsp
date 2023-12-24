<%--
  Created by IntelliJ IDEA.
  User: disfra
  Date: 23/12/2023
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Articles</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="row">
    <div class="container">
        <h3 class="text-center">List of Articles</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Libelle</th>
                    <th>Category</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Add date</th>
                    <th>State</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="article" items="${listArticle}">
                    <tr>
                        <td>
                            <c:out value="${article.id}"/>
                        </td>
                        <td>
                            <c:out value="${article.libelle}"/>
                        </td>
                        <td>
                            <c:out value="${article.category}"/>
                        </td>
                        <td>
                            <c:out value="${article.description}"/>
                        </td>
                        <td>
                            <c:out value="${article.price}"/>
                        </td>
                        <td>
                            <c:out value="${article.quantity}"/>
                        </td>
                        <td>
                            <c:out value="${article.addDate}"/>
                        </td>
                        <td>
                            <c:out value="${article.state}"/>
                        </td>
                        <td>
                            <a href="edit?id=<c:out value='${article.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${article.id}' />">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
