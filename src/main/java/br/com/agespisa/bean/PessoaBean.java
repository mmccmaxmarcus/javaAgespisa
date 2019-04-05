package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.CidadeDAO;
import br.com.agespisa.DAO.EstadoDAO;
import br.com.agespisa.DAO.PessoaDAO;
import br.com.agespisa.entidade.Cidade;
import br.com.agespisa.entidade.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Cidade> cidades;
	private Cidade cidade;
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		if (pessoa == null) {
			this.pessoa = new Pessoa();
		}
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public PessoaDAO getPessoaDAO() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO;
	}

	public CidadeDAO getCidadeDAO() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		return cidadeDAO;
	}

	public EstadoDAO getEstadoDAO() {
		EstadoDAO estadoDAO = new EstadoDAO();
		return estadoDAO;
	}

	public void novo() {
		this.pessoa = new Pessoa();
		this.pessoas = getPessoaDAO().listar();
		this.cidades = getCidadeDAO().listar();
	}

	public void salvar() {
		try {
			getPessoaDAO().merge(pessoa);
			this.novo();
			Messages.addGlobalInfo("Pessoa salva com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao salvar pessoa");
		}
	}

	@PostConstruct
	public void listar() {
		try {
			this.pessoas = getPessoaDAO().listar();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao listar pessoa");
		}
	}

	public void editar(ActionEvent evento) {
		try {
			this.pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			this.cidades = getCidadeDAO().listar();
			getPessoaDAO().merge(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao editar pessoa");
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			this.pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			getPessoaDAO().excluir(pessoa);
			this.pessoas = getPessoaDAO().listar();
			Messages.addGlobalInfo("Pessoa excluida com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao excluir pesssoa");
		}
	}

}
