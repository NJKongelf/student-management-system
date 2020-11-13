package se.iths.rest.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BadFormatInputException extends WebApplicationException {
    public BadFormatInputException(String message) {
        super(Response.status(Response.Status.NOT_ACCEPTABLE).entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}
