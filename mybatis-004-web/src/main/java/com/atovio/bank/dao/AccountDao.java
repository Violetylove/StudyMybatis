package com.atovio.bank.dao;

import com.atovio.bank.pojo.Account;

/**
 * 账户的DAO，负责表中数据的CRUD
 *
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 * @since 1.0
 */
public interface AccountDao {

    /**
     * 根据账户名查询账户信息
     *
     * @param actnu 账户名
     * @return 账户信息
     */
    Account selectByActnu(String actnu);

    /**
     * 根据账户名更新账户
     *
     * @param act 账户对象
     * @return 1表示成功，其他表示失败
     */
    int updateByActnu(Account act);

}
