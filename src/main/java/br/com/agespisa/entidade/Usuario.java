package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericEntidade {

	@Column(nullable = false)
	private Boolean ativo;

	@Column(length = 35, nullable = false)
	private String senha;

	@Column(nullable = false)
	private Character tipo;

	@JoinColumn(nullable = false)
	@OneToOne
	private Pessoa pessoa;

	@Transient
	private String senhaSemFormatar;

	public Boolean getAtivo() {
		return ativo;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getSenhaSemFormatar() {
		return senhaSemFormatar;
	}

	public void setSenhaSemFormatar(String senhaSemFormatar) {
		this.senhaSemFormatar = senhaSemFormatar;
	}

	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;
		if (this.tipo == 'A') {
			tipoFormatado = "Administrador";
		} else if (this.tipo == 'G') {
			tipoFormatado = "Genérico";
		}
		return tipoFormatado;
	}

	@Transient
	public String getAtivoFormatado() {
		String ativoFormatado = null;
		if (this.ativo == true) {
			ativoFormatado = "sim";
		} else if (this.ativo == false) {
			ativoFormatado = "não";
		}
		return ativoFormatado;
	}

}
