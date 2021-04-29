package edu.curso.java.proyecto.trackbug.service;

import java.util.Set;
import edu.curso.java.proyecto.trackbug.bo.Tarea;

public interface TareaService {
	
	public Set<Tarea> listarTareas();
	public Tarea listarTareasPorId(Long id);
	public Long crearTarea(Tarea tarea);
	public Double buscarHorasAsignadas(Long id);
}
