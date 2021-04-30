package edu.curso.java.proyecto.trackbug.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Usuario;
import edu.curso.java.proyecto.trackbug.repository.ProyectoRepository;
import edu.curso.java.proyecto.trackbug.repository.UsuarioRepository;

@Service
@Transactional
public class ProyectoServiceImp implements ProyectoService{

	
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Long crearProyecto(Proyecto proyecto) {
		return proyectoRepository.save(proyecto).getId();
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
		 return  proyectoRepository.findById(id).get();
	}

	@Override
	public List<Proyecto> buscadorDeProyectos(String nombre) {
		return proyectoRepository.buscadorDeProyectos("%" + nombre);
	}
	
	@Override
	public void asignarUsuario(Long id, Long idUsuario) {
		Proyecto proyecto = proyectoRepository.findById(id).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		proyecto.setUsuarioResponsable(usuario);
		proyectoRepository.save(proyecto);
		usuarioRepository.save(usuario);
	}
	
	

}
