package Main;

import Database.DB_AbstractFactory;
import Database.JavaSQL_Factory;
import Entities.Bacharelado;
import Entities.Estudante;

public class Program {

    public static void main(String[] args) {
        // Criando a fábrica concreta
        DB_AbstractFactory sqlFactory = new JavaSQL_Factory();

        // Criando um objeto de estudante
        Estudante estudante = new Bacharelado("João", 9.5, "Ensino Médio");

        // Usando a fábrica para inserir o estudante no banco de dados
        sqlFactory.InsertStudent(estudante);
    }
}
