package com.example.currencygifproviding.repository;

import com.example.currencygifproviding.domain.HistoricalCurrency;
import com.example.currencygifproviding.domain.HistoricalCurrencyId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalCurrencyRepository extends CrudRepository<HistoricalCurrency, HistoricalCurrencyId> {
    public HistoricalCurrency getHistoricalCurrencyById(HistoricalCurrencyId historicalCurrencyId);
}
