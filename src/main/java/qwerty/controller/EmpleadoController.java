package qwerty.controller;

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

import qwerty.dto.Empleado;
import qwerty.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	// Listar todos los clientes
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return empleadoServiceImpl.listarEmpleados();
	}
	
	// Listar empleados por el campo nombre
	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleado> listarEmpleadosNombre(@PathVariable(name="nombre") String nombre) {
		return empleadoServiceImpl.listarEmpleadosNombre(nombre);
	}
	
	// Guardar empleado
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return empleadoServiceImpl.guardarEmpleado(empleado);		
	}
	
	@GetMapping("/empleado/{id}")
	public Empleado empleadoPorId(@PathVariable(name="id")Long id) {
		
		Empleado empleado = new Empleado();
		
		empleado = empleadoServiceImpl.empleadoPorID(id);
		
		System.out.println("Empleado por id: " + empleado);
		
		return empleado;
	}
	
	@PutMapping("/empleado/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id, @RequestBody Empleado empleado) {
		Empleado empleado_seleccionado = new Empleado();
		Empleado empleado_actualizado = new Empleado();
		
		empleado_seleccionado = empleadoServiceImpl.empleadoPorID(id);
		
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellido(empleado.getApellido());
		empleado_seleccionado.setDireccion(empleado.getDireccion());
		empleado_seleccionado.setDni(empleado.getDni());
		empleado_seleccionado.setFecha(empleado.getFecha());
		
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El empleado actualizado es: " + empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	// Delete
	
	@DeleteMapping("/empleado/{id}")
	public void eliminarEmpleado(@PathVariable(name ="id") Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}
	
	

}
