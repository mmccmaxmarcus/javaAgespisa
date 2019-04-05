package br.com.agespisa.DAO;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.agespisa.entidade.Usuario;
import br.com.agespisa.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{
	public Usuario autenticar(String cpf, String senha) {
		super.sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.createAlias("pessoa", "p");
			SimpleHash hash = new SimpleHash("md5", senha);
			consulta.add(Restrictions.eq("p.cpf", cpf));
			consulta.add(Restrictions.eq("senha", hash.toHex()));
			Usuario resultado = (Usuario) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}
}
