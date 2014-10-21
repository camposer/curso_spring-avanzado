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

import springavanzado.ejercicio1.dao.PersonaDao;
import springavanzado.model.Persona;

@RunWith(SpringJUnit4ClassRunner.class) // Configura Spring para hacer la prueba
//@ContextConfiguration(locations="classpath:applicationContext.xml") // Define fichero de configuración de Spring
@ContextConfiguration(locations="classpath:applicationContext-test.xml") 
@Transactional // Porque estoy probando un DAO, si fuese el servicio no es necesario
public class PersonaDaoTest {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private PersonaDao personaDao;

	@Test
	public void agregar() {
		Date fecha = new Date();
		String nombre = "Nombre prueba";
		String apellido = "Apellido prueba";
		
		Persona p = new Persona();
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setFechanacimiento(fecha);
		
		int numPersonas = personaDao.obtenerTodos().size();
		
		personaDao.agregar(p); // Añadiendo la persona
		
		int numPersonasNuevo = personaDao.obtenerTodos().size();
		
		// TODO Validar que todos los campos fueron insertados correctamente
		assertTrue(numPersonas < numPersonasNuevo);
		assertNotNull(p.getId());
	}
	
	@Test
	public void modificar() {
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(new Date());
		
		personaDao.agregar(p); // Añadiendo la persona
		
		// Modificando datos de la persona
		p.setNombre(p.getNombre() + " mod");
		p.setApellido(p.getApellido() + " mod");
		p.setFechanacimiento(new Date());
		
		personaDao.modificar(p); // Modificando la persona
		
		entityManager.flush(); // Obligando a persistir los datos
		
		// Obteniendo el registro recién modificado
		Persona pMod = personaDao.obtener(p.getId());

		assertEquals(p.getId(), pMod.getId());
		assertEquals(p.getNombre(), pMod.getNombre());
		assertEquals(p.getApellido(), pMod.getApellido());
		assertEquals(p.getFechanacimiento(), pMod.getFechanacimiento());
		
	}
	
	@Test
	public void eliminar() {
		int numPersonas = personaDao.obtenerTodos().size();
		
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(new Date());
		
		personaDao.agregar(p); // Añadiendo la persona
		int numPersonasNuevo = personaDao.obtenerTodos().size();
		
		assertTrue(numPersonas < numPersonasNuevo);
		
		personaDao.eliminar(p.getId());
		numPersonasNuevo = personaDao.obtenerTodos().size();
		
		assertEquals(numPersonas, numPersonasNuevo);
		
	}
	
	@Test
	public void obtenerTodos() {
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(new Date());
		
		personaDao.agregar(p); // Añadiendo la persona

		int numPersonasNuevo = personaDao.obtenerTodos().size();
		assertTrue(numPersonasNuevo > 0);
	}

	@Test
	public void obtener() {
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(new Date());
		
		personaDao.agregar(p); // Añadiendo la persona

		assertNotNull(personaDao.obtener(p.getId()));
		
	}
}









