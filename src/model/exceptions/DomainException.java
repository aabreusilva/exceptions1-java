package model.exceptions;

public class DomainException extends RuntimeException {

    //Essa classe precisa de uma versão. (serializable)
    private static final long serialVersionUID = 1L;

    //Permitir que eu possa instanciar minha exceção passando uma mensagem a ela.
    public DomainException (String msg) {
        super(msg);
    }
}
