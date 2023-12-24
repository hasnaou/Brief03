<%--
  Created by IntelliJ IDEA.
  User: disfra
  Date: 24/12/2023
  Time: 02:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="SaveArticle.do" method="post">
        <table class="mt-3">
            <tr>
                <td>
                    <label>libelle</label>
                </td>
                <td>
                    <input type="text" name="libelle" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>category</label>
                </td>
                <td>
                    <input type="text" name="category" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>description</label>
                </td>
                <td>
                    <input type="text" name="description" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Quantity</label>
                </td>
                <td>
                    <input type="text" name="quantity" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>State</label>
                </td>
                <td>
                    <input type="text" name="state" class="form-control" required="required">
                </td>
            </tr>
        </table>
        <input type="submit" class="btn btn-dark" value="Ajouter">
    </form>
</div>
</body>
</html>
