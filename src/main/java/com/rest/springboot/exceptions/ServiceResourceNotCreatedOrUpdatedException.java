package com.rest.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ServiceResourceNotCreatedOrUpdatedException extends RuntimeException
{
	private String fieldName;
    private Integer fieldValue;


    public ServiceResourceNotCreatedOrUpdatedException( String fieldName, Integer id) {
        super(String.format("resource not created/updated ", fieldName, id));
        this.fieldName = fieldName;
        this.fieldValue = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Integer getFieldValue() {
        return fieldValue;
    }
}
