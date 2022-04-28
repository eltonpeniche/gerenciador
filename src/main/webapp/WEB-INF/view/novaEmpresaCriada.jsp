<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html> 
	<head>
	
	</head> 

	<body>
	
		<c:if test = "${not empty empresa }">
			EMPRESA ${ empresa } CADASTRADA COM SUCESSO
		</c:if>
		
		<c:if test = "${empty empresa }">
			NENHUMA EMPRESA CADASTRADA !!
		</c:if>
	</body>
</html>
