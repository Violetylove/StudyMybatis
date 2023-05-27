package com.atovio.bank.exceptions;

/**
 * 转账异常
 *
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class TransferException extends Exception {
    public TransferException() {
    }

    public TransferException(String s) {
        super(s);
    }
}
