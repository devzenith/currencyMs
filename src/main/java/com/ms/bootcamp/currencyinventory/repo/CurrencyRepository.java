package com.ms.bootcamp.currencyinventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ms.bootcamp.currencyinventory.model.Currency;

@Component
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
