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


import aiss.api.resources.comparators.ComparatorMatchPubgByKills;
import aiss.api.resources.comparators.ComparatorMatchPubgByKillsReverse;
import aiss.api.resources.comparators.ComparatorMatchPubgByLongestKill;
import aiss.api.resources.comparators.ComparatorMatchPubgByMap;
import aiss.modelapi.Matchpubg;
import aiss.model.repository.MapGamesRepository;
import aiss.model.repository.GamesRepository;


@Path("/partidaspubg")
public class MatchPubgResource {
	
	
	private static MatchPubgResource _instance=null;
	GamesRepository repository;
	
	private MatchPubgResource() {
		repository=MapGamesRepository.getInstance();

	}
	
	public static MatchPubgResource getInstance()
	{
		if(_instance==null)
				_instance=new MatchPubgResource();
		return _instance;
	}
	
	
    @GET
    @Produces("application/json")
    public Collection<Matchpubg> getAll(@QueryParam("order") String order,@QueryParam("player") String player,@QueryParam("id") String id,
    		@QueryParam("name") String name)
    {
        List<Matchpubg> result = new ArrayList<Matchpubg>();
            
        for (Matchpubg match: repository.getAllPubgMatch()) {
        	if(player!=null) {
  			  if ( match.getPlayer().getNombre().equals(player)) { // player filter
                    result.add(match);
            }
  		}else if(id!=null) {
  			  if ( match.getId().equals(id)) { // id filter
                    result.add(match);
            }
  		
  		}else if(name!=null) {
			  if ( match.getName().equals(name)) { // Name filter
                result.add(match);
        }
  		}else {
  			 result.add(match);
  		}
        
            
        }
            
        if (order != null) { // Order results
            if (order.equals("kill")) {
                Collections.sort(result, new ComparatorMatchPubgByKills());
            } else if (order.equals("-kill")) {
                Collections.sort(result, new ComparatorMatchPubgByKillsReverse());
            } else if (order.equals("lkill")){
            	Collections.sort(result, new ComparatorMatchPubgByLongestKill());
            } else if(order.equals("map")) {
            	Collections.sort(result, new ComparatorMatchPubgByMap());
            } else {
            	 throw new BadRequestException("The order parameter must be 'kill', '-kill','lkill' or 'map'.");
            }
        }

        return result;
    }
	
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addMatchPubg(@Context UriInfo uriInfo, Matchpubg match) {
		if (match.getName() == null || "".equals(match.getName()))
			throw new BadRequestException("The name of the match must not be null");
		
		

		repository.addPubgMatch(match);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(match.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(match);			
		return resp.build();
	}

	//Update match
	@PUT
	@Consumes("application/json")
	public Response updatePubgMatch(Matchpubg match) {
		Matchpubg oldmatch = repository.getPubgMatch(match.getId());
		if (oldmatch == null) {
			throw new NotFoundException("The match with id="+ match.getId() +" was not found");			
		}
		
		
		// Update name
		if (match.getName()!=null)
			oldmatch.setName(match.getName());
		
		// Update mapa
		if (match.getMapa()!=null)
			oldmatch.setMapa(match.getMapa());
		
		// Update kills
		if (match.getKills()!=null)
			oldmatch.setKills(match.getKills());
		
		// Update damage
		if (match.getDamage()!=null)
			oldmatch.setDamage(match.getDamage());
		
		// Update headshots
		if (match.getHeadshotskill()!=null)
			oldmatch.setHeadshotskill(match.getHeadshotskill());
		
		// Update walkdistance
		if (match.getWalkdistance()!=null)
			oldmatch.setWalkdistance(match.getWalkdistance());
				
		// Update longestkill
		if (match.getLongestkill()!=null)
			oldmatch.setLongestkill(match.getLongestkill());
				
		// Update place
		if (match.getWinplace()!=null)
			oldmatch.setWinplace(match.getWinplace());
							
				
		
		return Response.noContent().build();
	}
	
	//Borrar match por id
	@DELETE

	public Response removePubgMatch(@QueryParam("id") String id) {
		Matchpubg toberemoved=repository.getPubgMatch(id);
		if (toberemoved == null)
			throw new NotFoundException("The match with id="+ id +" was not found");
		else
			repository.deletePubgMatch(id);
		
		return Response.noContent().build();
	}
	
	//Borrar match por name
	@DELETE
	@Path("/deletebyname={name}")
	public Response removePubgMatchByName(@PathParam("name") String name) {
		Matchpubg toberemoved=null;
		  for (Matchpubg match: repository.getAllPubgMatch()) {
	            if (match.getName().equals(name)) { // Name filter
	              
	                    toberemoved=match;
	                
	            }
	        }
		if (toberemoved == null)
			throw new NotFoundException("The match with name="+ name +" was not found");
		else
			repository.deletePubgMatch(toberemoved.getId());
		
		return Response.noContent().build();
	}
	

}
