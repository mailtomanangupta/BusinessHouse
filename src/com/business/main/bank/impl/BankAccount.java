package com.business.main.bank.impl;

import com.business.main.bank.Account;
import com.business.main.player.IPlayer;

public class BankAccount implements Account {

    private int balance;
    private IPlayer player;
    String accountId;

    public BankAccount(int balance, IPlayer player) {
        this.balance = balance;
        this.player = player;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void credit(int amount) {
        this.balance += amount;
    }

    public void debit(int amount) {
        this.balance -= amount;
    }

    @Override
    public IPlayer getOwner() {
        return this.player;
    }

    @Override
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
