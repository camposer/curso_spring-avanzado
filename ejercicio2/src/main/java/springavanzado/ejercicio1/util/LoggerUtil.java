package springavanzado.ejercicio1.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerUtil {
	public static void escribirLinea(String rutaArchivo, String linea) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo, true));
		pw.println(linea);
		pw.flush();
		pw.close();
	}
}
