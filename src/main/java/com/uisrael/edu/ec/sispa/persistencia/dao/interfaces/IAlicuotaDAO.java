/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.AlicuotaDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.DepartamentoDTO;

/**
 * @author Jorge
 *
 */
public interface IAlicuotaDAO  extends JpaRepository<AlicuotaDTO, Long>{

	/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<AlicuotaDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(AlicuotaDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	AlicuotaDTO findById(Integer id);
	
	/**
	 * Contar por estado
	 * @param estado
	 * @return
	 */
	long countByEstado(String estado);
	
	/**
	 * Guardar entidad
	 * @param entity
	 * @return
	 */
	@Transactional
	AlicuotaDTO save(AlicuotaDTO entity);

	/**
	 * Busca alicuotas por anio
	 * @param anio
	 * @return
	 */
	List<AlicuotaDTO> findByAnio(String anio);

	/**
	 * @param anio
	 * @param usuario
	 * @param valorAlicuota
	 */
	@Transactional
	@Modifying
	@Query("insert into AlicuotaDTO(anio, estado, mes, usuario, valorAlicuota, departamentoDTO) " + 
			"select ?1, a.estado, a.mes, ?2, ?3, a.departamentoDTO " + 
			"from AlicuotaDTO a where a.anio ='2020' order by a.id")
	void insertNuevoAnio(String anio, String usuario, BigDecimal valorAlicuota);

	/**
	 * Busca los departamentos activos
	 * @param estadoActivo
	 * @return
	 */
	@Query(" from DepartamentoDTO d inner join d.propietarioDTO p "
			+ " where d.estado = ?1 ")
	public List<DepartamentoDTO> buscarDepartamentosActivos(String estadoActivo);

	/**
	 * 
	 * @param departamento
	 * @return
	 */
	public List<AlicuotaDTO> findByDepartamentoDTOOrderById(DepartamentoDTO departamento);

	/**
	 * 
	 * @param departamento
	 * @return
	 */
	public List<AlicuotaDTO> findByDepartamentoDTOAndValorPagadoIsNullOrderById(DepartamentoDTO departamento);
}