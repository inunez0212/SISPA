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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Ivan
 *
 */
@Data
@Entity
@Table(name = "alicuota")
public class AlicuotaDTO implements Serializable{
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 8708203123579407745L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private String usuario;
	
	private String mes;
	
	private String anio;
	
	private BigDecimal valorAlicuota;
	
	private BigDecimal valorPagado;
	
	private String telefono1;
	
	private String estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPago;

	@JoinColumn(name = "iddepartamento", referencedColumnName = "id")
    @ManyToOne
	private DepartamentoDTO departamentoDTO;


}
