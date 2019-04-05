package br.com.agespisa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.PessoaDAO;
import br.com.agespisa.DAO.UsuarioDAO;
import br.com.agespisa.entidade.Pessoa;
import br.com.agespisa.entidade.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable, GenericBean {
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Pessoa> pessoas;
	private Pessoa pessoa;

	public Usuario getUsuario() {
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	private PessoaDAO getPessoaDao() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO;
	}

	private UsuarioDAO getUsuarioDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO;
	}

	@Override
	public void novo() {
		try {
			this.usuario = new Usuario();
			this.pessoas = getPessoaDao().listar();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao adicionar novo usuário");

		}
	}

	@Override
	public void salvar() {
		try {
			SimpleHash hash = new SimpleHash("md5", usuario.getSenha());
			this.usuario.setSenha(hash.toHex());
			getUsuarioDAO().merge(usuario);
			this.novo();
			this.usuarios = getUsuarioDAO().listar();
			Messages.addGlobalInfo("Usuário salvo com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao salvar usuário");
		}
	}

	@Override
	@PostConstruct
	public void listar() {
		try {
			this.usuarios = getUsuarioDAO().listar();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao listar usuário");
		}
	}

	@Override
	public void excluir(ActionEvent evento) {
		try {
			this.usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			getUsuarioDAO().excluir(usuario);
			this.usuarios = getUsuarioDAO().listar();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao editar usuário");
		}
	}

	@Override
	public void editar(ActionEvent evento) {
		try {
			this.usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			this.pessoas = getPessoaDao().listar();
			getUsuarioDAO().merge(usuario);
			this.usuarios = getUsuarioDAO().listar();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao editar usuário");
		}
	}
	
	
}
