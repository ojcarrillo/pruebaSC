package co.com.datatools.data;

import java.util.List;

public class ObjPrueba {

	private String tipoIidentificacion;
	private String numeroIdentificacion;

	List<Direcion> direccion;

	public String getTipoIidentificacion() {
		return tipoIidentificacion;
	}

	public void setTipoIidentificacion(String tipoIidentificacion) {
		this.tipoIidentificacion = tipoIidentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public List<Direcion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direcion> direccion) {
		this.direccion = direccion;
	}

}
