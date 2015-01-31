package lirejarp;

//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;

public class App //extends Application
{
	
    public static void main( String[] args )
    {
//        launch(args);
//        
       	String domain = args[0];
       	startGeneration(domain);
//       	

    }
    
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Domain Configuration");
//        
//        final Label label1 = new Label("Domain Name:");
//        final TextField textField = new TextField ();
//        Button btn = new Button();
//        btn.setText("Generate");
//        final Label labelsuccess = new Label("");
//        
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//        	 
//            @Override
//            public void handle(ActionEvent event) {
//            	String text = textField.getText();
//            	textField.setText(null);
//            	startGeneration(text);
//            	labelsuccess.setText("Domain with name " + text + " generated!");
//            }
//        });
//        
//        VBox vb = new VBox();
//        
//        HBox hb = new HBox();
//        hb.getChildren().addAll(textField, btn);
//        hb.setSpacing(10);
//        vb.getChildren().addAll(label1, hb, labelsuccess);
//        vb.setSpacing(10);
//            
//
//        
//        
//
//        StackPane root = new StackPane();
//        root.getChildren().add(vb);
//        root.setPadding(new Insets(10));
//        primaryStage.setScene(new Scene(root, 270, 100));
//        primaryStage.show();
//    }
    
    private static void startGeneration(String domain) {
    	
	   	LirejarpGenerator lirejarpGenerator = new LirejarpGenerator();
	   	
	   	for (GeneratorConfig generatorConfig : GeneratorConfig.values()) {
	       	lirejarpGenerator.generate(domain, generatorConfig);
		}
	   	lirejarpGenerator.writeImportExportProterties(domain, GeneratorConfig.TESTDATA);
	   	lirejarpGenerator.writeImportExportProterties(domain, GeneratorConfig.JUNITTESTDATA);
	    	
    }
}