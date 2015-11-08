package de.starwit.lirejarp.api.restapp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import de.starwit.lirejarp.api.rest.AbstractRest;
import de.starwit.lirejarp.api.rest.AddressRest;
import de.starwit.lirejarp.api.rest.DataImportExportRest;
import de.starwit.lirejarp.api.rest.PersonRest;


@ApplicationPath("/api")
public class RestfulApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		// register root resource
		classes.add(AbstractRest.class);
		classes.add(AddressRest.class);
		classes.add(DataImportExportRest.class);
		classes.add(PersonRest.class);

		return classes;
	}

}