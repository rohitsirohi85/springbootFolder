package com.CorrencyConverter.CorrencyConverter.service;

import com.CorrencyConverter.CorrencyConverter.Dto.CurrencyApiResponseDto;
import com.CorrencyConverter.CorrencyConverter.Dto.CurrencyConversionResponseDto;
import com.CorrencyConverter.CorrencyConverter.entity.CurrencyConversion;
import com.CorrencyConverter.CorrencyConverter.repo.CurrencyConversionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyConversionService {

    private final RestClient restClient;
    private final CurrencyConversionRepo currencyConversionRepo;
    private final ModelMapper modelMapper;

    @Value("${currency.api.url}")
    private String api_url;

    @Value("${currency.api.key}")
    private String api_key;

    public CurrencyConversionResponseDto getConversion(String fromCurrency, String toCurrency, Double amount) {
          log.info("start checking the third party url");
        // 1. Build final URL dynamically using values from properties

    String finalUrl = api_url+"?apikey="+api_key+"&currencies="+toCurrency.toUpperCase()
            +"&base_currency="+fromCurrency.toUpperCase();

    // 2 Make Api Call
          CurrencyApiResponseDto responseDto = null;
        try{
            log.info("trying to fetch the url to third party api server");
           responseDto = restClient.get().uri(finalUrl).retrieve().body(CurrencyApiResponseDto.class);
        }catch (Exception e){
            log.error("error occurred : ",e);
        }


        // getting the value or rate of conversion currency
         log.info("getting the value of " + toCurrency.toUpperCase());
        Double rate = responseDto.getData().get(toCurrency.toUpperCase());

        // convert the total amount

        Double convertedAmount = rate*amount;

        // save the currency

        CurrencyConversion currencyConversion = CurrencyConversion.builder()
                .fromCurrency(fromCurrency.toUpperCase())
                .toCurrency(toCurrency.toUpperCase())
                .amount(amount)
                .convertedAmount(convertedAmount)
                .build();

        log.info("saving the data in repo");

         CurrencyConversion savedCurrencyConversion = currencyConversionRepo.save(currencyConversion);

        // map to entity to dto

        log.info("now the data will be stored and response is completed");
        return modelMapper.map(savedCurrencyConversion, CurrencyConversionResponseDto.class);



    }
}
