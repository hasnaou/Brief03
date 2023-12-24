<%--
  Created by IntelliJ IDEA.
  User: disfra
  Date: 22/12/2023
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="SaveClient.action" method="post">
        <table class="mt-3">
            <tr>
                <td>
                    <label>First Name</label>
                </td>
                <td>
                    <input type="text" name="firstName" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Last Name</label>
                </td>
                <td>
                    <input type="text" name="lastName" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Telephone</label>
                </td>
                <td>
                    <input type="text" name="tele" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Mail</label>
                </td>
                <td>
                    <input type="email" name="mail" class="form-control" required="required">
                </td>
            </tr>
        </table>
        <input type="submit" class="btn btn-dark" value="Ajouter">
    </form>
</div>
</body>
</html>
