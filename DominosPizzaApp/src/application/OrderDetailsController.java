package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OrderDetailsController {

    @FXML private BorderPane orderPane;
    
    @FXML private Label orderLabel;
    @FXML private Label totalLabel;
    
    @FXML private ListView<Pizza> orderLV;
    
    @FXML private Button clearButton;
    @FXML private Button wipeButton;
    @FXML private Button backButton;
    
    @FXML private TextArea outputTA;
    
    private final String TOTAL_TEXT = "Order Total: $";
    
    private Stage stage;
    private SelectionController slctrlr;
    private Scene orderScene;
    
    private ArrayList<Pizza> pizzas;
    
    public void start(Stage stage, SelectionController slctrlr) {
        this.stage = stage;
        this.slctrlr = slctrlr;
        orderScene = new Scene(orderPane);
        pizzas = slctrlr.getPizzas();
        orderLV.getItems().addAll(pizzas);
        orderLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        totalLabel.setText(TOTAL_TEXT + getTotal());
        clearButton.setDisable(true);
        outputTA.setEditable(false);
    }
    
    public void reset() {
        outputTA.setText("");
        orderLV.getItems().removeAll(orderLV.getItems());
        orderLV.getItems().addAll(pizzas);
        totalLabel.setText(TOTAL_TEXT + getTotal());
        clearButton.setDisable(true);
        wipeButton.setDisable(false);
    }
    
    @FXML
    private void clearSelection() {
        for(Pizza p: orderLV.getSelectionModel().getSelectedItems()) {
            outputTA.appendText("Removed -> " + p + "\n");
        }
        pizzas.removeAll(orderLV.getSelectionModel().getSelectedItems());
        orderLV.getItems().removeAll(orderLV.getSelectionModel().getSelectedItems());       
        totalLabel.setText(TOTAL_TEXT + getTotal());
        clearButton.setDisable(true);
        if(pizzas.size() <= 0) wipeButton.setDisable(true);
        orderLV.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void clearOrder() {
        outputTA.appendText("Removed all pizzas from order\n");
        orderLV.getItems().removeAll(orderLV.getItems());
        pizzas.removeAll(pizzas);
        totalLabel.setText(TOTAL_TEXT + getTotal());
        clearButton.setDisable(true);
        wipeButton.setDisable(true);
    }
    
    @FXML
    private void changeDisable() {
        if(orderLV.getSelectionModel().getSelectedItems().size() == 0) {
            clearButton.setDisable(true);
        } else {
            clearButton.setDisable(false);
        }
    }
    
    @FXML
    private void goBack() {
        slctrlr.reset();
        stage.hide();
        stage.setScene(slctrlr.getScene());
        stage.show();
    }
    
    private int getTotal() {
        int total = 0;
        for(Pizza p: pizzas) total += p.pizzaPrice();
        return total;
    }
    
    public Scene getScene() {
        return orderScene;
    }
}
