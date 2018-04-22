package com.business.main.entity.impl;

import com.business.main.bank.Account;
import com.business.main.bank.BankManager;

import static com.business.main.util.Constants.JAIL_FINE;

public class JailCell extends AbstractCell {

    private String accountId;
    private int amount = JAIL_FINE;
    private final String cellValue = "J";

    public JailCell(BankManager bankManager) {
        this.bankManager = bankManager;
    }

    @Override
    public void transact(Account playerAccount) {
        playerAccount.debit(amount);
        creditToAccount(amount, getAccount(accountId));
    }

    @Override
    public String getCellValue() {
        return cellValue;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
