package com.bluefokus.conversionmoneda;

public class TipoCambioNotFoundException extends RuntimeException {
    public TipoCambioNotFoundException(String message) {
        super(message);
    }
}
