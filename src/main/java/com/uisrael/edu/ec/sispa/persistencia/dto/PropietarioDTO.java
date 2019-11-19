/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Ivan
 *
 */
@Data
@Entity
@Table(name = "propietario")
public class PropietarioDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5143883420732396402L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String telefono1;
	
	private String estado;
	
	@OneToMany(mappedBy = "propietarioDTO")
    private Collection<DepartamentoDTO> departamentosCOL;

}
