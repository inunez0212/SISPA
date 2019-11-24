/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Ivan
 *
 */
@Data
@Entity
@Table(name = "cliente")
public class ClienteDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String direccion;
	
	private String telefono;
	
	private String estado;
	
	

}
