package br.com.agespisa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import br.com.agespisa.DAO.CargoDAO;
import br.com.agespisa.entidade.Cargo;

@FacesConverter("converterCargo")
public class ConverterCargo implements Converter {
	private CargoDAO cargoDAO = new CargoDAO();
	private Cargo cargo = null;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (StringUtils.isNotBlank(value)) {
			this.cargo = cargoDAO.buscar(new Long(value));
		}
		return cargo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Cargo) value).getCodigo();
			String busca = (codigo == null ? null : codigo.toString());
            return busca;
		}
		return "";
	}

}
