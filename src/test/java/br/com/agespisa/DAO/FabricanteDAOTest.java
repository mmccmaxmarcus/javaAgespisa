package br.com.agespisa.DAO;

import org.junit.Test;

import br.com.agespisa.entidade.Fabricante;

public class FabricanteDAOTest {

	private FabricanteDAO getFabricanteDAO() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		return fabricanteDAO;
	}
	
	@Test
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setNome("LEÃO");
		getFabricanteDAO().salvar(fabricante);
	}
	
	
}
