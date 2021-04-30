package edu.curso.java.proyecto.trackbug.rest;
import java.util.*;

import javax.persistence.EntityManager;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;
import edu.curso.java.proyecto.trackbug.service.ProyectoService;
import edu.curso.java.proyecto.trackbug.service.TareaService;
import edu.curso.java.proyecto.trackbug.service.UsuarioService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoRestController {
	
	
	@Autowired
	private ProyectoService proyectoService;
	@Autowired
	private TareaService tareaService;
	
	
	@GetMapping
	public ResponseEntity <List<ProyectoDTO>> listarProyectos()	{
		List<Proyecto> proyecto = proyectoService.listarProyectos();
		List<ProyectoDTO> proyectoDTO = new ArrayList<ProyectoDTO>();
		for(Proyecto p : proyecto) {
			proyectoDTO.add(new ProyectoDTO(p));
		}
		return ResponseEntity.ok(proyectoDTO);
	}
	
	@PostMapping
	public ResponseEntity<ProyectoDTO> crearProyecto(@Validated @RequestBody ProyectoDTO proyectoDTO){
		Proyecto proyecto = new Proyecto();
		proyecto.setId(proyectoDTO.getId());
		proyecto.setNombre(proyectoDTO.getNombre());
		proyecto.setHorasAsignadasProyecto(proyectoDTO.getHorasAsignadasProyecto());
		proyecto.setIdUsuarioResponsable(proyectoDTO.getIdUsuarioResponsable());
		proyectoService.crearProyecto(proyecto);
		return ResponseEntity.status(HttpStatus.CREATED).body(proyectoDTO);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarProyecto(@PathVariable Long id) {
		proyectoService.borrarProyecto(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDTO) {
		Proyecto proyecto= proyectoService.listarProyectosPorId(id);
		proyecto.setId(proyectoDTO.getId());
		proyecto.setNombre(proyectoDTO.getNombre());
		proyecto.setHorasAsignadasProyecto(proyectoDTO.getHorasAsignadasProyecto());
		proyecto.setIdUsuarioResponsable(proyectoDTO.getIdUsuarioResponsable());
		proyectoService.actualizarProyecto(proyecto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	
	@GetMapping(path = "/{id}")//manejar excepcion si no encuentra el proyecto
	public ResponseEntity <ProyectoDTO > listarProyectosPorId(@PathVariable Long id){
			Proyecto proyecto = proyectoService.listarProyectosPorId(id);
			ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto);
			tareaService.listarTareasPorProyecto(id);
			return ResponseEntity.ok(proyectoDTO);
	}
	
	@GetMapping(path = "/{id}/tareasporproyecto")
	public ResponseEntity <List<TareaDTO>> listarTareasPorProyecto(@PathVariable Long id){
			Proyecto proyecto = proyectoService.listarProyectosPorId(id);
			List<Tarea> tareas = new ArrayList(tareaService.listarTareasPorProyecto(id));
			List<TareaDTO> tareasDTO = new ArrayList<TareaDTO>();
			for(Tarea t : tareas) {
				tareasDTO.add(new TareaDTO(t));
			}
			return ResponseEntity.ok(tareasDTO);
	}
	
	
	
	@GetMapping(path = "/buscador")
	public ResponseEntity <List<ProyectoDTO>> buscarProyectosPorNombre(@RequestParam String nombre){
		List<Proyecto> proyectos = proyectoService.buscadorDeProyectos(nombre);
		List<ProyectoDTO>proyectosDTO = new ArrayList<ProyectoDTO>();
		for(Proyecto p : proyectos) {
			proyectosDTO.add(new ProyectoDTO(p));
		}
		return ResponseEntity.ok(proyectosDTO);
	}
	
	
	@PutMapping(path = "/{id}/agregarusuario/{idUsuario}")
	public ResponseEntity <Long> asignarUsuario(@PathVariable Long id ,@PathVariable Long idUsuario){
		proyectoService.asignarUsuario(id, idUsuario);
		return  ResponseEntity.ok(id);
	}
	
	
	@PostMapping(path = "/{id}/tareas")
	public ResponseEntity <TareaDTO>altaTarea(@PathVariable Long id , @Validated @RequestBody TareaDTO tareaDTO ) {
		Tarea tarea =  new Tarea();
		Proyecto proyecto = proyectoService.listarProyectosPorId(id);	
		tarea.setProyecto(proyecto);
		tarea.setId(tareaDTO.getId());
		tarea.setHorasAsignadas(tareaDTO.getHorasAsignadas());
		tarea.setIdEstado(tareaDTO.getIdEstado());
		tarea.setIdTipoTarea(tareaDTO.getIdTipoTarea());
		try {
			tareaService.crearTarea(tarea ,id);
			proyecto.agregarTarea(tarea);
			return ResponseEntity.status(HttpStatus.CREATED).body(tareaDTO);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	
}