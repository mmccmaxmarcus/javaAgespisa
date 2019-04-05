package br.com.agespisa.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import br.com.agespisa.DAO.EntradaBombaDAO;
import br.com.agespisa.entidade.EntradaBomba;
import br.com.agespisa.entidade.SaidaBomba;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class SaidaBombaBean implements Serializable {
	private EntradaBomba entradaBomba;
	private ScheduleModel scheduleEntrada;
	private List<EntradaBomba> entradaBombas = new ArrayList<EntradaBomba>();
	private SaidaBomba saidaBomba;

	public EntradaBomba getEntradaBomba() {
		return entradaBomba;
	}

	public void setEntradaBomba(EntradaBomba entradaBomba) {
		this.entradaBomba = entradaBomba;
	}

	public ScheduleModel getScheduleEntrada() {
		return scheduleEntrada;
	}

	public void setScheduleEntrada(ScheduleModel scheduleEntrada) {
		this.scheduleEntrada = scheduleEntrada;
	}

	public List<EntradaBomba> getEntradaBombas() {
		return entradaBombas;
	}

	public void setEntradaBombas(List<EntradaBomba> entradaBombas) {
		this.entradaBombas = entradaBombas;
	}

	private EntradaBombaDAO getEntradaBombaDAO() {
		EntradaBombaDAO entradaBombaDAO = new EntradaBombaDAO();
		return entradaBombaDAO;
	}

	@PostConstruct
	public void init() {
		this.entradaBomba = new EntradaBomba();
		this.saidaBomba = new SaidaBomba();

		this.scheduleEntrada = new DefaultScheduleModel();

		try {
			this.entradaBombas = getEntradaBombaDAO().listarOneToMany();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao criar Schedule");
		}

		for (EntradaBomba entrada : this.entradaBombas) {
			DefaultScheduleEvent event = new DefaultScheduleEvent();
			event.setStartDate(entrada.getDataEntrada());
			event.setEndDate(new Date());
			event.setTitle(entrada.getFuncionarioEntrada().getPessoa().getNome());
			event.setData(entrada.getCodigo());
			event.setDescription(entrada.getFuncionarioEntrada().getPessoa().getNome());
			event.setAllDay(true);
			event.setEditable(true);

			this.scheduleEntrada.addEvent(event);
		}

	}

}
