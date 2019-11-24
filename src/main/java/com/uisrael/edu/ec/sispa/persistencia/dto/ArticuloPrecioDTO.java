/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "ArticuloPrecio")
public class ArticuloPrecioDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6369479496037641333L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private BigDecimal costobruto;
	
	private BigDecimal costototal;
	
	private BigDecimal utilidad;
	
	private BigDecimal preciototal;
	
	private Date fecharegistro;
	
	private Integer usuarioregistro;
	
	private String estado;
	
	@JoinColumn(name = "idarticulo", referencedColumnName = "id")
    @ManyToOne
	private ArticuloDTO articuloDTO;
	

}
