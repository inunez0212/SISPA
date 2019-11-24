/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "factura")
public class FacturaDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private Integer idCliente;
	
	private Integer idusuario;
	
	private Date fecha;
	
	private BigDecimal totalsinimpuestos;
	
	private BigDecimal totalconimpuestos;
	
	private String estado;
	
}
