/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.implentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dao.GenericoDAO;
import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.ICatalogoServicio;

/**
 * 
 * @author Ivan
 *
 */
@Service
public class CatalogoServicio implements ICatalogoServicio {
	/**
	 * {@inheritDoc}
	 */
	@Autowired
	private GenericoDAO<CatalogoDTO, Integer> genericoDAO;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CatalogoDTO registrar(CatalogoDTO catalogo) {
		return this.genericoDAO.save(catalogo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CatalogoDTO actualizar(CatalogoDTO catalogo) {
		return this.genericoDAO.save(catalogo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CatalogoDTO> listarTodos() {
		return this.genericoDAO.findByEstado(Constantes.ESTADO_ACTIVO);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminar(CatalogoDTO catalogo) {
		this.genericoDAO.delete(catalogo);
	}
	
}
