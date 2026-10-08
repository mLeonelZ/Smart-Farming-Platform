package br.com.agricoladigital.smart_farming_api.exception;

public class SenhaAtualInvalidaException extends RuntimeException {
    public SenhaAtualInvalidaException() {
        super("A senha atual informada está incorreta.");
    }
}
