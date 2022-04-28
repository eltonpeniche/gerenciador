
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:url value="/entrada" var="linkServetNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkServetNovaEmpresa}" method = "post">
	<h2>CADASTRANDO NOVA EMPRESA</h2>
	Nome: <input type="text" name= "nome">
	Data de Abertura: <input type="text" name= "data">
	<input type="hidden" name= "acao" value="novaEmpresa">
  	<input type="submit" value="Submit">
	
	
	</form>
</body>
</html>