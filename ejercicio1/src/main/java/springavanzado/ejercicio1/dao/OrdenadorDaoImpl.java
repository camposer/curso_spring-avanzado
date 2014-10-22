package springavanzado.ejercicio1.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import springavanzado.model.Ordenador;

@Component
public class OrdenadorDaoImpl 
		extends GenericDaoImpl<Ordenador, Integer>
		implements OrdenadorDao {

	@Override
	public void eliminarPorPersonaId(Integer personaId) {
		Query q = em.createQuery("DELETE FROM Ordenador o WHERE "
				+ "o.persona.id = :personaId");
		q.setParameter("personaId", personaId);
		q.executeUpdate();
	}

}
