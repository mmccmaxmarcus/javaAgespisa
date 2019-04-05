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

@SuppressWarnings("serial")
@Entity()
public class SaidaBomba extends GenericEntidade {
    @Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAtual;
	
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date dataSaida;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Cidade cidade;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Funcionario funcionario;
	
	@JoinColumn(nullable = true)
	@ManyToOne
    private Poco saidaPoco;
	
	@Column(length = 200, nullable = true)
	private String obs;
	
	@OneToMany(mappedBy="saidaBomba", fetch = FetchType.EAGER)
	private List<ItemBombaSaida> itemBombaSaidas;
	 
	
	public Poco getSaidaPoco() {
		return saidaPoco;
	}

	public void setSaidaPoco(Poco saidaPoco) {
		this.saidaPoco = saidaPoco;
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

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ItemBombaSaida> getItemBombaSaidas() {
		return itemBombaSaidas;
	}

	public void setItemBombaSaidas(List<ItemBombaSaida> itemBombaSaidas) {
		this.itemBombaSaidas = itemBombaSaidas;
	}
	
	
}
