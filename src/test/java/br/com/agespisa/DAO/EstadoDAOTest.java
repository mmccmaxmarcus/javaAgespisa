package br.com.agespisa.DAO;

import org.junit.Test;

import br.com.agespisa.entidade.Estado;

public class EstadoDAOTest {
    
	private EstadoDAO getEstadoDAO() {
		EstadoDAO estadoDAO = new EstadoDAO();
		return estadoDAO;
	}
	
	@Test
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Piauí");
		estado.setSigla("PI");
		getEstadoDAO().salvar(estado);
	}
}
