package springavanzado.basico;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
