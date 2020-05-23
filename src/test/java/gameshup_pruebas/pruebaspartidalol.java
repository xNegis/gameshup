package gameshup_pruebas;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import aiss.model.resource.lolResource;
import lolmatch.Match;
import lolplayer.Player;

public class pruebaspartidalol {

	lolResource resource = new lolResource();
	
	@Test
	public void testGetJugador() throws IOException {
		String jugador = "xNegis";
		String region = "euw1";
		System.out.println("Test pruebasPartidaLol(testGetJugador): Probando búsqueda del jugador " + jugador + " en la region " + region);
		Player player = resource.getPlayer(region, jugador);
		if (player != null) {
			System.out.println("¡testGetJugador ejecutado con exito!");
		}else {
			System.out.println("¡Fallo al ejecutar testGetJugador! No se ha podido encontrar al jugador " + jugador + " en la region " + region);
		}
		assertNotNull("El jugador no puede ser null", player);

	}
	@Test
	public void testGetPartidas() throws IOException {
		String accountId="zXxS9cVnexscDILfwn8tk4X6kwkvphNdQIEteiuKcy6fWVE";
		String region="euw1";
		System.out.println("Test pruebasPartidaLol(testGetPartidas): Probando búsqueda del jugador con id " + accountId + " en la region " + region);
		List<lolmatchsxid.Match> listaPartidas = resource.getPartidas(region, accountId);
		if(listaPartidas==null) {
		System.out.println("¡Fallo al ejecutar testGetPartidas! No se ha podido encontrar al jugador con id " + accountId + " en la region " + region);
		}else {
			System.out.println("¡testGetPartidas ejecutado con exito!");

		}
		assertNotNull("La lista de partidas no puede ser null", listaPartidas);

		
	}
	
	@Test
	public void testGetPartida() throws IOException {
		Long gameId=4616208564L;
		String region="euw1";
		System.out.println("Test pruebasPartidaLol(testGetPartida): Probando búsqueda del partido con id " + gameId + " en la region " + region);
		Match partido = resource.getPartida(gameId,region);
		if(partido==null) {
		System.out.println("¡Fallo al ejecutar testGetPartida! No se ha podido encontrar al partido con id " + gameId + " en la region " + region);
		}else {
			System.out.println("¡testGetPartida ejecutado con exito!");

		}
		assertNotNull("El partido no puede ser null", partido);

		
	}
}

