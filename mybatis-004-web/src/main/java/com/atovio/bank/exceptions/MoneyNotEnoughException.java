package com.atovio.bank.exceptions;

/**
 * 余额不足异常。
 *
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class MoneyNotEnoughException extends Exception {
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String s) {
        super(s);
    }
}
