package lirejarp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class LirejarpGenerator {
	private static Logger LOG = Logger.getLogger(LirejarpGenerator.class);
	
	public void generate(String domain, GeneratorConfig generatorConfig) {
        //Freemarker configuration object
        Configuration cfg = new Configuration();
        try {
            //Load template from source folder
            Template template = cfg.getTemplate(generatorConfig.templateFile);
             
            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("domain", domain);
            data.put("domainLower", domain.toLowerCase());
            data.put("domainUpper", domain.toUpperCase());
 
            String className = domain + generatorConfig.suffix;
            // File output
            File serviceInterface = new File(generatorConfig.targetPath + className);
            if (!serviceInterface.exists()) {
	            Writer filewriter = new FileWriter (serviceInterface);
	            template.process(data, filewriter);
	            filewriter.flush();
	            filewriter.close();
        }
             
        } catch (IOException e) {
        	LOG.error("Error during file writing: ", e);
        } catch (TemplateException e) {
        	LOG.error("Error generation Template:", e);
        }
	}
	
	public void writeImportExportProterties(String domain, GeneratorConfig generatorConfig) {

		Properties prop = new Properties();
		final String configFileUrl = generatorConfig.targetPath + "importExport.properties";
		try {

	        File f = new File(configFileUrl);
	        FileInputStream is = new FileInputStream( f );
			prop.load(is);
			String loadedEntries = prop.getProperty("loadedEntities");
			if (loadedEntries == null || !loadedEntries.contains("," + domain + "Entity")) {
				loadedEntries = loadedEntries + "," + domain + "Entity";
			}
			prop.setProperty("loadedEntities", loadedEntries);
	        OutputStream out = new FileOutputStream(configFileUrl);
	        prop.store(out, "This is an optional header comment string");

		} catch (IOException e) {
			LOG.error("Error during file writing: ", e);
		}
	}
}
