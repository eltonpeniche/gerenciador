
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:url value="/entrada" var="linkServetNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<form action="${linkServetNovaEmpresa}" method = "post">
	<h2>Login</h2>
	Login: <input type="text" name= "login" autofocus>
	senha: <input type="password" name= "senha">
	<input type="hidden" name= "acao" value="Login">
  	<input type="submit" value="Enviar">
	
	
	</form>
</body>
</html>