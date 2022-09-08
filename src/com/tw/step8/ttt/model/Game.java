package com.tw.step8.ttt.model;

import java.util.Arrays;
import java.util.Objects;

public class Game {
  private static final int[][] winningCombination = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
  private final Player[] players;
  private final String[] cells = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
  private int currentPlayerIndex;
  private int movesPlayed = 0;
  private boolean isGameOver = false;
  private boolean isGameDrawn = false;
  private Player won;

  public Game(Player[] players) {
    this.players = players;
    this.currentPlayerIndex = 0;
  }

  public Player currentPlayer(){
    return this.players[currentPlayerIndex];
  }

  private void changePlayer() {
    this.currentPlayerIndex = (this.currentPlayerIndex + 1) % 2;
  }

  private void markCell(int cellPosition) {
    int cellIndex = cellPosition - 1;
    this.cells[cellIndex] = String.valueOf(this.currentPlayer().getSymbol());
    this.movesPlayed += 1;
  }

  public void play(int cellPosition) {
    this.markCell(cellPosition);

    if (this.isOver()) {
      return;
    }
    this.changePlayer();
  }

  private boolean isEvery (int[] winningComboIndices, String expectedSymbol) {

    for (int index : winningComboIndices) {

      String actualSymbol = this.cells[index];
      if (!Objects.equals(actualSymbol, expectedSymbol)) {
        return false;
      }
    }

    return true;
  }
  private boolean isWon() {
    String symbol = String.valueOf(this.currentPlayer().getSymbol());

    for (int[] combination : winningCombination) {
      if (isEvery(combination,symbol)){
        this.won = this.currentPlayer();
        return true;
      }
    }
    return false;
  }

  private boolean isOver(){
    if (this.isWon() || this.isDrawn()) {
      this.isGameOver = true;
      return true;
    }
      return false;
  }

  private boolean isDrawn() {
    return this.movesPlayed >= 9 && !this.isWon();
  }

  public boolean isGameOver() {
    return isGameOver;
  }

  public String results () {
    if (this.isGameOver && this.isDrawn()) {
      this.isGameDrawn = true;
      return "Game ended in a Draw";
    }
   return String.format("%s wins", this.won.getName());
  }

  public String[] getCells() {
    return cells;
  }

  @Override
  public String toString() {
    return "Game{" +
            "players=" + Arrays.toString(players) +
            ", currentPlayer=" + this.currentPlayer() +
            '}';
  }

  public boolean isGameDrawn() {
    return isGameDrawn;
  }
}
