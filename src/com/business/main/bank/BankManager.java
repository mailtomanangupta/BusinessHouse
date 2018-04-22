package com.business.main.bank;

import com.business.main.player.IPlayer;

public interface BankManager {

    String createAnAccount(int initialBalance, IPlayer player);

    Account getAccount(String accountId);

    void creditToCentralBank(int amount);

    void debitFromCentralBank(int amount);
}
