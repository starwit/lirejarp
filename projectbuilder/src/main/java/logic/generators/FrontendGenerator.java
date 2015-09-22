package logic.generators;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import frontend.beans.GeneratorSetupBean;
import logic.GeneratorConfig;

public class FrontendGenerator extends Generator {

	@Override
	public void generate(GeneratorSetupBean setupBean) {
		String packagePath = setupBean.getProjectPath() + "\\frontend\\" + Generator.SRC_FRONTEND_PATH;
		String domain = setupBean.getDomainName();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("domain", domain);
		data.put("domainLower", domain.toLowerCase());
		data.put("domainUpper", domain.toUpperCase());
		data.put("appName", setupBean.getProjectName());
		data.put("attributes", setupBean.getDomainAttributes());

		generateInDomainFolder(setupBean, packagePath, data, GeneratorConfig.ALL_UI);
		generateInDomainFolder(setupBean, packagePath, data, GeneratorConfig.MAINTAIN_UI);
		
		generateInDomainFolder(setupBean, packagePath, data, GeneratorConfig.CONFIG_UI);
		generateInDomainFolder(setupBean, packagePath, data, GeneratorConfig.CONTROLLER_UI);
		
		generateConnector(setupBean, packagePath, data);
	}
	
	private void generateConnector(GeneratorSetupBean setupBean, String packagePath, Map<String, Object> data) {
		try {
			Template template = getTemplate(setupBean, GeneratorConfig.CONNECTOR_UI);
			String domain = setupBean.getDomainName().toLowerCase();
			String name = domain + GeneratorConfig.CONNECTOR_UI.suffix;
			writeGeneratedFile(packagePath + "\\" + GeneratorConfig.CONNECTOR_UI.targetPath + "\\" + name, template, data);
		} catch (IOException e) {
			LOG.error("Error during file writing: ", e);
		} catch (TemplateException e) {
			LOG.error("Error generation Template:", e);
		}
	}

}
