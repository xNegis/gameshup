package aiss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class componentes
 */
public class componentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public componentes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head><title>Componentes</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">");

        out.println("</head>");


        out.println("<body>");
        out.println("<h1 class=\"display-4\">Componentes del grupo</h1>");
        
        out.println("<ul class=\"list-group\">");
        out.println("<li class=\"list-group-item\">Sergio Rojas Jimenez - uvus -> serrojjim@alum.us.es</li>");
        out.println("<li class=\"list-group-item\">Antonio Campuzano Martinez - uvus -> antcammar4@alum.us.es</li>");
        out.println("<li class=\"list-group-item\">Miguel Angel Nieva Arjona - uvus -> migniearj@alum.us.es</li>");
        out.println("<li class=\"list-group-item\">Amadeo Ramos Años - uvus -> amaramaño@alum.us.es</li>");
        out.println("</ul>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
