package springavanzado.ejercicio1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import springavanzado.ejercicio1.form.PersonaForm;
import springavanzado.ejercicio1.service.PersonaService;
import springavanzado.ejercicio1.validator.PersonaFormValidator;
import springavanzado.model.Persona;

@Controller
@RequestMapping("/persona/*")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@InitBinder // Configuraciones del controller
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new PersonaFormValidator());
	}
	
	@ModelAttribute("personaForm")
	public PersonaForm personaForm() {
		return new PersonaForm();
	}
	
	@RequestMapping({"", "index"})
	public String index(Model model) {
		inicializar(model);
		return "/WEB-INF/jsp/persona/index.jsp";
	}
	
	private void inicializar(Model model) {
		model.addAttribute("personas", personaService.obtenerPersonas());
	}

	@RequestMapping("agregar")
	public String agregar(Model model, 
			@Valid @ModelAttribute("personaForm") PersonaForm personaForm,
			BindingResult result) {
		
		if (!result.hasErrors()) {
			Persona p = new Persona();
			p.setNombre(personaForm.getNombre());
			p.setApellido(personaForm.getNombre());
			Date fecha;
			try {
				fecha = new SimpleDateFormat("yyyy-MM-dd")
					.parse(personaForm.getFechaNacimiento());
				p.setFechanacimiento(fecha);
			} catch (ParseException e1) { }
			
			try {
				personaService.agregarPersona(p);
			} catch (Exception e) {
				e.printStackTrace();
				result.reject("bd", "Error al insertar en BD");
			}
		} 
		
		if (result.hasErrors()) {
			inicializar(model);
			return "/WEB-INF/jsp/persona/index.jsp";
		} else {
			return "redirect:/persona/index.do"; // Ver Post-Redirect-Get
		}
	}
	
	@RequestMapping("eliminar")
	public String eliminar(@RequestParam Integer id) {
		try {
			personaService.eliminarPersona(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/persona/index.do";
	}
	
}







