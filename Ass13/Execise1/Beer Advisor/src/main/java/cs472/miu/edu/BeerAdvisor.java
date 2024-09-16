package cs472.miu.edu;

import cs472.miu.edu.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BeerAdvisor extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
						
		String color = request.getParameter("color");
		BeerExpert be = new BeerExpert();
		List result = be.getBrands(color);

		ServletContext context = getServletContext();

		request.setAttribute("styles", result);

		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request,response);
		
	}		
}
