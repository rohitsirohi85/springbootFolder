package com.Week2HHomeWork.demo.service;

import com.Week2HHomeWork.demo.entity.PocketMoney;
import com.Week2HHomeWork.demo.entity.Student;
import com.Week2HHomeWork.demo.repo.PocketMoneyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PocketMoneyService {

    private final PocketMoneyRepo pocketMoneyRepo;


    public void createPocketMoneyAccount(Student student){
        PocketMoney pocketMoney = PocketMoney.builder()
                .student(student)
                .balance(BigDecimal.ZERO)
                .build();

        pocketMoneyRepo.save(pocketMoney);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public PocketMoney incrementBalance(Long accountId) {
    PocketMoney pocketMoney = pocketMoneyRepo.findById(accountId).orElseThrow(null);
    BigDecimal prevBal = pocketMoney.getBalance();
    BigDecimal addBal = prevBal.add(BigDecimal.valueOf(10L));
    pocketMoney.setBalance(addBal);
    return pocketMoneyRepo.save(pocketMoney);
    }
}
