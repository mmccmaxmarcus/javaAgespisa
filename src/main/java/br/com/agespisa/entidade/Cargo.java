package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGO")
public class Cargo extends GenericEntidade{
   
	@Column(length = 50, nullable = false, name = "nome_cargo")
	private String nome;
	
	@Column(length = 200, nullable = true, name="obs_cargo")
	private String Obs;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setObs(String obs) {
		Obs = obs;
	}
	
	public String getObs() {
		return Obs;
	}

}
