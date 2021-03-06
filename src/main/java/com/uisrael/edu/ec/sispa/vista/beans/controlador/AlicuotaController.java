/**
 * 
 */
package com.uisrael.edu.ec.sispa.vista.beans.controlador;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dto.AlicuotaDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.DepartamentoDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IAlicuotaServicio;
import com.uisrael.edu.ec.sispa.servicio.interfaces.ICatalogoServicio;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IDepartamentoServicio;
import com.uisrael.edu.ec.sispa.vista.beans.util.JsfUtil;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Jorge
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
	
	private List<AlicuotaDTO> idAlicuotaPagoCol;
	
	private BigDecimal valorPago;
	
	private List<AlicuotaDTO> alicuotasDTOList; 
	
	private List<DepartamentoDTO> departamentoDTOList;

	private List<DepartamentoDTO> departamentoFilteredDTOList;
	
	private DepartamentoDTO departamentoSelectedDTO;
	
	private AlicuotaDTO alicuotaSelectedDTO;

	private BigDecimal totalAlicuotas;

	@PostConstruct
	public void inicializar() {
		this.departamentoDTOList = this.alicuotaServicio.buscarDepartamentosActivos();
		departamentoSelectedDTO=new DepartamentoDTO();
		alicuotasDTOList = new ArrayList<>();
		alicuotaSelectedDTO = new AlicuotaDTO();
		valorPago=BigDecimal.ZERO;
		inicializarPago();
		totalAlicuotas = BigDecimal.ZERO;
		this.idAlicuotaPagoCol = new ArrayList<>();
	}
	
	private void inicializarPago() {
		if(departamentoDTOList!=null) {
			for(DepartamentoDTO departamento : departamentoDTOList) {
				departamento.setEstadoPago(this.verificarPago(departamento.getId()));
			}
		}
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
			if(alicuota!=null && alicuota.getValorPagado()!=null && alicuota.getValorPagado().compareTo(alicuota.getValorAlicuota())==0) {
				estado = Constantes.ESTADO_PAGADO;
			}
		}
		return estado;
	}
	

	public List<AlicuotaDTO> alicuotasPendientes(Integer idDepartamento){
		DepartamentoDTO departamento = this.departamentoServicio.findById(idDepartamento);
		this.idAlicuotaPagoCol = new ArrayList<>();
		
		return this.alicuotaServicio.findByDepartamentoDTOAndValorPagadoIsNull(departamento);
	}
	
	public List<AlicuotaDTO> obtenerAlicuotas(Integer idDepartamento){
		DepartamentoDTO departamento = this.departamentoServicio.findById(idDepartamento);
		this.idAlicuotaPagoCol = new ArrayList<>();
		return this.alicuotaServicio.findByDepartamentoDTO(departamento);
	}
	
	
	public void guardar() {
    	try {
    		if(CollectionUtils.isNotEmpty(idAlicuotaPagoCol)) {
    			for(AlicuotaDTO alicuota : this.idAlicuotaPagoCol) {
    				alicuota.setFechaPago(new Date());
    				alicuota.setValorPagado(alicuota.getValorAlicuota());
    				alicuota.setUsuario(this.sessionController.getNombreUsuarioLogueado());
    				this.alicuotaServicio.actualizarAlicuota(alicuota);
    			}
    			JsfUtil.addSuccessMessage("Pago guardado correctamente");
    			this.imprimir();
    			this.inicializar();
    		}else {
    			JsfUtil.addErrorMessage("Debe seleccionar al menos una alicuota");
    		}
     	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo guardar el pago de la alicuota");
		}
    }

	public void seleccionarAlicuota(Integer id) {
		this.alicuotaSelectedDTO = this.alicuotaServicio.findById(id);
		this.alicuotaSelectedDTO.setDepartamentoDTO(departamentoSelectedDTO);
	}
	
	private boolean validarRegistro() {
		boolean estadoRegistro = true;
		if(alicuotaSelectedDTO == null) {
			estadoRegistro = false;
		}else if(alicuotaSelectedDTO.getValorPagado()==null || alicuotaSelectedDTO.getValorPagado().compareTo(alicuotaSelectedDTO.getValorAlicuota())!= 0) {
			estadoRegistro = false;
			JsfUtil.addErrorMessage("El valor del pago debe ser igual al de la alicuota");
		}
		return estadoRegistro;
	}

	public void filtrar() {
		
	}

	   
    public void imprimir() throws Exception {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String filename = "Recibo.pdf";
        String jasperPath ="/resources/recibo.jasper";
        Map<String, Object> parametros = new HashMap<>(); 
        parametros.put("departamento", idAlicuotaPagoCol.iterator().next().getDepartamentoDTO().getBloque() 
        		+ " " + idAlicuotaPagoCol.iterator().next().getDepartamentoDTO().getNumero());
        parametros.put("propietario", idAlicuotaPagoCol.iterator().next().getDepartamentoDTO().getPropietarioDTO().getNombre() 
        		+ " "+ idAlicuotaPagoCol.iterator().next().getDepartamentoDTO().getPropietarioDTO().getApellido());
        parametros.put("cedula", idAlicuotaPagoCol.iterator().next().getDepartamentoDTO().getPropietarioDTO().getCedula());
        
        String mensajePago = "Recibo por concepto de pago de alicuota de los meses: " + this.obtenerMesesPagadosAlicuotas();
        parametros.put("mensaje", mensajePago);
        parametros.put("pago", this.obtenerTotalAlicuotas());
        parametros.put("usuario", idAlicuotaPagoCol.iterator().next().getUsuario());
        parametros.put("fecha", formatDate.format(idAlicuotaPagoCol.iterator().next().getFechaPago()));
        this.generarPDF(parametros, jasperPath, filename);
    }
            

    private BigDecimal obtenerTotalAlicuotas() {
    	BigDecimal total = BigDecimal.ZERO;
    	for(AlicuotaDTO alicuota : idAlicuotaPagoCol) {
    		total = total.add(alicuota.getValorAlicuota());
    	}
    	return total;
	}

	private String obtenerMesesPagadosAlicuotas() {
		String mensaje = "";
    	for(AlicuotaDTO alicuota : idAlicuotaPagoCol) {
    		mensaje = mensaje + alicuota.getMes() + " "+alicuota.getAnio() +", "; 
    	}
    	mensaje = mensaje.substring(0, mensaje.length()-2);
		return mensaje;
	}

	public void generarPDF(Map<String, Object> params, String jasperPhath,  String fileName ) throws JRException, IOException {
        String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPhath);
        File file = new File(relativeWebPath);
        List<JRDataSource> datasurce = new ArrayList<>();
        datasurce.add(new JREmptyDataSource(1));
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(datasurce, false);
        //JasperReport reporte= JasperCompileManager.compileReport(file.getPath());
        //JasperPrint print = JasperFillManager.fillReport(reporte, params, source);
        JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, source);
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition","attachment;filename="+ fileName);
        ServletOutputStream stream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(print, stream);
        FacesContext.getCurrentInstance().responseComplete();
        
    }

    public BigDecimal sumarTotalAlicuotas(SelectEvent e){
    	AlicuotaDTO alicuotaDTO = (AlicuotaDTO)e.getObject();
    	totalAlicuotas = totalAlicuotas.add(alicuotaDTO.getValorAlicuota());
    	return totalAlicuotas;
    }
    
    public void inicializarTotal() {
    	this.idAlicuotaPagoCol = new ArrayList<>();
    	this.totalAlicuotas = BigDecimal.ZERO;
    }
    
    public BigDecimal restarTotalAlicuotas(UnselectEvent e){
    	AlicuotaDTO alicuotaDTO = (AlicuotaDTO)e.getObject();
    	totalAlicuotas = totalAlicuotas.subtract(alicuotaDTO.getValorAlicuota());
    	return totalAlicuotas;
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
	 * @return the departamentoFilteredDTOList
	 */
	public List<DepartamentoDTO> getDepartamentoFilteredDTOList() {
		return departamentoFilteredDTOList;
	}

	/**
	 * @param departamentoFilteredDTOList the departamentoFilteredDTOList to set
	 */
	public void setDepartamentoFilteredDTOList(List<DepartamentoDTO> departamentoFilteredDTOList) {
		this.departamentoFilteredDTOList = departamentoFilteredDTOList;
	}

	/**
	 * @return the idAlicuotaPagoCol
	 */
	public List<AlicuotaDTO> getIdAlicuotaPagoCol() {
		return idAlicuotaPagoCol;
	}

	/**
	 * @param idAlicuotaPagoCol the idAlicuotaPagoCol to set
	 */
	public void setIdAlicuotaPagoCol(List<AlicuotaDTO> idAlicuotaPagoCol) {
		this.idAlicuotaPagoCol = idAlicuotaPagoCol;
	}

	/**
	 * @return the totalAlicuotas
	 */
	public BigDecimal getTotalAlicuotas() {
		return totalAlicuotas;
	}

	/**
	 * @param totalAlicuotas the totalAlicuotas to set
	 */
	public void setTotalAlicuotas(BigDecimal totalAlicuotas) {
		this.totalAlicuotas = totalAlicuotas;
	}
}
