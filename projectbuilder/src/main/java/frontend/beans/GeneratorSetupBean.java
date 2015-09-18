package frontend.beans;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSetupBean {
	
	private String projectName;
	private String projectPath;
	private String templatePath;
	private String domainName;
	private GeneratorOptions generatorOptions;
	
	private List<DomainAttributeBean> domainAttributes = new ArrayList<DomainAttributeBean>();
	
	public GeneratorSetupBean() {
		this.projectName = "lirejarp";
		this.projectPath = Paths.get("").toAbsolutePath().getParent().toString() + "\\" + projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public List<DomainAttributeBean> getDomainAttributes() {
		return domainAttributes;
	}
	public void setDomainAttributes(List<DomainAttributeBean> domainAttributes) {
		this.domainAttributes = domainAttributes;
	}
	
	public GeneratorOptions getGeneratorOptions() {
		return generatorOptions;
	}
	public void setGeneratorOptions(GeneratorOptions generatorOptions) {
		this.generatorOptions = generatorOptions;
	}
	
	public String getTemplatePath() {
		return templatePath;
	}
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

}
