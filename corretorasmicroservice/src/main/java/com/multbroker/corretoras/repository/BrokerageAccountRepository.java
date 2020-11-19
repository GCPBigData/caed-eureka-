package com.multbroker.corretoras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.multbroker.models.BrokerageAccount;

public interface BrokerageAccountRepository extends CrudRepository<BrokerageAccount, Long>{
	
	@Query("select b from BrokerageAccount b where b.user.id = :id")
	List<BrokerageAccount> findByUserId(@Param("id")Long userId);
}
