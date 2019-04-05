package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Poco extends GenericEntidade {

	@Column(nullable = true, length = 100)
	private String endereco;

	@Column(nullable = true)
	private Short numero;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Cidade cidade;
	
	@Column(length = 10, nullable = true, name="coluna_edutora")
	private String colunaEdutora;
	
	@Column(nullable= true, length = 10)
	private String vazaoPoco;
	
	@Column(nullable = true,  length = 200)
	private String descricao;
   
	public String getVazaoPoco() {
		return vazaoPoco;
	}

	public void setVazaoPoco(String vazaoPoco) {
		this.vazaoPoco = vazaoPoco;
	}

	public String getColunaEdutora() {
		return colunaEdutora;
	}

	public void setColunaEdutora(String colunaEdutora) {
		this.colunaEdutora = colunaEdutora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

}
