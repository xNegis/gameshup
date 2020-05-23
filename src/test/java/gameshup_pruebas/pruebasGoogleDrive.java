package gameshup_pruebas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resource.GoogleDriveResource;

public class pruebasGoogleDrive {
	 GoogleDriveResource gdResource 
	    = new GoogleDriveResource("ya29.a0AfH6SMDKkI2N1oLV-vXW6lyPjvhOS56NjbTEn9cxp1zrSLiHiizwEZW_ANEtxqnCBTORrNGIxj91478osXH8yDp0a7qHVzWgy0pRG80uEKYBrG9DlUxDgUeeH4Wm0SOjOqrFW63aOOOInpjS8CpE8AAv5Pd48mJVTLg");
	    
	    @Test
		public void testGetFiles() throws IOException {
			System.out.println("Test pruebasGoogleDrive(testGetFiles)");
			Files files = gdResource.getFiles();
			if(files==null) {
				System.out.println("¡Fallo en testGetFiles! El acces-token ha caducado o es erróneo para este cliente");
			}else {
				System.out.println("¡Exito en testGetFiles!");

			}
			assertNotNull("El numero de files no puede ser null", files);

		}
	    
	    @Test
	    public void testGetFile() throws IOException {
			System.out.println("Test pruebasGoogleDrive(testGetFile)");
			String id="1J1Ke144iCmdB8HBIa0itbz5X4EafZRur";
			FileItem file = gdResource.getFile(id);
			if(file==null) {
				System.out.println("¡Fallo en testGetFile! El id " + id +" no existe,es erroneo o ya se ha borrado");
			}else {
				System.out.println("¡Exito en testGetFile!");

			}
			assertNotNull("El numero de files no puede ser null", file);
		}
	    @Test
	    public void testInsertFile() throws IOException {
			System.out.println("Test pruebasGoogleDrive(testInsertFile)");
	    	FileItem file = new FileItem();
			file.setTitle("testInsertFile");
            file.setMimeType("text/plain");
            String insert = gdResource.insertFile(file, "prueba testInsertFile ");
            if(insert==null) {
				System.out.println("¡Fallo en testInsertFile! No se ha podido insertar(acces-token)");            	
            }else {
				System.out.println("¡Exito en testInsertFile!");            	
            }
			assertNotNull("El numero de files no puede ser null", insert);
		}
	    
	    @Test
	    public void testDeleteFile() throws IOException {
			System.out.println("Test pruebasGoogleDrive(testDeleteFile)");
			String id="1xKtjbCAZq8avexIXGAvXW-B4l5udC4WG";
            Boolean delete = gdResource.deleteFile(id);
            if(!delete) {
				System.out.println("¡Fallo en testDeleteFile! No se puede eliminar el file con id "+ id +".Ya ha sido borrada o no existe.");            	
            }else {
				System.out.println("¡Exito en testDeleteFile!");            	
            }
            assertTrue("Tiene que borrarse un archivo", delete);
		}
	    
	    @Test
	    public void testGetFileContent() throws IOException {
			System.out.println("Test pruebasGoogleDrive(testGetFileContent)");
			FileItem file = new FileItem();
			file.setTitle("testGetFileContent");
            file.setMimeType("text/plain");
            file.setDownloadUrl("https://drive.google.com/open?id=1BUabjSpiPcq3TF-WHUE_Sjtd1KAa6OQk");
			String result = gdResource.getFileContent(file);
            if(result==null) {
				System.out.println("¡Fallo en testGetFileContent! No se ha podido actualizar el fichero "+file.getTitle());            	
            }else {
				System.out.println("¡Exito en testGetFileContent!");            	
            }
            assertNotNull("Tiene que borrarse un archivo", result);
		}
}
