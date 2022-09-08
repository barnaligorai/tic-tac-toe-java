package com.tw.step8.ttt.exception;

public class InvalidCellException extends Throwable {

  private final String pos;

  public InvalidCellException(String message, String pos) {
    super(message);
    this.pos = pos;
  }

  public InvalidCellException(String message, int cellPos) {
    super(message);
    this.pos = cellPos + "";
  }

  @Override
  public String getMessage() {
    return super.getMessage() + " " + this.pos;
  }
}
