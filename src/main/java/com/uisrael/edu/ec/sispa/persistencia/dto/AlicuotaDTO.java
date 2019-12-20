/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ivan
 *
 */
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
	
	@Column(name="valoralicuota")
	private BigDecimal valorAlicuota;
	
	@Column(name="valorpagado")
	private BigDecimal valorPagado;
	
	
	private String estado;
	
	@Column(name="fechapago")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPago;

	@JoinColumn(name = "iddepartamento", referencedColumnName = "id")
    @ManyToOne
	private DepartamentoDTO departamentoDTO;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the valorAlicuota
	 */
	public BigDecimal getValorAlicuota() {
		return valorAlicuota;
	}

	/**
	 * @param valorAlicuota the valorAlicuota to set
	 */
	public void setValorAlicuota(BigDecimal valorAlicuota) {
		this.valorAlicuota = valorAlicuota;
	}

	/**
	 * @return the valorPagado
	 */
	public BigDecimal getValorPagado() {
		return valorPagado;
	}

	/**
	 * @param valorPagado the valorPagado to set
	 */
	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaPago
	 */
	public Date getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the departamentoDTO
	 */
	public DepartamentoDTO getDepartamentoDTO() {
		return departamentoDTO;
	}

	/**
	 * @param departamentoDTO the departamentoDTO to set
	 */
	public void setDepartamentoDTO(DepartamentoDTO departamentoDTO) {
		this.departamentoDTO = departamentoDTO;
	}

	

}
