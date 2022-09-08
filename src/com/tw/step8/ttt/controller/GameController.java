package com.tw.step8.ttt.controller;

import com.tw.step8.ttt.model.Game;
import com.tw.step8.ttt.view.View;

import java.io.IOException;

public class GameController {
  private final Game game;
  private final View view;

  public GameController(Game game, View view) {
    this.game = game;
    this.view = view;
  }

  public void print(String text) throws IOException {
    this.view.write(text);
  }

  public void start() throws IOException {
    while (!this.game.isGameOver()){

      this.print(game.displayGame());
      this.print(game.prompt());

      int cellPos = Integer.parseInt(view.read());
      game.play(cellPos);
    }

    this.print(game.displayGame());
    this.print(game.results());
  }
}
