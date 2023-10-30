package Entities;

import java.util.HashMap;
import java.util.Map;

public abstract class Estudante {
	
	protected String Nome;
	protected String Aprovado;
	protected String Escolaridade;
	protected Map<String, String> notasDisciplinas;


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

	public Map<String, String> getNotasDisciplinas() {
		return notasDisciplinas;
	}

	public void setNotasDisciplinas(Map<String, String> notasDisciplinas) {
		if (notasDisciplinas.size() == 3) {
			this.notasDisciplinas = notasDisciplinas;
		} else {
			throw new IllegalArgumentException("O mapa de notas das disciplinas deve ter um tamanho de 3.");
		}
	}



	public Estudante(String nome, String Aprovado, String escolaridade, Map<String, String> disciplinas) {
		super();
		Nome = nome;
		Aprovado = Aprovado;
		Escolaridade = escolaridade;
		if (disciplinas.size() == 3) {
			this.notasDisciplinas = disciplinas;
		} else {
			throw new IllegalArgumentException("O mapa de disciplinas deve ter um tamanho de 3.");
		}
	}

	
	
}