package com.tw.step8.ttt.view;

import java.io.IOException;
import java.io.OutputStream;

public class Renderer {
  private final OutputStream out;

  public Renderer(OutputStream out) {
    this.out = out;
  }

  public void write (String text) throws IOException {
    out.write(text.getBytes());
  }

  public void showPrompt(String name) throws IOException {
    String prompt = String.format("%s's turn. Please Enter the cell number > ", name);
    this.write(prompt);
  }

  public void displayBoard(String[] cells) throws IOException {
    String board = String.format(" %s %s %s\n %s %s %s\n %s %s %s\n", cells);
    this.write(board);
  }

  public void showError(Exception e) throws IOException {
    String error = String.format("*ERROR* %s, Please provide a vacant cell between 1-9\n", e.getMessage());
    this.write(error);
  }
}
