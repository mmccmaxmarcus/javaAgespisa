package br.com.agespisa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import br.com.agespisa.DAO.FabricanteDAO;
import br.com.agespisa.entidade.Fabricante;


@FacesConverter("ConverterFabricante")
public class ConverterFabricante implements Converter {
  
	private FabricanteDAO fabricanteDAO = new FabricanteDAO();
     private Fabricante fabricante = null;

	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if(StringUtils.isNotBlank(value)) {
        	 this.fabricante = this.fabricanteDAO.buscar(new Long(value)); 
         }
		return fabricante;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
      if(value != null) {
    	  Long codigo = ((Fabricante)value).getCodigo();
    	  String busca = (codigo == null ? null : codigo.toString());
    	  return busca;
      }
		return "";
	}

}
