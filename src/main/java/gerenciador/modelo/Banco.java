package gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private static List<Empresa> lista =  new ArrayList<>();
	private static int chaveSequencial = 1;
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("GOOGLE");
		lista.add(empresa);
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("MICROSOFT");
		lista.add(empresa2);
		
		Empresa empresa3 = new Empresa();
		empresa3.setId(chaveSequencial++);
		empresa3.setNome("APPLE");
		lista.add(empresa3);
		
		Empresa empresa4 = new Empresa();
		empresa4.setId(chaveSequencial++);
		empresa4.setNome("TESLA");
		lista.add(empresa4);
		
		Empresa empresa5 = new Empresa();
		empresa5.setId(chaveSequencial++);
		empresa5.setNome("SPACEX");
		lista.add(empresa5);
	}
	
	
	

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
		
	}
	
	public static void remove(int id) {
		
		for(Empresa empresa : lista ){
            if(empresa.getId() == id) {
            	lista.remove(empresa);
            	break;
            }
        }
		
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public Empresa buscaEmpresaPelaId(int id) {
	
		for (Empresa empresa:lista) {
			if (empresa.getId() == id){
				return empresa;
			}
		}
		return null;
	} 

}
