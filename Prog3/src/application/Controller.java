package application;

import tuitionManager.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Controller {
    private static final String[] STATUS = { 
	    "Tuition Manager started successfully\n\n",
            "Student successfully added to the list\n", 
	    "Student successfully removed from the list\n",
            "Error: No first name and/or last name specified for student\n",
            "Error: credits specified is not a number\n", 
	    "Error: number of credits must be greater than zero\n",
            "Error: No first name and/or last name specified for student\n", 
	    "Error: student specified not on list\n",
            "Error: student already on list\n", 
	    "Error: amount of funding specified is not an integer\n",
            "Error: invalid amount of funding\n", 
	    "Warning: part time students are not eligible for funding\n",
            "Error: International students must take at least " + International.MIN_CREDIT_HOURS + " credit hours\n",
            "Error: number of credits not specified\n", 
	    "Student specified was unable to be added to list\n\n",
            "Student specified was unable to be removed from list\n\n" };

    private static final String INSTATE_RBTEXT = "Instate";
    private static final String OUTSTATE_RBTEXT = "Outstate";
    private static final String INTERNATIONAL_RBTEXT = "International";

    @FXML
    private Label fnameLabel;
    @FXML
    private TextField fnameTF;
    @FXML
    private Label lnameLabel;
    @FXML
    private TextField lnameTF;
    @FXML
    private Label creditsLabel;
    @FXML
    private TextField creditsTF;
    @FXML
    private Label studentTypeLabel;
    @FXML
    private RadioButton instateRB;
    @FXML
    private RadioButton outstateRB;
    @FXML
    private RadioButton internationalRB;
    @FXML
    private CheckBox instateCB;
    @FXML
    private CheckBox outstateCB;
    @FXML
    private CheckBox internationalCB;
    @FXML
    private TextField instateTF;
    @FXML
    private TextArea outputTA;

    private StudentList students = new StudentList();
    ToggleGroup studentTypeRG = new ToggleGroup();

    public void start(Stage primaryStage) {
        instateRB.setToggleGroup(studentTypeRG);
        outstateRB.setToggleGroup(studentTypeRG);
        internationalRB.setToggleGroup(studentTypeRG);
        studentTypeRG.selectToggle(instateRB);
        outstateCB.setDisable(true);
        internationalCB.setDisable(true);
        outputTA.setEditable(false);
        outputTA.setText(STATUS[0]);

        fnameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                fnameTF.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
        lnameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                lnameTF.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
    }

    @FXML
    private void instateRBClick() {
        instateCB.setDisable(false);
        instateTF.setDisable(false);
        outstateCB.setDisable(true);
        outstateCB.setSelected(false);
        internationalCB.setDisable(true);
        internationalCB.setSelected(false);
    }

    @FXML
    private void outstateRBClick() {
        instateCB.setDisable(true);
        instateCB.setSelected(false);
        instateTF.setDisable(true);
        outstateCB.setDisable(false);
        internationalCB.setDisable(true);
        internationalCB.setSelected(false);
    }

    @FXML
    private void internationalRBClick() {
        instateCB.setDisable(true);
        instateCB.setSelected(false);
        instateTF.setDisable(true);
        outstateCB.setDisable(true);
        outstateCB.setSelected(false);
        internationalCB.setDisable(false);
    }

    @FXML
    private void add() {
        boolean blockStudentAdd = false;

        String fn = fnameTF.getText();
        String ln = lnameTF.getText();
        if (fn.equals("") || ln.equals("")) {
            outputTA.appendText(STATUS[3]);
            blockStudentAdd = true;
        }

        String studentType = ((RadioButton) studentTypeRG.getSelectedToggle()).getText();

        String crs = creditsTF.getText();
        if (crs.equals("")) {
            outputTA.appendText(STATUS[13]);
            outputTA.appendText(STATUS[14]);
            return;
        }
        int cr = 0;
        int funds = 0;
        try {
            cr = Integer.parseInt(crs);
            if (studentType.equals(INTERNATIONAL_RBTEXT) && cr < International.MIN_CREDIT_HOURS) {
                outputTA.appendText(STATUS[12]);
                blockStudentAdd = true;
            } else if (cr <= 0) {
                outputTA.appendText(STATUS[5]);
                blockStudentAdd = true;

            } else if (studentType.equals(INSTATE_RBTEXT) && instateCB.isSelected()) {
                try {
                    funds = Integer.parseInt(instateTF.getText());
                    if (cr < Student.FULL_TIME_CREDITS) {
                        outputTA.appendText(STATUS[11]);
                    }
                    if (funds < 0) {
                        outputTA.appendText(STATUS[10]);
                        blockStudentAdd = true;
                    }
                } catch (NumberFormatException ex) {
                    outputTA.appendText(STATUS[9]);
                    blockStudentAdd = true;
                }
            }
        } catch (NumberFormatException ex) {
            outputTA.appendText(STATUS[4]);
            blockStudentAdd = true;
        }

        if (blockStudentAdd) {
            outputTA.appendText(STATUS[14]);
            return;
        }

        boolean isAdded = false;
        switch (studentType) {
            case INSTATE_RBTEXT:
                isAdded = students.add(new Instate(fn, ln, cr, funds));
                break;
            case OUTSTATE_RBTEXT:
                isAdded = students.add(new Outstate(fn, ln, cr, outstateCB.isSelected()));
                break;
            case INTERNATIONAL_RBTEXT:
                isAdded = students.add(new International(fn, ln, cr, internationalCB.isSelected()));
                break;
        }

        if (isAdded) {
            outputTA.appendText(STATUS[1]);
        } else {
            outputTA.appendText(STATUS[8]);
            outputTA.appendText(STATUS[14]);
        }
    }

    @FXML
    private void remove() {
        String fn = fnameTF.getText();
        String ln = lnameTF.getText();
        if (fn.equals("") || ln.equals("")) {
            outputTA.appendText(STATUS[6]);
            outputTA.appendText(STATUS[15]);
            return;
        }

        if (students.remove(new Instate(fn, ln, 0, 0))) {
            outputTA.appendText(STATUS[2]);
        } else {
            outputTA.appendText(STATUS[7]);
            outputTA.appendText(STATUS[15]);
        }
    }

    @FXML
    private void print() {
        outputTA.appendText(students.toString() + "\n");
    }
}