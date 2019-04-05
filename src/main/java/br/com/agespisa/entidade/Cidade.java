package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericEntidade {
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Estado estado;
	
	@Column(length=40, nullable=false)
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
    public Estado getEstado() {
		return estado;
	}
    
    public void setEstado(Estado estado) {
		this.estado = estado;
	}
    
}
