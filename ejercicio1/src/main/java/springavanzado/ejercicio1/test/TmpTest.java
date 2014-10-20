package springavanzado.ejercicio1.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springavanzado.ejercicio1.service.PersonaService;
import springavanzado.model.Persona;

public class TmpTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonaService personaService = ctx.getBean(PersonaService.class);
	
		// Obtener todos
		for (Persona p : personaService.obtenerPersonas())
			System.out.println(p);
		
		// Agregar
		Persona persona = new Persona();
		persona.setNombre("Félix");
		persona.setApellido("Otro");
		persona.setFechanacimiento(new Date());
		
		personaService.agregarPersona(persona);

		// Obtener todos
		System.out.println();
		for (Persona p : personaService.obtenerPersonas())
			System.out.println(p);
	}
	
}
