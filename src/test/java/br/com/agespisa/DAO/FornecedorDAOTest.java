package br.com.agespisa.DAO;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agespisa.entidade.Cidade;
import br.com.agespisa.entidade.Fornecedor;
import br.com.agespisa.entidade.Poco;

public class FornecedorDAOTest {
	
	private FornecedorDAO getFornecedorDAO() {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		return fornecedorDAO;
	}
	
	
	@Test
	public void salvar() {
	    Fornecedor fornecedor = new Fornecedor();
	    fornecedor.setDescricao("Conjunto");
	    fornecedor.setNome("Ebara");
	    getFornecedorDAO().salvar(fornecedor);
	    
	}
}
