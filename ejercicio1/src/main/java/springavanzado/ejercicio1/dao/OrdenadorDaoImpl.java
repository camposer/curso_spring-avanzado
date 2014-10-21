package springavanzado.ejercicio1.dao;

import org.springframework.stereotype.Component;

import springavanzado.model.Ordenador;

@Component
public class OrdenadorDaoImpl 
		extends GenericDaoImpl<Ordenador, Integer>
		implements OrdenadorDao {

}
