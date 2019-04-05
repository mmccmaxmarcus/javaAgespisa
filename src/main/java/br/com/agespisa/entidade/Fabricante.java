package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Fabricante extends GenericEntidade {
    
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 45, nullable = true)
	private String telefone;
	
	@Column(length = 45, nullable = true)
	private String site;
	
	@Column(length = 45, nullable = true, name="endereço")
	private String endereco;
	
	@Column(length = 45, nullable = true, name = "email")
	private String email;
	
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
