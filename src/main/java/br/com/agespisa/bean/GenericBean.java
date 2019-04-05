package br.com.agespisa.bean;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

public interface GenericBean {
    
	public void novo();
	public void salvar();
	@PostConstruct
    public void listar();
    public void excluir(ActionEvent evento);
	public void editar(ActionEvent evento);
}
