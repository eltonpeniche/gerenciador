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

public class EditaEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("Alterando Dados da EMPRESA");
		String nomeEmpresa = request.getParameter("nome");
		String paramdataAbertuta = request.getParameter("data");
		int idEmpresa = Integer.parseInt( request.getParameter("id"));
		
		Date dataAbertura = null;
		
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramdataAbertuta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		Banco banco =  new Banco();
		Empresa empresa = null;
		
		empresa = banco.buscaEmpresaPelaId(idEmpresa);
		
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		//response.sendRedirect("entrada?acao=listaEmpresas");
		
		return "redirect:entrada?acao=ListaEmpresas";

		
	}

}
