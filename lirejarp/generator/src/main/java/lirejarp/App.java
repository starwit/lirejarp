package lirejarp;

public class App 
{
    public static void main( String[] args )
    {
       	ServiceGenerator serviceGenerator = new ServiceGenerator();
        serviceGenerator.generateServiceInterfaces("TestTest");
        serviceGenerator.generateServiceImpl("TestTest");
        
        RestGenerator restGenerator = new RestGenerator();
        restGenerator.generateRest("TestTest");
    }
}
