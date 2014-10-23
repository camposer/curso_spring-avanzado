package springavanzado.ejercicio1.aop;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CustomLogger implements MethodInterceptor {
	private String rutaArchivo;

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo, true));
		
		String linea = "Método: " + methodInvocation.getMethod().getName();
		String argumentos = "";
		for (Object a : methodInvocation.getArguments())
			argumentos += a + " ";
		
		linea += ", Argumentos: " + argumentos;
		linea += ", Hora: " + new Date().toString();
		
		pw.println(linea);
		pw.flush();
		pw.close();
		
		return methodInvocation.proceed();
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
}