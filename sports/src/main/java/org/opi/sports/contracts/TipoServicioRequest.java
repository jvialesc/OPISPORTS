package org.opi.sports.contracts;

import org.opi.sports.pojo.TipoServicioPOJO;

/**
 * Fecha: 20-07-2015 version 1.0
 *
 * @author Luis ESteban López Ramírez
 *
 *Sprint #4 Se encarga de realizar los request de los tipos de servicios, desde
 *el fornt end.
 */
public class TipoServicioRequest extends BasePagingRequest{

	private String tipoServicio;
	private String accion;
	private Integer idTipoServicio;

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	public String toString(){
		return "TipoServiceRequest [tipoServicio=" + tipoServicio  + "]";
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Integer getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(Integer idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}
}
