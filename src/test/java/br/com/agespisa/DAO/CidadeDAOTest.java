package br.com.agespisa.DAO;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agespisa.entidade.Cidade;
import br.com.agespisa.entidade.Estado;

public class CidadeDAOTest {
    
	private CidadeDAO getCidadeDAO() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		return cidadeDAO;
	}
	
	private EstadoDAO getEstadoDAO(){
		EstadoDAO estadoDAO = new EstadoDAO();
		return estadoDAO;
	}
	
    @Test
	public void salvar() {
    	Estado estado = getEstadoDAO().buscar(1l);
		Cidade cidade = new Cidade();
		cidade.setNome("Teresina");
		cidade.setEstado(estado);
		getCidadeDAO().salvar(cidade);
	}
	
}
