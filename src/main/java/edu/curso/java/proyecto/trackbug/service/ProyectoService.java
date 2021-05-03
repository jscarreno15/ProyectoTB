package edu.curso.java.proyecto.trackbug.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.query.Param;

import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;

public interface ProyectoService {

	public Long crearProyecto(Proyecto proyecto);
	public void borrarProyecto(Long id);
	public List<Proyecto> listarProyectos();
	public Proyecto buscarProyectosPorId(Long id) throws ProyectoException;
	public List<Proyecto> buscadorDeProyectos(String nombre)throws ProyectoException;
	public void asignarUsuario(Long id, Long idUsuario)throws ProyectoException;
	public void actualizarProyecto(Proyecto proyecto);
}
