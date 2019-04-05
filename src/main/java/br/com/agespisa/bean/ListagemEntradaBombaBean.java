package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.EntradaBombaDAO;
import br.com.agespisa.entidade.EntradaBomba;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ListagemEntradaBombaBean implements Serializable {
	private List<EntradaBomba> entradaBombas;
	private List<EntradaBomba> filterEntradaBomba;
	
	public List<EntradaBomba> getFilterEntradaBomba() {
		return filterEntradaBomba;
	}
	
	public void setFilterEntradaBomba(List<EntradaBomba> filterEntradaBomba) {
		this.filterEntradaBomba = filterEntradaBomba;
	}

	public List<EntradaBomba> getEntradaBombas() {
		return entradaBombas;
	}

	public void setEntradaBombas(List<EntradaBomba> entradaBombas) {
		this.entradaBombas = entradaBombas;
	}

	private EntradaBombaDAO getEntradaBomabaDAO() {
		EntradaBombaDAO entradaBombaDAO = new EntradaBombaDAO();
		return entradaBombaDAO;
	}

	@PostConstruct
	public void listar() {
		try {
			this.entradaBombas = getEntradaBomabaDAO().listarOneToMany();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro na listagem de entrada de bombas");
		}
	
	}

}
