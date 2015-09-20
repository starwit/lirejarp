package logic.generators;

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
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import frontend.beans.GeneratorSetupBean;
import logic.GeneratorConfig;

public abstract class Generator {
	
	public final static Logger LOG = Logger.getLogger(Generator.class);

	public final static String SRC_JAVA_PATH = "src\\main\\java\\de\\starwit\\";
	public final static String TEST_JAVA_PATH = "src\\test\\java\\de\\starwit\\";
	public final static String TEST_RESOURCES_PATH = "src\\test\\resources\\";
	
	public abstract void generate(GeneratorSetupBean setupBean);
	
	protected void writeGeneratedFile(String filepath, Template template, Map<String, Object> data) throws IOException, TemplateException {
		
		// File output
		File serviceInterface = new File(filepath);
		if (!serviceInterface.exists()) {
		    Writer filewriter = new FileWriter (serviceInterface);
		    template.process(data, filewriter);
		    filewriter.flush();
		    filewriter.close();
		}
	}
	
	protected void generate(GeneratorSetupBean setupBean, String packagePath, GeneratorConfig generatorConfig) {
        String domain = setupBean.getDomainName();
        
	       // Build the data-model
	       Map<String, Object> data = new HashMap<String, Object>();
	       data.put("domain", domain);
	       data.put("domainLower", domain.toLowerCase());
	       data.put("domainUpper", domain.toUpperCase());

	       generate(setupBean, packagePath, data, generatorConfig);
	}
	
	protected void generate(GeneratorSetupBean setupBean, String packagePath, Map<String, Object> data, GeneratorConfig generatorConfig) {
        Configuration cfg = new Configuration();
		cfg.setObjectWrapper( new DefaultObjectWrapper() );
        String domain = setupBean.getDomainName();

        try {
        	cfg.setDirectoryForTemplateLoading(new File(setupBean.getTemplatePath()));
            //Load template from source folder
            Template template = cfg.getTemplate(generatorConfig.templateFile);
            
            String name = domain + generatorConfig.suffix;  
            writeGeneratedFile(packagePath + "\\" + generatorConfig.targetPath + "\\" + name + "\\", template, data);
        } catch (IOException e) {
        	LOG.error("Error during file writing: ", e);
        } catch (TemplateException e) {
        	LOG.error("Error generation Template:", e);
        }
	}
	
	protected void writeImportExportProterties(String domain, String packagePath, GeneratorConfig generatorConfig) {

		Properties prop = new Properties();
		final String configFileUrl = packagePath + "\\" + generatorConfig.targetPath + "\\" + "importExport.properties";
		
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
