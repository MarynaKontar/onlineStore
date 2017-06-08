package com.app.Exceptions;

import java.sql.SQLException;

/**
 * Created by User on 05.06.2017.
 */
public class DAOException extends RuntimeException{
    public DAOException(String message, Exception cause) {
        super(message, cause);
    }
}
