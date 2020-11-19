package com.multbroker.corretoras.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.multbroker.models.Brokerage;

public interface BrokerageRepository extends CrudRepository<Brokerage, Long> {
	
	@Query("select b from Brokerage b")
	public List<Brokerage> findAll(PageRequest pageRequest);

	@Query("select b from Brokerage b  where b.name like CONCAT(?1, '%')")
	public List<Brokerage> findByName(String name);
	
	public List<Brokerage> findByCnpj(String cnpj);

    // SELECT t.name, t.iss, t.swing_trade, t.day_trade FROM multbroker.brokerage t ORDER BY  id DESC LIMIT 1
	  @Query("select b from Brokerage b where b.id > 1 order by b.id desc")
	  List<Brokerage> findByPainel();

}
