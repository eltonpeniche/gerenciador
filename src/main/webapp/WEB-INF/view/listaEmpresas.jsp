
<%@ page import = "java.util.List, gerenciador.modelo.Empresa"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>

		<c:if test = "${not empty empresa }">
			EMPRESA ${ empresa } CADASTRADA COM SUCESSO
		</c:if>
		
		<h1>EMPRESAS CADASTRADAS</h1>
		<br>
		<ul> 
			<c:forEach items = "${ empresas }" var= "empresa"> 
				
				<li> 
					${empresa.id}: ${empresa.nome} - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
					<a href="/gerenciador/entrada?acao=removeEmpresa&id=${empresa.id}"> Remove </a>
					<a href="/gerenciador/entrada?acao=mostraEmpresa&id=${empresa.id}"> Editar </a>
				
				</li>
			</c:forEach>
		</ul>
		<br>
		<a href="/gerenciador/entrada?acao=formNovaEmpresa"> NOVA EMPRESA </a>
	</body>
</html>