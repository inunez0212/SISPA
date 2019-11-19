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
@Table(name = "catalogo")
public class CatalogoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3938524883609070734L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private String nombreCatalogo;
	
	private String valorCatalogo;
	
	private String estado;

	@JoinColumn(name = "catalogorelacionado", referencedColumnName = "id")
    @ManyToOne
	private CatalogoDTO catalogoRelacionado;
	
	@OneToMany(mappedBy = "catalogorelacionado")
    private Collection<CatalogoDTO> catalogoRelacionadoCOL;
	
	
}
