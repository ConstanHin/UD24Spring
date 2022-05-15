package qwerty.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import qwerty.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long>{
	
	//Listar empleados por campo nombre
	public List<Empleado> findByNombre(String nombre);

}
