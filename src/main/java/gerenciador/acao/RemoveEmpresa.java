package gerenciador.acao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("1Removendo EMPRESA");
		
		int idEmpresa = Integer.parseInt( request.getParameter("id"));
		
		PrintWriter out = response.getWriter();
		out.println("ID EMPRESA= "+ idEmpresa);
		Banco.remove(idEmpresa);
		
		//response.sendRedirect("entrada?acao=listaEmpresas");
		
		return "redirect:entrada?acao=ListaEmpresas";
		
		
	}

}
