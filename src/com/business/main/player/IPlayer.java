package com.business.main.player;

import com.business.main.bank.Account;
import com.business.main.entity.Cell;

public interface IPlayer {

    void rollTheDice();

    int numOfChances();

    void doAction(Cell cell);

    String getPlayerName();

    String getAccountId();

    void setAccountId(String accountId);

    Account getAccount();

}
