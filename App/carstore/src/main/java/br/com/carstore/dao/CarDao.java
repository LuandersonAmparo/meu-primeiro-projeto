package br.com.carstore.dao;

import br.com.carstore.model.Car;
import com.mysql.cj.protocol.Resultset;

import javax.naming.Name;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDao {

    public void createCar(Car car) {

        String SQL = "INSERT INTO CAR (name,color) VALUES (?,?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1", "Admin","4062*Amparo");

            System.out.println("banco de dados conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());// Instanciando o parametro nome
            //preparedStatement.execute();

            preparedStatement.setString(2, car.getColor());//Instanciando o parametro color
            preparedStatement.execute();

            System.out.println("Sucesso ao inserir o carro no banco de dados ");

            connection.close();//fechando a conexão com o banco.

        } catch (Exception e) {

            System.out.println("falaha na conexão com o banco de dados: " + e.getMessage());

        }

    }

    public List<Car> findAllCars(){

        String SQL = "SELECT * FROM CAR";

        try{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1", "Admin","4062*Amparo");

            System.out.println("banco de dados conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> allCars = new ArrayList<Car>();

            while (resultSet.next()){

                String ID = resultSet.getString("ID");//pega a coluna ID da tabela Car
                String nome = resultSet.getString("NAME");//Referenciando a tabela nome "NAME" do BD.
                String color = resultSet.getString("color");//Referenciando a tabela color do BD.

                Car car = new Car(nome,color); //instanciando a classe Car.


                allCars.add(car);
            }

            System.out.println("Sucesso ao Consultar os dados na Tabela CAR ");

            connection.close();//fechando a conexão com o banco.

            return allCars;

        }catch (Exception e){
            System.out.println("Falha ao Consultar os Carros no DB  " +e.getMessage());
        }

        return Collections.emptyList();
    }
}