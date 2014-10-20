package springavanzado.basicoant.service;

public abstract class HolaMundoFactory {
	public static HolaMundo createHolaMundo() {
		return new HelloWorldImpl();
	}
}
