package cs472.miu.edu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Lab1Task2
 */
public class Task2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task2() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("../task2.jsp");

        String val1 = request.getParameter("add1");
        String val2 = request.getParameter("add2");
        String val3 = request.getParameter("multiply1");
        String val4 = request.getParameter("multiply2");

        request.setAttribute("add1Value", val1);
        request.setAttribute("add2Value", val2);
        request.setAttribute("addResultValue", Calculator.sum(val1, val2));

        request.setAttribute("multiply1Value", val3);
        request.setAttribute("multiply2Value", val4);
        request.setAttribute("multiplyResultValue", Calculator.multiply(val3, val4));

        rd.forward(request, response);
    }

}
