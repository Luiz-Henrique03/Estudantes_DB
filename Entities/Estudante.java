package Entities;

import java.util.HashMap;
import java.util.Map;

public abstract class Estudante {
	
	protected String Nome;
	protected String Aprovado;
	protected String Escolaridade;
	protected Map<String, Double> disciplinas; // Mapa de disciplinas e notas

	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}

	public String getAprovado() {
		return Aprovado;
	}

	public void setAprovado(String aprovado) {
		Aprovado = aprovado;
	}

	public String getEscolaridade() {
		return Escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		Escolaridade = escolaridade;
	}

	public Map<String, Double> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Map<String, Double> disciplinas) {
		if (disciplinas.size() == 3) {
			this.disciplinas = disciplinas;
		} else {
			throw new IllegalArgumentException("O mapa de disciplinas deve ter um tamanho de 3.");
		}
	}

	public Estudante(String nome, String Aprovado, String escolaridade, Map<String, Double> disciplinas) {
		super();
		Nome = nome;
		Aprovado = Aprovado;
		Escolaridade = escolaridade;
		if (disciplinas.size() == 3) {
			this.disciplinas = disciplinas;
		} else {
			throw new IllegalArgumentException("O mapa de disciplinas deve ter um tamanho de 3.");
		}
	}
}
