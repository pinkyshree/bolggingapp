package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class IdNotFoundException extends Exception
{
	public IdNotFoundException(String message)
	{
		super(message);
	}

}
