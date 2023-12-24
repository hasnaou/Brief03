<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tree with Buttons</title>
    <style>
        .tree {
            list-style-type: none;
            padding-left: 20px;
        }

        .tree li {
            margin: 0;
            padding: 10px 0;
            position: relative;
        }

        .tree li::before,
        .tree li::after {
            content: '';
            left: -20px;
            position: absolute;
            right: auto;
        }

        .tree li::before {
            border-left: 1px solid #000;
            bottom: 50px;
            height: 100%;
            top: 0;
        }

        .tree li::after {
            border-top: 1px solid #000;
            height: 20px;
            top: 25px;
            width: 20px;
        }

        .tree li a {
            color: #000;
            text-decoration: none;
            display: inline-block;
            padding: 5px 10px;
            border: 1px solid #000;
            border-radius: 5px;
            background-color: #f8f8f8;
        }
    </style>
</head>
<body>

<ul class="tree">
    <li>
        <a href="Client/client.jsp">Client management</a>
    </li>
    <li>
        <a href="Article/article.jsp">Article management</a>
    </li>
    <li>
        <a href="Command/command.jsp">Command management</a>
    </li>
</ul>

</body>
</html>
