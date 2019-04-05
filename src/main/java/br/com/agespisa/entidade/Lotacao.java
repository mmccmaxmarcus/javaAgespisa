package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOTACAO")
public class Lotacao extends GenericEntidade {
	@Column(length = 20, nullable = false, name = "sigla_lotacao")
	private String nome;

	@Column(length = 59, nullable = true, name = "descricao_lotacao")
	private String descricao;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
