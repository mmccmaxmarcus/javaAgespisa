package br.com.agespisa.DAO;

import java.util.List;

import br.com.agespisa.entidade.DemonstrativoBomba;
import br.com.agespisa.entidade.DemonstrativoBombasItens;
import br.com.agespisa.util.HibernateUtil;

public class DemonstrativoBombaDAO extends GenericDAO<DemonstrativoBomba> {
	public void salvar(DemonstrativoBomba demonstrativoBomba, List<DemonstrativoBombasItens> demonstrativoBombasItens) {
		super.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        super.transacao = null;
		try {
              transacao = sessao.beginTransaction();
        	  sessao.save(demonstrativoBomba);
              for(int posicao = 0; posicao < demonstrativoBombasItens.size(); posicao ++) {
            	 DemonstrativoBombasItens item = demonstrativoBombasItens.get(posicao);
            	 item.setDemonstrativoBomba(demonstrativoBomba);
            	 sessao.save(item);
            	  
              }
              transacao.commit();
		} catch (RuntimeException e) {
			  if(transacao != null) {
				  transacao.rollback();
			  }
			  throw e;
		} finally {
            sessao.close();
		}
	}
}
