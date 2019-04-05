package br.com.agespisa.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.agespisa.bean.AutenticacaoBean;
import br.com.agespisa.entidade.Usuario;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		String paginaAtual = Faces.getViewId();
		boolean paginaAutenticada = paginaAtual.contains("autentica.xhtml");
		if (!paginaAutenticada) {
			AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute("autenticacaoBean");
			if (autenticacaoBean == null) {
				Faces.navigate("/pages/autentica.xhtml");
				return;
			}
			Usuario usuario = autenticacaoBean.getLogado();
			if (usuario == null) {
				Faces.navigate("/pages/autentica.xhtml");
				return;
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
