package br.com.agespisa.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agespisa.entidade.Cidade;
import br.com.agespisa.entidade.Poco;

public class PocoDAOTest {
   
    private PocoDAO getPocoDao() {
    	PocoDAO pocoDAO = new PocoDAO();
    	return pocoDAO;
    }
    
    private CidadeDAO getCidadeDAO() {
    	CidadeDAO cidadeDAO = new CidadeDAO();
    	return cidadeDAO;
    }
	
	@Test
	public void salvar() {
	    Cidade cidade = getCidadeDAO().buscar(1l);
	    Poco poco = new Poco();
	    poco.setEndereco("poço das cobras");
	    poco.setNumero((short) 12);
	    poco.setCidade(cidade);
	    getPocoDao().salvar(poco);
	}
	
	@Test
	@Ignore
	public void listar() {
		List<Poco> pocos = getPocoDao().listar();
		for (Poco poco : pocos) {
			System.out.println(poco.getEndereco());
			System.out.println(poco.getNumero());
			System.out.println(poco.getCidade().getNome());
			System.out.println(poco.getCidade().getEstado().getSigla());
		}
	}
	
}
