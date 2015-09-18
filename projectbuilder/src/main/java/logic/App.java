package logic;

public class App {
	
    public static void main( String[] args ) {
    	String projectName = args[0];
       	String domain = args[1];
       	startGeneration(projectName, domain);
    }
    
    private static void startGeneration(String projectName, String domain) {
    	
	   	LirejarpGenerator lirejarpGenerator = new LirejarpGenerator();
	   	
	   	for (GeneratorConfig generatorConfig : GeneratorConfig.values()) {
	   		if (!GeneratorConfig.REST_APP.equals(generatorConfig)) {
	   			lirejarpGenerator.generate(domain, generatorConfig);
	   		}
		}
	   	lirejarpGenerator.writeImportExportProterties(domain, GeneratorConfig.TESTDATA);
	   	lirejarpGenerator.writeImportExportProterties(domain, GeneratorConfig.JUNITTESTDATA);
	   	lirejarpGenerator.generateRestfulApplications(GeneratorConfig.REST, GeneratorConfig.REST_APP);
	    	
    }
}