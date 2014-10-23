package springavanzado.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springavanzado.ejercicio1.dao.OrdenadorDao;
import springavanzado.model.Ordenador;

@Component
@Transactional
public class OrdenadorServiceImpl implements OrdenadorService {
	@Autowired
	private OrdenadorDao ordenadorDao;
	
	@Override
	public void agregarOrdenador(Ordenador p) {
		ordenadorDao.agregar(p);
	}

	@Override
	public void modificarOrdenador(Ordenador p) {
		ordenadorDao.modificar(p);
	}

	@Override
	public void eliminarOrdenador(Integer id) {
		ordenadorDao.eliminar(id);
	}

	@Override
	public List<Ordenador> obtenerOrdenadores() {
		return ordenadorDao.obtenerTodos();
	}

	@Override
	public Ordenador obtenerOrdenador(Integer id) {
		return ordenadorDao.obtener(id);
	}

}
