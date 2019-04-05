package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.BombaDAO;
import br.com.agespisa.DAO.FabricanteDAO;
import br.com.agespisa.entidade.Bomba;
import br.com.agespisa.entidade.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BombaBean implements GenericBean, Serializable {
	private Bomba bomba;
	private List<Bomba> bombas;
	private List<Fabricante> fabricantes;
	private Fabricante fabricante;
	

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Bomba getBomba() {
		if (bomba == null) {
			this.bomba = new Bomba();
		}
		return bomba;
	}

	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}

	public List<Bomba> getBombas() {
		return bombas;
	}

	public void setBombas(List<Bomba> bombas) {
		this.bombas = bombas;
	}

	private BombaDAO getBombaDAO() {
		BombaDAO bombaDAO = new BombaDAO();
		return bombaDAO;
	}

	private FabricanteDAO getFabricanteDAO() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		return fabricanteDAO;
	}

	

	@Override
	public void novo() {
		try {
			this.bomba = new Bomba();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao criar nova bomba");
		}
	}

	@Override
	public void salvar() {
		try {
			getBombaDAO().salvar(bomba);
			this.bombas = getBombaDAO().listarOneToMany();
			Messages.addGlobalInfo("Bomba salva com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar bomba");

		}
	}
	

	@Override
	@PostConstruct
	public void listar() {
		try {
			this.bombas = getBombaDAO().listarOneToMany();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar poço");
		}

	}

	public List<Fabricante> buscaFabricante(String nome) {
		return this.getFabricanteDAO().autoComplete(nome);
	}

	@Override
	public void excluir(ActionEvent evento) {

	}

	@Override
	public void editar(ActionEvent evento) {

	}

}
