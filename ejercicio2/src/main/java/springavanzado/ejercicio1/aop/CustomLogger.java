package springavanzado.ejercicio1.aop;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import springavanzado.ejercicio1.util.LoggerUtil;

public class CustomLogger implements MethodInterceptor {
	private String rutaArchivo;

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String linea = "Método: " + methodInvocation.getMethod().getName();
		String argumentos = "";
		for (Object a : methodInvocation.getArguments())
			argumentos += a + " ";
		
		linea += ", Argumentos: " + argumentos;
		linea += ", Hora: " + new Date().toString();

		LoggerUtil.escribirLinea(rutaArchivo, linea);
		
		return methodInvocation.proceed();
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
}