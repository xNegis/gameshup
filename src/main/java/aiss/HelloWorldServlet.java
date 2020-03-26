package aiss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(HelloWorldServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		log.log(Level.FINE, "Processing GET request");
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head><title>Informacion</title></head>");
        out.println("<body>");
        out.println("<h1>Detalles sobre gameshup.</h1><p>");
        out.println("<p>Hoy día el mundo de los videojuegos está totalmente en auge. Pero, con ello viene la revalidad y el hecho de querer ser mejor que los demás. ¿Qué problema hay?              Pues que no existen apenas aplicaciones en las que puedes ver detalladamente las   estadísticas de los demás jugadores para poder compararte con ellos. Así pues, GameShup usará las APIs de tres juegos y en ella se podrá elegir uno de los tres juegos y con solo introducir el NickName de un jugador de dicho juego le saldrá todas las estadísticas que el juego registra en la temporada que se elija. Los juegos suelen dividirse en temporadas, que normalmente se corresponden con cada año.</p>");
        
	}
}
