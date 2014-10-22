package springavanzado.ejercicio1.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springavanzado.ejercicio1.form.OrdenadorForm;

public class OrdenadorFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrdenadorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errores) {
		OrdenadorForm ordenadorForm =
				(OrdenadorForm)obj;
		
		if (ordenadorForm.getNombre() == null || 
				ordenadorForm.getNombre().trim().equals(""))
			errores.reject("nombre", "Nombre inválido");

		if (ordenadorForm.getSerial() == null || 
				ordenadorForm.getSerial().trim().equals(""))
			errores.reject("serial", "Serial inválido");
		
		if (ordenadorForm.getPersonaId() == null) 
			errores.reject("personaId", "Id de persona inválido");
	}

}
