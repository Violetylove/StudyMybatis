package com.atovio.bank.pojo;

/**
 * 账户类，封装账户数据。
 *
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class Account {

    private Long id;
    private String actnu;
    private Double balance;

    public Account() {
    }

    public Account(Long id, String actnu, Double balance) {
        this.id = id;
        this.actnu = actnu;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActnu() {
        return actnu;
    }

    public void setActnu(String actnu) {
        this.actnu = actnu;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actnu='" + actnu + '\'' +
                ", balance=" + balance +
                '}';
    }
}
