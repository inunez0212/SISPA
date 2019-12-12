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
import java.util.Date;
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
import com.uisrael.edu.ec.sispa.servicio.interfaces.IDepartamentoServicio;
import com.uisrael.edu.ec.sispa.vista.beans.util.JsfUtil;

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

	@Autowired
	private IDepartamentoServicio departamentoServicio;
	
	private Integer idAlicuotaPago;
	
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
		valorPago=BigDecimal.ZERO;
	}

	/**
	 * Verifica si el departamento esta al dia 
	 * @param idDepartamento
	 */
	public String verificarPago(Integer idDepartamento) {
		String estado =  Constantes.ESTADO_PENDIENTE;
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
	

	public List<AlicuotaDTO> alicuotasPendientes(Integer idDepartamento){
		DepartamentoDTO departamento = this.departamentoServicio.findById(idDepartamento);
		return this.alicuotaServicio.findByDepartamentoDTOAndValorPagadoIsNull(departamento);
	}
	
	public void guardar() {
    	try {
    		if(this.validarRegistro()) {
    			alicuotaSelectedDTO.setFechaPago(new Date());
    			alicuotaSelectedDTO.setUsuario(this.sessionController.getNombreUsuarioLogueado());
    			this.alicuotaServicio.actualizarAlicuota(alicuotaSelectedDTO);
    			inicializar();
    			JsfUtil.addSuccessMessage("Pago guardado correctamente");
    		}else {
    			JsfUtil.addErrorMessage("No se encontró el registro para actualizar");
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo guardar el pago de la alicuota");
		}
    }

	public void seleccionarAlicuota() {
		this.alicuotaSelectedDTO = this.alicuotaServicio.findById(this.idAlicuotaPago);
	}
	
	private boolean validarRegistro() {
		boolean estadoRegistro = true;
		if(alicuotaSelectedDTO == null) {
			estadoRegistro = false;
		}
		if(valorPago==null || valorPago.compareTo(BigDecimal.ONE)< 0) {
			estadoRegistro = false;
			JsfUtil.addErrorMessage("El valor del pago debe ser mayor a 1");
		}
		return estadoRegistro;
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

	/**
	 * @return the idAlicuotaPago
	 */
	public Integer getIdAlicuotaPago() {
		return idAlicuotaPago;
	}

	/**
	 * @param idAlicuotaPago the idAlicuotaPago to set
	 */
	public void setIdAlicuotaPago(Integer idAlicuotaPago) {
		this.idAlicuotaPago = idAlicuotaPago;
	}

	
}
