package com.multbroker.corretoras.service;

import com.multbroker.corretoras.repository.BrokerageRepository;
import com.multbroker.models.Brokerage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrokerageService {

	BrokerageRepository repository;

	@Autowired
	public BrokerageService(BrokerageRepository brokerageRepository) {
		this.repository = brokerageRepository;
	}

	/*
	 * public List<Brokerage> search(Integer page, Integer linesPerPage, String
	 * orderBy, String direction) { PageRequest pageRequest = PageRequest.of(page,
	 * linesPerPage, Sort.Direction.valueOf(direction), orderBy); return
	 * repository.findAll(pageRequest); }
	 */
	public List<Brokerage> findByName(String name){
		return repository.findByName(name);
	}
	
	public List<Brokerage> findByCnpj(String cnpj){
		return repository.findByCnpj(cnpj);
	}

	public List<Brokerage> findByPainel(){ return repository.findByPainel(); }

    public List<Brokerage> findAll(){ return (List<Brokerage>) repository.findAll(); }

	public Brokerage save(Brokerage brokerage) {
		return repository.save(brokerage);
	}

	public Brokerage update(Brokerage brokerage) {
		return repository.save(brokerage);
	}

	public Brokerage findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
