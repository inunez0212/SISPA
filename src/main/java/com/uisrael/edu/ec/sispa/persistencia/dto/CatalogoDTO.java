/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
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
    @Basic(optional = false)
	private String id;
	
	@Column(name="nombrecatalogo")
	private String nombreCatalogo;
	
	@Column(name="valorcatalogo")
	private String valorCatalogo;
	
	private String estado;

	@JoinColumn(name = "catalogorelacionado", referencedColumnName = "id")
    @ManyToOne
	private CatalogoDTO catalogoRelacionado;
	
	@OneToMany(mappedBy = "catalogoRelacionado")
    private Collection<CatalogoDTO> catalogoRelacionadoCOL;
	
	
}
