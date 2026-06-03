package sn.dcssi.courrier.gestcourrier.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

// Exception métier personnalisée
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Long id) {
        super(String.format("%s introuvable avec l'ID : %d", resource, id));
    }
}




