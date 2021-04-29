package edu.curso.java.proyecto.trackbug.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.repository.TareaRepository;

public class TareaServiceImp implements TareaService{
	
	@Autowired
	private TareaRepository tareaRepository;

	
	
	@Override
	public Double buscarHorasAsignadas(Long id) {
		return tareaRepository.buscarHorasAsignadas(id);
	}

	
	@Override
	public Set<Tarea> listarTareas() {
		return null;
	}

	@Override
	public Tarea listarTareasPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long crearTarea(Tarea tarea) {
		
		return tareaRepository.save(tarea).getId();
	}

	
}
