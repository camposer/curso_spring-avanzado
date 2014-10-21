package springavanzado.ejercicio1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
