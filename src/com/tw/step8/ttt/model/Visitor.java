package com.tw.step8.ttt.model;

public class Visitor {
  private Player currentPlayer;
  private Player[] players;
  private String[] cells;
  private boolean isGameDrawn;

  public void visitGame(Game game){
    this.currentPlayer = game.currentPlayer();
    this.players = game.getPlayers();
    this.cells = game.getCells();
    this.isGameDrawn = game.isGameDrawn();
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public Player[] getPlayers() {
    return players;
  }

  public String[] getCells() {
    return cells;
  }

  public boolean isGameDrawn() {
    return isGameDrawn;
  }

}
