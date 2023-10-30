package Entities;

import java.util.Map;

public class Mestrado extends Estudante {

	public Mestrado(String nome, String Aprovado, String escolaridade, Map<String, String> disciplinas) {
		super(nome, Aprovado, escolaridade, disciplinas);
		
		 // Verifica se o aluno foi aprovado com uma nota D
        if (notasDisciplinas.containsValue("D")) {
            this.setAprovado("Reprovado");
        }
        
        this.setAprovado("Aprovado");
	}
	
	
}
