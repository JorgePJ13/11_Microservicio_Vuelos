package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VueloServiceImpl implements VueloService {

	VuelosDao dao;

	public VueloServiceImpl(@Autowired VuelosDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Vuelo buscarVuelo(int idVuelo) {
		return dao.findById(idVuelo).orElse(null);
	}

	@Override
	public List<Vuelo> vuelosDisponibles(int plazas) {
		return dao.findAll().stream().filter(v -> (v.getPlazas() >= plazas))
				.collect(Collectors.toList());
	}

	@Override
	public boolean actualizarVuelo(int idvuelo, int plazas) {
		Vuelo v = buscarVuelo(idvuelo);
		if (v != null && v.getPlazas() >= plazas) {
			v.setPlazas(v.getPlazas() - plazas);
			dao.save(v);
			return true;
		}
		return false;
	}

}
