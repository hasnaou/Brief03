<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th colspan="3" class="th1"> List des Produits </th>
            <th><a href="AjouterArticle.do" class="btn btn-dark">Ajouter</a></th>
        </tr>
        <tr>
            <th scope="col">libelle</th>
            <th scope="col">Category</th>
            <th scope="col">Description�</th>
            <th scope="col">Price�</th>
            <th scope="col">Quantity�</th>
            <th scope="col">State�</th>
            <th scope="col">Editer</th>
            <th scope="col">Supprimer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="a" items="${articleModel.articles}">
            <tr>
                <td>${a.libelle}</td>
                <td>${a.category}</td>
                <td>${a.description}</td>
                <td>${a.price}</td>
                <td>${a.quantity}</td>
                <td>${a.state}</td>
                <td><a href="EditArticle.do?id=${ a.id }" class="btn btn-dark">Edit</a></td>
                <td><a onclick="return confirm('�tes-vous s�r ?')" href="SupprimerArticle.do?id=${ a.id }" class="btn btn-dark">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
