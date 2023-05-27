package com.atovio.bank.service.impl;

import com.atovio.bank.dao.AccountDao;
import com.atovio.bank.dao.impl.AccountDaoImpl;
import com.atovio.bank.exceptions.MoneyNotEnoughException;
import com.atovio.bank.exceptions.TransferException;
import com.atovio.bank.pojo.Account;
import com.atovio.bank.service.AccountService;
import com.atovio.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Objects;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class AccountServiceImpl implements AccountService {

    // private final AccountDao accountDao = new AccountDaoImpl();

    // 在mybatis中，可以为我们动态生成dao的接口类(dao接口的代理类）
    // 使用mybatis代理机制的前提是：SqlMapper.xml文件中的namespace必须为全限定名称，id必须为接口中的方法名。
    private AccountDao accountDao = SqlSessionUtil.OpenSession().getMapper(AccountDao.class);

    @Override
    public void transfer(String fromActnu, String toActnu, double money) throws MoneyNotEnoughException, TransferException {

        if (Objects.equals(fromActnu, toActnu)) {
            throw new TransferException("转出账户与转入账户相同！！");
        } else {

            // 添加事务管理机制代码
            SqlSession sqlSession = SqlSessionUtil.OpenSession();

            // 1. 判断余额是否充足
            Account fromAct = accountDao.selectByActnu(fromActnu);
            if (fromAct.getBalance() < money) {
                // 2. 余额不足，抛异常
                throw new MoneyNotEnoughException("对不起，余额不足！");
            }
            // 3. 充足，更新转出账户余额
            Account toAct = accountDao.selectByActnu(toActnu);
            fromAct.setBalance(fromAct.getBalance() - money);
            toAct.setBalance(toAct.getBalance() + money);

            int count = 0;
            count += accountDao.updateByActnu(fromAct);

            // 模拟异常
            /*String s = null;
            s.toString();*/

            // 4. 更新转入账户余额
            count += accountDao.updateByActnu(toAct);

            if (count != 2) {
                throw new TransferException("转账异常，原因未知");
            }
            // 提交事务
            sqlSession.commit();
            // 关闭资源
            SqlSessionUtil.close(sqlSession);
        }
    }
}
