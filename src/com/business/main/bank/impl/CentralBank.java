package com.business.main.bank.impl;

import static com.business.main.util.Constants.BANK_INITIAL_BALANCE;

public class CentralBank {

    private static CentralBank centralBankInstance = null;
    private int balance;

    private CentralBank() {
        balance = BANK_INITIAL_BALANCE;
    }

    public static CentralBank getInstance() {
        if (centralBankInstance == null) {
            centralBankInstance = new CentralBank();
        }

        return centralBankInstance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void credit(int amount) {
        this.balance += amount;
    }

    public void debit(int amount) {
        if (hasSufficientFunds(amount)) {
            this.balance -= amount;
        } else {
            throw new UnsupportedOperationException("Insufficient Funds in Central Account");
        }
    }

    private boolean hasSufficientFunds(int amount) {
        return this.balance >= amount;
    }
}
