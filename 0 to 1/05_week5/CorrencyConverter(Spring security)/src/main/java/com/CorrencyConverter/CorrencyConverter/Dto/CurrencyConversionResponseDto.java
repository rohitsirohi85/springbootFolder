package com.CorrencyConverter.CorrencyConverter.Dto;

import com.CorrencyConverter.CorrencyConverter.entity.AuditingEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionResponseDto  {

    private String fromCurrency;
    private String toCurrency;
    private Double amount;
    private Double convertedAmount;
    private LocalDateTime conversionTime;
}
