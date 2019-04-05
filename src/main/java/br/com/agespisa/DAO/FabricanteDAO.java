package br.com.agespisa.DAO;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.agespisa.entidade.Fabricante;
import br.com.agespisa.util.HibernateUtil;

public class FabricanteDAO extends GenericDAO<Fabricante> {

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscaPorFabricante(String nome) {
		super.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Fabricante.class);
			if (StringUtils.isNotBlank(nome)) {
				consulta.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
			}
			return consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
	}
}
