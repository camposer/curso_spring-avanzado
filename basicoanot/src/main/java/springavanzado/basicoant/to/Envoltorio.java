package springavanzado.basico;

public class Envoltorio {
	private String nombre;

	public Envoltorio(String nombre) {
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
