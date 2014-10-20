package springavanzado.basicoant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import springavanzado.basicoant.to.Envoltorio;

@Service(value="holaMundo") // id por defecto helloWorldImpl
@Scope("singleton")
public class HelloWorldImpl implements HolaMundo {
	@Autowired
	private Envoltorio envoltorio;
	
	public Envoltorio saludar(String nombre) {
		envoltorio.setNombre("Hello " + nombre);
		return envoltorio;
	}

}
