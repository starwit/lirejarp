package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    		String name = domain + generatorConfig.suffix;
            writeGeneratedFile(generatorConfig.targetPath + name, template, data);
        } catch (IOException e) {
        	LOG.error("Error during file writing: ", e);
        } catch (TemplateException e) {
        	LOG.error("Error generation Template:", e);
        }
	}

	private void writeGeneratedFile(String filepath, Template template, Map<String, Object> data) throws IOException, TemplateException {
		
		// File output
		File serviceInterface = new File(filepath);
		if (!serviceInterface.exists()) {
		    Writer filewriter = new FileWriter (serviceInterface);
		    template.process(data, filewriter);
		    filewriter.flush();
		    filewriter.close();
		}
	}
	
	public void generateRestfulApplications(GeneratorConfig restservicesfolder,
			GeneratorConfig generatorConfig) {

		File folder = new File(restservicesfolder.targetPath);
		File[] listOfFiles = folder.listFiles();
		int l = listOfFiles.length;

		List<String> classnames = new ArrayList<String>(l);
		for (File file : listOfFiles) {
			if (file.isFile()) {
				String value = file.getName().replace(".java", "");
				classnames.add(value);
			}
		}

		// Freemarker configuration object
		Configuration cfg = new Configuration();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("classnames", classnames);

		try {
			// Load template from source folder
			Template template = cfg.getTemplate(generatorConfig.templateFile);
			File restapp = new File(generatorConfig.targetPath
					+ generatorConfig.suffix);
		    Writer filewriter = new FileWriter (restapp);
		    template.process(data, filewriter);
		    filewriter.flush();
		    filewriter.close();
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
