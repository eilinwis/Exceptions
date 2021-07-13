package ru.netology.Exceptions;

import lombok.SneakyThrows;


public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }

}