package com.business.test;

import com.business.main.board.Game;

public class GameTest {

    public static void main(String[] args) {

        String[] cells = {"J", "H", "J", "L", "E", "H", "L", "J", "E"};
        Game game = new Game();
        game.play(6, cells);

    }

}
