package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String TITLE = "Tuition Manager";
    private static final String FXML_LOCATION = "./application.FXML";
    private static boolean IS_RESIZABLE = false;

    /**
     * main function used to launch the JavaFX GUI used to manage a list of Students
     * 
     * @param args standard main input
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Sets the properties of the Stage used to manage a list of Students
     * graphically
     * 
     * @param primaryStage Stage to set the properties used to manage a list of
     *                     students to
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(FXML_LOCATION));

        BorderPane root = (BorderPane) loader.load();
        Controller ctrlr = loader.getController();
        ctrlr.start(primaryStage);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(IS_RESIZABLE);
        primaryStage.show();
    }
}
