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

import aiss.api.resources.comparators.ComparatorMatchLolByKills;
import aiss.api.resources.comparators.ComparatorMatchLolByKillsReverse;
import aiss.modelapi.MatchLoL;
import aiss.model.repository.MapGamesRepository;
import aiss.model.repository.GamesRepository;


@Path("/lolmatch")
public class MatchLolResource {
	
	/* Singleton */
	private static MatchLolResource _instance=null;
	GamesRepository repository;
	
	private MatchLolResource() {
		repository=MapGamesRepository.getInstance();

	}
	
	public static MatchLolResource getInstance()
	{
		if(_instance==null)
				_instance=new MatchLolResource();
		return _instance;
	}
	
	
    @GET
    @Produces("application/json")
    public Collection<MatchLoL> getAll(@QueryParam("order") String order)
    {
        List<MatchLoL> result = new ArrayList<MatchLoL>();
            
        for (MatchLoL match: repository.getAllLolMatch()) {
           
              result.add(match);
              
        }
            
        if (order != null) { // Order results
            if (order.equals("kill")) {
                Collections.sort(result, new ComparatorMatchLolByKills());
            } else if (order.equals("-kill")) {
                Collections.sort(result, new ComparatorMatchLolByKillsReverse());
            } else {
                throw new BadRequestException("The order parameter must be 'kill' or '-kill'.");
            }
        }

        return result;
    }
	
    //BUSCAR MATCHS DE UN JUGADOR
 	@GET
 	@Path("/playermatchlol={playername}")
 	@Produces("application/json")
 	public List<MatchLoL> getbyplayer(@PathParam("playername") String playername,@QueryParam("order") String order){
 		List<MatchLoL> list = new ArrayList<MatchLoL>();
 		
 		for (MatchLoL match: repository.getAllLolMatch()) {
             if ( match.getPlayer().getNombre().equals(playername)) { // Name filter
                     list.add(match);
             }
         }
 		
 		if (list.isEmpty()) {
 			throw new NotFoundException("The matchs with player name="+ playername +" was not found");			
 		}
 		
 	    if (order != null) { // Order results
            if (order.equals("kill")) {
                Collections.sort(list, new ComparatorMatchLolByKills());
            } else if (order.equals("-kill")) {
                Collections.sort(list, new ComparatorMatchLolByKillsReverse());
            } else {
                throw new BadRequestException("The order parameter must be 'kill' or '-kill'.");
            }
        }
 		
 		return list;
 	}
    
    //BUSCAR MATCH POR NOMBRE
	@GET
	@Path("/matchlolbyname={name}")
	@Produces("application/json")
	public MatchLoL getbyname(@PathParam("name") String name){
		MatchLoL list = null;
		
		for (MatchLoL match: repository.getAllLolMatch()) {
            if ( match.getName().equals(name)) { // Name filter
                    list=match;
            }
        }
		
		if (list == null) {
			throw new NotFoundException("The match with name="+ name +" was not found");			
		}
		
		return list;
	}
	
    //Obtener match por id
	@GET
	@Path("/matchlol={id}")
	@Produces("application/json")
	public MatchLoL get(@PathParam("id") String id)
	{
		MatchLoL list = repository.getLolMatch(id);
		
		if (list == null) {
			throw new NotFoundException("The match with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	//Añadir nuevo match
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addMatchLol(@Context UriInfo uriInfo, MatchLoL match) {
		if (match.getName() == null || "".equals(match.getName()))
			throw new BadRequestException("The name of the match must not be null");
		
		

		repository.addLolMatch(match);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(match.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(match);			
		return resp.build();
	}

	//Updatear match
	@PUT
	@Consumes("application/json")
	public Response updateLolMatch(MatchLoL match) {
		MatchLoL oldmatch = repository.getLolMatch(match.getId());
		if (oldmatch == null) {
			throw new NotFoundException("The match with id="+ match.getId() +" was not found");			
		}
		
		
		// Update name
		if (match.getName()!=null)
			oldmatch.setName(match.getName());
		
		// Update champion
		if (match.getChampion()!=null)
			oldmatch.setChampion(match.getChampion());
		
		// Update kills
		if (match.getKills()!=null)
			oldmatch.setKills(match.getKills());
		
		// Update deaths
		if (match.getDeaths()!=null)
			oldmatch.setDeaths(match.getDeaths());
		
		// Update assist
		if (match.getAssists()!=null)
			oldmatch.setAssists(match.getAssists());
		
				
				
		
		return Response.noContent().build();
	}
	
	
	//Borrar match por id
	@DELETE
	@Path("/deletematchlol={id}")
	public Response removeLolMatch(@PathParam("id") String id) {
		MatchLoL toberemoved=repository.getLolMatch(id);
		if (toberemoved == null)
			throw new NotFoundException("The match with id="+ id +" was not found");
		else
			repository.deleteLolMatch(id);
		
		return Response.noContent().build();
	}
	
	//Borrar match por nombre
	@DELETE
	@Path("/deletematchlolbyname={name}")
	public Response removeLolMatchbyname(@PathParam("name") String name) {
		MatchLoL toberemoved=null;
		for (MatchLoL match: repository.getAllLolMatch()) {
            if ( match.getName().equals(name)) { // Name filter
            	toberemoved=match;
            }
        }
		if (toberemoved == null)
			throw new NotFoundException("The match with name="+ name +" was not found");
		else
			repository.deleteLolMatch(toberemoved.getId());
		
		return Response.noContent().build();
	}
	

}
