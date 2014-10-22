package springavanzado.ejercicio1.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springavanzado.ejercicio1.form.PersonaForm;

public class PersonaFormValidator implements Validator {

	/**
	 * Valida que el form guarda correspondencia con el validador
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return PersonaForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errores) {
		PersonaForm personaForm = (PersonaForm)obj;
		
		if (personaForm.getNombre() == null || 
				personaForm.getNombre().trim().equals(""))
			errores.reject("nombre", "Nombre inválido");

		if (personaForm.getApellido() == null || 
				personaForm.getApellido().trim().equals(""))
			errores.reject("apellido", "Apellido inválido");
		
		if (personaForm.getFechaNacimiento() == null)
			errores.reject("fechaNacimiento", "Fecha inválida");
	}

}
