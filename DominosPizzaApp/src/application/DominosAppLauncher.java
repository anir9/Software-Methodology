package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class DominosAppLauncher extends Application {
    
    public static final Image DELUXE_IMAGE = new Image("/application/deluxe.jpeg");
    public static final Image HAWAIIAN_IMAGE = new Image("/application/hawaiian.jpeg");
    public static final Image BUILD_YOUR_OWN_IMAGE = new Image("/application/BuildYourOwn.jpeg");
    
    private static final String TITLE = "Domino's Pizza!";
    private static final String FXML_LOCATION_SELECTION = "./Selection.fxml";
    private static final String FXML_LOCATION_DETAILS = "./OrderDetails.fxml";
    private static boolean IS_RESIZABLE = false;
    
	@Override
	public void start(Stage primaryStage) throws Exception{
	    FXMLLoader selectionLoader = new FXMLLoader();
        selectionLoader.setLocation(getClass().getResource(FXML_LOCATION_SELECTION));
	    FXMLLoader detailsLoader = new FXMLLoader();
	    detailsLoader.setLocation(getClass().getResource(FXML_LOCATION_DETAILS));

	    selectionLoader.load();
	    detailsLoader.load();
	    
        SelectionController slctrlr = selectionLoader.getController();
        OrderDetailsController odctrlr = detailsLoader.getController();
        
        slctrlr.start(primaryStage, odctrlr);
        odctrlr.start(primaryStage, slctrlr);

        primaryStage.setScene(slctrlr.getScene());
        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(IS_RESIZABLE);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
