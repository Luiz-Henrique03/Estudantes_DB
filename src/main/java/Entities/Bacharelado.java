package Entities;

import java.util.Map;
import java.util.HashMap;

public class Bacharelado extends Estudante {
    public Bacharelado(String nome, String aprovado, String escolaridade, Map<String, String> disciplinas) {
        super(nome, aprovado, escolaridade, disciplinas);

        // Verifica se o tamanho do mapa de disciplinas é igual a 3
        if (disciplinas.size() == 3) {
            Map<String, Double> notasDisciplinas = new HashMap<>();

            for (Map.Entry<String, String> entry : disciplinas.entrySet()) {
                String disciplina = entry.getKey();
                String notaString = entry.getValue();
                double nota = Double.parseDouble(notaString);
                notasDisciplinas.put(disciplina, nota);
            }

            for (Double nota : notasDisciplinas.values()) {
        
                if (nota <= 6.0) {
                    setAprovado("Reprovado");
                    break;
                }else {
                	setAprovado("Aprovado");
                }
            }

           
                
            

            Map<String, String> notasDisciplinasString = new HashMap<>();
            for (Map.Entry<String, Double> entry : notasDisciplinas.entrySet()) {
                notasDisciplinasString.put(entry.getKey(), String.valueOf(entry.getValue()));
            }

            setNotasDisciplinas(notasDisciplinasString);
        } else {
            throw new IllegalArgumentException("O mapa de disciplinas deve ter um tamanho de 3.");
        }
    }
}
