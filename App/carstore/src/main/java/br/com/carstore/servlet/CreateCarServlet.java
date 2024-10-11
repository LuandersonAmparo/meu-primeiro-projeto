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

        String carName = request.getParameter("car-name");
        
        Car car = new Car();//Instanciando a classe Car
        car.setName(carName);//Chamando a função

        CarDao carDao = new CarDao(); //Instanciando a classe CarDao
        carDao.createCar(car);//referenciando a classe de conexão

        request.getRequestDispatcher("index.html").forward(request, response);

    }
}
