/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Ivan
 *
 */
@Data
@Entity
@Table(name = "usuario")
public class UsuarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -671412443517256125L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private String cargo;
	
	private String direccion;
	
	private String telefono1;
	
	private String telefono2;
	
	private String estado;
	
	@JoinColumn(name = "tipousuario", referencedColumnName = "id")
    @ManyToOne
	private CatalogoDTO tipoUsuario;
	
}
