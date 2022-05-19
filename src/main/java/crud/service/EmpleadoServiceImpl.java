package crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.dao.IEmpleadoDAO;
import crud.dto.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	// Utilizamos los metodos de la interface IEmpleadoDAO, es como si
	// instaciaramos.
	@Autowired
	IEmpleadoDAO iEmpleadoDAO;

	@Override
	public List<Empleado> listarEmpleados() {
		return iEmpleadoDAO.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public Empleado empleadoPorID(Long id) {
		return iEmpleadoDAO.findById(id).get();
	}

	@Override
	public List<Empleado> listarEmpleadosNombre(String nombre) {
		return iEmpleadoDAO.findByNombre(nombre);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		iEmpleadoDAO.deleteById(id);
	}

	@Override
	public List<Empleado> listarEmpleadosTrabajo(String trabajo) {
		return iEmpleadoDAO.findByTrabajo(trabajo);
	}

	@Override
	public List<Empleado> listarEmpleadosApellido(String apellido) {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.findByApellido(apellido);
	}
	
}
