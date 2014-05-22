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

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.starwit.lirejarp.config.ProjectConfig;
import de.starwit.lirejarp.ejb.DataImportExportService;
import de.starwit.lirejarp.entity.AbstractEntity;
import de.starwit.lirejarp.enumerations.EntityForImport;
import de.starwit.lirejarp.exception.ImportException;


@Singleton
@Startup
@Stateless(name="DataImportExportService")
public class DataImportExportServiceImpl implements DataImportExportService {
	
	private static Logger LOG = Logger.getLogger( DataImportExportServiceImpl.class );

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
		try {
			File file = new File(getClass().getClassLoader().getResource(ProjectConfig.IMPORT_EXPORT_FOLDER).getPath());
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
		} catch (ImportException e) {
			LOG.error(e.getMessage(), e.getThrowable());
		}
	}
	
	@Override
	public void importEntityData(Class<? extends AbstractEntity> entityClass, InputStream in) 
			throws ImportException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			
				List<? extends AbstractEntity> entities = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, entityClass));
				for (AbstractEntity entity : entities) {
					entityManager.persist(entity);
				}
			} catch (JsonParseException e) {
				throw new ImportException(e, ImportException.MessageType.JSON_PARSING);
			} catch (JsonMappingException e) {
				throw new ImportException(e, ImportException.MessageType.JSON_MAPPING);
			} catch (IOException e) {
				throw new ImportException(e, ImportException.MessageType.READ_FILE);
			}
		}
	
	private String readImportExportProperties() throws ImportException {
		Properties prop = new Properties();
		final String configFileUrl = ProjectConfig.IMPORT_EXPORT_FOLDER 
	    		+ "/" + ProjectConfig.IMPORT_EXPORT_CONFIG_FILENAME;
		try {
		    //load a properties file from class path, inside static method
		    prop.load(getClass().getClassLoader().getResourceAsStream(configFileUrl));
		    return prop.getProperty("loadedEntities");
		} 
		catch (IOException e) {
			throw new ImportException(e, ImportException.MessageType.READ_CONFIG, configFileUrl, ". ");
		}
	}
}
