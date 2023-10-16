package org.consultadd.lambdarestapi.exceptions;

public class NoMappingFoundException extends RuntimeException {


    public NoMappingFoundException() {
        super();
    }

    public NoMappingFoundException(String cause) {
        super(cause);
    }
}
