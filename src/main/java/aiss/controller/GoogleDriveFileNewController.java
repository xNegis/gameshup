package aiss.controller;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resource.GoogleDriveResource;
import model.auxiliary.MatchLoL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.apphosting.utils.remoteapi.RemoteApiPb.Request;

public class GoogleDriveFileNewController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GoogleDriveFileDeleteController.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	HttpSession request = req.getSession();
    	Boolean vengoLol = (Boolean) request.getAttribute("vengoLol");
    	if(vengoLol) {
    		request.setAttribute("vengoLol", false);
    		Integer tripleKills =0;
    	    Integer quadraKills =0;
    	    Integer pentaKills =0;
    	    String  campeon="";
    	    Integer asesinatos=0;
    	    Integer asistencias=0;
    	    Integer muertes=0;
    	     	 for(int i=0;i<6;i++) {
    	    	 if(req.getParameter("boton"+i)!=null) {
    	    		 campeon =(String) request.getAttribute("campeon"+i);
    	    		 asesinatos =(Integer) request.getAttribute("asesinatos"+i);
    	    		 asistencias =(Integer) request.getAttribute("asistencias"+i);
    	    		 muertes =(Integer) request.getAttribute("muertes"+i);
    	    		 tripleKills =(Integer) request.getAttribute("tks"+i);
    	    		 quadraKills =(Integer) request.getAttribute("qks"+i);
    	    		 pentaKills =(Integer) request.getAttribute("pks"+i);
    	    	 }
    	     }


       	
       	 String accessToken = (String) req.getSession().getAttribute("GoogleDrive-token");
            if (accessToken != null && !"".equals(accessToken)) {

                GoogleDriveResource gdResource = new GoogleDriveResource(accessToken);
                
                Files files = gdResource.getFiles();
                
            	String title = "GameShup LoL " +asesinatos+muertes+asistencias+tripleKills+ quadraKills+ pentaKills;
            	   	String content = ""; 
            	   	content+="Campeon invocado : " +  campeon;
            	   	content+= "\nNumero de asesinatos  :  " + asesinatos;
            	   	content+= "\nNumero de asistencias :  " + asistencias;
            	   	content+= "\nNumero de muertes     :  " + muertes;
            	   	content+= "\nNumero de asesinatos triples :  " + tripleKills;
            	   	content+= "\nNumero de asesinatos cuadruples :  " +quadraKills;
            	    content+= "\nNumero de pentakills :  " +pentaKills;
            	  
            	    List<FileItem> files2 = files.getItems();
            	    Boolean esta = false;
                    for(FileItem file:files2) {
                    	if(file.getTitle().equals(title)) {
                    		 req.setAttribute("mensaje", "<div id=\"errorp\" class=\"w-50 alert alert-danger\" role=\"alert\">\r\n" + 
                 					"  ESE ARCHIVO YA EXISTE\r\n" + 
                					"</div>");
                             req.getRequestDispatcher("/lolcontroller?name="+request.getAttribute("nombre")+"&region="+request.getAttribute("region")).forward(req, resp);
                             esta =true;
                    	}
                    }
                    
                if (title != null && !"".equals(title) && !esta) {
                    FileItem file = new FileItem();
                    file.setTitle(title);
                    file.setMimeType("text/plain");
                    gdResource.insertFile(file, content);
                    //req.setAttribute("message", "File '" + title + "' added to your Drive!");
                   // req.getRequestDispatcher("/googleDriveFileList").forward(req, resp);
                    req.getRequestDispatcher("/lolcontroller?name="+request.getAttribute("nombre")+"&region="+request.getAttribute("region")).forward(req, resp);
                } else {
                    req.setAttribute("message", "You must provide a valid title for file");
                    req.setAttribute("content", content);
                }
            } else {
                log.info("Trying to access Google Drive without an access token, redirecting to OAuth servlet");
                req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req, resp);
            }
    	}else {
    		System.out.println("NOMBRE ->" + request.getAttribute("pubgNombre"));
    		System.out.println("PLATAFORMA ->" + request.getAttribute("pubgPlataforma"));
    		 String nombre ="";
			 Integer kills=0;
			 Double damage=0.;
			 Integer hKills=0;
			 Integer win=0;
     	    Boolean esta = false;

    		 for(int i=0;i<6;i++) {
    			
    	    	 if(req.getParameter("boton"+i)!=null) {
     	    		nombre = (String)request.getAttribute("nombre"+i);
    	    		kills = (Integer)request.getAttribute("kills"+i);
    	    		damage = (Double)request.getAttribute("damage"+i);
    	    		win= (Integer)request.getAttribute("win"+i);
    	    		hKills=(Integer) request.getAttribute("hKills"+i);

    	    	 }
    		 }
    		 String accessToken = (String) req.getSession().getAttribute("GoogleDrive-token");
             if (accessToken != null && !"".equals(accessToken) || !esta) {

                 GoogleDriveResource gdResource = new GoogleDriveResource(accessToken);
                 
                 Files files = gdResource.getFiles();
                 int damage1 = damage.intValue();
             	String title = "GameShup PUBG " +kills+hKills+win;
             	   	String content = ""; 
             	   	content+="Nombre del jugador : " +  nombre;
             	   	content+= "\nNumero de asesinatos  :  " + kills;
             	   	content+= "\nNumero de asesinatos en la cabeza :  " + hKills;
             	   	content+= "\nDamage     :  " + damage;
             	   	content+= "\nPosicion:  " + win;
             	  
             	    List<FileItem> files2 = files.getItems();

                     for(FileItem file:files2) {
                     	if(file.getTitle().equals(title)) {
                     		 req.setAttribute("mensaje", "<div id=\"errorp\" class=\"w-50 alert alert-danger\" role=\"alert\">\r\n" + 
                  					"  ESE ARCHIVO YA EXISTE\r\n" + 
                 					"</div>");
                             esta =true;

                              req.getRequestDispatcher("/pubgcontroller?name="+request.getAttribute("pubgNombre")+"&plataformap="+request.getAttribute("pubgPlataforma")).forward(req, resp);
                     	}
                     }
                     
                 if (title != null && !"".equals(title) && !esta) {
                     FileItem file = new FileItem();
                     file.setTitle(title);
                     file.setMimeType("text/plain");
                     gdResource.insertFile(file, content);

                     req.getRequestDispatcher("/pubgcontroller?name="+request.getAttribute("pubgNombre")+"&plataformap="+request.getAttribute("pubgPlataforma")).forward(req, resp);
                 } else {
                     req.setAttribute("message", "You must provide a valid title for file");
                     req.setAttribute("content", content);
                     req.getRequestDispatcher("/pubgcontroller?name="+request.getAttribute("pubgNombre")+"&plataformap="+request.getAttribute("pubgPlataforma")).forward(req, resp);
                 }
             } else {
                 log.info("Trying to access Google Drive without an access token, redirecting to OAuth servlet");
                 req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req, resp);
             }
    		 
    	}
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
}
