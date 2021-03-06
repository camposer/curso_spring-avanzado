package springavanzado.ejercicio0.service;

import org.springframework.stereotype.Service;

@Service // id = calculadoraServiceImpl
public class CalculadoraServiceImpl implements CalculadoraService {

	public float sumar(float a, float b) {
		return a + b;
	}

	public float restar(float a, float b) {
		return a - b;
	}

	public float multiplicar(float a, float b) {
		return a * b;
	}

	public float dividir(float a, float b) {
		return a / b;
	}

}
