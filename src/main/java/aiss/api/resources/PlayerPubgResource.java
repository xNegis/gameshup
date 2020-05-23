package aiss.api.resources;

import java.net.URI;





import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorPlayerPubgByPlataforma;
import aiss.modelapi.PubgPlayer;
import aiss.model.repository.MapGamesRepository;
import aiss.model.repository.GamesRepository;


@Path("/jugadorespubg")
public class PlayerPubgResource {
	
	/* Singleton */
	private static PlayerPubgResource _instance=null;
	GamesRepository repository;
	
	private PlayerPubgResource() {
		repository=MapGamesRepository.getInstance();

	}
	
	public static PlayerPubgResource getInstance()
	{
		if(_instance==null)
				_instance=new PlayerPubgResource();
		return _instance;
	}
	
	
    @GET
    @Produces("application/json")
    public Collection<PubgPlayer> getAll(@QueryParam("order") String order, @QueryParam("name") String name,@QueryParam("id") String id)
    {
        List<PubgPlayer> result = new ArrayList<PubgPlayer>();
            
        for (PubgPlayer player: repository.getAllPubgPlayer()) {
        	if(name!=null) {
    			  if ( player.getNombre().equals(name)) { // name filter
                      result.add(player);
              }
    		}else if(id!=null) {
    			  
    			if ( player.getId().equals(id)) { // id filter
                      result.add(player);
              }
    		
    		}else {
    			 result.add(player);
    		}
        }
            
        if (order != null) { // Order results
            if (order.equals("platform")) {
                Collections.sort(result, new ComparatorPlayerPubgByPlataforma());
            } else {
                throw new BadRequestException("The order parameter must be 'platform'.");
            }
        }

        return result;
    }

	//Añadir nuevo player
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPubgPlayer(@Context UriInfo uriInfo, PubgPlayer player) {
		if (player.getNombre() == null || "".equals(player.getNombre()))
			throw new BadRequestException("The name of the player must not be null");
		
		

		repository.addPubgPlayer(player);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(player.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(player);			
		return resp.build();
	}

	//Updatear player
	@PUT
	@Consumes("application/json")
	public Response updatePubgPlayer(PubgPlayer player) {
		PubgPlayer oldplayer = repository.getPubgPlayer(player.getId());
		if (oldplayer == null) {
			throw new NotFoundException("The player with id="+ player.getId() +" was not found");			
		}
		
		
		// Update name
		if (player.getNombre()!=null)
			oldplayer.setNombre(player.getNombre());
		
		// Update email
		if (player.getEmail()!=null)
			oldplayer.setEmail(player.getEmail());
		
		// Update plataforma
		if (player.getPlataforma()!=null)
			oldplayer.setPlataforma(player.getPlataforma());
	
				
				
		
		return Response.noContent().build();
	}
	
	
	//Borrar player por id
	@DELETE
	
	public Response removePubgPlayer(@QueryParam("id") String id) {
		PubgPlayer toberemoved=repository.getPubgPlayer(id);
		if (toberemoved == null)
			throw new NotFoundException("The player with id="+ id +" was not found");
		else
			repository.deletePubgPlayer(id);
		
		return Response.noContent().build();
	}
	
	//Borrar player por nombre
	@DELETE
	@Path("/deletebyname={name}")
	public Response removePubgPlayerbyname(@PathParam("name") String name) {
		PubgPlayer toberemoved=null;
		for (PubgPlayer player: repository.getAllPubgPlayer()) {
            if ( player.getNombre().equals(name)) { // Name filter
            	toberemoved=player;
            }
        }
		if (toberemoved == null)
			throw new NotFoundException("The player with name="+ name +" was not found");
		else
			repository.deletePubgPlayer(toberemoved.getId());
		
		return Response.noContent().build();
	}
	

}
