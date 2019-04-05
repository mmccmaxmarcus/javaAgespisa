package br.com.agespisa.DAO;

import org.junit.Test;

import br.com.agespisa.entidade.Lotacao;

public class LotacaoDAOTest {
	@Test
	public void salvar() {
		Lotacao lotacao = new Lotacao();
		LotacaoDAO lotacaoDAO = new LotacaoDAO();
		
		lotacao.setNome("GEMEL");
		lotacaoDAO.salvar(lotacao);
	}
}
