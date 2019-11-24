/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.implentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dao.GenericoDAO;
import com.uisrael.edu.ec.sispa.persistencia.dto.UsuarioDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IUsuarioServicio;

/**
 * @author Ivan
 *
 */
@Service
public class UsuarioServicio implements IUsuarioServicio{

	/**
	 * {@inheritDoc}
	 */
	@Autowired
	private GenericoDAO<UsuarioDTO, Integer> genericoDAO;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsuarioDTO registrar(UsuarioDTO usuario) {
		return this.genericoDAO.save(usuario);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsuarioDTO actualizar(UsuarioDTO usuario) {
		return this.genericoDAO.save(usuario);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UsuarioDTO> listarTodos() {
		return this.genericoDAO.findByEstado(Constantes.ESTADO_ACTIVO);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminar(UsuarioDTO usuario) {
		this.genericoDAO.delete(usuario);
	}
	
}
