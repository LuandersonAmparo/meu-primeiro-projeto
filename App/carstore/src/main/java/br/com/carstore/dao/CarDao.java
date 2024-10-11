package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarDao {

    public void createCar(Car car) {

        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("banco de dados conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.execute();

            System.out.println("Sucesso ao inserir o carro no banco de dados ");

           // connection.close();

        } catch (Exception e) {

            System.out.println("falaha na conexão com o banco de dados: " + e.getMessage());

        }

    }

}