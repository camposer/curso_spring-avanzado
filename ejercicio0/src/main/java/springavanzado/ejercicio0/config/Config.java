package springavanzado.ejercicio0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springavanzado.ejercicio0.gui.CalculadoraGui;

@Configuration
public class Config {
	@Bean(name="calculadoraGui")
	public CalculadoraGui getCalculadoraGui() {
		return new CalculadoraGui();
	}
}
