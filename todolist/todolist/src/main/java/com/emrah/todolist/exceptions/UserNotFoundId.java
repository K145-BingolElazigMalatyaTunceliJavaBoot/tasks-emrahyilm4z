package com.emrah.todolist.exceptions;

public class UserNotFoundId extends RuntimeException {
    public UserNotFoundId() {
        super(Message.ID_NOT_FOUND);
    }
}

