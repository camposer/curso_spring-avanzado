package springavanzado.basicoant.service;

import springavanzado.basicoant.to.Envoltorio;

public class HolaMundoImpl implements HolaMundo {
	private Envoltorio envoltorio;
	
	public Envoltorio saludar(String nombre) {
		envoltorio.setNombre("Hola " + nombre);
		return envoltorio;
	}

	public Envoltorio getEnvoltorio() {
		return envoltorio;
	}

	public void setEnvoltorio(Envoltorio envoltorio) {
		this.envoltorio = envoltorio;
	}
}
