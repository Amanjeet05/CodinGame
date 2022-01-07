package com.crio.codingame.exceptions;

public class InvalidContestException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidContestException()
    {
        super();
    }
    public InvalidContestException(String msg)
    {
        super(msg);
    }
}
