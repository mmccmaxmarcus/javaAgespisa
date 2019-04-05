package br.com.agespisa.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "BOMBA_ESTOQUE")
public class BombasEstoque extends GenericEntidade {

	
	@OneToOne
	@JoinColumn(nullable = false, name = "laudo_fk")
	private Laudo laudo;

	@Column(nullable = false, name = "qtde")
	private Short quantidade;

	@Column(nullable = false, name = "data_estoque")
	@Temporal(TemporalType.DATE)
    private Date dataEntrouEstoque;
	
	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public Laudo getLaudo() {
		return laudo;
	}

	public void setLaudo(Laudo laudo) {
		this.laudo = laudo;
	}

	public Date getDataEntrouEstoque() {
		return dataEntrouEstoque;
	}

	public void setDataEntrouEstoque(Date dataEntrouEstoque) {
		this.dataEntrouEstoque = dataEntrouEstoque;
	}
	
	

	

}
