package br.com.agespisa.DAO;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.agespisa.entidade.Pessoa;
import br.com.agespisa.entidade.Usuario;

public class UsuarioDAOTest {

	public PessoaDAO getPessoaDAO() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO;
	}

	@Test
	public void salvar() {
        Pessoa pessoa = getPessoaDAO().buscar(1l);
        Usuario usuario = new Usuario();
        usuario.setPessoa(pessoa);
        usuario.setAtivo(true);
        usuario.setSenhaSemFormatar("max123");
        usuario.setTipo('A');
        SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemFormatar());
        usuario.setSenha(hash.toHex());
        getUsuarioDAO().salvar(usuario);
	}
    
	@Test
	@Ignore
	public void listar() {
		List<Usuario> usuarios = getUsuarioDAO().listar();
		for (Usuario u : usuarios) {
			System.out.println(u.getPessoa().getNome());
			System.out.println(u.getSenha());
			System.out.println(u.getAtivo());
			System.out.println(u.getTipo());
		}
	}

}
