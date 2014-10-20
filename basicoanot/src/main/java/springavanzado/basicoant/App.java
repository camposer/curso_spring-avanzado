package springavanzado.basicoant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springavanzado.basicoant.service.HolaMundo;
import springavanzado.basicoant.service.HolaMundoFactory;


public class App 
{
    public static void main( String[] args )
    {
//    	utilizandoFactorias();
    	utilizandoSpring();
    }

	private static void utilizandoSpring() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HolaMundo hm = ctx.getBean("holaMundo", HolaMundo.class);
		System.out.println(hm.saludar("Juan"));
		
	}

	private static void utilizandoFactorias() {
    	HolaMundo hm = HolaMundoFactory.createHolaMundo();
    	System.out.println(hm.saludar("Juan"));
	}
}
