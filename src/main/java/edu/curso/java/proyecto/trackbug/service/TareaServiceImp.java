package edu.curso.java.proyecto.trackbug.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.proyecto.trackbug.bo.EstadoDeTarea;
import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.TipoDeTarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;
import edu.curso.java.proyecto.trackbug.repository.ProyectoRepository;
import edu.curso.java.proyecto.trackbug.repository.TareaRepository;
import edu.curso.java.proyecto.trackbug.repository.UsuarioRepository;


@Service
@Transactional
public class TareaServiceImp implements TareaService{

	@Autowired
	private TareaRepository tareaRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Tarea> listarTareas() {
		List<Tarea> tareas = (List<Tarea>) tareaRepository.findAll();
		return tareas;
	}

	@Override
	public Tarea buscarTareasPorId(Long id) throws TareaException {
		if(tareaRepository.findById(id).get() == null) 
			throw new TareaException("El id de la tarea no existe en base de datos");
		return tareaRepository.findById(id).get();
	}

	@Override
	public Long crearTarea(Tarea tarea , Long idProyecto )  throws TareaException {
		tareaRepository.save(tarea);
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Double horasDisponibles = proyecto.getHorasAsignadasProyecto() - tarea.getHorasAsignadas();
		if(horasDisponibles < 0 )
			throw new TareaException("Las horas de la tarea son superiores a las horas del proyecto.....");
		proyecto.setHorasAsignadasProyecto(horasDisponibles);
		return tareaRepository.save(tarea).getId();
	}

	
	@Override
	public void borrarTarea(Long id) {
		tareaRepository.deleteById(id);
		
	}
	
	@Override
	public List<Tarea> buscadorDeTareas(String nombre) {
		return tareaRepository.buscadorDeTareas("%" + nombre);
	}

	@Override
	public Double buscarHorasAsignadas(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void asignarUsuario(Long id, Long idUsuario) {
		Tarea tarea = tareaRepository.findById(id).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		tarea.agregarUsuario(usuario);
		tareaRepository.save(tarea);	
	}

	@Override
	public List<Tarea> buscarTareasPorProyecto(Long idProyecto) {
		return tareaRepository.tareasPorProyecto(idProyecto);
	}

	@Override
	public void actualizarTarea(Tarea tarea) {
		tareaRepository.save(tarea);
	}

	
}
