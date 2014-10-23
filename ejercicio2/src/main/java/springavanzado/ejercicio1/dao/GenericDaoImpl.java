package springavanzado.ejercicio1.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import springavanzado.ejercicio1.annotation.CustomLog;

public class GenericDaoImpl<T, K> implements GenericDao<T, K> {
	@Autowired
	@PersistenceContext
	protected EntityManager em;
	protected Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void agregar(T obj) {
		em.persist(obj);
	}

	public void modificar(T obj) {
		em.merge(obj);
	}

	public void eliminar(K id) {
		Query q = em.createQuery("DELETE FROM " + clazz.getSimpleName() + " t WHERE t.id = :id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@CustomLog
	public List<T> obtenerTodos() {
		return em.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t")
				.getResultList();
	}

	@CustomLog
	public T obtener(K id) {
		return em.find(clazz, id);
	}

}
