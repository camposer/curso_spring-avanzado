package springavanzado.basicoant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import springavanzado.basicoant.service.HelloWorldImpl;
import springavanzado.basicoant.service.HolaMundo;
import springavanzado.basicoant.service.HolaMundoImpl;
import springavanzado.basicoant.to.Envoltorio;

@Configuration
public class Config {

	@Bean(name="envoltorio")
	@Scope("singleton")
	public Envoltorio getEnvoltorio() {
		return new Envoltorio("Juan");
	}
	
	@Bean
	public HolaMundo holaMundo() { // id por defecto holaMundo
		return new HelloWorldImpl();
	}

	
	/*
	@Bean
	public HolaMundo holaMundo() {
		HolaMundoImpl holaMundo = new HolaMundoImpl();
		holaMundo.setEnvoltorio(getEnvoltorio());
		
		return holaMundo;
	}
	*/
}
