package es.e3corp.eSalud.exception;

import org.springframework.core.NestedRuntimeException;


public class CitaNotFoundException extends NestedRuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CitaNotFoundException(String id) {

        super(String.format("Cita with  Id '%s' not found", id));

    }

}