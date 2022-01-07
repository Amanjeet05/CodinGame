package com.crio.codingame.exceptions;

public class QuestionNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public QuestionNotFoundException()
    {
     super();
    }
    public QuestionNotFoundException(String msg)
    {
     super(msg);
    }
}  
