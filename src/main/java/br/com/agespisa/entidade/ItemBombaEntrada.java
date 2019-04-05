package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItemBombaEntrada extends GenericEntidade {

	@JoinColumn(nullable = false)
	@ManyToOne
	private BombasEstoque bombasEstoqueItem;

	@Column(nullable = false)
	private Short quantidadePacialItem;

	@JoinColumn(nullable = false)
	@ManyToOne
	private EntradaBomba entradaBomba;

	public BombasEstoque getBombasEstoqueItem() {
		return bombasEstoqueItem;
	}

	public void setBombasEstoqueItem(BombasEstoque bombasEstoqueItem) {
		this.bombasEstoqueItem = bombasEstoqueItem;
	}
	
	
	
	public EntradaBomba getEntradaBomba() {
		return entradaBomba;
	}

	public void setEntradaBomba(EntradaBomba entradaBomba) {
		this.entradaBomba = entradaBomba;
	}

	public Short getQuantidadePacialItem() {
		return quantidadePacialItem;
	}

	public void setQuantidadePacialItem(Short quantidadePacialItem) {
		this.quantidadePacialItem = quantidadePacialItem;
	}

	

}
