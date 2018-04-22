package com.business.main.board;

import com.business.main.bank.BankManager;
import com.business.main.bank.impl.CentralBank;
import com.business.main.entity.Cell;
import com.business.main.entity.impl.*;
import com.business.main.factory.CellFactory;
import com.business.main.bank.impl.BankManagerImpl;
import com.business.main.player.IPlayer;
import com.business.main.player.impl.Player;
import com.business.main.util.HotelRating;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.business.main.util.Constants.MAXIMUM_CHANCES;
import static com.business.main.util.Constants.PLAYER_INITIAL_BALANCE;

public class Game {

    public void play(int numOfPlayers, String[] cells) {

        List<IPlayer> players = new ArrayList<>();

        CentralBank centralBank = CentralBank.getInstance();
        BankManager bankManager = new BankManagerImpl();

        for (int i = 0; i < numOfPlayers; i++) {
            IPlayer player = new Player("Player - " + (i + 1), bankManager);
            String accountId = bankManager.createAnAccount(PLAYER_INITIAL_BALANCE, player);
            player.setAccountId(accountId);

            players.add(player);
        }

        int maxChancesPerPlayer = MAXIMUM_CHANCES;

        CellFactory cellFactory = new CellFactory();

        createCells(cellFactory, bankManager);

        while (maxChancesPerPlayer > 0) {

            for (IPlayer player : players) {

                player.rollTheDice();
                int num = ThreadLocalRandom.current().nextInt(1, 7);

                Cell cell = cellFactory.getCellType(cells[num]);

                if (cell != null) {
                    player.doAction(cell);
                }
            }

            maxChancesPerPlayer--;
        }

        System.out.println("Winner is - " + getWinner(players).getPlayerName());

        for (IPlayer player : players) {
            System.out.println(player.getPlayerName() + " Bank Balance is - " + player.getAccount().getBalance());
        }
        System.out.println("Central Bank Balance is - " + centralBank.getBalance());
    }

    private IPlayer getWinner(List<IPlayer> players) {
        IPlayer winner = null;

        int maxBalance = 0;

        for (IPlayer player : players) {
            if (player.getAccount().getBalance() > maxBalance) {
                maxBalance = player.getAccount().getBalance();
                winner = player;
            }
        }

        return winner;
    }

    private void createCells(CellFactory cellFactory, BankManager bankManager) {

        List<Cell> cells = new ArrayList<>();

        cells.add(new HotelCell(HotelRating.SILVER, "Radisson", bankManager));
        cells.add(new HotelCell(HotelRating.GOLD, "Taj", bankManager));
        cells.add(new HotelCell(HotelRating.PLATINUM, "Le Meridien", bankManager));

        cells.add(new JailCell(bankManager));

        cells.add(new LotteryCell(bankManager));

        for (Cell cell : cells) {
            cellFactory.addCell(cell);
        }
    }

}
