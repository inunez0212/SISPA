/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.implentacion;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dao.interfaces.IAlicuotaDAO;
import com.uisrael.edu.ec.sispa.persistencia.dao.interfaces.IDepartamentoDAO;
import com.uisrael.edu.ec.sispa.persistencia.dao.interfaces.IPropietarioDAO;
import com.uisrael.edu.ec.sispa.persistencia.dto.AlicuotaDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.DepartamentoDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.PropietarioDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IAlicuotaServicio;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Ivan
 *
 */
@Service
public class AlicuotaServicio implements IAlicuotaServicio{
	
	@Autowired
	private IAlicuotaDAO alicuotaDAO;
	
	@Autowired
	private IPropietarioDAO propietarioDAO;
	
	@Autowired
	private IDepartamentoDAO departamentoDAO;
	
	
	/**
	 * {inheritDoc}
	 * @throws IOException 
	 */
	@Override
	public void cargarDatos( byte[] uploadedData) throws Exception {
		CSVReader reader = new CSVReader(new InputStreamReader(new ByteArrayInputStream(uploadedData)), 
				Constantes.DELIMITADOR_ARCHIVO);
		int numeroFila =0;
		for(String[] datosArchivoCOL : reader.readAll()){
			if(datosArchivoCOL==null || datosArchivoCOL.length==0) {
				throw new IOException("Error en columna");
			}
			if(numeroFila>1){
				this.registrarDatos(datosArchivoCOL, numeroFila);
			}
			numeroFila ++;
		}
		reader.close();
	}

	/**
	 * Carga los datos de propietario, departamento y alicuotas  
	 * @throws IOException 
	 */
	private void registrarDatos(String[] datosArchivoCOL, int numeroFila) throws IOException {
		//Propietario
		PropietarioDTO propietarioDTO = this.cargarDatosPropietario(datosArchivoCOL[Constantes.ARCHIVO_POSICION_CEDULA],
				datosArchivoCOL[Constantes.ARCHIVO_POSICION_NOMBRE],datosArchivoCOL[Constantes.ARCHIVO_POSICION_APELLIDO],
				datosArchivoCOL[Constantes.ARCHIVO_POSICION_EMAIL], datosArchivoCOL[Constantes.ARCHIVO_POSICION_TELEFONO],
				numeroFila);
		//Departamento
		DepartamentoDTO departamentoDTO = this.cargarDatosDepartamento( propietarioDTO, 
				datosArchivoCOL[Constantes.ARCHIVO_POSICION_BLOQUE],datosArchivoCOL[Constantes.ARCHIVO_POSICION_NUMERO], 
				datosArchivoCOL[Constantes.ARCHIVO_POSICION_TEL_CONVENCIONAL], numeroFila );
		//Alicuota
		this.cargarDatosAlicuota(departamentoDTO, datosArchivoCOL[Constantes.ARCHIVO_POSICION_USUARIO],
				datosArchivoCOL[Constantes.ARCHIVO_POSICION_ANIO], datosArchivoCOL[Constantes.ARCHIVO_POSICION_MES], 
				datosArchivoCOL[Constantes.ARCHIVO_POSICION_VALOR], datosArchivoCOL[Constantes.ARCHIVO_POSICION_PAGO],
				datosArchivoCOL[Constantes.ARCHIVO_POSICION_FECHA], numeroFila);
	}

	private void cargarDatosAlicuota(DepartamentoDTO departamentoDTO, String usuario, String anio, String mes,
			String valor, String pago, String fecha, int numeroFila) throws IOException {
		String[] cabeceras = { anio, mes, valor};
		if(this.validarDatos(cabeceras)) {
			throw new IOException("Error en datos de alicuota, fila "+ (numeroFila+1));
		}
		AlicuotaDTO alicuotaDTO = new AlicuotaDTO();
		alicuotaDTO.setAnio(anio);
		alicuotaDTO.setDepartamentoDTO(departamentoDTO);
		alicuotaDTO.setEstado(Constantes.ESTADO_ACTIVO);
		alicuotaDTO.setMes(mes);
		alicuotaDTO.setUsuario(usuario);
		try {
			alicuotaDTO.setValorAlicuota(BigDecimal.valueOf(Double.parseDouble(valor)));
			if(StringUtils.isNotBlank(pago)&&StringUtils.isNotBlank(fecha)) {
				alicuotaDTO.setValorPagado(BigDecimal.valueOf(Double.parseDouble(pago)));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				alicuotaDTO.setFechaPago(dateFormat.parse(fecha));
			}
		}catch (Exception e) {
			throw new IOException("Error en el formato de los datos de alicuota, fila "+ numeroFila);
		}
		this.alicuotaDAO.save(alicuotaDTO);
	}

