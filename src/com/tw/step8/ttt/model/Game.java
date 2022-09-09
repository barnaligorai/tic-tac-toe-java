package com.tw.step8.ttt.model;

import com.tw.step8.ttt.exception.CellNotVacantException;
import com.tw.step8.ttt.view.GameVisitor;
import com.tw.step8.ttt.view.Visitor;

import java.util.Objects;

public class Game {
  private static final int[][] winningCombination = {
          {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
          {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
          {0, 4, 8}, {2, 4, 6}};
  private final Player[] players;
  private final String[] cells = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
  private int currentPlayerIndex;
  private int movesPlayed = 0;
  private boolean isGameOver = false;
  private boolean isGameDrawn = false;

  public Game(Player[] players) {
    this.players = players;
    this.currentPlayerIndex = 0;
  }

  public Player currentPlayer() {
    return this.players[currentPlayerIndex];
  }

  private void changePlayer() {
    this.currentPlayerIndex = (this.currentPlayerIndex + 1) % 2;
  }

  private void markCell(int cellIndex) {
    this.cells[cellIndex] = String.valueOf(this.currentPlayer().getSymbol());
    this.movesPlayed += 1;
  }

  private boolean isPositionOccupied(int cellPos) throws CellNotVacantException {
    return this.cells[cellPos].matches("[XO]");
  }

  public void play(int cellPosition) throws CellNotVacantException {
    if (isPositionOccupied(cellPosition)) {
      throw new CellNotVacantException(cellPosition);
    }

    this.markCell(cellPosition);

    if (this.isOver()) {
      return;
    }

    this.changePlayer();
  }

  private boolean isEvery(int[] winningComboIndices, String expectedSymbol) {
    for (int index : winningComboIndices) {
      String actualSymbol = this.cells[index];
      if (!Objects.equals(actualSymbol, expectedSymbol)) {
        return false;
      }
    }
    return true;
  }

  private boolean hasPlayerWon() {
    String symbol = String.valueOf(this.currentPlayer().getSymbol());

    for (int[] combination : winningCombination) {
      if (isEvery(combination, symbol)) {
        this.isGameOver = true;
        return true;
      }
    }
    return false;
  }

  private boolean isOver() {
    return this.hasPlayerWon() || this.isDrawn();
  }

  private boolean isDrawn() {
    if(this.movesPlayed >= 9 && !this.hasPlayerWon()){
     this.isGameDrawn = true;
      this.isGameOver = true;
      return true;
    };
    return false;
  }

  public boolean isGameOver() {
    return isGameOver;
  }

  public String[] getCells() {
    return cells;
  }

  public boolean isGameDrawn() {

    return isGameDrawn;
  }

  public void accept(GameVisitor visitor) {
    visitor.visitGame(this);
  }

  public Player[] getPlayers() {

    return this.players;
  }
}