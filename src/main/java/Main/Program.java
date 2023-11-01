package Main;

import Database.DB_AbstractFactory;
import Database.JavaSQL_Handler;
import Database.MongoDB_Factory;
import Database.MongoDB_Handler;

import java.sql.Connection;
import java.util.Map;

import Entities.Bacharelado;
import Entities.Estudante;
import Entities.BachareladoDecorator;
import Entities.EstudanteDecorator;

public class Program {
    public static void main(String[] args) {
        // Use a fábrica de conexão do MongoDB
        DB_AbstractFactory mongoFactory = new MongoDB_Handler();
        DB_AbstractFactory mySQlFactory = new JavaSQL_Handler();
        
        Connection connection = mongoFactory.createConnection(mongoFactory);;

        Estudante estudante = new Bacharelado("Jason Sobreiro", "Aprovado", "Técnico", Map.of("OOP", "0", "Design Pattern", "0", "IA", "0"));
        EstudanteDecorator estudanteDecorado = new BachareladoDecorator(estudante);

        MongoDB_Handler mongoHandler = (MongoDB_Handler) connection;
        mongoHandler.insertStudent(estudante);
        mongoHandler.updateStudent("653ec86c44e8a441dae16c68", estudanteDecorado.getEscolaridade());

        
        /*
        JavaSQL_Handler sql_Handler = new JavaSQL_Handler();
        sql_Handler.InsertStudent(connection, estudante);
        sql_Handler.updateStudent(connection, 10,  estudanteDecorado.getEscolaridade());
        */
    }
}
