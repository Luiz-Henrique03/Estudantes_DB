package Entities;

public class EstudanteDecorator extends Estudante {
    private Estudante estudanteDecorado;
    private String novaEscolaridade;

    public EstudanteDecorator(Estudante estudante, String novaEscolaridade) {
        super(estudante.getNome(), estudante.getAprovado(), estudante.getEscolaridade(), estudante.getNotasDisciplinas());

        this.estudanteDecorado = estudante;
        this.novaEscolaridade = novaEscolaridade;

        // Adicione a nova escolaridade ao estudante decorado
        setEscolaridade(estudante.getEscolaridade() + ", " + novaEscolaridade);
    }


}
