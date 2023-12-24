<%--
  Created by IntelliJ IDEA.
  User: disfra
  Date: 23/12/2023
  Time: 22:03
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
<div class="container">
    <form action="UpdateClient.action" method="post">
        <input type="hidden" name="id" value="${ id }" class="form-control" required="required">
        <table class="mt-3">
            <tr>
                <td>
                    <label>First Name</label>
                </td>
                <td>
                    <input type="text" name="firstName" value="${ client.firstName }" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Last Name</label>
                </td>
                <td>
                    <input type="text" name="firstName" value="${ client.lastName }" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Telephone</label>
                </td>
                <td>
                    <input type="text" name="tele" value="${ client.tele }" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>gmail</label>
                </td>
                <td>
                    <input type="email" name="tele" value="${ client.mail }" class="form-control" required="required">
                </td>
            </tr>
        </table>
        <input type="submit" class="btn btn-dark" value="Update">
    </form>
</div>
</body>
</html>
