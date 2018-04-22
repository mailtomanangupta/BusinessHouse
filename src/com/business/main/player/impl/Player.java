package com.business.main.player.impl;

import com.business.main.bank.Account;
import com.business.main.bank.BankManager;
import com.business.main.entity.Cell;
import com.business.main.player.IPlayer;

import static com.business.main.util.Constants.MAXIMUM_CHANCES;

public class Player implements IPlayer {

    private int chance = 0;
    private String playerName;
    private String accountId;
    private BankManager bankManager;

    public Player(String name, BankManager bankManager) {
        this.playerName = name;
        this.bankManager = bankManager;
    }

    @Override
    public void rollTheDice() {
        if (chance < MAXIMUM_CHANCES) {
            ++chance;
        } else {
            throw new UnsupportedOperationException("A IPlayer can play maximum 10 chances");
        }
    }

    @Override
    public int numOfChances() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void doAction(Cell cell) {
        cell.transact(getAccount());
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public Account getAccount() {
        return bankManager.getAccount(accountId);
    }
}
