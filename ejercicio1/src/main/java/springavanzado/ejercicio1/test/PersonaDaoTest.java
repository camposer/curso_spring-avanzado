package springavanzado.ejercicio1.test;

import java.util.Date;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import springavanzado.ejercicio1.dao.PersonaDao;
import springavanzado.model.Persona;

@RunWith(SpringJUnit4ClassRunner.class) // Configura Spring para hacer la prueba
@ContextConfiguration(locations="classpath:applicationContext-test.xml") // Define fichero de configuración de Spring
@Transactional // Porque estoy probando un DAO, si fuese el servicio no es necesario
public class PersonaDaoTest {
	@Autowired
	private PersonaDao personaDao;
	
	@Test
	public void agregar() {
		Date fecha = new Date();
		Persona p = new Persona();
		p.setNombre("Nombre prueba");
		p.setApellido("Apellido prueba");
		p.setFechanacimiento(fecha);
		
		int numPersonas = personaDao.obtenerTodos().size();
		
		personaDao.agregar(p); // Añadiendo la persona
		
		int numPersonasNuevo = personaDao.obtenerTodos().size();
		
		assertTrue(numPersonas < numPersonasNuevo);
		assertNotNull(p.getId());
	}
	
	
}
