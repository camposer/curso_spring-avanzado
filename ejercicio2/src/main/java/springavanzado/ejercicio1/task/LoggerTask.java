package springavanzado.ejercicio1.task;

import java.io.IOException;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import springavanzado.ejercicio1.util.LoggerUtil;

public class LoggerTask {
	private String rutaArchivo;

	@Scheduled(cron="*/60 * * * * MON-SUN")
	@Async
	public void holaMundo() {
		String linea = "HolaMundo " + new Date().toString();
		try {
			LoggerUtil.escribirLinea(rutaArchivo, linea);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
}
