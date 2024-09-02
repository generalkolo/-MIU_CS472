package cs472.miu.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MultiplyOperationServlet
 */
public class Task1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task1() {
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
        String val1 = request.getParameter("add1");
        String val2 = request.getParameter("add2");
        String val3 = request.getParameter("multiply1");
        String val4 = request.getParameter("multiply2");

        if(!val1.equals("") && !val2.equals("")) {
            response.getWriter()
                    .append(val1).append(" + ").append(val2).append(" = ")
                    .append(Calculator.sum(val1, val2))
                    .append("\n");
        }
        if(!val3.equals("") && !val4.equals("")) {
            response.getWriter()
                    .append(val3).append(" * ").append(val4).append(" = ")
                    .append(Calculator.multiply(val3, val4));
        }
    }

}
