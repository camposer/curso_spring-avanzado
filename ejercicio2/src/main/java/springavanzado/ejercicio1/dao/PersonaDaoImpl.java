package springavanzado.ejercicio1.dao;

import org.springframework.stereotype.Component;

import springavanzado.model.Persona;

@Component
public class PersonaDaoImpl 
		extends GenericDaoImpl<Persona, Integer>
		implements PersonaDao {

}
