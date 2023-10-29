package Entities;

import java.util.HashMap;
import java.util.Map;

public class Bacharelado extends Estudante {


	public Bacharelado(String nome, String aprovado, String escolaridade, Map<String, Double> disciplinas) {
	    super(nome, aprovado, escolaridade, disciplinas);

	    // Verifica se o tamanho do mapa de disciplinas é igual a 3
	    if (disciplinas.size() == 3) {
	        setDisciplinas(disciplinas);
	        
	        // Verifica se pelo menos uma nota é menor que 6
	        for (Double nota : disciplinas.values()) {
	            if (nota < 6.0) {
	                setAprovado("Reprovado");
	                break;
	            }
	        }
	    } else {
	        throw new IllegalArgumentException("O mapa de disciplinas deve ter um tamanho de 3.");
 }
	}
}
