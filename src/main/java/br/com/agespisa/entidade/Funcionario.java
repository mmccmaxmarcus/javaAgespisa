package br.com.agespisa.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericEntidade {

	@Column(length = 10, nullable = false, unique = true, name = "matr_funcionario")
	private String matricula;

	@JoinColumn(nullable = false, name = "cargo_fk")
	@ManyToOne
	private Cargo cargo;

	@JoinColumn(nullable = false, name = "lotacao_fk")
	@ManyToOne
	private Lotacao lotacao;

	@JoinColumn(nullable = false, name = "pessoa_fk")
	@OneToOne
	private Pessoa pessoa;

	public Lotacao getLotacao() {
		return lotacao;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Cargo getCargo() {
		return cargo;
	}
     

}
