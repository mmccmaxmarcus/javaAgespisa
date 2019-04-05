package br.com.agespisa.DAO;

import org.junit.Test;

import br.com.agespisa.entidade.Cargo;
import br.com.agespisa.entidade.Funcionario;
import br.com.agespisa.entidade.Lotacao;
import br.com.agespisa.entidade.Pessoa;

public class FuncionarioTest {
   
	@Test
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1l);
		CargoDAO cargoDAO = new CargoDAO();
		LotacaoDAO lotacaoDAO = new LotacaoDAO();
		Cargo cargo = cargoDAO.buscar(1l);
		Lotacao lotacao = lotacaoDAO.buscar(1l);
		
		funcionario.setCargo(cargo);
		funcionario.setLotacao(lotacao);
		funcionario.setPessoa(pessoa);
		funcionario.setMatricula("1199-1");
		funcionarioDAO.salvar(funcionario);
	}
	
}
