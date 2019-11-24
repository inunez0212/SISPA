/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.math.BigDecimal;

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
@Table(name = "detallefactura")
public class DetalleFacturaDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private Integer idfactura;
	
	private Integer idarticulo;
	
	private BigDecimal preciosinimpuestos;
	
	private BigDecimal precioconimpuestos;
	
	private BigDecimal ganancia;
	
	private String estado;
	
	

}
