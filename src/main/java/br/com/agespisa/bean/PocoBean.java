package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.CidadeDAO;
import br.com.agespisa.DAO.PocoDAO;
import br.com.agespisa.entidade.Cidade;
import br.com.agespisa.entidade.Poco;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PocoBean implements GenericBean, Serializable {
	private Poco poco;
	private List<Poco> pocos;
	private List<Cidade> cidades;

	private PocoDAO getPocoDAO() {
		PocoDAO pocoDAO = new PocoDAO();
		return pocoDAO;
	}

	private CidadeDAO getCidadeDAO() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		return cidadeDAO;
	}

	public Poco getPoco() {
		if(poco == null) {
			this.poco = new Poco();
		}
		return poco;
	}

	public void setPoco(Poco poco) {
		this.poco = poco;
	}

	public List<Poco> getPocos() {
		return pocos;
	}

	public void setPocos(List<Poco> pocos) {
		this.pocos = pocos;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public void novo() {
		try {
		this.poco = new Poco();
		this.cidades = getCidadeDAO().listar();
		}catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao adicionar poço novo");
		}
	}

	@Override
	public void salvar() {
		try {
			this.poco = getPocoDAO().merge(poco);
			this.pocos = getPocoDAO().listar();
			Messages.addGlobalInfo("Poço salvo com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao salvar poço");
            
		}

	}

	@Override
	@PostConstruct
	public void listar() {
		try {
           this.pocos = getPocoDAO().listar();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao listar poço");
		}
	}

	@Override
	public void excluir(ActionEvent evento) {
		try {
           this.poco = (Poco) evento.getComponent().getAttributes().get("pocoSelecionado");
           getPocoDAO().excluir(poco);
           this.pocos = getPocoDAO().listar();
			Messages.addGlobalInfo("Poço excluido com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao excluir poço");

		}
	}

	@Override
	public void editar(ActionEvent evento) {
		try {
			this.poco = (Poco) evento.getComponent().getAttributes().get("pocoSelecionado");
            this.cidades = getCidadeDAO().listar();
            this.getPocoDAO().merge(poco);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao editar poço");
		}
	}

}
