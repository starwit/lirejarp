package lirejarp;

public class App 
{
	
    public static void main( String[] args )
    {
       	LirejarpGenerator lirejarpGenerator = new LirejarpGenerator();
       	
       	String domain = "TestTest2";
       	
       	for (GeneratorConfig generatorConfig : GeneratorConfig.values()) {
           	lirejarpGenerator.generate(domain, generatorConfig);
		}
       	lirejarpGenerator.writeImportExportProterties(domain, GeneratorConfig.TESTDATA);
       	lirejarpGenerator.writeImportExportProterties(domain, GeneratorConfig.JUNITTESTDATA);
    }
}
