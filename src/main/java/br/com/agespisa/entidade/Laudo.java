package br.com.agespisa.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity()
@Table(name = "LAUDO")
public class Laudo extends GenericEntidade {

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "data_laudo")
	private Date dataLaudo;

	@Column(length = 200, nullable = true, name = "detalhe_laudo")
	private String detalhes;

	@Column(nullable = false, name = "situacao_laudo")
	private Character situacao;

	@JoinColumn(name = "pk_bomba", nullable = false)
	@ManyToOne
	private Bomba bomba;

	@Transient
	public String situacaoFormatada() {
		String formatado = null;
		if (this.situacao == 'M') {
			 formatado = "Manutenção".toUpperCase();
		} else if (this.situacao == 'R') {
			 formatado = "Recuperado".toUpperCase();
		} else if (this.situacao == 'I') {
			 formatado = "Irrecuperável".toUpperCase();
		} else if (this.situacao == 'O') {
			formatado = "Outros".toUpperCase();
		}
		return formatado;
	}

	public Date getDataLaudo() {
		return dataLaudo;
	}

	public void setDataLaudo(Date dataLaudo) {
		this.dataLaudo = dataLaudo;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public Bomba getBomba() {
		return bomba;
	}

	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}

}
