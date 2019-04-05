package br.com.agespisa.DAO;

import java.util.List;

import br.com.agespisa.entidade.BombasEstoque;
import br.com.agespisa.entidade.EntradaBomba;
import br.com.agespisa.entidade.ItemBombaEntrada;
import br.com.agespisa.util.HibernateUtil;

public class EntradaBombaDAO extends GenericDAO<EntradaBomba> {
	public void salvarItemEntrada(EntradaBomba entradaBomba, List<ItemBombaEntrada> itemBombaEntradas) {
		super.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		super.transacao = null;
		try {
			super.transacao = sessao.beginTransaction();
			sessao.save(entradaBomba);
			for(int pos=0; pos<itemBombaEntradas.size(); pos++) {
				ItemBombaEntrada itemBombaEntrada = itemBombaEntradas.get(pos);
				itemBombaEntrada.setEntradaBomba(entradaBomba);
				super.sessao.save(itemBombaEntrada);
				
				BombasEstoque estoque = itemBombaEntrada.getBombasEstoqueItem();
				Integer qtde = estoque.getQuantidade() + itemBombaEntrada.getQuantidadePacialItem();
				if(qtde >= 0 ) {
			     estoque.setQuantidade(new Short((qtde) + ""));
					this.sessao.update(estoque);
				}else {
					throw new RuntimeException("Quantidade incompatível com estoque de bombas");
				}
				
			}
			super.transacao.commit();
		} catch (RuntimeException e) {
			if(super.transacao != null) {
				super.transacao.rollback();
			}
			throw e;
		}finally {
			super.sessao.close();
		}
	}
	
}

