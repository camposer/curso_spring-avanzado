package springavanzado.ejercicio1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springavanzado.ejercicio1.service.OrdenadorService;
import springavanzado.model.Ordenador;

@Controller
@RequestMapping("/api/ordenadores")
public class OrdenadorRest {
	@Autowired
	private OrdenadorService ordenadorService;
	
	/**
	 * GET /api/ordenadores.do
	 * HEADER = Accept: application-json
	 * RETURN = JSON
	 */
	@RequestMapping(
			value="",
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody List<Ordenador> obtenerOrdenadores() {
		return ordenadorService.obtenerOrdenadores();
	}
	
	/**
	 * GET /api/ordenadores/{id}.do
	 * HEADER = Accept: application-json
	 * RETURN = JSON
	 */
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody Ordenador obetenerOrdenador(
				@PathVariable("id") Integer id
			) {
		return ordenadorService.obtenerOrdenador(id);
	}
	
	/**
	 * DELETE /api/ordenadores/{id}
	 */
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.DELETE
		)
	public @ResponseBody String eliminarOrdenador(
				@PathVariable("id") Integer id
			) {
		ordenadorService.eliminarOrdenador(id);
		return "";
	}
	
	/**
	 * POST /v1/ordenadores.do
	 * HEADER = Content-type: application-json
	 * BODY = JSON
	 * Ejemplo:
	 * {
	 * 	"nombre": "Ord",
	 *	"serial": "1234",
	 *	"persona": { "id": 1 }
	 * } 
	 */
	@RequestMapping(
			value="",
			method=RequestMethod.POST,
			consumes="application/json"
		)
	public @ResponseBody String agregarOrdenador(
				@RequestBody Ordenador o
			) {
		ordenadorService.agregarOrdenador(o);
		
		return "";
	}
	
	/**
	 * PUT /v1/ordenadores/{id}.do
	 * HEADER = Content-type: application-json
	 * BODY = JSON
	 */
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.PUT,
			consumes="application/json"
		)
	public @ResponseBody String modificarOrdenador(
				@RequestBody Ordenador o,
				@PathVariable("id") Integer id
			) {
		o.setId(id);
		ordenadorService.modificarOrdenador(o);
		return "";
	}
	
}
