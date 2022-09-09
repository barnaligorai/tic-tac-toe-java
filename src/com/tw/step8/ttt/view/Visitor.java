package com.tw.step8.ttt.view;

import com.tw.step8.ttt.model.Game;
import com.tw.step8.ttt.model.Player;

public class Visitor implements GameVisitor, GameData {
  public String currentPlayerName;
  public String[] cells;
  protected boolean isGameDrawn;

  protected String firstPlayerName;
  protected String firstPlayerSymbol;
  protected String secondPlayerName;
  protected String secondPlayerSymbol;

  public void visitGame(Game game){
    this.cells = game.getCells();
    this.isGameDrawn = game.isGameDrawn();

    this.setCurrentPlayerName(game.currentPlayer());
    this.setPlayersInfo(game.getPlayers());
  }

  private void setCurrentPlayerName(Player currentPlayer) {
    this.currentPlayerName = currentPlayer.getName();
  }

  private void setPlayersInfo(Player[] players) {
    this.firstPlayerName = players[0].getName();
    this.firstPlayerSymbol = players[0].getSymbol().toString();
    this.secondPlayerName = players[1].getName();
    this.secondPlayerSymbol = players[1].getSymbol().toString();
  }

  @Override
  public String[] getCells() {
    return this.cells;
  }

  @Override
  public String getCurrentPlayerName() {
    return this.currentPlayerName;
  }

  @Override
  public boolean isGameDrawn() {
    return this.isGameDrawn;
  }
}
