package com.uisrael.edu.ec.sispa.servicio.implentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.edu.ec.sispa.persistencia.dao.interfaces.IDepartamentoDAO;
import com.uisrael.edu.ec.sispa.persistencia.dto.DepartamentoDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IDepartamentoServicio;

@Service
public class DepartamentoServicio implements IDepartamentoServicio{

	@Autowired
	IDepartamentoDAO departamentoDAO;
	
	@Override
	public DepartamentoDTO findById(Integer id) {
		return this.departamentoDAO.findById(id);
	}
	

}
