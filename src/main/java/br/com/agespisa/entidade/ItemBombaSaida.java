package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItemBombaSaida extends GenericEntidade {
    
	@JoinColumn(nullable = false, name = "fk_bombasestoque")
	@ManyToOne
	private BombasEstoque bombasEstoque;
    
	@JoinColumn(nullable = false, name = "fk_saidabomba")
	@ManyToOne
    private SaidaBomba saidaBomba;
    
	@Column(nullable = false, name = "quantidade_parcial_item_saida")
    private Short quantidade_parcial;
	
	
	public BombasEstoque getBombasEstoque() {
		return bombasEstoque;
	}

	public void setBombasEstoque(BombasEstoque bombasEstoque) {
		this.bombasEstoque = bombasEstoque;
	}

	public SaidaBomba getSaidaBomba() {
		return saidaBomba;
	}

	public void setSaidaBomba(SaidaBomba saidaBomba) {
		this.saidaBomba = saidaBomba;
	}

	public Short getQuantidade_parcial() {
		return quantidade_parcial;
	}

	public void setQuantidade_parcial(Short quantidade_parcial) {
		this.quantidade_parcial = quantidade_parcial;
	}
    
}
