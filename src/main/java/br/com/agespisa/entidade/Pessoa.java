
package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.br.CPF;

@SuppressWarnings("serial")
@Entity
public class Pessoa extends GenericEntidade {
	
	@Column(length = 50, nullable = false)
	private String nome;
    
	@CPF(message="CPF inválido")
	@Column(length = 14, nullable = false)
	private String cpf;

	
	@Column(length = 14, nullable = false)
	private String rg;

	@Column(length = 100, nullable = false)
	private String rua;

	@Column(nullable = false)
	private Short numero;

	@Column(length = 14, nullable = false)
	private String cep;

	@Column(length = 200)
	private String complemento;

	
	@Column(length = 15, nullable = false)
	private String telefone;

	@Column(length = 15, nullable = false)
	private String celular;
     
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private Cidade cidade;
	
	
    public Cidade getCidade() {
		return cidade;
	}
    
    public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
    	
	
}
