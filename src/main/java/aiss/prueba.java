package aiss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class prueba extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(prueba.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken=(String) req.getSession().getAttribute("Google-token");
		
		if(accessToken!=null && !"".equals(accessToken)) {
			System.out.println(accessToken);
		}else {
				log.info("Redirigiendo a oauth servlet para conseguir el token");	
				req.getRequestDispatcher("/AuthController/Google").forward(req,resp);;
		}
	}
}
