package com.event.platform.ticktes.exception.custome;

import com.event.platform.ticktes.exception.base.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException() {
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
