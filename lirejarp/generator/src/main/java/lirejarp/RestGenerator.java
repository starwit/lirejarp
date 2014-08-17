package lirejarp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class RestGenerator {

	public void generateRest(String domain) {
        //Freemarker configuration object
        Configuration cfg = new Configuration();
        try {
            //Load template from source folder
            Template template = cfg.getTemplate("src/main/resources/rest.ftl");
             
            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("domain", domain);
            data.put("domainLower", domain.toLowerCase());
 
            String className = domain + "Rest.java";
            // File output
            File serviceInterface = new File("..\\business\\src\\main\\java\\de\\starwit\\lirejarp\\api\\rest\\" + className);
            if (!serviceInterface.exists()) {
	            Writer filewriter = new FileWriter (serviceInterface);
	            template.process(data, filewriter);
	            filewriter.flush();
	            filewriter.close();
        }
             
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
	}
}
