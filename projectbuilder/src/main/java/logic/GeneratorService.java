package logic;

import org.apache.log4j.Logger;

import frontend.beans.GeneratorSetupBean;

public class GeneratorService {
	private final static Logger LOG = Logger.getLogger(GeneratorService.class);
	
	public void generate(GeneratorSetupBean setupBean) {
		LOG.info("Setup Bean name " + setupBean.getProjectName() + " " + setupBean.getGenerateEntity());
		
	}

}
