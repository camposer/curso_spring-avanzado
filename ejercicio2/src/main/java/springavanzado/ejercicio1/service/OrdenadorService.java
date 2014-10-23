package springavanzado.ejercicio1.service;

import java.util.List;

import springavanzado.model.Ordenador;

public interface OrdenadorService {
	public void agregarOrdenador(Ordenador p);
	public void modificarOrdenador(Ordenador p);
	public void eliminarOrdenador(Integer id);
	public List<Ordenador> obtenerOrdenadores();
	public Ordenador obtenerOrdenador(Integer id);
}
