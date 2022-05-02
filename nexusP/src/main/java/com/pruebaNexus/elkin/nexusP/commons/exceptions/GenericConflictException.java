package com.pruebaNexus.elkin.nexusP.commons.exceptions;

import commons.CoreException;
import commons.exceptions.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class GenericConflictException extends CoreException {
    public GenericConflictException(ErrorCode code) {
        super(code);
    }

    public GenericConflictException(ErrorCode code, Throwable cause) {
        super(code, cause);
    }
}
