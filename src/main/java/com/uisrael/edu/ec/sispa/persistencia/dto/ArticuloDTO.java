/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "articulo")
public class ArticuloDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 890717537059443604L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private String nombre;
	
	private String imagen;
	
	private BigDecimal costo;
	
	private BigDecimal precioactual;
	
	private BigDecimal utilidad;
	
	private String estado;
	
	@OneToMany(mappedBy = "articuloDTO")
    private Collection<ArticuloPrecioDTO> articulosPrecioCOL;
	

}
