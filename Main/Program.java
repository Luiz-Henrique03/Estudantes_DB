package Main;

import Database.JAVASQL_Factory;
import Database.JavaSQL_Handler;

import java.sql.Connection;
import java.util.Map;

import Database.DB_AbstractFactory;
import Entities.Bacharelado;
import Entities.Estudante;
import Entities.Mestrado;
import Entities.BachareladoDecorator;
import Entities.EstudanteDecorator;

public class Program {
    public static void main(String[] args) {
        DB_AbstractFactory mysqlFactory = new JavaSQL_Handler();
        Connection connection = mysqlFactory.createConnection(mysqlFactory);

        Estudante estudante = new Bacharelado("Jason Sobreiro", "Aprovado", "Tecnico", Map.of("OOP", "0", "Design Pattern", "0", "IA", "0"));
        EstudanteDecorator estudanteDecorado = new BachareladoDecorator(estudante);
        
        JavaSQL_Handler sql_Handler = new JavaSQL_Handler();
        sql_Handler.InsertStudent(connection, estudante);
        sql_Handler.updateStudent(connection, 10,  estudanteDecorado.getEscolaridade());

    }
}
