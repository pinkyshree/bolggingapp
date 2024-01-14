package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NotEnoughPointsException extends Exception
{
	public NotEnoughPointsException() 
	{
		super();
	}

	public NotEnoughPointsException(String message, Throwable cause)
	{
		super(message, cause);	
	}

}
