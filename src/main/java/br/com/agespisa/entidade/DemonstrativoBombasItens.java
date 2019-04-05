package br.com.agespisa.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class DemonstrativoBombasItens extends GenericEntidade {

	@JoinColumn(nullable = false)
	@ManyToOne
	private DemonstrativoBomba demonstrativoBomba;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Poco poco;

	@Column(length = 10, nullable = false)
	private String submersoCentrifugo;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Bomba bomba;

	@Column(nullable = true, length = 50)
	private String vazaoPoco;

	@Column(nullable = true, length = 50)
	private String vazaoBomba;

	@Column(nullable = true, length = 50)
	private String alturaManometrica;

	@Column(nullable = true, length = 50)
	private String reservacao;

	@Column(nullable = true, length = 50)
	private String profundidadeColocacao;

	@Column(nullable = true, length = 50)
	private String diametroTudoEdutor;

	@Column(nullable = true, length = 50)
	private String diametroBarrilete;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInstalacao;

	public DemonstrativoBomba getDemonstrativoBomba() {
		return demonstrativoBomba;
	}

	public void setDemonstrativoBomba(DemonstrativoBomba demonstrativoBomba) {
		this.demonstrativoBomba = demonstrativoBomba;
	}
	
	public Poco getPoco() {
		return poco;
	}

	public void setPoco(Poco poco) {
		this.poco = poco;
	}

	public String getSubmersoCentrifugo() {
		return submersoCentrifugo;
	}

	public void setSubmersoCentrifugo(String submersoCentrifugo) {
		this.submersoCentrifugo = submersoCentrifugo;
	}

	public Bomba getBomba() {
		return bomba;
	}

	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}

	public String getVazaoBomba() {
		return vazaoBomba;
	}

	public void setVazaoBomba(String vazaoBomba) {
		this.vazaoBomba = vazaoBomba;
	}

	public String getAlturaManometrica() {
		return alturaManometrica;
	}

	public void setAlturaManometrica(String alturaManometrica) {
		this.alturaManometrica = alturaManometrica;
	}

	public String getReservacao() {
		return reservacao;
	}

	public void setReservacao(String reservacao) {
		this.reservacao = reservacao;
	}

	public String getProfundidadeColocacao() {
		return profundidadeColocacao;
	}

	public void setProfundidadeColocacao(String profundidadeColocacao) {
		this.profundidadeColocacao = profundidadeColocacao;
	}

	public String getDiametroTudoEdutor() {
		return diametroTudoEdutor;
	}

	public void setDiametroTudoEdutor(String diametroTudoEdutor) {
		this.diametroTudoEdutor = diametroTudoEdutor;
	}

	public String getDiametroBarrilete() {
		return diametroBarrilete;
	}

	public void setDiametroBarrilete(String diametroBarrilete) {
		this.diametroBarrilete = diametroBarrilete;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	
	public String getVazaoPoco() {
		return vazaoPoco;
	}
	
	public void setVazaoPoco(String vazaoPoco) {
		this.vazaoPoco = vazaoPoco;
	}

}
