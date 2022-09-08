package com.tw.step8.ttt.model;

import java.util.Arrays;
import java.util.Objects;

public class Game {
  private static final int[][] winningCombination = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
  private final Player[] players;
  private final String[] cells = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
  private int currentPlayerIndex;
  private boolean isGameOver = false;

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
  }

  public void play(int cellPosition) {
    this.markCell(cellPosition);

    this.isOver();
    this.changePlayer();
  }

  private boolean isEvery (int[] winningCombo, String expectedSymbol) {
    for (int index = 0; index < winningCombo.length; index++) {

      String actualSymbol = this.cells[winningCombo[index]];
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
        return true;
      }
    }
    return false;
  }

  private void isOver(){
    if (this.isWon()) {
      this.isGameOver = true;
    }
  }

  public boolean isGameOver() {
    return isGameOver;
  }
  public String displayCells() {
    return String.format("\n--------\n %s %s %s\n %s %s %s\n %s %s %s\n--------\n",this.cells);
  }

  @Override
  public String toString() {
    return "Game{" +
            "players=" + Arrays.toString(players) +
            ", currentPlayer=" + this.currentPlayer() +
            '}';
  }

}
