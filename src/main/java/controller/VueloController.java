package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import service.VueloService;

@RestController
public class VueloController {

	@Autowired
	VueloService service;

	@GetMapping(value = "Vuelo/{idvuelo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo buscarVuelo(@PathVariable("idvuelo") int idvuelo) {
		return service.buscarVuelo(idvuelo);
	}

	@GetMapping(value = "Vuelos/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelos(@PathVariable("plazas") int plazas) {
		return service.vuelosDisponibles(plazas);
	}

	@PutMapping(value = "Vuelo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String actualizar(@RequestParam("idvuelo") int idvuelo, @RequestParam("plazas") int plazas) {
		return String.valueOf(service.actualizarVuelo(idvuelo, plazas));
	}
}
