package springavanzado.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springavanzado.ejercicio1.dao.OrdenadorDao;
import springavanzado.ejercicio1.dao.PersonaDao;
import springavanzado.model.Persona;

@Component
@Transactional
public class PersonaServiceImpl implements PersonaService {
	@Autowired
	private PersonaDao personaDao;
	@Autowired
	private OrdenadorDao ordenadorDao;

	public void agregarPersona(Persona p) {
			personaDao.agregar(p);
	}

	public void modificarPersona(Persona p) {
		personaDao.modificar(p);
	}

	public void eliminarPersona(Integer id) {
		ordenadorDao.eliminarPorPersonaId(id);
		personaDao.eliminar(id);
	}

	public List<Persona> obtenerPersonas() {
		return personaDao.obtenerTodos();
	}

	public Persona obtener(Integer id) {
		return personaDao.obtener(id);
	}
	

}
