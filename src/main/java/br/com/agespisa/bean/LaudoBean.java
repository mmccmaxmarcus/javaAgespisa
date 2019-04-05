package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

import br.com.agespisa.DAO.BombaDAO;
import br.com.agespisa.DAO.BombasEstoqueDAO;
import br.com.agespisa.DAO.LaudoDAO;
import br.com.agespisa.entidade.Bomba;
import br.com.agespisa.entidade.BombasEstoque;
import br.com.agespisa.entidade.Laudo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LaudoBean implements Serializable {
	private Bomba bomba;
	private List<Bomba> bombas;
	private boolean skip;
	private Laudo laudo;
	private List<Laudo> laudos;
	private BombasEstoque bombasEstoque;
	private List<BombasEstoque> bombasEstoques;
	private boolean ativaDialog;
	private Laudo laudoSelecionado;

	public boolean isAtivaDialog() {
		return ativaDialog;
	}

	public void setAtivaDialog(boolean ativaDialog) {
		this.ativaDialog = ativaDialog;
	}

	public Laudo getLaudoSelecionado() {
		return laudoSelecionado;
	}

	public void setLaudoSelecionado(Laudo laudoSelecionado) {
		this.laudoSelecionado = laudoSelecionado;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public Laudo getLaudo() {
		if (this.laudo == null) {
			this.laudo = new Laudo();
		}
		return laudo;
	}

	public void setLaudo(Laudo laudo) {
		this.laudo = laudo;
	}

	public List<Laudo> getLaudos() {
		return laudos;
	}

	public void setLaudos(List<Laudo> laudos) {
		this.laudos = laudos;
	}

	public BombasEstoque getBombasEstoque() {
		if(this.bombasEstoque == null) {
			this.bombasEstoque = new BombasEstoque();
		}
		return bombasEstoque;
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

	public Bomba getBomba() {
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

	private LaudoDAO getlaudoDAO() {
		LaudoDAO laudoDAO = new LaudoDAO();
		return laudoDAO;
	}

	private BombaDAO getbombaDAO() {
		BombaDAO bombaDAO = new BombaDAO();
		return bombaDAO;
	}

	private BombasEstoqueDAO getBombaEstoqueDAO() {
		BombasEstoqueDAO bombasEstoqueDAO = new BombasEstoqueDAO();
		return bombasEstoqueDAO;
	}

	@PostConstruct
	public void novo() {
		try {
			this.bombasEstoque = new BombasEstoque();
			this.bombasEstoques = getBombaEstoqueDAO().listarOneToMany();
			this.bomba = new Bomba();
			this.bombas = getbombaDAO().listarOneToMany();
			this.laudo = new Laudo();
			this.laudo.setDataLaudo(new Date());
			this.bombasEstoque.setQuantidade(new Short("0"));
			this.ativaDialog = false;
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao criar novo laudo");
		}
	}

	@SuppressWarnings("deprecation")
	public void adicionaEstoque(ActionEvent evento) {
		Bomba bombaSelecionada = (Bomba) evento.getComponent().getAttributes().get("bombaSelecionada");
		RequestContext context = RequestContext.getCurrentInstance();
		try {

			if (!bombaSelecionada.getLaudos().isEmpty()) {
				Bomba bomba = getbombaDAO().buscarBombaOneToMany(bombaSelecionada.getCodigo());
				this.laudoSelecionado = bomba.getLaudos().get(bomba.getLaudos().size() - 1);
				context.execute("PF('dlgEstoque').show();");
			} else {
				this.ativaDialog = false;
				Messages.addFlashGlobalWarn("Adicione status a bomba");
				return;
			}

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao adicionar");
		}

	}

	public void salvarEstoque() {
		try {
			if (this.laudoSelecionado.getSituacao().equals('R')) {
				this.bombasEstoque.setLaudo(this.laudoSelecionado);
				Faces.getExternalContext().getFlash().setKeepMessages(true);
				getBombaEstoqueDAO().salvar(this.bombasEstoque);
				Messages.addGlobalInfo("Bomba adicionada ao estoque com sucesso");
			} else {
				Messages.addGlobalWarn("Só é possivel adicionar bomba ao estoque se estiver recuperada");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao salvar no estoque");

		}
	}

	public void Adicionar() {
		try {
			getlaudoDAO().salvar(laudo);
			this.laudo = new Laudo();
			Faces.getExternalContext().getFlash().setKeepMessages(true);
			Messages.addGlobalInfo("Salvo com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}
