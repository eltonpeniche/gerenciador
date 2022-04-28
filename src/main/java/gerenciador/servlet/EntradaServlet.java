package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.acao.EditaEmpresa;
import gerenciador.acao.ListaEmpresas;
import gerenciador.acao.MostraEmpresa;
import gerenciador.acao.NovaEmpresa;
import gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("listaEmpresas")) {
			
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(request, response);
			
			
		} else if(paramAcao.equals("removeEmpresa")) {
			
			RemoveEmpresa acao =  new RemoveEmpresa();
			acao.executa(request, response);
			
		}else if (paramAcao.equals("mostraEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);
			
			
		}else if (paramAcao.equals("editaEmpresa")) {
			
			EditaEmpresa acao = new EditaEmpresa();
			acao.executa(request, response);
		
		}else if (paramAcao.equals("novaEmpresa")) {
			
			NovaEmpresa acao = new NovaEmpresa();
			acao.executa(request, response);
		
		}
	}

}
