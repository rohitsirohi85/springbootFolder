package com.CorrencyConverter.CorrencyConverter.controller;

import com.CorrencyConverter.CorrencyConverter.Dto.CurrencyConversionResponseDto;
import com.CorrencyConverter.CorrencyConverter.service.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencyConvert")
@RequiredArgsConstructor
public class CurrencyConversionController {


    private final CurrencyConversionService currencyConversionService;


    @GetMapping("/from/{fromCurrency}/to/{toCurrency}/unit/{amount}")
    public CurrencyConversionResponseDto getConversion(@PathVariable String fromCurrency,@PathVariable String toCurrency , @PathVariable Double amount){
        return currencyConversionService.getConversion(fromCurrency,toCurrency,amount);
    }


}
