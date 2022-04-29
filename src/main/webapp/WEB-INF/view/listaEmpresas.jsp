
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
	<h2>Usuário Logado: ${usuarioLogado.login}</h2>
	<a href="entrada?acao=Logout">Sair</a>
		<c:if test = "${not empty empresa }">
			EMPRESA ${ empresa } CADASTRADA COM SUCESSO
		</c:if>
		
		<h1>EMPRESAS CADASTRADAS</h1>
		<a href="/gerenciador/entrada?acao=FormNovaEmpresa"> NOVA EMPRESA </a>
		<br>
		<ul> 
			<c:forEach items = "${ empresas }" var= "empresa"> 
				
				<li> 
					${empresa.id}: ${empresa.nome} - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
					<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}"> Remove </a>
					<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}"> Editar </a>
				
				</li>
			</c:forEach>
		</ul>
		<br>
		
	</body>
</html>