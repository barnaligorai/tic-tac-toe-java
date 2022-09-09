package com.tw.step8.ttt;

import com.tw.step8.ttt.controller.GameController;
import com.tw.step8.ttt.model.Game;
import com.tw.step8.ttt.model.Player;
import com.tw.step8.ttt.symbol.Symbol;
import com.tw.step8.ttt.view.GameInput;
import com.tw.step8.ttt.view.Renderer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {
  public static void main(String[] args) throws IOException {
    Player player1 = new Player("Ramesh", Symbol.X);
    Player player2 = new Player("Suresh", Symbol.O);
    Player[] players = new Player[]{player1, player2};
    Game game = new Game(players);

    PrintStream out = System.out;
    InputStream inputStream = System.in;
    GameInput gameInput = new GameInput(inputStream);

//    byte[] b = "9 1 5 2 6 3".getBytes();
//    byte[] b = "1 2 3 5 4 7 6 9 8".getBytes();

//    ByteArrayInputStream buff = new ByteArrayInputStream(b);
//    GameInput gameInput = new GameInput(buff);

    Renderer renderer = new Renderer(out);
    GameController gameController = new GameController(game, gameInput, renderer);

    gameController.start();
  }
}
