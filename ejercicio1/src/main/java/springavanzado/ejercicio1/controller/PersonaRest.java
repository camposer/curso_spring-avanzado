package springavanzado.ejercicio1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springavanzado.ejercicio1.service.PersonaService;
import springavanzado.model.Persona;

@Controller
@RequestMapping("/v1/personas")
public class PersonaRest {
	@Autowired
	private PersonaService personaService;
	
	private Persona dettachPersona(Persona p) {
		Persona result = new Persona();
		result.setId(p.getId());
		result.setNombre(p.getNombre());
		result.setApellido(p.getApellido());
		result.setFechanacimiento(p.getFechanacimiento());
		
		return result;
	}
	
	@RequestMapping(
			value="",
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody List<Persona> personas() {
		List<Persona> result = new ArrayList<Persona>();
		List<Persona> personas = personaService.obtenerPersonas();
		
		for (Persona p : personas)
			result.add(dettachPersona(p)); // Para evitar referencias circulares
		
		return result;
	}
	
	
}
