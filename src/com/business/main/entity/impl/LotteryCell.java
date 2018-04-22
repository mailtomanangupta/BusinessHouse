package com.business.main.entity.impl;

import com.business.main.bank.Account;
import com.business.main.bank.BankManager;

import static com.business.main.util.Constants.LOTTERY_AMOUNT;

public class LotteryCell extends AbstractCell {

    private String accountId;
    private int amount = LOTTERY_AMOUNT;
    private final String cellValue = "L";

    public LotteryCell(BankManager bankManager) {
        this.bankManager = bankManager;
    }

    @Override
    public void transact(Account playerAccount) {
        playerAccount.credit(amount);
        debitFromAccount(amount, getAccount(accountId));
    }

    @Override
    public String getCellValue() {
        return cellValue;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
