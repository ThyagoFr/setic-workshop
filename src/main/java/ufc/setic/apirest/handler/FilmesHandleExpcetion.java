package ufc.setic.apirest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ufc.setic.apirest.exceptions.MensagemErro;
import ufc.setic.apirest.exceptions.ResourceBadRequestException;
import ufc.setic.apirest.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class FilmesHandleExpcetion {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handlerResourceNotFoundException(
      ResourceNotFoundException exception
  ){
    MensagemErro erro = new MensagemErro();
    erro.setStatus(404);
    erro.setMensagem(exception.getMessage());
    erro.setData(LocalDateTime.now().toString());
    return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ResourceBadRequestException.class)
  public ResponseEntity<?> handlerResourceBadRequestException(
      ResourceBadRequestException exception
  ){
    MensagemErro erro = new MensagemErro();
    erro.setStatus(400);
    erro.setMensagem(exception.getMessage());
    erro.setData(LocalDateTime.now().toString());
    return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
  }
}
