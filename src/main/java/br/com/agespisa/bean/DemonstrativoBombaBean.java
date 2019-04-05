package br.com.agespisa.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.BombaDAO;
import br.com.agespisa.DAO.DemonstrativoBombaDAO;
import br.com.agespisa.DAO.FuncionarioDAO;
import br.com.agespisa.DAO.PocoDAO;
import br.com.agespisa.entidade.Bomba;
import br.com.agespisa.entidade.DemonstrativoBomba;
import br.com.agespisa.entidade.DemonstrativoBombasItens;
import br.com.agespisa.entidade.Funcionario;
import br.com.agespisa.entidade.Poco;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DemonstrativoBombaBean implements Serializable {
	private DemonstrativoBomba demonstrativoBomba;
	private List<DemonstrativoBomba> demonstrativoBombas;
	private List<DemonstrativoBombasItens> demonstrativoBombasItens;
	private DemonstrativoBombasItens bombasItem;
	private List<Poco> pocos;
	private List<Bomba> bombas;
	private List<Funcionario> funcionarios;
	private int indice = -1;

	private DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR"));

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public DemonstrativoBombasItens getBombasItem() {
		if(this.bombasItem == null) {
			this.bombasItem = new DemonstrativoBombasItens();
		}
		return bombasItem;
	}

	public void setBombasItem(DemonstrativoBombasItens bombasItem) {
		this.bombasItem = bombasItem;
	}

	public List<Bomba> getBombas() {
		return bombas;
	}

	public void setBombas(List<Bomba> bombas) {
		this.bombas = bombas;
	}

	public List<Poco> getPocos() {
		return pocos;
	}

	public void setPocos(List<Poco> pocos) {
		this.pocos = pocos;
	}

	public DemonstrativoBomba getDemonstrativoBomba() {
		if (demonstrativoBomba == null) {
			this.demonstrativoBomba = new DemonstrativoBomba();
		}
		return demonstrativoBomba;
	}

	public void setDemonstrativoBomba(DemonstrativoBomba demonstrativoBomba) {
		this.demonstrativoBomba = demonstrativoBomba;
	}

	public List<DemonstrativoBomba> getDemonstrativoBombas() {
		return demonstrativoBombas;
	}

	public void setDemonstrativoBombas(List<DemonstrativoBomba> demonstrativoBombas) {
		this.demonstrativoBombas = demonstrativoBombas;
	}

	public List<DemonstrativoBombasItens> getDemonstrativoBombasItens() {
		return demonstrativoBombasItens;
	}

	public void setDemonstrativoBombasItens(List<DemonstrativoBombasItens> demonstrativoBombasItens) {
		this.demonstrativoBombasItens = demonstrativoBombasItens;
	}

	private DemonstrativoBombaDAO getDemonstrativoDAO() {
		DemonstrativoBombaDAO bombaDAO = new DemonstrativoBombaDAO();
		return bombaDAO;
	}

	private PocoDAO getPocoDAO() {
		PocoDAO pocoDAO = new PocoDAO();
		return pocoDAO;
	}

	private BombaDAO getBombaDAO() {
		BombaDAO bombaDAO = new BombaDAO();
		return bombaDAO;
	}

	private FuncionarioDAO getFuncionarioDAO() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}

	public void novo() {
		try {
			this.demonstrativoBombasItens = new ArrayList<>();
			this.bombasItem = new DemonstrativoBombasItens();
			this.pocos = getPocoDAO().listar();
			this.bombas = getBombaDAO().listar();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao criar novo demonstrativo de bombas");

		}
	}

	public void adicionarDemonstrativo() {
		this.testeBotaoAdicionar();
		this.demonstrativoBombasItens.add(bombasItem);
		this.bombasItem = new DemonstrativoBombasItens();
		


		for (DemonstrativoBombasItens posicao : this.demonstrativoBombasItens) {
			System.out.println(df.format(posicao.getDataInstalacao()));
		}
		System.out.println();
	}

	public boolean testeBotaoAdicionar() {
		if (this.demonstrativoBombasItens.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public void removerItemDemonstrativo(DemonstrativoBombasItens itemDemonstrativo) {
		synchronized (demonstrativoBombasItens) {
		   DemonstrativoBombasItens item = itemDemonstrativo;
		   demonstrativoBombasItens.remove(item);
			
		   
		}	  
		  
	}

	public void finalizarDemonstrativo() {
		try {
			this.demonstrativoBomba = new DemonstrativoBomba();
			this.demonstrativoBomba.setDataAtual(new Date());
			this.funcionarios = getFuncionarioDAO().listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao finalizar");
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			getDemonstrativoDAO().salvar(this.demonstrativoBomba, this.demonstrativoBombasItens);
			this.bombasItem = new DemonstrativoBombasItens();
			Messages.addGlobalInfo("Demonstrativo salvo com sucesso");
			Faces.getExternalContext().getFlash().setKeepMessages(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao salvar demonstrativo de bombas");
		}
	}

	public void listar() {
		try {
			this.demonstrativoBombas = getDemonstrativoDAO().listar();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addFlashGlobalError("Erro ao listar");
		}
	}


	
	}


	
	



