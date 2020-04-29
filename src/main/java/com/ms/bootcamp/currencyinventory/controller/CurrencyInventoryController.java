package com.ms.bootcamp.currencyinventory.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.bootcamp.currencyinventory.model.Currency;
import com.ms.bootcamp.currencyinventory.service.CurrencyInventoryService;


@RestController
@RefreshScope
public class CurrencyInventoryController {
	
	@Autowired
	CurrencyInventoryService service;
	
	@GetMapping("/conversionfactors")
	public List<Currency> getAllConversionfactors(){
		
		return service.getAllConversionFactors();
		
	}
	
	@GetMapping("/conversionfactors/{isoCode}")
	public ResponseEntity<Currency> getProduct(@PathVariable String isoCode) {
		Currency c = service.getConvfactorByCountry(isoCode);
		if (c != null) {
			return new ResponseEntity<Currency>(c, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Currency>(HttpStatus.NOT_FOUND);
		}
	}

}
