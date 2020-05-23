package gameshup_pruebas;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import aiss.model.resource.pubgMatchResource;
import pubgmatch.PubgMatch;
import pubgplayer.PlayerPubg;

public class pruebasPubgMatch {
	pubgMatchResource resource = new pubgMatchResource();//obtengo stats de cada partido


	@Test
	public void testGetPartido() throws IOException {
		String idmatch ="9e272e84-bc7f-49ba-9aa4-6bd9f3d29608";
		String plataforma ="steam";
		System.out.println("Test pruebasPubgMatch(testGetPartido): Probando búsqueda del partido " +idmatch + " en la plataforma " + plataforma);
		PubgMatch partido = resource.getMatchPubg(idmatch, plataforma);
		if(partido==null) {
		System.out.println("¡Fallo al ejecutar testGetPartido! No se ha podido encontrar el partido "+idmatch+" en la plataforma "+ plataforma);
		}else {
		System.out.println("¡testGetPartido ejecutado con Exito!");
		}
		assertNotNull("El jugador no puede ser null", partido);
	}
}
