package br.com.agespisa.DAO;

import org.hibernate.Query;

import br.com.agespisa.entidade.Bomba;
import br.com.agespisa.util.HibernateUtil;

public class BombaDAO extends GenericDAO<Bomba> {
	public Bomba buscarBombaOneToMany(Long codigo) {
		Bomba bomba = null;
		super.sessao = null;
		super.transacao = null;
		try {
			super.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			super.transacao = super.sessao.beginTransaction();
			Query query = sessao.createQuery("from Bomba where codigo = :codigo");
			query.setParameter("codigo", codigo);
			bomba = (Bomba) query.uniqueResult();
			super.transacao.commit();

		} catch (Exception e) {
			if (super.transacao != null) {
				super.transacao.rollback();
			}
			throw e;
		} finally {
			super.sessao.close();
		}
		return bomba;
	}
}
