package com.tw.step8.ttt.model;

import java.util.Arrays;

public class Game {
  private Player[] players;
  private int currentPlayerIndex;

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

  @Override
  public String toString() {
    return "Game{" +
            "players=" + Arrays.toString(players) +
            ", currentPlayer=" + this.currentPlayer() +
            '}';
  }
}
