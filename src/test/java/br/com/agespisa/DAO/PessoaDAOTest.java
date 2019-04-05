package br.com.agespisa.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agespisa.entidade.Cidade;
import br.com.agespisa.entidade.Pessoa;

public class PessoaDAOTest {
	private PessoaDAO getPessoaDAO() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO;
	}
	
	private CidadeDAO getCidadeDAO() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		return cidadeDAO;
	}
	
	@Test
	public void salvar() {
	   Pessoa pessoa = new Pessoa();
	   Cidade cidade = getCidadeDAO().buscar(1l); 
	   pessoa.setNome("Max Marcus");
	   pessoa.setCpf("044.254.403-07");
	   pessoa.setRg("2.780-545");
	   pessoa.setRua("Freitas Neto");
	   pessoa.setNumero(new Short((short) 3));
	   pessoa.setCep("64010-260");
	   pessoa.setComplemento("Pato Preto");
	   pessoa.setTelefone("3216 - 6365");
	   pessoa.setCelular("(86)99978-8794");
	   pessoa.setEmail("mmccmaxmarcus@gmail.com");
	   pessoa.setCidade(cidade);
	   getPessoaDAO().salvar(pessoa);
	}
	
	@Test
	@Ignore
	public void listar() {
		List<Pessoa> pessoas = getPessoaDAO().listar();
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getCodigo());
			System.out.println(pessoa.getCelular());
			System.out.println(pessoa.getCep());
			System.out.println(pessoa.getComplemento());
			System.out.println(pessoa.getCpf());
			System.out.println(pessoa.getEmail());
			System.out.println(pessoa.getNome());
			System.out.println(pessoa.getRg());
			System.out.println(pessoa.getRua());
			System.out.println(pessoa.getTelefone());
			System.out.println(pessoa.getCodigo());
			System.out.println(pessoa.getNumero());
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		Pessoa pessoa = getPessoaDAO().buscar(1l);
		System.out.println(pessoa.getCelular());
		System.out.println(pessoa.getCep());
		System.out.println(pessoa.getComplemento());
		System.out.println(pessoa.getCpf());
		System.out.println(pessoa.getEmail());
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getRg());
		System.out.println(pessoa.getRua());
		System.out.println(pessoa.getTelefone());
		System.out.println(pessoa.getCodigo());
		System.out.println(pessoa.getNumero());
	}
	
	@Test
	@Ignore
	public void editar() {
		Pessoa pessoa = getPessoaDAO().buscar(1l);
		pessoa.setNome("Max Marcus");
		   pessoa.setCpf("044.254.403-07");
		   pessoa.setRg("2.780-556");
		   pessoa.setRua("Freitas Neto");
		   pessoa.setNumero(new Short((short) 3));
		   pessoa.setCep("64010-300");
		   pessoa.setComplemento("Pato Preto");
		   pessoa.setTelefone("3216 - 6365");
		   pessoa.setCelular("(86)99978-8794");
		   pessoa.setEmail("mmccmaxmarcus@gmail.com");
		getPessoaDAO().editar(pessoa);
		
		List<Pessoa> pessoas = getPessoaDAO().listar();
		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo());
			System.out.println(p.getCelular());
			System.out.println(p.getCep());
			System.out.println(p.getComplemento());
			System.out.println(p.getCpf());
			System.out.println(p.getEmail());
			System.out.println(p.getNome());
			System.out.println(p.getRg());
			System.out.println(p.getRua());
			System.out.println(p.getTelefone());
			System.out.println(p.getCodigo());
			System.out.println(p.getNumero());
		}
		
	}
	
	@Test
	@Ignore
	public void excluir() {
		Pessoa pessoa = getPessoaDAO().buscar(1l);
		getPessoaDAO().excluir(pessoa);
	}
	
	
	
}
