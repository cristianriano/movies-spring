package com.cristianriano.movies.controllers;

import com.cristianriano.movies.errors.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private final static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

  @ExceptionHandler({ NotFoundException.class })
  protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
    logger.error(ex.getMessage());
    return handleExceptionInternal(ex, "Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }
}
