package com.devsuperior.dsmeta.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsuperior.dsmeta.dtos.SaleSumDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleMaxProjection;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	/**
	 * Esse metodo a consulta sql está personalizada para roda no banco h2
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	@Query("SELECT new com.devsuperior.dsmeta.dtos.SaleSumDTO(SUM(s.amount), s.seller.name) "
			+ "FROM Sale s "
			+ "WHERE s.date BETWEEN :minDate AND :maxDate "
			+ "GROUP BY s.seller.name "
			+ "ORDER BY s.seller.name ASC")
		List<SaleSumDTO> getSummary(@Param("minDate") String minDate, @Param("maxDate") String maxDate);



	/**
	 * Esse metodo a consulta sql está personalizada para roda no banco h2
	 * @param minDate
	 * @param maxDate
	 * @param name
	 * @param pageable
	 * @return
	 */
	@Query(nativeQuery = true, value = "SELECT tb_sales.id, "
			+ "tb_sales.date, "
			+ "COALESCE (SUM(tb_sales.amount), 0), "
			+ "tb_seller.name "
			+ "FROM tb_sales "
			+ "INNER JOIN tb_seller ON tb_seller.id = tb_sales.seller_id "
			+ "WHERE tb_sales.date "
			+ "BETWEEN PARSEDATETIME(:minDate, 'yyyy-MM-dd') "
			+ "AND PARSEDATETIME(:maxDate, 'yyyy-MM-dd') "
			+ "AND UPPER(tb_seller.name) LIKE UPPER (CONCAT('%', :name, '%')) "
			+ "GROUP BY tb_seller.name, tb_sales.id, tb_sales.date "
			+ "ORDER BY tb_sales.id ASC")
	Page<SaleMaxProjection> getReport(@Param("minDate") String minDate, @Param("maxDate") String maxDate,@Param("name") String name, Pageable pageable);
	
}
