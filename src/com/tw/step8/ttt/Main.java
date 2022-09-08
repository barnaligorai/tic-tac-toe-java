package com.tw.step8.ttt;

import com.tw.step8.ttt.model.Game;
import com.tw.step8.ttt.model.Player;
import com.tw.step8.ttt.symbol.Symbol;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Player player1 = new Player("Ramesh", Symbol.X);
    Player player2 = new Player("Suresh", Symbol.O);
    Player[] players = new Player[]{player1, player2};

    Game game = new Game(players);

    System.out.println(game.displayCells());
    Scanner scanner = new Scanner(System.in);

    while(!game.isGameOver()) {
      System.out.println("Enter position");
      int cellPos = Integer.parseInt(scanner.next());
      game.play(cellPos);
      System.out.println(game.displayCells());
    }

    scanner.close();
    System.out.println("game over");
  }

}