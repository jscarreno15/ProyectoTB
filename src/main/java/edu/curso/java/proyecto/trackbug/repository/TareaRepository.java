package edu.curso.java.proyecto.trackbug.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;

public interface TareaRepository extends CrudRepository <Tarea , Long> {

	@Query(value ="select sum(t.horasAsignadas) from Tarea t where t.proyecto.id = :idProyecto")
	public Double buscarHorasAsignadas(@Param(value = "idProyecto") Long idProyecto);
	
	@Query(value = "from Tarea t  where t.nombre like : nombre")
	public Set<Tarea> buscadorDeTareas(@Param("nombre") String nombre);
	
	@Query(value = "from Tarea t where t.proyecto.id = :idProyecto")
	public Set<Tarea> tareasPorProyecto(@Param("idProyecto") Long idProyecto);
	
}
