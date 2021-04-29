package edu.curso.java.proyecto.trackbug.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.repository.ProyectoRepository;

@Service
@Transactional
public class ProyectoServiceImp implements ProyectoService{

	
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public Long crearProyecto(Proyecto proyecto) {
		proyectoRepository.save(proyecto);
		return proyecto.getId();
	}

	@Override
	public void borrarProyecto(Long id) {
		proyectoRepository.deleteById(id);
	}

	@Override
	public List<Proyecto> listarProyectos() {
		List<Proyecto> proyectos = (List<Proyecto>) proyectoRepository.findAll();
		return proyectos;
	}

	@Override
	public Proyecto listarProyectosPorId(Long id) {
		 proyectoRepository.findById(id);
		 return null;
	}

	@Override
	public List<Proyecto> buscadorDeProyectos(String nombre) {
		return proyectoRepository.buscadorDeProyectos("%" + nombre);
	}
	
	


	

}
