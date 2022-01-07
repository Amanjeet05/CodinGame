package com.crio.codingame.exceptions;

public class UserNotFoundException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserNotFoundException()
 {
  super();
 }
 public UserNotFoundException(String msg)
 {
  super(msg);
 }
}
