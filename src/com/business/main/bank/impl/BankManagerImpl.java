package com.business.main.bank.impl;

import com.business.main.bank.Account;
import com.business.main.bank.BankManager;
import com.business.main.player.IPlayer;
import com.business.main.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class BankManagerImpl implements BankManager {

    private Map<String, Account> accountMap = new HashMap<>();

    @Override
    public String createAnAccount(int initialBalance, IPlayer player) {
        String accountId = player.getPlayerName() + "_acc";
        BankAccount account = new BankAccount(initialBalance, player);
        account.setAccountId(accountId);

        accountMap.put(accountId, account);

        return accountId;
    }

    @Override
    public Account getAccount(String accountId) {
        if (StringUtil.isNotEmpty(accountId)) {
            return accountMap.get(accountId);
        }
        return null;
    }

    @Override
    public void creditToCentralBank(int amount) {
        CentralBank.getInstance().credit(amount);
    }

    @Override
    public void debitFromCentralBank(int amount) {
        CentralBank.getInstance().debit(amount);
    }
}
