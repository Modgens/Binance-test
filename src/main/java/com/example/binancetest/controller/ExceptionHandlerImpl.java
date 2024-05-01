package com.example.binancetest.controller;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.exceptions.BinanceServerException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerImpl extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BinanceClientException.class})
    public ResponseEntity<Object> handleClientException(BinanceClientException ex) {
        return ResponseEntity.ok(ex.getErrMsg());
    }
    @ExceptionHandler(value = {BinanceConnectorException.class})
    public ResponseEntity<Object> handleConnectorException(BinanceConnectorException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
    @ExceptionHandler(value = {BinanceServerException.class})
    public ResponseEntity<Object> handleServerException(BinanceServerException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}
