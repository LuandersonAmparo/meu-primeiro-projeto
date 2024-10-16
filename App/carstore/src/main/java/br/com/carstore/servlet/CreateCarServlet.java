package br.com.carstore.servlet;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")//link da pagina
public class CreateCarServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //todas as entradas(inputs) da pagina Index aqui
        String name = request.getParameter("car-name");//recebendo input da index parametro nome
        String color = request.getParameter("color"); // recebendo input da index parametro cor

        //Todas as Impressões da pagina Index Aqui
        System.out.println(name + " Adicionado com Sucesso" );//Impimindo a entrada da pagnia web
        System.out.println(color + " Cor do veiculo recebido com sucesso"); // Imprimindo a cor do veiculo

        //Instanciando as classes aqui
        Car car = new Car(name,color);//Instanciando a classe Car c/ parametro name e color: construtor.
        CarDao carDao = new CarDao(); //Instanciando a classe CarDao.
        carDao.createCar(car);//Chamando o metodo createCar da classe de conexão CarDao.

        //redirecionamento de pagina aqui
        request.getRequestDispatcher("index.html").forward(request, response);
        //response.sendRedirect("/find-all-cars");

    }
}
