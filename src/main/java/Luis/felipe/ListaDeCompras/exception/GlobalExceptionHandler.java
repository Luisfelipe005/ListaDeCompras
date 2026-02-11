package Luis.felipe.ListaDeCompras.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ItemNaoEncontrado.class)
    public ResponseEntity<String> itemnaoencontrado(ItemNaoEncontrado itemNaoEncontrado){
        return ResponseEntity.status(404).body(itemNaoEncontrado.getMessage());
    }

    @ExceptionHandler(RequisicaoInvalidaException.class)
    public ResponseEntity<String> stringResponseEntity(RequisicaoInvalidaException requisicaoInvalidaException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(requisicaoInvalidaException.getMessage());
    }
}

