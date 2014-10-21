package springavanzado.ejercicio1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springavanzado.ejercicio1.to.Persona;

@Controller
public class HolaMundoController {
	// http://localhost:8080/ejercicio1/holaMundo.do
	@RequestMapping("/holaMundo")
	public @ResponseBody String holaMundo() {
		String html = "<html>"
				+ "<head><title>Hola mundo!</title>"
				+ "<body>Hola mundo!</body>"
				+ "</html>";
		
		return html;
	}
	
	@RequestMapping("/holaMundo1")
	public String holaMundo1() {
		return "forward:/WEB-INF/jsp/holaMundo.jsp";
		//return "/WEB-INF/jsp/holaMundo.jsp";
	}

	// Este método es equivalente a holaMundo1
	@RequestMapping("/holaMundo2")
	public void holaMundo2(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsp/holaMundo.jsp")
			.forward(request, response);
	}

	@RequestMapping("/holaMundo3")
	public String holaMundo3() {
		return "redirect:/holaMundo2.do";
	}


	// Este método es equivalente a holaMundo3
	@RequestMapping("/holaMundo4")
	public void holaMundo4(
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getServletContext().getContextPath() + 
				"/holaMundo2.do");
	}
	
	// Equivalentes: holaMundo5, holaMundo6 y holaMundo7
	@RequestMapping("/holaMundo5")
	public String holaMundo5(HttpServletRequest request) throws IOException {
		
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		return "forward:/WEB-INF/jsp/holaMundo.jsp";
	}
	
	// Equivalentes: holaMundo5, holaMundo6 y holaMundo7
	@RequestMapping("/holaMundo6")
	public ModelAndView holaMundo6(@RequestParam("nombre") String nom)  {
		return new ModelAndView("/WEB-INF/jsp/holaMundo.jsp", "nombre", nom);
	}
	
	// Equivalentes: holaMundo5, holaMundo6 y holaMundo7
	@RequestMapping("/holaMundo7")
	public String holaMundo7(
			@RequestParam String nombre,
			Model model) {
		
		model.addAttribute("nombre", nombre); // request.setAttribute
		return "/WEB-INF/jsp/holaMundo.jsp";
	}

	@RequestMapping("/holaMundo8")
	public String holaMundo8(
			Persona persona,
			Model model) {
		
		model.addAttribute("nombre", persona.getNombre()); // request.setAttribute
		System.out.println("apellido: " + persona.getApellido());
		return "/WEB-INF/jsp/holaMundo.jsp";
	}
	
	
}


