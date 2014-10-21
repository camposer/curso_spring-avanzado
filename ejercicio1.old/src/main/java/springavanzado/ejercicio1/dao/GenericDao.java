package springavanzado.ejercicio1.dao;

import java.util.List;

public interface GenericDao<T, K> {
	public void agregar(T obj);
	public void modificar(T obj);
	public void eliminar(K id);
	public List<T> obtenerTodos();
	public T obtener(K id);
}
