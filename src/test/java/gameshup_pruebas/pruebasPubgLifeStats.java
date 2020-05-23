package gameshup_pruebas;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import aiss.model.resource.pubgLifeTimeResource;
import pubfLifeStats.LifeStats;

public class pruebasPubgLifeStats {
	pubgLifeTimeResource resource = new pubgLifeTimeResource(); //Obtengo las estadisticas de vida del player

	@Test
	public void testGetLifeTimeStats() throws IOException {
		String id ="account.8c9eefd7ec7846fdb848a03757ec3fa1";
		String plataforma ="steam";
		System.out.println("Test pruebasPubgLifeStats(testGetLifeTimeStats): Probando búsqueda del jugador con id " + id + " en la plataforma " + plataforma);
		LifeStats player = resource.getLifeTimePubg(id, plataforma);
		if(player==null) {
		System.out.println("¡Fallo al ejecutar testGetLifeTimeStats! No se ha podido encontrar al jugador con id "+id+" en la plataforma "+ plataforma +" o bien no tiene partidas");
		}else {
		System.out.println("¡testGetJugador ejecutado con Exito!");
		}
		assertNotNull("El jugador no puede ser null", player);
	}
}
