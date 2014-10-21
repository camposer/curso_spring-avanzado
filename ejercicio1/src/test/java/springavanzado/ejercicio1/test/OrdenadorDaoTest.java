package springavanzado.ejercicio1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import springavanzado.ejercicio1.dao.OrdenadorDao;
import springavanzado.ejercicio1.dao.PersonaDao;
import springavanzado.model.Ordenador;
import springavanzado.model.Persona;

@RunWith(SpringJUnit4ClassRunner.class) // Configura Spring para hacer la prueba
//@ContextConfiguration(locations="classpath:applicationContext.xml") // Define fichero de configuración de Spring
@ContextConfiguration(locations="classpath:applicationContext-test.xml") 
@Transactional // Porque estoy probando un DAO, si fuese el servicio no es necesario
public class OrdenadorDaoTest {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private OrdenadorDao ordenadorDao;
	@Autowired
	private PersonaDao personaDao;

	@Test
	public void agregar() {
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(new Date());
		personaDao.agregar(p); // Añadiendo la persona
		
		int numOrdenadores = ordenadorDao.obtenerTodos().size();
		
		Ordenador o = new Ordenador();
		o.setNombre("Nombre ordenador");
		o.setSerial("Serial ordenador");
		o.setPersona(p);
		ordenadorDao.agregar(o);
		
		int numOrdenadoresNuevo = ordenadorDao.obtenerTodos().size();
		
		assertTrue(numOrdenadores < numOrdenadoresNuevo);
		assertNotNull(o.getId());
	}

	@Test
	public void modificar() {
		Persona p1 = new Persona();
		p1.setNombre("Nombre prueba");
		p1.setApellido("Apellido prueba");
		p1.setFechanacimiento(new Date());
		personaDao.agregar(p1); // Añadiendo la persona
		
		Persona p2 = new Persona();
		p2.setNombre("Nombre prueba");
		p2.setApellido("Apellido prueba");
		p2.setFechanacimiento(new Date());
		personaDao.agregar(p2); // Añadiendo la persona

		Ordenador o = new Ordenador();
		o.setNombre("Nombre ordenador");
		o.setSerial("Serial ordenador");
		o.setPersona(p1);
		ordenadorDao.agregar(o); // Añadiendo ordenador
		
		// Modificando datos de la persona
		o.setNombre(p1.getNombre() + " mod");
		o.setSerial(p1.getApellido() + " mod");
		o.setPersona(p2);
		
		personaDao.modificar(p1); // Modificando la persona
		
		entityManager.flush(); // Obligando a persistir los datos
		
		// Obteniendo el registro recién modificado
		Ordenador oMod = ordenadorDao.obtener(o.getId());

		assertEquals(o.getId(), oMod.getId());
		assertEquals(o.getNombre(), oMod.getNombre());
		assertEquals(o.getSerial(), oMod.getSerial());
		assertEquals(o.getPersona().getId(), oMod.getPersona().getId());
		
	}
	
	@Test
	public void eliminar() {
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(new Date());
		personaDao.agregar(p); // Añadiendo la persona
		
		int numOrdenadores = ordenadorDao.obtenerTodos().size();
		
		Ordenador o = new Ordenador();
		o.setNombre("Nombre ordenador");
		o.setSerial("Serial ordenador");
		o.setPersona(p);
		ordenadorDao.agregar(o);

		int numOrdenadoresNuevo = ordenadorDao.obtenerTodos().size();

		assertTrue(numOrdenadores < numOrdenadoresNuevo);
		
		ordenadorDao.eliminar(o.getId());
		
		numOrdenadoresNuevo = ordenadorDao.obtenerTodos().size();
		
		assertEquals(numOrdenadores, numOrdenadoresNuevo);
	}
	
	@Test
	public void obtenerTodos() {
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(new Date());
		personaDao.agregar(p); // Añadiendo la persona
		
		Ordenador o = new Ordenador();
		o.setNombre("Nombre ordenador");
		o.setSerial("Serial ordenador");
		o.setPersona(p);
		ordenadorDao.agregar(o);

		int numOrdenadoresNuevo = ordenadorDao.obtenerTodos().size();
		assertTrue(numOrdenadoresNuevo > 0);
	}

	@Test
	public void obtener() {
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(new Date());
		personaDao.agregar(p); // Añadiendo la persona
		
		Ordenador o = new Ordenador();
		o.setNombre("Nombre ordenador");
		o.setSerial("Serial ordenador");
		o.setPersona(p);
		ordenadorDao.agregar(o);

		assertNotNull(ordenadorDao.obtener(o.getId()));
	}
}









