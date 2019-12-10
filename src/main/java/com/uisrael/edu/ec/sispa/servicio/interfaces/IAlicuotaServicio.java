package com.uisrael.edu.ec.sispa.servicio.interfaces;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 
 * @author kali
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
	
	

}
