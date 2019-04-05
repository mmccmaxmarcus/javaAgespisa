package br.com.agespisa.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.agespisa.DAO.UsuarioDAO;
import br.com.agespisa.entidade.Pessoa;
import br.com.agespisa.entidade.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {
	private Usuario usuario;
	private Usuario logado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getLogado() {
		return logado;
	}

	public void setLogado(Usuario logado) {
		this.logado = logado;
	}

	private UsuarioDAO getUsuarioDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO;
	}

	@PostConstruct
	public void novo() {
		this.usuario = new Usuario();
		usuario.setPessoa(new Pessoa());
	}

	public void autenticar() {
		try {
			this.logado = getUsuarioDAO().autenticar(this.usuario.getPessoa().getCpf(), this.usuario.getSenha());
			if (logado != null) {
				Faces.redirect("./pages/principal.xhtml");
			} else {
				Messages.addGlobalWarn("Digite 'cpf' ou 'senha' corretos ");
			}
		} catch (IOException e) {
			e.printStackTrace();
			Messages.addGlobalError(e.getMessage());
		}
	}

	public boolean ocultarPermissoes(List<String> permissoes) {
		for (String permissao : permissoes) {
			if (this.logado.getTipo() == permissao.charAt(0)) {
				return true;
			}
		}
		return false;
	}
}
