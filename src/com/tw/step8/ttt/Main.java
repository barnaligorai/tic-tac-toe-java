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
    Scanner scanner = new Scanner(System.in);

    while(!game.isGameOver()) {
      playGame(game, scanner);
    }

    scanner.close();
    displayGameResult(game);
  }

  private static void displayGameResult(Game game) {
    System.out.println(game.displayGame());
    System.out.println(game.results());
  }

  private static void playGame(Game game, Scanner scanner) {
    System.out.println(game.displayGame());
    System.out.printf(game.prompt());

    int cellPos = Integer.parseInt(scanner.next());
    game.play(cellPos);
  }
}
