package lirejarp;

public class App {
	
    public static void main( String[] args ) {
       	String domain = args[0];
       	startGeneration(domain);
    }
    
    private static void startGeneration(String domain) {
    	
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