package springavanzado.ejercicio1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springavanzado.ejercicio1.service.PersonaService;
import springavanzado.model.Persona;

/**
 * Podríamos cambiar los tipos de retorno para envolver en 
 * un objeto de respuesta con el estatus, por ejemplo:
 * {
 * 	status: "success",
 * 	data: [...]
 * 	error: "..."
 * } 
 */
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
	
	/**
	 * GET /api/v1/personas
	 * HEADER = Accept: application-json
	 * RETURN = JSON
	 */
	@RequestMapping(
			value="",
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody List<Persona> obtenerPersonas() {
		List<Persona> result = new ArrayList<Persona>();
		List<Persona> personas = personaService.obtenerPersonas();
		
		for (Persona p : personas)
			result.add(dettachPersona(p)); // Para evitar referencias circulares
		
		return result;
	}
	
	/**
	 * GET /api/v1/personas/{id}
	 * HEADER = Accept: application-json
	 * RETURN = JSON
	 */
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody Persona obetenerPersona(
				@PathVariable("id") Integer id
			) {
		Persona p = personaService.obtenerPersona(id);
		return dettachPersona(p);
	}
	
	/**
	 * DELETE /api/v1/personas/{id}
	 */
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.DELETE
		)
	public @ResponseBody String eliminarPersona(
				@PathVariable("id") Integer id
			) {
		personaService.eliminarPersona(id);
		return "";
	}
	
	/**
	 * POST /v1/personas.do
	 * HEADER = Content-type: application-json
	 * BODY = JSON
	 * Ejemplo:
	 * {
	 * 	"nombre": "Nuevo",
	 * 	"apellido": "Nuevo",
	 * 	"fechanacimiento": "2012-01-01"
	 * } 
	 */
	@RequestMapping(
			value="",
			method=RequestMethod.POST,
			consumes="application/json"
		)
	public @ResponseBody String agregarPersona(
				@RequestBody Persona p
			) {
		personaService.agregarPersona(p);
		
		return "";
	}
	
	/**
	 * PUT /v1/personas/{id}.do
	 * HEADER = Content-type: application-json
	 * BODY = JSON
	 */
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.PUT,
			consumes="application/json"
		)
	public @ResponseBody String modificarPersona(
				@RequestBody Persona p,
				@PathVariable("id") Integer id
			) {
		p.setId(id);
		personaService.modificarPersona(p);
		return "";
	}
}
