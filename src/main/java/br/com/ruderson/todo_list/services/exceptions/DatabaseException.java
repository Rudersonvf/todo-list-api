package br.com.ruderson.todo_list.services.exceptions;

public class DatabaseException extends RuntimeException {
  public DatabaseException(String message) {
    super(message);
  }
}
