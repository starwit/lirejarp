package logic;

import org.apache.log4j.Logger;

import frontend.beans.GeneratorSetupBean;
import logic.generators.EntityGenerator;
import logic.generators.FrontendGenerator;
import logic.generators.RestGenerator;
import logic.generators.ServiceGenerator;

public class GeneratorService {

	public final static Logger LOG = Logger.getLogger(GeneratorService.class);
	
	public void generate(GeneratorSetupBean setupBean) {

		LOG.info("Setup Bean templatePath " + setupBean.getTemplatePath());
		LOG.info("Setup Bean generate Entity:  " + setupBean.getGenerateEntity());
		LOG.info("Setup Bean generate Service: " + setupBean.getGenerateService());
		LOG.info("Setup Bean generate Rest: " + setupBean.getGenerateRest());
		LOG.info("Setup Bean generate Frontend: " + setupBean.getGenerateFrontend());
		if (setupBean.getDomainAttributes() != null && setupBean.getDomainAttributes().size() > 0) {
			LOG.info("First Attribute Name: " + setupBean.getDomainAttributes().get(0).getColumnName());
		}
		
		if (setupBean.getGenerateEntity()) {
			EntityGenerator entityGenerator = new EntityGenerator();
			entityGenerator.generate(setupBean);
		}
		if (setupBean.getGenerateService()) {
			ServiceGenerator serviceGenerator = new ServiceGenerator();
			serviceGenerator.generate(setupBean);
		}
		if (setupBean.getGenerateRest()) {
			RestGenerator restGenerator = new RestGenerator();
			restGenerator.generate(setupBean);
		}
		
		if (setupBean.getGenerateFrontend()) {
			FrontendGenerator frontendGenerator = new FrontendGenerator();
			frontendGenerator.generate(setupBean);
		}
		
	}
	

	
}
