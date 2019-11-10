package es.e3corp.eSalud.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * author: a3corp
 */
public class CitaNotFoundException extends NestedRuntimeException {

    /**
     * author: a3corp
     */
    private static final long serialVersionUID = 1L;
    /**
     * author: a3corp
     */
    public CitaNotFoundException(final String idcita) {

        super(String.format("Cita with  Id '%s' not found", idcita));

    }

}