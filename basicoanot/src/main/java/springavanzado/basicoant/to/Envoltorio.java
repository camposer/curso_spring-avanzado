package springavanzado.basicoant.to;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Envoltorio {
	private String nombre;

	@Autowired
	public Envoltorio(@Value("Juan") String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Envoltorio [nombre=" + nombre + "]";
	}
}
