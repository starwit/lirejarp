package lirejarp;

public enum GeneratorConfig {
	ENTITY("Entity.java", "src/main/resources/entity.ftl",  "../persistence/src/main/java/de/starwit/lirejarp/entity/"),
	SERVICE_INTERFACE("Service.java", "src/main/resources/service.ftl", "../persistence/src/main/java/de/starwit/lirejarp/ejb/"),
	
	SERVICE_IMPL("ServiceImpl.java", "src/main/resources/serviceImpl.ftl", "../persistence/src/main/java/de/starwit/lirejarp/ejb/impl/"),
	SERVICE_TEST("ServiceTest.java", "src/main/resources/serviceTest.ftl", "../persistence/src/test/java/de/starwit/lirejarp/ejb/"),
	TESTDATA("Entity.json", "src/main/resources/entityDataImport.ftl", "../business/src/main/resources/datasets/"),
	JUNITTESTDATA("Entity.json", "src/main/resources/entityDataImport.ftl", "../persistence/src/test/resources/datasets/"),

	REST("Rest.java", "src/main/resources/rest.ftl", "../business/src/main/java/de/starwit/lirejarp/api/rest/"),
	REST_APP("RestfulApplication.java", "src/main/resources/restfulApplication.ftl", "../business/src/main/java/de/starwit/lirejarp/api/restapp/");
	
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
