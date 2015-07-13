package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ReservacionesResponse;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.helpers.ReservacionesHelper;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.services.ReservacionesServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 01 Descripción:Esta clase es la que contendrá cada uno de los servicios que
 *serán necesarios para procesar la información de reservaciones de la aplicación
 */

@RestController
@RequestMapping(value = "rest/reservaciones")

public class ReservacionController {
	
	@Autowired
	ReservacionesServiceInterface reservacionesServices;

	/**
	 *Este método obtiene cada una de las instancias de reservaciones
	 *registradas en la base de datos
	 */	
	@RequestMapping(value="getAll", method = RequestMethod.GET)
	public ReservacionesResponse getAll(){
		
		ReservacionesResponse reservacionesResponse = new ReservacionesResponse();
		
		List<Reservaciones> reservacionesList = reservacionesServices.getAllReservaciones();
		List<ReservacionesPOJO> reservacionesViewList = new ArrayList<ReservacionesPOJO>();
		
		for(Reservaciones reservaciones : reservacionesList){
			ReservacionesPOJO reservacionesView = new ReservacionesPOJO();
			PojoUtils.pojoMappingUtility(reservacionesView, reservaciones);
			reservacionesViewList.add(reservacionesView);
		}
		
		reservacionesResponse.setReservacion(reservacionesViewList);
		reservacionesResponse.setJSONCalendar(ReservacionesHelper.getInstance().calendarioSerializer(reservacionesViewList));
		
		return reservacionesResponse;		
		
	}

}
