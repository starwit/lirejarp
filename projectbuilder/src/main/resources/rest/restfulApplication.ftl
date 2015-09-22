package de.starwit.lirejarp.api.restapp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
<#list (classnames) as name>
import de.starwit.lirejarp.api.rest.${name};
</#list>


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
		<#list (classnames) as name>
		classes.add(${name}.class);
		</#list>

		return classes;
	}

}