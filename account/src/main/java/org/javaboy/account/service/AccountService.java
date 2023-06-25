package org.javaboy.account.service;

import org.javaboy.account.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/20 8:52
 */
@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    public boolean deductAccount(String account, Double money) {
        Double m = accountMapper.getMoneyByAccount(account);
        if (m < money) {
            throw new RuntimeException("账户余额不足");
        }
        int i = accountMapper.updateAccount(account, money);
        return i == 1;
    }
}
