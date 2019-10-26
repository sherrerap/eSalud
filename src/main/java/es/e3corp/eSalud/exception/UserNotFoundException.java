package es.e3corp.eSalud.exception;

import org.springframework.core.NestedRuntimeException;


public class UserNotFoundException extends NestedRuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String id) {

        super(String.format("User with  Id '%s' not founded", id));

    }

}