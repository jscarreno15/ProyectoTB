package edu.curso.java.proyecto.trackbug.service;


import java.util.List;
import edu.curso.java.proyecto.trackbug.bo.EstadoDeTarea;
import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.TipoDeTarea;

public interface TareaService {
	
	public List<Tarea> listarTareas();
	public Tarea buscarTareasPorId(Long id) throws TareaException;
	public Long crearTarea(Tarea tarea , Long idProyecto) throws TareaException;
	public Double buscarHorasAsignadas(Long id);
	public void borrarTarea(Long id);
	public List<Tarea> buscadorDeTareas(String nombre);
	public void asignarUsuario(Long id, Long idUsuario);
	public List<Tarea> buscarTareasPorProyecto(Long idProyecto);
	public void actualizarTarea(Tarea tarea);
}
