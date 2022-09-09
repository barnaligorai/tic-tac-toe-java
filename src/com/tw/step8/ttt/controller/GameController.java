package com.tw.step8.ttt.controller;

import com.tw.step8.ttt.model.Visitor;
import com.tw.step8.ttt.view.GameInput;
import com.tw.step8.ttt.view.Renderer;
import com.tw.step8.ttt.exception.CellNotVacantException;
import com.tw.step8.ttt.exception.InvalidCellException;
import com.tw.step8.ttt.model.Game;

import java.io.IOException;

public class GameController {
  private final Game game;
  private final GameInput gameInput;
  private final Renderer renderer;

  public GameController(Game game, GameInput gameInput, Renderer renderer) {
    this.game = game;
    this.gameInput = gameInput;
    this.renderer = renderer;
  }

  public void start() throws IOException {
    Visitor visitor = new Visitor();

    game.accept(visitor);
    this.renderer.displayBoard(visitor);

    while (!this.game.isGameOver()){
      this.displayPrompt();
      try {
        int cellPos = gameInput.getPos();
        game.play(cellPos - 1);

        game.accept(visitor);
        this.displayBoard(visitor);
      } catch (InvalidCellException | CellNotVacantException e) {
        this.renderer.showError(e);
      }
    }

    game.accept(visitor);
    this.renderer.diplayResult(visitor);
    this.stop();
  }

  private void displayPrompt() throws IOException {
    this.renderer.showPrompt(this.game.currentPlayer().getName());
  }

  private void displayBoard(Visitor visitor) throws IOException {
    this.renderer.displayBoard(visitor);
  }

  public void stop() {
    this.gameInput.stop();
  }
}
