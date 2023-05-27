package com.atovio.bank.dao;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public interface AccountDao {

    void delete();

    int insert(String actnu);

    int update(String actnu, Double money);

    String select(String actnu);
}
