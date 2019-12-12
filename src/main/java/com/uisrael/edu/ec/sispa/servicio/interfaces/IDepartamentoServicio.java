/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.interfaces;

import com.uisrael.edu.ec.sispa.persistencia.dto.DepartamentoDTO;

/**
 * @author Ivan
 *
 */
public interface IDepartamentoServicio {

	DepartamentoDTO findById(Integer id);
}
