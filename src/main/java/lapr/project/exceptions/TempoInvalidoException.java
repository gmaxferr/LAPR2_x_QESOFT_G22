package lapr.project.exceptions;

public class TempoInvalidoException extends IllegalArgumentException {

    public TempoInvalidoException() {
        super("Dia é inválido!!");
    }

    public TempoInvalidoException(String mensagem) {
        super(mensagem);
    }

}
