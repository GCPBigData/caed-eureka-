package com.multbroker.corretoras.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.multbroker.corretoras.dto.BrokerageAccountDTO;
import com.multbroker.corretoras.repository.BrokerageAccountRepository;
import com.multbroker.corretoras.repository.BrokerageRepository;
import com.multbroker.models.BrokerageAccount;
import com.multbroker.models.UserEntity;

@Service
public class BrokerageAccountService {
	
	BrokerageAccountRepository account;
	
	BrokerageRepository brokerageRepository;
	
	@Autowired
	public BrokerageAccountService(BrokerageAccountRepository repository,BrokerageRepository brokerageRepository) {
		account = repository;
		this.brokerageRepository = brokerageRepository;
		
	}

	public BrokerageAccountDTO findAccountById(Long idAccount) {
		
		BrokerageAccount brokerAccount = account.findById(idAccount).get();
		
		BrokerageAccountDTO dto = new BrokerageAccountDTO();
		
		dto.setId(brokerAccount.getId());
		dto.setUserId(brokerAccount.getUser().getId());
		dto.setBrokerageId(brokerAccount.getBrokerage().getId());
		dto.setBrokerageName(brokerAccount.getBrokerage().getName());
		dto.setLoginEmail(brokerAccount.getLoginEmail());
		dto.setLoginAccessCode(brokerAccount.getLoginAccessCode());
		dto.setLoginCpf(brokerAccount.getLoginCpf());
		dto.setLoginPassword(brokerAccount.getLoginPassword());
		dto.setIssDay(brokerAccount.getIssDay());
		dto.setIssSwing(brokerAccount.getIssSwing());
		dto.setSignature(brokerAccount.getSignature());
		dto.setSwingTrade(brokerAccount.getSwingTrade());
		dto.setDayTrade(brokerAccount.getDayTrade());
		
		return dto;
		
	}
	
	public List<BrokerageAccountDTO> findAllByUser(Long idUsuario){
		
		List<BrokerageAccountDTO> dtos = new ArrayList<BrokerageAccountDTO>();
		
		// TODO Colocar Model MAPPER DEPOIS
		List<BrokerageAccount> lista = account.findByUserId(idUsuario);	
		
		for(BrokerageAccount broker : lista) {
			
			BrokerageAccountDTO dto = new BrokerageAccountDTO();
			
			dto.setId(broker.getId());
			dto.setUserId(broker.getUser().getId());
			dto.setBrokerageId(broker.getBrokerage().getId());
			dto.setBrokerageName(broker.getBrokerage().getName());
			dto.setLoginEmail(broker.getLoginEmail());
			dto.setLoginAccessCode(broker.getLoginAccessCode());
			dto.setLoginCpf(broker.getLoginCpf());
			dto.setLoginPassword(broker.getLoginPassword());
			dto.setIssDay(broker.getIssDay());
			dto.setIssSwing(broker.getIssSwing());
			dto.setSignature(broker.getSignature());
			dto.setSwingTrade(broker.getSwingTrade());
			dto.setDayTrade(broker.getDayTrade());

			dtos.add(dto);			
			
		}
		
		
		return 	dtos;
		
	}
	
	public BrokerageAccount save(BrokerageAccount broker) {
		
		final String uri = "http://localhost/zuul/users/users/findbyid/"+broker.getUserId();
		
	    RestTemplate restTemplate = new RestTemplate();
	     
	    UserEntity result = restTemplate.getForObject(uri, UserEntity.class);
	     
	    broker.setUser(result);	
	    broker.setBrokerage(brokerageRepository.findById(broker.getBrokerageId()).get());
	    
	    account.save(broker);
		
		return broker;
	}

}
