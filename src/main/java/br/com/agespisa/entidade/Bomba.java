package br.com.agespisa.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Bomba extends GenericEntidade {

	@JoinColumn(nullable = false)
	@ManyToOne
	private Fabricante fabricante;

	@Column(length = 45, nullable = false)
	private String modelo;

	@Column(length = 10, nullable = true, name = "vazão")
	private String vazao;

	@Column(length = 10, nullable = false, name = "potência")
	private String potencia;

	@Column(length = 10, nullable = true, name = "altura_manumétrica")
	private String alturaManumetrica;

	@Column(length = 45, nullable = true)
	private String tombamento;
	
	@OneToMany(mappedBy="bomba", fetch=FetchType.EAGER,orphanRemoval=true)
	private List<Laudo> laudos;

	public List<Laudo> getLaudos() {
		return laudos;
	}
	
	public void setLaudos(List<Laudo> laudos) {
		this.laudos = laudos;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVazao() {
		return vazao;
	}

	public void setVazao(String vazao) {
		this.vazao = vazao;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getAlturaManumetrica() {
		return alturaManumetrica;
	}

	public void setAlturaManumetrica(String alturaManumetrica) {
		this.alturaManumetrica = alturaManumetrica;
	}

	public String getTombamento() {
		return tombamento;
	}

	public void setTombamento(String tombamento) {
		this.tombamento = tombamento;
	}

}
