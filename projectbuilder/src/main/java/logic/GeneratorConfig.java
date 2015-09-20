package logic;

public enum GeneratorConfig {
	ENTITY("Entity.java", "entity.ftl",  "entity"),
	
	SERVICE_INTERFACE("Service.java", "service.ftl", "ejb"),
	SERVICE_IMPL("ServiceImpl.java", "serviceImpl.ftl", "ejb/impl"),
	SERVICE_TEST("ServiceTest.java", "serviceTest.ftl", "ejb"),
	JUNITTESTDATA("Entity.json", "entityDataImport.ftl", "datasets"),

	REST("Rest.java", "rest.ftl", "api/rest"),
	REST_APP("RestfulApplication.java", "restfulApplication.ftl", "api/restapp"),

	TESTDATA("Entity.json", "entityDataImport.ftl", "datasets");
	
	public String suffix;
	public String templateFile;
	public String targetPath;
	
	private GeneratorConfig(String suffix, String templateFile, String targetPath) {
		this.suffix = suffix;
		this.templateFile = templateFile;
		this.targetPath = targetPath;
		
	}

	public String getSuffix() {
		return suffix;
	}

	public String getTemplateFile() {
		return templateFile;
	}

	public String getTargetPath() {
		return targetPath;
	}
}
