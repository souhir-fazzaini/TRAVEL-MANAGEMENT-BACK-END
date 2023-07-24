package com.example.gestion.des.voyages.execption;

import lombok.Data;

@Data
public class EntityNotfoundException extends RuntimeException {
    private ErrorCodes errorCode;
    public EntityNotfoundException(String message)
    {
        super(message);

    }
    public EntityNotfoundException(String message, Throwable cause)
    {
        super(message,cause);
    }
    public EntityNotfoundException(String message, Throwable cause,ErrorCodes errorCode)
    {
        super(message,cause);
        this.errorCode= errorCode;

    }
    public EntityNotfoundException(String message,ErrorCodes errorCode)
    {
        super(message);
        this.errorCode= errorCode;

    }
}
