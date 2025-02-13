package com.codingshuttle.cachingApp.services.impl;

import com.codingshuttle.cachingApp.entities.Employee;
import com.codingshuttle.cachingApp.entities.SalaryAccount;
import com.codingshuttle.cachingApp.repositories.SalaryAccountRepo;
import com.codingshuttle.cachingApp.services.SalaryAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SalaryAccountServiceImpl implements SalaryAccountService {

    private final SalaryAccountRepo salaryAccountRepo;

    @Override
    public void createAccount(Employee employee) {

        if (employee.getName().equals("rohit"))throw new RuntimeException("rohit is not allowed for a salary account");

        SalaryAccount salaryAccount = SalaryAccount.builder()
                .employee(employee)
                .balance(BigDecimal.ZERO)
                .build();

        salaryAccountRepo.save(salaryAccount);
    }

    @Override
    @Transactional
//    @Transactional(isolation = Isolation.SERIALIZABLE)  /// to make a sequential call for  method so data is consistent and not concurrent when many api calls happen at the same time
    public SalaryAccount incrementBalance(Long accountId) {
        SalaryAccount salaryAccount = salaryAccountRepo.findById(accountId).orElseThrow(()->new RuntimeException("not found"));
        BigDecimal prevBalance = salaryAccount.getBalance();
        BigDecimal newBalance = prevBalance.add(BigDecimal.valueOf(10L));
        salaryAccount.setBalance(newBalance);
        return salaryAccountRepo.save(salaryAccount);
    }
}
