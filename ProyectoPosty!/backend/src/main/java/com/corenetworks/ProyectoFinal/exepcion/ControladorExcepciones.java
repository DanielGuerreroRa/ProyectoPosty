package com.corenetworks.ProyectoFinal.exepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class ControladorExcepciones extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ExcepcionPersonalizada.class)
    public ResponseEntity<ExcepcionDetalles> GET(ExcepcionPersonalizada ed, WebRequest peticion){
        ExcepcionDetalles e= new ExcepcionDetalles(LocalDateTime.now(),ed.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    public  final ResponseEntity<ExcepcionDetalles> post400(Exception ed, WebRequest peticion){
        ExcepcionDetalles e= new ExcepcionDetalles(LocalDateTime.now(),ed.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public final ResponseEntity<ExcepcionDetalles> badRequest500(Exception ee, WebRequest peticion){
    ExcepcionDetalles e= new ExcepcionDetalles(LocalDateTime.now(),ee.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }




}
