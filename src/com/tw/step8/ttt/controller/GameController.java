package com.tw.step8.ttt.controller;

import com.tw.step8.ttt.exception.InvalidCellException;
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

  public void start() throws IOException {
    while (!this.game.isGameOver()){

      // view
      this.displayBoard();
      this.displayPrompt();

      String pos = view.read(); // read

      try {
        int cellPos = parsePosition(pos); // validate characters
        validatePosition(cellPos); // validate invalid integers

          game.play(cellPos);

      } catch (Throwable e) {
        this.view.showError(e);
      }

    }

    this.displayBoard();
    this.view.write(game.results());
  }

  private void validatePosition(int cellPos) throws Throwable {
    if (cellPos < 1 || cellPos > 9) {
      throw new InvalidCellException("Invalid cell", cellPos);
    }
  }

  private int parsePosition(String pos) throws Throwable {
    int cellPos;
    try {
      cellPos = Integer.parseInt(pos);
      return cellPos;
    } catch (Throwable e) {
      throw new InvalidCellException("Invalid cell", pos);
    }
  }

  private void displayPrompt() throws IOException {
    this.view.showPrompt(this.game.currentPlayer().getName());
  }

  private void displayBoard() throws IOException {
    this.view.displayBoard(this.game.getCells());
  }

}
