package gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class MostraEmpresa {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("1Mostrando EMPRESA");
		
		int idEmpresa = Integer.parseInt( request.getParameter("id"));
		
		Banco banco= new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(idEmpresa);
		
		request.setAttribute("empresa", empresa);
		//RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		return "forward:/formAlteraEmpresa.jsp";
		
	}

}
