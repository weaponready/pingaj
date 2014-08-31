package org.pingaj.app.exception;

/**
 * Created by Jamy on 14-8-18.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("object not found.");
    }

    public NotFoundException(String message) {
        super("object "+ message+ " not found.");
    }


}
