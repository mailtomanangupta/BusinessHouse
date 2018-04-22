package com.business.main.entity.impl;

import com.business.main.bank.Account;
import com.business.main.bank.BankManager;
import com.business.main.bank.impl.CentralBank;
import com.business.main.util.HotelRating;

public class HotelCell extends AbstractCell {

    private String name;
    private HotelRating hotelRating;
    private boolean purchased;
    private String accountId;

    private final String cellValue = "H";

    public HotelCell(HotelRating rating, String name, BankManager bankManager) {
        this.hotelRating = rating;
        this.name = name;
        this.bankManager = bankManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelRating getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(HotelRating hotelRating) {
        this.hotelRating = hotelRating;
    }

    public void upgradeRating() {
        this.hotelRating = this.hotelRating.upgrade();
    }

    public int getUpgradationCost() {
        return this.hotelRating.getUpgradationCost();
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    @Override
    public void transact(Account playerAccount) {
        if (isPurchased()) {
            if (playerAccount.getOwner().getPlayerName().equalsIgnoreCase(getAccount(accountId).getOwner().getPlayerName())) {
                playerAccount.debit(hotelRating.getUpgradationCost());
                creditToAccount(hotelRating.getUpgradationCost(), getAccount(accountId));
            } else {
                playerAccount.debit(hotelRating.getRent());
                getAccount(accountId).credit(hotelRating.getRent());
            }
        } else {
            playerAccount.debit(hotelRating.getValue());
            creditToAccount(hotelRating.getValue(), getAccount(accountId));
            purchased = true;
            this.setAccountId(playerAccount.getAccountId());
        }
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String getCellValue() {
        return cellValue;
    }

    private void payToCentralBank(int amount) {
        CentralBank.getInstance().credit(amount);
    }
}
