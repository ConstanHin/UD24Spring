package crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.dto.Empleado;
import crud.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	/**
	 * Listar todos los empleados
	 * 
	 * @return
	 */
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return empleadoServiceImpl.listarEmpleados();
	}
	
	/**
	 *  Listar empleados por el campo nombre
	 * @param nombre
	 * @return
	 */
	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleado> listarEmpleadosNombre(@PathVariable(name="nombre") String nombre) {
		return empleadoServiceImpl.listarEmpleadosNombre(nombre);
	}
	
	/**
	 * Listar empleados por el campo apellido
	 * 
	 * @param apellido
	 * @return
	 */
	@GetMapping("/empleados/apellido/{apellido}")
	public List<Empleado> listarEmpleadosApellido(@PathVariable(name="apellido") String apellido) {
		return empleadoServiceImpl.listarEmpleadosApellido(apellido);
	}
	
	/**
	 * Listar empleador por el campo trabajo
	 * @param trabajo
	 * @return
	 */
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleado> listarEmpeadosTrabajo(@PathVariable(name="trabajo") String trabajo){
		return empleadoServiceImpl.listarEmpleadosTrabajo(trabajo);
	}
	
	/**
	 *  Guardar empleado
	 *  
	 * @param empleado
	 * @return
	 */
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		
		// Settear el string del trabajao y la cantidad del salario segun el Enumerable "Trabajo.java"
		empleado.setTrabajo(Trabajo.getTrabajo(empleado.getTrabajoEnum()));
		empleado.setSalario(Trabajo.getSalario(empleado.getTrabajoEnum()));
		
		return empleadoServiceImpl.guardarEmpleado(empleado);		
	}
	
	/**
	 * Obtener por id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/empleado/{id}")
	public Empleado empleadoPorId(@PathVariable(name="id")Long id) {
		
		Empleado empleado = new Empleado();
		
		empleado = empleadoServiceImpl.empleadoPorID(id);
		
		System.out.println("Empleado por id: " + empleado);
		
		return empleado;
	}
	
	/**
	 * Actualizar por id
	 * 
	 * @param id
	 * @param empleado
	 * @return
	 */
	@PutMapping("/empleado/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id, @RequestBody Empleado empleado) {
		Empleado empleado_seleccionado = new Empleado();
		Empleado empleado_actualizado = new Empleado();
		
		empleado_seleccionado = empleadoServiceImpl.empleadoPorID(id);
		
		empleado_seleccionado.setNombre(empleado.getNombre());
		
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El empleado actualizado es: " + empleado_actualizado);
		
		return empleado_actualizado;
	}
	

	/**
	 * Eliminar por id
	 * 
	 * @param id
	 */
	@DeleteMapping("/empleado/{id}")
	public void eliminarEmpleado(@PathVariable(name ="id") Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}
	
	

}
