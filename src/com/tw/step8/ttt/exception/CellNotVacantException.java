package com.tw.step8.ttt.exception;

public class CellNotVacantException extends Exception {
  private final int cellPos;

  public CellNotVacantException(int cellPos) {
    this.cellPos = cellPos;
  }

  @Override
  public String getMessage() {
    return String.format("Cell %s is Not Vacant", this.cellPos);
  }
}
