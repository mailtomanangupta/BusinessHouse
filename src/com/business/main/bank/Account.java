package com.business.main.bank;

import com.business.main.player.IPlayer;

public interface Account {

    int getBalance();

    void credit(int amount);

    void debit(int amount);

    IPlayer getOwner();

    String getAccountId();
}
