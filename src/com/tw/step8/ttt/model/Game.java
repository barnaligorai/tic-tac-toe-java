package com.tw.step8.ttt.model;

import java.util.Arrays;
import java.util.Objects;

public class Game {
  private static final int[][] winningCombination = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
  private final Player[] players;
  private final String[] cells = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
  private int currentPlayerIndex;
  private boolean isGameOver = false;
  private Player won;
  private int movesPlayed = 0;

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
    return this.movesPlayed == 9 && !this.isWon();
  }

  public boolean isGameOver() {
    return isGameOver;
  }

  public String results () {
    if (this.isGameOver && this.isDrawn()) {
      return "Game ended in a Draw";
    }
   return String.format("%s wins", this.won.getName());
  }

  public String displayGame() {
    String player1Info = String.format("%s : %s", players[0].getName(), players[0].getSymbol());
    String player2Info = String.format("%s : %s", players[1].getName(), players[1].getSymbol());
    String playersInfo = String.format("-----------------------\n%s %s\n", player1Info, player2Info);

    String board = String.format(" %s %s %s\n %s %s %s\n %s %s %s\n", this.cells);
    return playersInfo + board;
  }

  public String prompt() {
    return String.format("%s's turn. Please Enter the cell number > ", this.currentPlayer().getName());
  }
  @Override
  public String toString() {
    return "Game{" +
            "players=" + Arrays.toString(players) +
            ", currentPlayer=" + this.currentPlayer() +
            '}';
  }

}
