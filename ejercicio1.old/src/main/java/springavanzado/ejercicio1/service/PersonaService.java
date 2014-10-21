package springavanzado.ejercicio1.service;

import java.util.List;

import springavanzado.model.Persona;

public interface PersonaService {
	public void agregarPersona(Persona p);
	public void modificarPersona(Persona p);
	public void eliminarPersona(Integer id);
	public List<Persona> obtenerPersonas();
	public Persona obtener(Integer id);
}
