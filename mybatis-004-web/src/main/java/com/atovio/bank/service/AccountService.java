package com.atovio.bank.service;

import com.atovio.bank.exceptions.MoneyNotEnoughException;
import com.atovio.bank.exceptions.TransferException;

/**
 * 账户业务类，负责处理业务
 *
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 * @since 1.0
 */
public interface AccountService {

    /**
     * 账户转账业务
     *
     * @param fromActnu 转出账号
     * @param toActnu   转入账号
     * @param money     转账金额
     */
    void transfer(String fromActnu, String toActnu, double money) throws MoneyNotEnoughException, TransferException;
}
