package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.model.DualListModel;

import br.com.agespisa.DAO.BombasEstoqueDAO;
import br.com.agespisa.DAO.CidadeDAO;
import br.com.agespisa.DAO.EntradaBombaDAO;
import br.com.agespisa.DAO.FabricanteDAO;
import br.com.agespisa.DAO.FuncionarioDAO;
import br.com.agespisa.DAO.PocoDAO;
import br.com.agespisa.entidade.Bomba;
import br.com.agespisa.entidade.BombasEstoque;
import br.com.agespisa.entidade.Cidade;
import br.com.agespisa.entidade.EntradaBomba;
import br.com.agespisa.entidade.Fabricante;
import br.com.agespisa.entidade.Funcionario;
import br.com.agespisa.entidade.ItemBombaEntrada;
import br.com.agespisa.entidade.Poco;

@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class EntradaBombaBean implements Serializable {
	private List<BombasEstoque> bombasEstoques;
	private List<BombasEstoque> bombasEstoquesFilters;
	private BombasEstoque bombasEstoque;
	private EntradaBomba entradaBomba;
	private List<EntradaBomba> entradaBombas;
	private List<Fabricante> fabricantes;
	private List<ItemBombaEntrada> itensBombaEntradas;
	private List<Funcionario> funcionarios;
	private List<Poco> pocos;
	private List<Cidade> cidades;
	private boolean ativaBotaoFinalizar = false;



	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public boolean isAtivaBotaoFinalizar() {
		return ativaBotaoFinalizar;
	}

	public void setAtivaBotaoFinalizar(boolean ativaBotaoFinalizar) {
		this.ativaBotaoFinalizar = ativaBotaoFinalizar;
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

	private FuncionarioDAO getFuncionarioDAO() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO;
	}

	private PocoDAO getPocoDAO() {
		PocoDAO pocoDAO = new PocoDAO();
		return pocoDAO;
	}

	private CidadeDAO getCidadeDAO() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		return cidadeDAO;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public List<ItemBombaEntrada> getItensBombaEntradas() {
		return itensBombaEntradas;
	}

	public void setItensBombaEntradas(List<ItemBombaEntrada> itensBombaEntradas) {
		this.itensBombaEntradas = itensBombaEntradas;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public BombasEstoque getBombasEstoque() {
		if (bombasEstoque == null) {
			this.bombasEstoque = new BombasEstoque();
		}
		return bombasEstoque;
	}

	public List<BombasEstoque> getBombasEstoquesFilters() {
		return bombasEstoquesFilters;
	}

	public void setBombasEstoquesFilters(List<BombasEstoque> bombasEstoquesFilters) {
		this.bombasEstoquesFilters = bombasEstoquesFilters;
	}

	public void setBombasEstoque(BombasEstoque bombasEstoque) {
		this.bombasEstoque = bombasEstoque;
	}

	public List<BombasEstoque> getBombasEstoques() {
		return bombasEstoques;
	}

	public void setBombasEstoques(List<BombasEstoque> bombasEstoques) {
		this.bombasEstoques = bombasEstoques;
	}

	public EntradaBomba getEntradaBomba() {
		return entradaBomba;
	}

	public void setEntradaBomba(EntradaBomba entradaBomba) {
		this.entradaBomba = entradaBomba;
	}

	public List<EntradaBomba> getEntradaBombas() {
		return entradaBombas;
	}

	public void setEntradaBombas(List<EntradaBomba> entradaBombas) {
		this.entradaBombas = entradaBombas;
	}

	private EntradaBombaDAO getEntradaBombaDAO() {
		EntradaBombaDAO entradaBombaDAO = new EntradaBombaDAO();
		return entradaBombaDAO;
	}

	private BombasEstoqueDAO getBombasEstoqueDAO() {
		BombasEstoqueDAO bombasEstoqueDAO = new BombasEstoqueDAO();
		return bombasEstoqueDAO;
	}

	private FabricanteDAO getFabricanteDAO() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		return fabricanteDAO;

	}

	public void novo() {
		try {
			this.bombasEstoques = getBombasEstoqueDAO().listarOneToMany();
			this.entradaBomba = new EntradaBomba();
			this.entradaBomba.setQuantidadeTotal(new Short("0"));
			this.itensBombaEntradas = new ArrayList<>(); 
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao criar nova listagem");
			e.printStackTrace();
		}

	}

	public void adiciona(ActionEvent evento) {
		BombasEstoque bomba = (BombasEstoque) evento.getComponent().getAttributes().get("bombaAdicionada");
		Integer achou = null;
		this.ativaBotaoFinalizar = true;
		for (int pos = 0; pos < itensBombaEntradas.size(); pos++) {
			if (this.itensBombaEntradas.get(pos).getBombasEstoqueItem().equals(bomba)) {
				achou = pos;
			}
		}
		if (achou == null) {
			ItemBombaEntrada bombaEntrada = new ItemBombaEntrada();
			bombaEntrada.setBombasEstoqueItem(bomba);
			bombaEntrada.setQuantidadePacialItem(new Short("1"));
			this.itensBombaEntradas.add(bombaEntrada);
		} else {
			ItemBombaEntrada bombaEntrada = this.itensBombaEntradas.get(achou);
			bombaEntrada.setQuantidadePacialItem((short) (bombaEntrada.getQuantidadePacialItem() + 1));

		}

		calcula();

	}

	public void atualizaQuantidadeParcial() {
		for (ItemBombaEntrada itemBombaEntrada : this.itensBombaEntradas) {
			itemBombaEntrada.setQuantidadePacialItem((short) (itemBombaEntrada.getBombasEstoqueItem().getQuantidade()
					+ itemBombaEntrada.getQuantidadePacialItem()));
		}
	}

	private void calcula() {
		this.entradaBomba.setQuantidadeTotal((short) 0);

		for (ItemBombaEntrada itemBombaEntrada : this.itensBombaEntradas) {
			this.entradaBomba.setQuantidadeTotal(
					(short) (entradaBomba.getQuantidadeTotal() + itemBombaEntrada.getQuantidadePacialItem()));
		}
	}

	public void finalizar() {
		try {
			this.entradaBomba.setDataAtual(new Date());
			this.funcionarios = getFuncionarioDAO().listar();
			this.cidades = getCidadeDAO().listar();
			this.pocos = getPocoDAO().listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao finalizar entrada");
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			if (this.entradaBomba.getQuantidadeTotal() == 0) {
				Messages.addGlobalWarn("Adicione item para finalizar ");
				return;
			}
			getEntradaBombaDAO().salvarItemEntrada(this.entradaBomba, this.itensBombaEntradas);
			this.entradaBomba = new EntradaBomba();
			Messages.addGlobalInfo("Entrada da bomba realizada com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar entrada");
			e.printStackTrace();
		}
	}

}
