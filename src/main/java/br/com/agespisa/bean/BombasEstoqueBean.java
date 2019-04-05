package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.BombasEstoqueDAO;
import br.com.agespisa.DAO.FabricanteDAO;
import br.com.agespisa.entidade.BombasEstoque;
import br.com.agespisa.entidade.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BombasEstoqueBean implements GenericBean, Serializable {

	private BombasEstoque bombasEstoque;
	private List<BombasEstoque> bombasEstoques;
    
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	private BombasEstoqueDAO getBombasEstoqueDAO() {
		BombasEstoqueDAO bombasEstoqueDAO = new BombasEstoqueDAO();
		return bombasEstoqueDAO;
	}

	private FabricanteDAO getFabricanteDAO() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		return fabricanteDAO;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<BombasEstoque> getBombasEstoques() {
		return bombasEstoques;
	}

	public void setBombasEstoques(List<BombasEstoque> bombasEstoques) {
		this.bombasEstoques = bombasEstoques;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public BombasEstoque getBombasEstoque() {
		if(bombasEstoque == null) {
			this.bombasEstoque = new BombasEstoque();
		}
		return bombasEstoque;
	}

	public void setBombasEstoque(BombasEstoque bombasEstoque) {
		this.bombasEstoque = bombasEstoque;
	}

	@Override
	public void novo() {
		this.bombasEstoque = new BombasEstoque();
		this.fabricantes = getFabricanteDAO().listar();
	}

	@Override
	public void salvar() {
		try {
			getBombasEstoqueDAO().merge(bombasEstoque);
			this.bombasEstoque = new BombasEstoque();
			this.bombasEstoques = getBombasEstoqueDAO().listar();
			Messages.addGlobalInfo("Bomba salva com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao gravar bomba em estoque");
			e.printStackTrace();
		}

	}

	@Override
	@PostConstruct
	public void listar() {
		try {
			this.bombasEstoques = getBombasEstoqueDAO().listar();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao listar");
		}

	}
	
	@Override
	public void editar(ActionEvent evento) {
		this.bombasEstoque = (BombasEstoque) evento.getComponent().getAttributes().get("bombaEstoque");
		try {
			this.fabricantes = getFabricanteDAO().listar();
			getBombasEstoqueDAO().merge(bombasEstoque);
		} catch (RuntimeException e) {
			Messages.addFlashGlobalError("Erro ao editar");
		}

	}

	@Override
	public void excluir(ActionEvent evento) {
		this.bombasEstoque = (BombasEstoque) evento.getComponent().getAttributes().get("bombaEstoque");
		try {
			getBombasEstoqueDAO().excluir(bombasEstoque);
			this.bombasEstoques = getBombasEstoqueDAO().listar();
            Messages.addGlobalInfo("Bomba excluida com sucesso"); 
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao excluir bomba em estoque");
 		}

	}
	
	public List<Fabricante> buscaFabricantes(String nome) {
		return getFabricanteDAO().buscaPorFabricante(nome);
	}

}
