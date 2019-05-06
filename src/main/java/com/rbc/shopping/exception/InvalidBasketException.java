package com.rbc.shopping.exception;

/**
*
* @author rmazumde
*/

public class InvalidBasketException extends RuntimeException {
    public InvalidBasketException(String message) {
        super(message);
    }
}
