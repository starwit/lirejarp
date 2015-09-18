package de.starwit.lirejarp.api.restapp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import de.starwit.lirejarp.api.rest.NewsRest;
import de.starwit.lirejarp.api.rest.AbstractRest;
import de.starwit.lirejarp.api.rest.CategoryRest;
import de.starwit.lirejarp.api.rest.DataImportExportRest;


/**
 * This class registers all rest web service implementing classes. Necessary due to "advancements" in JAX-RS 2.0.
 * Be aware that no service will run unless added here!
 *  
 * @author markus
 *
 */
@ApplicationPath("/api")
public class RestfulApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		// register root resource
		classes.add(NewsRest.class);
		classes.add(AbstractRest.class);
		classes.add(CategoryRest.class);
		classes.add(DataImportExportRest.class);

		return classes;
	}

}