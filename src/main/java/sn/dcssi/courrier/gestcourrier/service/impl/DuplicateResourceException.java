package sn.dcssi.courrier.gestcourrier.service.impl;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String resource, String field, String value) {
        super(String.format("%s existe déjà avec %s : %s", resource, field, value));
    }

    public DuplicateResourceException(String string) {
        //TODO Auto-generated constructor stub
        super(string);
    }

}