	private DepartamentoDTO cargarDatosDepartamento(PropietarioDTO propietarioDTO, String bloque,	
			String numero,	String telefono, int numeroFila) throws IOException {
		DepartamentoDTO departamentoDTO = null;
		String[] cabeceras = {bloque, numero};
		if(this.validarDatos(cabeceras)) {
			throw new IOException("Error en datos del departamento, fila "+ (numeroFila-1));
		}
		departamentoDTO = this.departamentoDAO.findByBloqueAndNumero(bloque, numero);
		if(departamentoDTO==null) {
			departamentoDTO = new DepartamentoDTO();
			departamentoDTO.setBloque(bloque);
			departamentoDTO.setEstado(Constantes.ESTADO_ACTIVO);
			departamentoDTO.setNumero(numero);
			departamentoDTO.setTelefono(telefono);
			departamentoDTO = this.departamentoDAO.save(departamentoDTO);
			departamentoDTO.setPropietarioDTO(propietarioDTO);
		}
		return departamentoDTO;
	}

	private PropietarioDTO cargarDatosPropietario(String cedula, String nombre, String apellido, 
			String email,	String telefono, int numeroFila) throws IOException {
		PropietarioDTO propietarioDTO = null;
		String[] cabeceras = {cedula,nombre,apellido,email,telefono};
		if(this.validarDatos(cabeceras)) {
			throw new IOException("Error en datos del propietario, fila "+ (numeroFila));
		}
		propietarioDTO = this.propietarioDAO.findByCedula(cedula);
		if(propietarioDTO==null) {
		 	propietarioDTO	 = new PropietarioDTO();
			propietarioDTO.setCedula(cedula);
			propietarioDTO.setNombre(nombre);
			propietarioDTO.setApellido(apellido);
			propietarioDTO.setNombre(nombre);
			propietarioDTO.setEmail(email);
			propietarioDTO.setTelefono1(telefono);
			propietarioDTO.setEstado(Constantes.ESTADO_ACTIVO);
			propietarioDTO = this.propietarioDAO.save(propietarioDTO);
		}
		return propietarioDTO;
		
	}

	private boolean validarDatos( String[] datos) {
		boolean errores = false;
		for(String dato :datos) {
			if(StringUtils.isBlank(dato)) {
				errores =true;
			}
		}
		return errores;
	}

	/**
	 * {inheritDoc}
	 * @throws Exception 
	 */
	public void generarNuevoAnio(String anio, String usuario, BigDecimal valorAlicuota) throws Exception {
		List<AlicuotaDTO> alicuotasCOL = this.alicuotaDAO.findByAnio(anio);
		if(alicuotasCOL ==null || alicuotasCOL.isEmpty()) {
			this.alicuotaDAO.insertNuevoAnio(anio, usuario, valorAlicuota);
		}else {
			throw new Exception("Ya existen datos creados para el "+ anio);
		}
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public List<DepartamentoDTO> buscarDepartamentosActivos() {
		return this.alicuotaDAO.buscarDepartamentosActivos(Constantes.ESTADO_ACTIVO);
	}


	/**
	 * {inheritDoc}
	 */
	@Override
	public Collection<AlicuotaDTO> findByDepartamentoDTO(DepartamentoDTO departamento) {
		return this.alicuotaDAO.findByDepartamentoDTO(departamento);
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public List<AlicuotaDTO> findByDepartamentoDTOAndValorPagadoIsNull(DepartamentoDTO departamento) {
		return this.alicuotaDAO.findByDepartamentoDTOAndValorPagadoIsNull(departamento);
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public AlicuotaDTO actualizarAlicuota(AlicuotaDTO alicuota) {
		return this.alicuotaDAO.save(alicuota);
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public AlicuotaDTO findById(Integer idAlicuotaPago) {
		return this.alicuotaDAO.findById(idAlicuotaPago);
	}
	
	
}
