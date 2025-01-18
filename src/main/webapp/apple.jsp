<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jabłka</title>
</head>
<body>

<h1>Oto dział w jabłkami:</h1>

<form action="${pageContext.request.contextPath}/add-to-basket" method="post">
    <input type="hidden" name="item" value="jabłko">

    <label for="quantity">Ilość produktów:</label>
    <input name="quantity" id="quantity" type="number" required />

    <input type="submit" value="Kup jabłko">
</form>

<form action="${pageContext.request.contextPath}/" method="post">
    <input type="submit" value="Rozmyśliłem się">
</form>

</body>
</html>
