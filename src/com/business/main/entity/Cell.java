package com.business.main.entity;

import com.business.main.bank.Account;

public interface Cell {

    void transact(Account account);

    String getCellValue();

}
