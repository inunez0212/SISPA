/**
 * 
 */
package com.uisrael.edu.ec.sispa.vista.beans.controlador;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dto.AlicuotaDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.DepartamentoDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IAlicuotaServicio;
import com.uisrael.edu.ec.sispa.servicio.interfaces.ICatalogoServicio;

/**
 * @author kali
 *
 */
@Named("alicuotaController")
public class AlicuotaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4971454799669174523L;
	
	@Autowired
	private ICatalogoServicio catalogoServicio;
	
	@Autowired
	private IAlicuotaServicio alicuotaServicio;
	
	@Autowired
	private SessionController sessionController;
		
	private String anio;
	
	private BigDecimal valorPago;
	
	private List<AlicuotaDTO> alicuotasDTOList; 
	
	private List<DepartamentoDTO> departamentoDTOList;
	
	private DepartamentoDTO departamentoSelectedDTO;
	
	private AlicuotaDTO alicuotaSelectedDTO;

	@PostConstruct
	public void inicializar() {
		this.departamentoDTOList = this.alicuotaServicio.buscarDepartamentosActivos();
		departamentoSelectedDTO=new DepartamentoDTO();
		alicuotasDTOList = new ArrayList<>();
		alicuotaSelectedDTO = new AlicuotaDTO();
	}

	/**
	 * Verifica si el departamento esta al dia 
	 * @param idDepartamento
	 */
	public String verificarPago(Integer idDepartamento) {
		String estado = estado = Constantes.ESTADO_PENDIENTE;
		DepartamentoDTO departamento = this.departamentoDTOList.stream().
				filter(dato -> dato.getId().equals(idDepartamento)).findAny().orElse(null);
		if(departamento !=null ) {
			departamento.setAlicuotasCOL(this.alicuotaServicio.findByDepartamentoDTO(departamento));
			LocalDate fechaActual = LocalDate.now().minusMonths(1);
			Month mesActual = fechaActual.getMonth();
			Integer anioActual = fechaActual.getYear();
			AlicuotaDTO alicuota = departamento.getAlicuotasCOL().stream().filter(
				dato -> Integer.parseInt(dato.getAnio())==anioActual.intValue() && 
				dato.getMes().equalsIgnoreCase(mesActual.getDisplayName(TextStyle.FULL,new Locale("es", "ES"))))
				.findAny().orElse(null);
			if(alicuota!=null && alicuota.getValorPagado().compareTo(alicuota.getValorAlicuota())==0) {
				estado = Constantes.ESTADO_PAGADO;
			}
		}
		return estado;
	}
	
	
	/**
	 * @return the sessionController
	 */
	public SessionController getSessionController() {
		return sessionController;
	}

	/**
	 * @param sessionController the sessionController to set
	 */
	public void setSessionController(SessionController sessionController) {
		this.sessionController = sessionController;
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
	 * @return the valorPago
	 */
	public BigDecimal getValorPago() {
		return valorPago;
	}

	/**
	 * @param valorPago the valorPago to set
	 */
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	/**
	 * @return the alicuotasDTOList
	 */
	public List<AlicuotaDTO> getAlicuotasDTOList() {
		return alicuotasDTOList;
	}

	/**
	 * @param alicuotasDTOList the alicuotasDTOList to set
	 */
	public void setAlicuotasDTOList(List<AlicuotaDTO> alicuotasDTOList) {
		this.alicuotasDTOList = alicuotasDTOList;
	}

	/**
	 * @return the departamentoDTOList
	 */
	public List<DepartamentoDTO> getDepartamentoDTOList() {
		return departamentoDTOList;
	}

	/**
	 * @param departamentoDTOList the departamentoDTOList to set
	 */
	public void setDepartamentoDTOList(List<DepartamentoDTO> departamentoDTOList) {
		this.departamentoDTOList = departamentoDTOList;
	}

	/**
	 * @return the departamentoSelectedDTO
	 */
	public DepartamentoDTO getDepartamentoSelectedDTO() {
		return departamentoSelectedDTO;
	}

	/**
	 * @param departamentoSelectedDTO the departamentoSelectedDTO to set
	 */
	public void setDepartamentoSelectedDTO(DepartamentoDTO departamentoSelectedDTO) {
		this.departamentoSelectedDTO = departamentoSelectedDTO;
	}

	/**
	 * @return the alicuotaSelectedDTO
	 */
	public AlicuotaDTO getAlicuotaSelectedDTO() {
		return alicuotaSelectedDTO;
	}

	/**
	 * @param alicuotaSelectedDTO the alicuotaSelectedDTO to set
	 */
	public void setAlicuotaSelectedDTO(AlicuotaDTO alicuotaSelectedDTO) {
		this.alicuotaSelectedDTO = alicuotaSelectedDTO;
	}
	
}
