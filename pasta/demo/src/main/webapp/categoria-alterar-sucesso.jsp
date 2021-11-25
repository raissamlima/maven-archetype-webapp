<%
    int id = (int)request.getAttribute("id");
%>


<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterado com sucesso</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h1>Alterado com sucesso</h1> 
    <h4>Categoria de id:<%= id%></h4>
    <a href="/demo-1/categoria/listar">Categoria Listar</a>
</body>
</html>