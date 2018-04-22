package com.business.main.entity.impl;

import com.business.main.bank.Account;
import com.business.main.bank.BankManager;
import com.business.main.bank.impl.CentralBank;
import com.business.main.entity.Cell;

public abstract class AbstractCell implements Cell{

    protected BankManager bankManager;

    public abstract void transact(Account account);

    public abstract String getCellValue();

    public void creditToAccount(int amount, Account account) {
        if (account == null) {
            CentralBank.getInstance().credit(amount);
        } else {
            account.credit(amount);
        }
    }

    public void debitFromAccount(int amount, Account account) {
        if (account == null) {
            CentralBank.getInstance().debit(amount);
        } else {
            account.debit(amount);
        }
    }

    protected Account getAccount(String accId) {
        return bankManager.getAccount(accId);
    }
}
