package service;

import java.util.List;

import model.Vuelo;

public interface VueloService {

	/**
	 * Metodo qu devuelve un vuelo segun su ID
	 * 
	 * @param idVuelo: identificador del vuelo
	 * @return el vuelo segun su ID
	 */
	Vuelo buscarVuelo(int idVuelo);
	
	/**
	 * Metodo que devuele la lista de vuelos disponibles
	 * 
	 * @param plazas: total de plazas que se pretenden reservar
	 * @return la lista de vuelos disponibles
	 */
	List<Vuelo> vuelosDisponibles(int plazas);
	
	/**
	 * Metodo que actualiza los datos de un vuelo 
	 * 
	 * @param idvuelo: identificador del vuelo a actualizar
	 * @param plazas: numero de plazas reservadas
	 * @return true si se ha actualizado el vuelo correctamente; false en caso contrario
	 */
	boolean actualizarVuelo(int idvuelo, int plazas);
}
