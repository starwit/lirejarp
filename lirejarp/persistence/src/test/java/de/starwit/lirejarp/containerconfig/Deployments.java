package de.starwit.lirejarp.containerconfig;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

/**
 * For description https://github.com/ingwarsw/arquillian-suite-extension
 * 
 * @author Anett
 *
 */
@ArquillianSuiteDeployment
public class Deployments {

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar").addPackages(true, "de/starwit/lirejarp")
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
	                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
	}
	


}
