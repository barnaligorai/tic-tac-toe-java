package com.tw.step8.ttt;

import com.tw.step8.ttt.controller.GameController;
import com.tw.step8.ttt.model.Game;
import com.tw.step8.ttt.model.Player;
import com.tw.step8.ttt.symbol.Symbol;
import com.tw.step8.ttt.view.View;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Player player1 = new Player("Ramesh", Symbol.X);
    Player player2 = new Player("Suresh", Symbol.O);
    Player[] players = new Player[]{player1, player2};
    Game game = new Game(players);

    Scanner scanner = new Scanner(System.in);
    OutputStream out = System.out;
    View view = new View(scanner, out);

    GameController gameController = new GameController(game, view);
    gameController.start();
  }
}
