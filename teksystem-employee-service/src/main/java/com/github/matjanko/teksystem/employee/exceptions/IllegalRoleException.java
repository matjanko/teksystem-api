package com.github.matjanko.teksystem.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author matjanko
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IllegalRoleException extends RuntimeException {

    public IllegalRoleException(String message) {
        super(message);
    }
}
