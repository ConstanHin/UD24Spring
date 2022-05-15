package qwerty.service;

import java.util.List;

import qwerty.dto.Empleado;

public interface IEmpleadoService {
	
	// Methods CRUD
	
	// list All
	public List<Empleado> listarEmpleados();
	
	// CREATE Guarda un empleado
	
	public Empleado guardarEmpleado(Empleado empleado);
	
	//READ, Leer datos de un empleado
	
	public Empleado empleadoPorID(Long id);
	
	// Listar empleados por campo nombre
	
	public List<Empleado> listarEmpleadosNombre(String nombre);
	
	// UPDATE actualizar datos del empleado
	
	public Empleado actualizarEmpleado(Empleado empleado);
	
	// DELETE, Eliminar empleado por id
	
	public void eliminarEmpleado(Long id);

}
