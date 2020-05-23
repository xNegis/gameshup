package aiss.controller;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resource.GoogleDriveResource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoogleDriveFileListController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GoogleDriveFileListController.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String accessToken = (String) req.getSession().getAttribute("GoogleDrive-token");
        try {
            if (accessToken != null && !"".equals(accessToken)) {
                GoogleDriveResource gdResource = new GoogleDriveResource(accessToken);
                
                Files files = gdResource.getFiles();
                if (files != null) {

                    List<FileItem> files2 = files.getItems();
                    List<FileItem> filtradas = new ArrayList<FileItem>();
                    
                    System.out.println(req.getSession().getAttribute("botonLol")!=null);
                    if(req.getSession().getAttribute("vengoLol")==null) req.getSession().setAttribute("vengoLol",false);
                    if((Boolean) req.getSession().getAttribute("vengoLol")  
                    		|| req.getParameter("botonLol")!=null 
                    		|| req.getSession().getAttribute("botonLol")!=null) {
                    	
                    	
                    	req.getSession().setAttribute("botonLol",null);
                    	
                    	for(FileItem file:files2) {
                         	if(file.getTitle().contains("GameShup LoL ")) {
                         		filtradas.add(file);
                         		
                         	}
                    	 }
                    	
                 		 req.getSession().setAttribute("vengoLol", false);
                         req.setAttribute("filtradas", filtradas);
                         req.getRequestDispatcher("misPartidasLol.jsp").forward(req, resp);

                    }else {
                    	 for(FileItem file:files2) {
                         	if(file.getTitle().contains("GameShup PUBG ")) {
                         		filtradas.add(file);
                         	}
                         }
                         req.setAttribute("filtradas", filtradas);
                         req.getRequestDispatcher("misPartidasPubg.jsp").forward(req, resp);

                    }
                } else {

                    log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
                    req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req, resp);
                }
                
            }else {
            	if(req.getParameter("botonLol")!=null) {
            		req.getSession().setAttribute("botonLol", "botonLol");
            	}
            	System.out.println(req.getSession().getAttribute("botonLol"));
            	log.info("Trying to access Google Drive without an access token, redirecting to OAuth servlet");
                req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req, resp);
            }
        }catch(NullPointerException e) {
        	
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
}
