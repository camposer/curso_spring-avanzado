package springavanzado.basico;

public class HelloWorldImpl implements HolaMundo {
	private Envoltorio envoltorio;
	
	public Envoltorio saludar(String nombre) {
		envoltorio.setNombre("Hello " + nombre);
		return envoltorio;
	}

	public Envoltorio getEnvoltorio() {
		return envoltorio;
	}

	public void setEnvoltorio(Envoltorio envoltorio) {
		this.envoltorio = envoltorio;
	}
}
