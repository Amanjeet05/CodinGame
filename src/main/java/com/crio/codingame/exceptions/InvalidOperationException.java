package com.crio.codingame.exceptions;

public class InvalidOperationException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidOperationException()
    {
     super();
    }
    public InvalidOperationException(String msg)
    {
     super(msg);
    }
}
