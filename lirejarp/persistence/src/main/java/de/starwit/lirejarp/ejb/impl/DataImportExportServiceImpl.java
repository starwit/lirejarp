package de.starwit.lirejarp.ejb.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.starwit.lirejarp.ejb.DataImportExportService;
import de.starwit.lirejarp.entity.AbstractEntity;
import de.starwit.lirejarp.enumerations.EntityForImport;


@Singleton
@Startup
@Stateless(name="DataImportExportService")
public class DataImportExportServiceImpl implements DataImportExportService {
	//TODO: refactor
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	private void startup() {
		init(); 
	}

	@PreDestroy
	private void shutdown() {
		
	}

	public void init() {
		File file = new File(getClass().getClassLoader().getResource("datasets").getPath());
		if (file.exists()) {
			String entityList = readImportExportProperties();
			
		    StringTokenizer tok = new StringTokenizer(entityList, ",");
		    while (tok.hasMoreTokens()) {
		    	String entry = tok.nextToken();
		    	EntityForImport entityDef = EntityForImport.valueOf(entry);
				InputStream in = this.getClass().getClassLoader()
						.getResourceAsStream("datasets/" + entityDef.name() + ".json");
				if (file.exists()) {
					importEntityData(entityDef.getEntityClass(), in);
				}
		    }
		}
	}
	
	@Override
	public void importEntityData(Class<? extends AbstractEntity> entityClass, InputStream in) {

			ObjectMapper mapper = new ObjectMapper();
			try {
				List<? extends AbstractEntity> entities = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, entityClass));
				for (AbstractEntity entity : entities) {
					entityManager.persist(entity);
				}
				//TODO: logging
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	private String readImportExportProperties() {
		Properties prop = new Properties();
		try {
		    //load a properties file from class path, inside static method
		    prop.load(getClass().getClassLoader().getResourceAsStream("datasets/importExport.properties"));
		    return prop.getProperty("loadedEntities");
		} 
		catch (IOException ex) {
			//TODO: logging
		    ex.printStackTrace();
		    return null;
		}
	}
}
