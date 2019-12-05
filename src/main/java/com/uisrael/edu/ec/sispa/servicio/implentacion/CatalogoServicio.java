/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.implentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dao.interfaces.ICatalogoDAO;
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
	private ICatalogoDAO catalogoDAO;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CatalogoDTO registrar(CatalogoDTO catalogo) {
		return catalogoDAO.save(catalogo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CatalogoDTO actualizar(CatalogoDTO catalogo) {
		return catalogoDAO.save(catalogo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CatalogoDTO> listarTodos() {
		return this.catalogoDAO.findByEstado(Constantes.ESTADO_ACTIVO);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminar(CatalogoDTO catalogo) {
		this.catalogoDAO.delete(catalogo);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CatalogoDTO buscarPorId(String id) {
		return this.catalogoDAO.findById(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CatalogoDTO> buscarPorRelacionado(String idRelacionado){
		CatalogoDTO relacionado = new CatalogoDTO();
		relacionado.setId(idRelacionado);
		return this.catalogoDAO.findByCatalogoRelacionado(relacionado);
	}
}
