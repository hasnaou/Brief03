<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<form class="form" action="LoginServlet" method="post">
  <div class="form-group">
    <label for="inputEmail">Email address</label>
    <input type="email" class="form-control" name="gmail" id="inputEmail" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="inputPass">Password</label>
    <input type="password" class="form-control" name="passWord" id="inputPass" placeholder="Password">
  </div>
  <input type="submit" class="btn btn-dark" value="Login">
</form>
</body>
</html>
