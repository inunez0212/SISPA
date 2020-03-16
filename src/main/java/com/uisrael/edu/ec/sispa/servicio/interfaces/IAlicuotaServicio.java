package com.uisrael.edu.ec.sispa.servicio.interfaces;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.uisrael.edu.ec.sispa.persistencia.dto.AlicuotaDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.DepartamentoDTO;

/**
 * 
 * @author Jorge
 *
 */
public interface IAlicuotaServicio {

	/**
	 * Carga los datos de propietario, departamento y alicuotas
	 * @param uploadedData
	 * @param usuario
	 * @throws IOException 
	 */
	void cargarDatos(byte[] uploadedData) throws Exception;

	/**
	 * Genera datos para un nuevo anio
	 * @param anio
	 */
	void generarNuevoAnio(String anio, String usuario, BigDecimal valorAlicuota) throws Exception ;
	
	/**
	 * Busca todos los departamentos
	 */
	List<DepartamentoDTO> buscarDepartamentosActivos();

	/**
	 * Busca las alicutoas de los departamentos
	 * @param departamento
	 * @return
	 */
	Collection<AlicuotaDTO> findByDepartamentoDTO(DepartamentoDTO departamento);

	/**
	 * Busca alicuotas pendientes por departamento
	 * @param departamento
	 * @return
	 */
	List<AlicuotaDTO> findByDepartamentoDTOAndValorPagadoIsNull(DepartamentoDTO departamento);

	/**
	 * Actualiza la alicuota
	 * @param alicuota
	 * @return
	 */
	AlicuotaDTO actualizarAlicuota(AlicuotaDTO alicuota);

	/**
	 * Busca alicuota por ID
	 * @param idAlicuotaPago
	 * @return
	 */
	AlicuotaDTO findById(Integer idAlicuotaPago);
}
