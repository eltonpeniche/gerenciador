package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.acao.EditaEmpresa;
import gerenciador.acao.FormNovaEmpresa;
import gerenciador.acao.ListaEmpresas;
import gerenciador.acao.MostraEmpresa;
import gerenciador.acao.NovaEmpresa;
import gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String nome = null;
		String url = request.getRequestURI();
		
		System.out.println(url);
		
		if (paramAcao.equals("listaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);	
			
		} else if(paramAcao.equals("removeEmpresa")) {
			RemoveEmpresa acao =  new RemoveEmpresa();
			nome = acao.executa(request, response);
			
		}else if (paramAcao.equals("mostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);
				
		}else if (paramAcao.equals("editaEmpresa")) {
			
			EditaEmpresa acao = new EditaEmpresa();
			nome = acao.executa(request, response);
		
		}else if (paramAcao.equals("novaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);
		
		}else if (paramAcao.equals("formNovaEmpresa")){
			FormNovaEmpresa acao = new FormNovaEmpresa();
			nome = acao.executa(request, response);	
		
		}
		
		String [] tipoEndereco = nome.split(":"); 
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
	}

}
