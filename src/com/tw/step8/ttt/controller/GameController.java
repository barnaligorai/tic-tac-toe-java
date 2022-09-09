package com.tw.step8.ttt.controller;

import com.tw.step8.ttt.view.Visitor;
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

    this.runGame(visitor);

    game.accept(visitor);
    this.renderer.displayResult(visitor);
    this.stop();
  }

  private void runGame(Visitor visitor) throws IOException {
    while (!this.game.isGameOver()){
      this.displayPrompt(visitor);
      try {
        int cellPos = gameInput.getPos();
        game.play(cellPos - 1);
        game.accept(visitor);
        this.displayBoard(visitor);
      } catch (InvalidCellException | CellNotVacantException e) {
        this.renderer.showError(e);
      }
    }
  }

  private void displayPrompt(Visitor visitor) throws IOException {
    this.renderer.showPrompt(visitor);
  }

  private void displayBoard(Visitor visitor) throws IOException {
    this.renderer.displayBoard(visitor);
  }

  public void stop() {
    this.gameInput.stop();
  }
}
