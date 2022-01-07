package com.crio.codingame.exceptions;

public class ContestNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ContestNotFoundException()
    {
     super();
    }
    public ContestNotFoundException(String msg)
    {
     super(msg);
    }
}
