package aiss.api;

import java.util.HashSet;

import java.util.Set;

import javax.ws.rs.core.Application;
import aiss.api.resources.MatchLolResource;
import aiss.api.resources.MatchPubgResource;
import aiss.api.resources.PlayerLolResource;
import aiss.api.resources.PlayerPubgResource;



public class GameApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public GameApplication() {

		singletons.add(MatchLolResource.getInstance());
		singletons.add(MatchPubgResource.getInstance());
		singletons.add(PlayerLolResource.getInstance());
		singletons.add(PlayerPubgResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
