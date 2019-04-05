package br.com.agespisa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import br.com.agespisa.DAO.LotacaoDAO;
import br.com.agespisa.entidade.Lotacao;

@FacesConverter("converterLotacao")
public class ConverterLotacao implements Converter {
	private LotacaoDAO lotacaoDAO = new LotacaoDAO();
	private Lotacao lotacao = null;

	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(StringUtils.isNotBlank(value)) {
       	 this.lotacao = lotacaoDAO.buscar(new Long(value)); 
        }
		return lotacao;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
     if(value != null) {
   	  Long codigo = ((Lotacao)value).getCodigo();
   	  String busca = (codigo == null ? null : codigo.toString());
   	  return busca;
     }
		return "";
	}
}
