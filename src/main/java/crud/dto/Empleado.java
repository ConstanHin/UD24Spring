package crud.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import crud.controller.Trabajo;

@Entity
@Table(name="empleados")
public class Empleado {
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String trabajo;
	private int salario;
	private Trabajo trabajoEnum;

	
	//Construcor
	public Empleado() {
		
	}

	public Empleado(Long id, String nombre, String apellido, Trabajo trabajoEnum) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.trabajo = Trabajo.getTrabajo(trabajoEnum);
		this.salario = Trabajo.getSalario(trabajoEnum);
	}

	// Getters setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Trabajo getTrabajoEnum() {
		return trabajoEnum;
	}

	public void setTrabajoEnum(Trabajo trabajoEnum) {
		this.trabajoEnum = trabajoEnum;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}


}
