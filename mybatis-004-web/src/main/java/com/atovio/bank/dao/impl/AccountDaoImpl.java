package com.atovio.bank.dao.impl;

import com.atovio.bank.dao.AccountDao;
import com.atovio.bank.pojo.Account;
import com.atovio.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Dao的实现类
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 * @since 1.0
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActnu(String actnu) {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();
        Account account = sqlSession.selectOne("com.atovio.bank.dao.AccountDao.selectByActnu", actnu);
        return account;
    }

    @Override
    public int updateByActnu(Account act) {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();
        int count = sqlSession.update("com.atovio.bank.dao.AccountDao.updateByActnu", act);
        return count;
    }
}
