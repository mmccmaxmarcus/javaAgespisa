package br.com.agespisa.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class EntradaBomba extends GenericEntidade {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAtual;

	@Column(nullable = false)
	private Short quantidadeTotal;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Funcionario funcionarioEntrada;

	@JoinColumn(nullable = true)
	@ManyToOne
	private Poco pocoItem;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Cidade cidadeEntrada;

	@Column(nullable = true, length = 200)
	private String obs;

	@OneToMany(mappedBy = "entradaBomba", fetch = FetchType.EAGER)
	private List<ItemBombaEntrada> itemBombaEntradas;

	public Poco getPocoItem() {
		return pocoItem;
	}

	public void setPocoItem(Poco pocoItem) {
		this.pocoItem = pocoItem;
	}

	public Short getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Short quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Funcionario getFuncionarioEntrada() {
		return funcionarioEntrada;
	}

	public void setFuncionarioEntrada(Funcionario funcionarioEntrada) {
		this.funcionarioEntrada = funcionarioEntrada;
	}

	public Cidade getCidadeEntrada() {
		return cidadeEntrada;
	}

	public void setCidadeEntrada(Cidade cidadeEntrada) {
		this.cidadeEntrada = cidadeEntrada;
	}

	public List<ItemBombaEntrada> getItemBombaEntradas() {
		return itemBombaEntradas;
	}

	public void setItemBombaEntradas(List<ItemBombaEntrada> itemBombaEntradas) {
		this.itemBombaEntradas = itemBombaEntradas;
	}


}
