package br.com.agespisa.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.agespisa.util.HibernateUtil;

public class GenericDAO<Entidade> {
	private Class<Entidade> classe;
	protected Session sessao;
	protected Transaction transacao = null;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		this.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}

			throw e;
		} finally {
			sessao.close();
		}
	}

	public List<Entidade> listar() {
		this.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria resultado = sessao.createCriteria(classe);
			@SuppressWarnings("unchecked")
			List<Entidade> resultadoListagem = resultado.list();
			return resultadoListagem;
		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		this.sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}

	}

	public void excluir(Entidade entidade) {
		this.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			this.transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {
		this.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			this.transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade merge(Entidade entidade) {
		this.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			this.transacao = sessao.beginTransaction();
			Entidade retorno = (Entidade) sessao.merge(entidade);
			transacao.commit();
			return retorno;
		} catch (Exception e) {
			if (transacao != null) {
				transacao.commit();
			}
			throw e;
		} finally {

		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> autoComplete(String nome) {
		this.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = this.sessao.createCriteria(classe);
			if (StringUtils.isNotBlank(nome)) {
				consulta.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
			}
			return consulta.list();
		} catch (Exception e) {
			throw e;
		} finally {
			this.sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listarOneToMany() {
		this.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria resultado = this.sessao.createCriteria(classe);
			resultado.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Entidade> listagemEntidade = resultado.list();
			return listagemEntidade;
		} catch (Exception e) {
			throw e;
		} finally {
           this.sessao.close();
		}
	}
}
