package edu.curso.java.proyecto.trackbug.rest;
import java.util.*;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.service.ProyectoService;
import edu.curso.java.proyecto.trackbug.service.TareaService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoRestController {
	
	
	@Autowired
	private ProyectoService proyectoService;
	
	
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
		proyecto.setUsuarioResponsable(proyectoDTO.getUsuarioResponsable());
		proyectoService.crearProyecto(proyecto);
		return ResponseEntity.status(HttpStatus.CREATED).body(proyectoDTO);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarProyecto(@PathVariable Long id) {
		proyectoService.borrarProyecto(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping(path = "/{id}")//manejar excepcion si no encuentra el proyecto
	public ResponseEntity <ProyectoDTO> listarProyectosPorId(@PathVariable Long id){
			Proyecto proyecto = proyectoService.listarProyectosPorId(id);
			ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto);
			return ResponseEntity.ok(proyectoDTO);
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
	
	
}