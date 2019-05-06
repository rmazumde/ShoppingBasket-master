package com.rbc.shopping.exception;

/**
*
* @author rmazumde
*/

public class InvalidFruitException extends RuntimeException {
    public InvalidFruitException(String message) {
        super(message);
    }
}
