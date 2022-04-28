package gerenciador.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class NovaEmpresa {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("CADASTRANDO NOVA EMPRESA");
		String nomeEmpresa = request.getParameter("nome");
		String paramdataAbertuta = request.getParameter("data");
		
		Date dataAbertura = null;
		
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramdataAbertuta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		
		Banco banco =  new Banco();
		banco.adiciona(empresa);
		
		
		request.setAttribute("empresa", empresa.getNome());
		
		response.sendRedirect("entrada?acao=listaEmpresas");
		
		
		//chamar JPS
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);

		
		
	}

}
