package springavanzado.ejercicio1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springavanzado.ejercicio1.form.OrdenadorForm;
import springavanzado.ejercicio1.service.OrdenadorService;
import springavanzado.ejercicio1.service.PersonaService;
import springavanzado.ejercicio1.validator.OrdenadorFormValidator;
import springavanzado.model.Ordenador;
import springavanzado.model.Persona;

@Controller
@RequestMapping("/ordenador/*")
public class OrdenadorController {
	@Autowired
	private OrdenadorService ordenadorService;
	@Autowired
	private PersonaService personaService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new OrdenadorFormValidator());
	}
	
	@ModelAttribute("ordenadorForm")
	public OrdenadorForm ordenadorForm() {
		return new OrdenadorForm();
	}
	
	private void inicializar(Model model) {
		try {
			model.addAttribute("personas", 
					personaService.obtenerPersonas());
			model.addAttribute("ordenadores", 
					ordenadorService.obtenerOrdenadores());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"index", ""})
	public String index(Model model) {
		inicializar(model);
		return "/WEB-INF/jsp/ordenador/index.jsp";
	}

	@RequestMapping("guardar")
	public String guardar(Model model, 
			@RequestParam(required=false) String btnModificar,
			@Valid @ModelAttribute("ordenadorForm") OrdenadorForm ordenadorForm,
			BindingResult result) {
		
		if (!result.hasErrors()) {
			Persona p = new Persona();
			p.setId(ordenadorForm.getPersonaId());
			
			Ordenador o = new Ordenador();
			o.setNombre(ordenadorForm.getNombre());
			o.setSerial(ordenadorForm.getSerial());
			o.setPersona(p);
			
			try {
				if (btnModificar != null && !btnModificar.equals("")) {
					o.setId(ordenadorForm.getId());
					ordenadorService.modificarOrdenador(o);
				} else { // Agregando
					ordenadorService.agregarOrdenador(o);
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.reject("bd", "Error al guardar en BD");
			}
		} 
		
		if (result.hasErrors()) {
			inicializar(model);
			return "/WEB-INF/jsp/ordenador/index.jsp";
		} else {
			return "redirect:/ordenador/index.do"; 
		}
	}
	
	@RequestMapping("eliminar")
	public String eliminar(Model model, @RequestParam Integer id) {
		try {
			ordenadorService.eliminarOrdenador(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		inicializar(model);
		return "/WEB-INF/jsp/ordenador/index.jsp";
	}
	
	@RequestMapping("mostrar")
	public String mostrar(Model model, @RequestParam Integer id) {
		OrdenadorForm ordenadorForm = new OrdenadorForm();
		try {
			Ordenador o = ordenadorService.obtenerOrdenador(id);
			
			ordenadorForm.setId(o.getId());
			ordenadorForm.setNombre(o.getNombre());
			ordenadorForm.setSerial(o.getSerial());
			ordenadorForm.setPersonaId(o.getPersona().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("ordenadorForm", ordenadorForm);
		inicializar(model);
		return "/WEB-INF/jsp/ordenador/index.jsp";
	}
	
}
