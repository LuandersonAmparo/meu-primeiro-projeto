package br.com.carstore.servlet;


import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-cars")
public class ListCarServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);

        CarDao carDao = new CarDao();//Instanciando a classe CarDao.

        List<Car> allCars = carDao.findAllCars();//chama o metodo findAllCars() de carDao, que retorna uma lista de todos os objetos Car, e armazena essa lista na variável allCars.

        req.setAttribute("cars", allCars);//requisição http p/ lista cars se acessada e visualizada

        req.getRequestDispatcher("/dashboard.jsp").forward(req,resp);//encaminha a requisição e a resposta para a página "dashboard.jsp",


    }
}
