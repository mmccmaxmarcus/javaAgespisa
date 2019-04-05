package br.com.agespisa.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class DemonstrativoBomba extends GenericEntidade {

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "demonstrativoBomba", cascade = CascadeType.ALL)
	private List<DemonstrativoBombasItens> demonstrativoBombasItens;
     
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAtual;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Date getDataAtual() {
		return dataAtual;
	}
	
	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	
    public List<DemonstrativoBombasItens> getDemonstrativoBombasItens() {
		return demonstrativoBombasItens;
	}
    
    public void setDemonstrativoBombasItens(List<DemonstrativoBombasItens> demonstrativoBombasItens) {
		this.demonstrativoBombasItens = demonstrativoBombasItens;
	}
    
    

}
