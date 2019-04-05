package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.CargoDAO;
import br.com.agespisa.DAO.FuncionarioDAO;
import br.com.agespisa.DAO.LotacaoDAO;
import br.com.agespisa.DAO.PessoaDAO;
import br.com.agespisa.entidade.Cargo;
import br.com.agespisa.entidade.Funcionario;
import br.com.agespisa.entidade.Lotacao;
import br.com.agespisa.entidade.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBean implements GenericBean, Serializable {
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Pessoa> pessoas;
	private List<Cargo> cargos;
	private List<Lotacao> lotacaos;

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public List<Lotacao> getLotacaos() {
		return lotacaos;
	}

	public void setLotacaos(List<Lotacao> lotacaos) {
		this.lotacaos = lotacaos;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	private PessoaDAO getPessoaDAO() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO;
	}

	private FuncionarioDAO getFuncionarioDAO() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO;
	}

	private CargoDAO getCargoDAO() {
		CargoDAO cargoDAO = new CargoDAO();
		return cargoDAO;
	}

	private LotacaoDAO getLotacaoDAO() {
		LotacaoDAO lotacaoDAO = new LotacaoDAO();
		return lotacaoDAO;
	}

	@Override
	public void novo() {
		this.funcionario = new Funcionario();
		this.funcionarios = getFuncionarioDAO().listar();
		this.pessoas = getPessoaDAO().listar();

	}

	@Override
	public void salvar() {
		try {
			getFuncionarioDAO().merge(funcionario);
			this.novo();
			Messages.addGlobalInfo("Funcionário salvo com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao salvar funcionário");
		}

	}

	@Override
	public void editar(ActionEvent evento) {
		try {
			this.funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
			this.pessoas = getPessoaDAO().listar();
			getFuncionarioDAO().merge(funcionario);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao editar funcionário");

		}

	}

	public List<Cargo> buscaCargo(String cargo) {
		return getCargoDAO().autoComplete(cargo);
	}

	public List<Lotacao> buscaLotacao(String lotacao) {
		return getLotacaoDAO().autoComplete(lotacao);
	}

	@Override
	@PostConstruct
	public void listar() {
		try {
			this.funcionarios = getFuncionarioDAO().listar();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao listar funcionário");
		}

	}

	@Override
	public void excluir(ActionEvent eventos) {
		try {
			this.funcionario = (Funcionario) eventos.getComponent().getAttributes().get("funcionarioSelecionado");
			getFuncionarioDAO().excluir(funcionario);
			this.listar();
			Messages.addGlobalInfo("Funcionário excluido com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao excluir funcionário");
		}

	}

}
