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

import aiss.api.resources.comparators.ComparatorPlayerLolByLevel;
import aiss.api.resources.comparators.ComparatorPlayerLolByLevelReverse;
import aiss.modelapi.LolPlayer;
import aiss.model.repository.MapGamesRepository;
import aiss.model.repository.GamesRepository;


@Path("/jugadoreslol")
public class PlayerLolResource {
	
	/* Singleton */
	private static PlayerLolResource _instance=null;
	GamesRepository repository;
	
	private PlayerLolResource() {
		repository=MapGamesRepository.getInstance();

	}
	
	public static PlayerLolResource getInstance()
	{
		if(_instance==null)
				_instance=new PlayerLolResource();
		return _instance;
	}
	
	
    @GET
    @Produces("application/json")
    public Collection<LolPlayer> getAll(@QueryParam("order") String order, @QueryParam("name") String name,@QueryParam("id") String id)
    {
        List<LolPlayer> result = new ArrayList<LolPlayer>();
            
        for (LolPlayer player: repository.getAllLolPlayer()) {
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
            if (order.equals("nivel")) {
                Collections.sort(result, new ComparatorPlayerLolByLevel());
            } else if (order.equals("-nivel")) {
                Collections.sort(result, new ComparatorPlayerLolByLevelReverse());
            } else {
                throw new BadRequestException("The order parameter must be 'nivel' or '-nivel'.");
            }
        }

        return result;
    }
	

	
	//Añadir nuevo player
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addLolPlayer(@Context UriInfo uriInfo, LolPlayer player) {
		if (player.getNombre() == null || "".equals(player.getNombre()))
			throw new BadRequestException("The name of the player must not be null");
		
		

		repository.addLolPlayer(player);

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
	public Response updateLolPlayer(LolPlayer player) {
		LolPlayer oldplayer = repository.getLolPlayer(player.getId());
		if (oldplayer == null) {
			throw new NotFoundException("The player with id="+ player.getId() +" was not found");			
		}
		
		
		// Update name
		if (player.getNombre()!=null)
			oldplayer.setNombre(player.getNombre());
		
		// Update email
		if (player.getEmail()!=null)
			oldplayer.setEmail(player.getEmail());
		
		// Update level
		if (player.getnivel()!=null)
			oldplayer.setnivel(player.getnivel());
	
				
				
		
		return Response.noContent().build();
	}
	
	
	//Borrar player por id
	@DELETE
	public Response removeLolPlayer(@QueryParam("id") String id) {
		LolPlayer toberemoved=repository.getLolPlayer(id);
		if (toberemoved == null)
			throw new NotFoundException("The player with id="+ id +" was not found");
		else
			repository.deleteLolPlayer(id);
		
		return Response.noContent().build();
	}
	
	//Borrar match por nombre
	@DELETE
	@Path("/deletebyname={name}")
	public Response removeLolPlayerbyname(@PathParam("name") String name) {
		LolPlayer toberemoved=null;
		for (LolPlayer player: repository.getAllLolPlayer()) {
            if ( player.getNombre().equals(name)) { // Name filter
            	toberemoved=player;
            }
        }
		if (toberemoved == null)
			throw new NotFoundException("The player with name="+ name +" was not found");
		else
			repository.deleteLolPlayer(toberemoved.getId());
		
		return Response.noContent().build();
	}
	

}
