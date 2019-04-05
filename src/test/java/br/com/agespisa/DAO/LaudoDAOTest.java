package br.com.agespisa.DAO;

import org.junit.Test;

import br.com.agespisa.entidade.Bomba;
import br.com.agespisa.entidade.Laudo;

public class LaudoDAOTest {

	@Test
	public void busca() {
		BombaDAO bombaDAO = new BombaDAO();
		Bomba bomba = bombaDAO.buscarBombaOneToMany(3L);
		System.out.println(bomba.getModelo());
		System.out.println(bomba.getPotencia());

		for (Laudo laudo : bomba.getLaudos()) {
			System.out.println(laudo.getSituacao());

		}

		Laudo l = bomba.getLaudos().get(bomba.getLaudos().size() - 1);
		if (l.getSituacao().equals('R')) {
			System.out.println(l.situacaoFormatada());
		}else {
			System.out.println("Não está em recuperada");
		}

	}

}
