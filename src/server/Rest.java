package server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
@ApplicationPath("/rest")
public class Rest extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(schach.server.Spiel.class);
		classes.add(schach.server.SpielAdmin.class);
		return classes;
	}
}



 


