package gerenciador.servlet;
import gerenciador.acao.Acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//import gerenciador.acao.EditaEmpresa;
//import gerenciador.acao.FormNovaEmpresa;
//import gerenciador.acao.ListaEmpresas;
//import gerenciador.acao.MostraEmpresa;
//import gerenciador.acao.NovaEmpresa;
//import gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		String paramAcao = request.getParameter("acao");
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		String nomeDaClasse = "gerenciador.acao." + paramAcao.substring(0, 1).toUpperCase() + paramAcao.substring(1); 
		//String nomeDaClasse = "gerenciador.acao." + paramAcao; 
		System.out.println("nome da classe: " + nomeDaClasse);
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance(); 
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
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
