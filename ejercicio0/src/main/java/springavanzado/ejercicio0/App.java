package springavanzado.ejercicio0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springavanzado.ejercicio0.gui.CalculadoraGui;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.getBean("calculadoraGui", CalculadoraGui.class).iniciar();
		
	}
}
