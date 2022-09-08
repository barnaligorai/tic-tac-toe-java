package com.tw.step8.ttt.view;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class View {
  private final Scanner scanner;
  private final OutputStream out;

  public View(Scanner scanner, OutputStream out) {
    this.scanner = scanner;
    this.out = out;
  }

  public String read (){
    return scanner.next();
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

  public void showError(Throwable e) throws IOException {
    String message = String.format("%s, Please provide a vacant cell between 1-9", e.getMessage());
    this.write(message);
  }
}
