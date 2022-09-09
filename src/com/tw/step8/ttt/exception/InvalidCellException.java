package com.tw.step8.ttt.exception;

public class InvalidCellException extends Exception {

  private final String pos;

  public InvalidCellException(String pos) {
    this.pos = pos;
  }

  @Override
  public String getMessage() {
    return "Invalid cell " + this.pos;
  }
}
