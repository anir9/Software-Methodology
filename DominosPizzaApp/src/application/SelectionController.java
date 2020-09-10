package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SelectionController {
    
    @FXML private BorderPane selectionPane;
    
    @FXML private Label styleLabel;
    @FXML private Label sizeLabel;
    @FXML private Label usedLabel;
    @FXML private Label unusedLabel;
    
    @FXML private ComboBox<String> styleComboBox;
    @FXML private ComboBox<String> sizeComboBox;
    
    @FXML private ImageView pizzaIV;
    
    @FXML private ListView<String> usedLV;
    @FXML private ListView<String> unusedLV;
    
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private Button clearButton;
    @FXML private Button orderButton;
    @FXML private Button showButton;
    
    @FXML private TextArea outputTA;
    
    private Stage stage;
    private OrderDetailsController odctrlr;
    private Scene selectionScene;
    
    private ArrayList<Pizza> pizzas;
    private ArrayList<String> toppings;
    
    public void start(Stage stage, OrderDetailsController odctrlr) {
        this.stage = stage;
        this.odctrlr = odctrlr;
        selectionScene = new Scene(selectionPane);
        styleComboBox.getItems().addAll(Pizza.DELUXE, Pizza.HAWAIIAN, Pizza.BUILD_YOUR_OWN);
        sizeComboBox.getItems().addAll(Pizza.SMALL, Pizza.MEDIUM, Pizza.LARGE);
        styleComboBox.setValue(Pizza.BUILD_YOUR_OWN);
        sizeComboBox.setValue(Pizza.MEDIUM);
        pizzaIV.setImage(DominosAppLauncher.BUILD_YOUR_OWN_IMAGE);
        addButton.setDisable(true);
        removeButton.setDisable(true);
        clearButton.setDisable(true);
        orderButton.setDisable(true);
        showButton.setDisable(true);
        resetLVs();
        pizzas = new ArrayList<Pizza>();
        unusedLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        usedLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        outputTA.setEditable(false);
    }
    
    public void reset() {
        styleComboBox.setValue(Pizza.BUILD_YOUR_OWN);
        sizeComboBox.setValue(Pizza.MEDIUM);
        pizzaIV.setImage(DominosAppLauncher.BUILD_YOUR_OWN_IMAGE);
        orderButton.setDisable(true);
        if(pizzas.size() == 0) showButton.setDisable(true);
        resetLVs();
        outputTA.setText("");
        for(Pizza p: pizzas) {
            outputTA.appendText(p + "\n");
        }
    }
    
    @FXML
    private void changePizzaStyle() {
        resetLVs();
        addButton.setDisable(true);
        removeButton.setDisable(true);
        clearButton.setDisable(true);
        
        switch(styleComboBox.getValue()) {
        case Pizza.DELUXE:
            unusedLV.getItems().removeAll(Deluxe.DELUXE_TOPPINGS);
            usedLV.getItems().addAll(Deluxe.DELUXE_TOPPINGS);
            for(String s: Deluxe.DELUXE_TOPPINGS) toppings.add(s);
            orderButton.setDisable(false);
            pizzaIV.setImage(DominosAppLauncher.DELUXE_IMAGE);
            break;
        case Pizza.HAWAIIAN:
            unusedLV.getItems().removeAll(Hawaiian.HAWAIIAN_TOPPINGS);
            usedLV.getItems().addAll(Hawaiian.HAWAIIAN_TOPPINGS);
            for(String s: Hawaiian.HAWAIIAN_TOPPINGS) toppings.add(s);
            orderButton.setDisable(false);
            pizzaIV.setImage(DominosAppLauncher.HAWAIIAN_IMAGE);
            break;
        case Pizza.BUILD_YOUR_OWN:
            orderButton.setDisable(true);
            pizzaIV.setImage(DominosAppLauncher.BUILD_YOUR_OWN_IMAGE);
            break;
        }
    }
    
    @FXML
    private void addToppings() {
        usedLV.getItems().addAll(unusedLV.getSelectionModel().getSelectedItems());
        toppings.addAll(unusedLV.getSelectionModel().getSelectedItems());
        unusedLV.getItems().removeAll(unusedLV.getSelectionModel().getSelectedItems());
        usedLV.getSelectionModel().clearSelection();
        unusedLV.getSelectionModel().clearSelection();
        addButton.setDisable(true);
        clearButton.setDisable(false);
        orderButton.setDisable(false);
    }
    
    @FXML
    private void removeToppings() {
        unusedLV.getItems().addAll(usedLV.getSelectionModel().getSelectedItems());
        toppings.removeAll(usedLV.getSelectionModel().getSelectedItems());
        usedLV.getItems().removeAll(usedLV.getSelectionModel().getSelectedItems());
        usedLV.getSelectionModel().clearSelection();
        unusedLV.getSelectionModel().clearSelection();
        addButton.setDisable(true);
        removeButton.setDisable(true);
        if(toppings.size() == 0) {
            clearButton.setDisable(true);
            orderButton.setDisable(true);
        }
    }
    
    @FXML
    private void selectionChage() {
        int numUnusedSelected = unusedLV.getSelectionModel().getSelectedIndices().size();
        int numUsedSelected = usedLV.getSelectionModel().getSelectedIndices().size();
        int numSelected = numUnusedSelected + toppings.size();
        if(numSelected > BuildYourOwn.MAX_NUM_TOPPINGS) {
            addButton.setDisable(true);
        } else if(numUnusedSelected > 0){
            addButton.setDisable(false);
        } else {
            addButton.setDisable(true);
        }
        if(toppings.size() == 0) {
            removeButton.setDisable(true);
            clearButton.setDisable(true);
        } else if(numUsedSelected == 0) {
            removeButton.setDisable(true);
            clearButton.setDisable(false);
        } else {
            removeButton.setDisable(false);
            clearButton.setDisable(false);
        }
    }
    
    @FXML
    private void clearSelection() {
        resetLVs();
        usedLV.getSelectionModel().clearSelection();
        unusedLV.getSelectionModel().clearSelection();
        addButton.setDisable(true);
        removeButton.setDisable(true);
        orderButton.setDisable(true);
        clearButton.setDisable(true);
    }
    
    @FXML
    private void addToOrder() {
        switch(styleComboBox.getValue()) {
        case Pizza.DELUXE:
                pizzas.add(new Deluxe(styleComboBox.getValue(), sizeComboBox.getValue(), toppings));
                break;
        case Pizza.HAWAIIAN:
                pizzas.add(new Hawaiian(styleComboBox.getValue(), sizeComboBox.getValue(), toppings));
                break;
        case Pizza.BUILD_YOUR_OWN:
                pizzas.add(new BuildYourOwn(styleComboBox.getValue(), sizeComboBox.getValue(), toppings));
                break;
        }
        outputTA.appendText("Added -> " + pizzas.get(pizzas.size()-1) + "\n");
        if(styleComboBox.getValue().equals(Pizza.BUILD_YOUR_OWN)) {
            resetLVs();
            orderButton.setDisable(true);
        }
        addButton.setDisable(true);
        removeButton.setDisable(true);
        clearButton.setDisable(true);
        showButton.setDisable(false);
    }
    
    @FXML
    private void showOrder() {
        odctrlr.reset();
        stage.hide();
        stage.setScene(odctrlr.getScene());
        stage.show();
    }
    
    private void resetLVs() {
        usedLV.getItems().clear();
        unusedLV.getItems().clear();
        unusedLV.getItems().addAll(Pizza.TOPPINGS_AVAILABLE);
        
        toppings = new ArrayList<String>();
    }
    
    public Scene getScene() {
        return selectionScene;
    }
    
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
}
