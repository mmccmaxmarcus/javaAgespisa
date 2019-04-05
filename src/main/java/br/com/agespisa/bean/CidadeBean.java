package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import br.com.agespisa.DAO.CidadeDAO;
import br.com.agespisa.entidade.Cidade;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private List<Cidade> cidades;

	private CidadeDAO getCidadeDAO() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		return cidadeDAO;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void listar() {
		try {
			this.cidades = getCidadeDAO().listar();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao listar cidades");
		}
	}

}
