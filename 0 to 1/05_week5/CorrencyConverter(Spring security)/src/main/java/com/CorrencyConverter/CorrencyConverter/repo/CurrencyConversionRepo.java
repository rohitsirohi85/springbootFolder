package com.CorrencyConverter.CorrencyConverter.repo;

import com.CorrencyConverter.CorrencyConverter.entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepo extends JpaRepository<CurrencyConversion,Long> {

}
