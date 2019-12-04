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

/**
 * @author Ivan
 *
 */
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
	 * @return the bloque
	 */
	public String getBloque() {
		return bloque;
	}

	/**
	 * @param bloque the bloque to set
	 */
	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	 * @return the propietarioDTO
	 */
	public PropietarioDTO getPropietarioDTO() {
		return propietarioDTO;
	}

	/**
	 * @param propietarioDTO the propietarioDTO to set
	 */
	public void setPropietarioDTO(PropietarioDTO propietarioDTO) {
		this.propietarioDTO = propietarioDTO;
	}

	/**
	 * @return the alicuotasCOL
	 */
	public Collection<AlicuotaDTO> getAlicuotasCOL() {
		return alicuotasCOL;
	}

	/**
	 * @param alicuotasCOL the alicuotasCOL to set
	 */
	public void setAlicuotasCOL(Collection<AlicuotaDTO> alicuotasCOL) {
		this.alicuotasCOL = alicuotasCOL;
	}

	
}
