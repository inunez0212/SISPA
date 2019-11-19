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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Ivan
 *
 */
@Data
@Entity
@Table(name = "departamento")
public class DepartamentoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6618667572825728098L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private String bloque;
	
	private String numero;
	
	private String telefono;
	
	private String estado;
	
	@JoinColumn(name = "idpropietario", referencedColumnName = "id")
    @ManyToOne
	private PropietarioDTO propietarioDTO;
	
	@OneToMany(mappedBy = "departamentoDTO")
    private Collection<AlicuotaDTO> alicuotasCOL;
	
}
