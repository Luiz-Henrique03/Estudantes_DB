package Entities;

public class TecnicoDecorator extends EstudanteDecorator {
    public TecnicoDecorator(Estudante estudante) {
        super(estudante, "Mestrado");
    }
}
