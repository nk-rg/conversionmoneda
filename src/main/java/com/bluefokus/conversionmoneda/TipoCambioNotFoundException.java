package com.bluefokus.conversionmoneda;

public class TipoCambioNotFoundException extends RuntimeException {
    public TipoCambioNotFoundException() {
    }

    public TipoCambioNotFoundException(String message) {
        super(message);
    }
}
