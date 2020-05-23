package gameshup_pruebas;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import aiss.model.resource.pubgPlayerResource;
import pubgplayer.PlayerPubg;

public class pruebasPubgPlayer {

	   pubgPlayerResource resource = new pubgPlayerResource();

	@Test
	public void testGetJugador() throws IOException {
		String jugador ="Pm25_TanT";
		String plataforma ="steam";
		System.out.println("Test pruebasPubgPlayer(testGetJugador): Probando búsqueda del jugador " + jugador + " en la plataforma " + plataforma);
		PlayerPubg player = resource.getPlayerPubg(jugador, plataforma);
		if(player==null) {
		System.out.println("¡Fallo al ejecutar testGetJugador! No se ha podido encontrar al jugador "+jugador+" en la plataforma "+ plataforma);
		}else {
		System.out.println("¡testGetJugador ejecutado con Exito!");
		}
		assertNotNull("El jugador no puede ser null", player);
	}
}
