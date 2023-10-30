package Entities;

public class MestradoDecorator extends EstudanteDecorator {
    public MestradoDecorator(Estudante estudante) {
        super(estudante, "Mestrado");
    }
}
