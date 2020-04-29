package com.ms.bootcamp.currencyinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ms.bootcamp.currencyinventory.model.Currency;
import com.ms.bootcamp.currencyinventory.repo.CurrencyRepository;

@Service
public class CurrencyInventoryService {
	
	@Autowired
	CurrencyRepository repo;
	
	public List<Currency> getAllConversionFactors(){
		
		 return repo.findAll();		
		
	}
	
	public Currency getConvfactorByCountry(String isoCode) {
		
		System.out.println("Country code at service >>>>>>>>>>>>> " + isoCode);
		Currency c = new Currency();
		c.setCountryCode(isoCode);
		c.setConversionFactor(71.0);
		Example<Currency> example = Example.of(c);
		Optional<Currency> op = repo.findOne(example);
		
		System.out.println("op.isPresent() >>>>>>> " + op.isPresent());
		if(op.isPresent()) {
			return op.get();
		}
		else return null;
		
	}

}
