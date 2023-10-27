package Entities;

public abstract class Estudante {
	
	protected String Nome;
	protected double Nota;
	protected String Escolaridade;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public double getNota() {
		return Nota;
	}
	public void setNota(double nota) {
		Nota = nota;
	}
	public String getEscolaridade() {
		return Escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		Escolaridade = escolaridade;
	}
	
	public Estudante(String nome, double nota, String escolaridade) {
		super();
		Nome = nome;
		Nota = nota;
		Escolaridade = escolaridade;
	}
	
	
}
