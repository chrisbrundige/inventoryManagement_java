package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Part;

import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.util.EventListener;
import java.util.Random;

public class AddPartController {

    Stage stage;
    Parent scene;

    @FXML
    private TextField machineIdtxt;

    @FXML
    private Label isInhouse;

    @FXML
    private TextField partIDtxt;

    @FXML
    private TextField mintxt;

    @FXML
    private TextField maxtxt;

    @FXML
    private TextField partNametxt;

    @FXML
    private TextField inventorytxt;

    @FXML
    private TextField costtxt;

    @FXML
    private RadioButton inHouseRadio;

    @FXML
    private RadioButton outSourceRadio;

    @FXML
    private Button addPartSaveBtn;

    @FXML
    private Button cancelPartBtn;

    @FXML
    void changeIHLabel() {


        if (!inHouseRadio.isSelected()) isInhouse.setText("Company");
        else isInhouse.setText("Machine id");


    }

    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {


        int min = Integer.parseInt(mintxt.getText());
        int max = Integer.parseInt(maxtxt.getText());
        String name = partNametxt.getText();
        int inv = Integer.parseInt(inventorytxt.getText());
        int id = genPartId(inv);
        double price = Double.parseDouble(costtxt.getText());


        if (inHouseRadio.isSelected()) {
            int machineID = Integer.parseInt(machineIdtxt.getText());
            Inventory.addPart(new InHouse(id, name, price, inv, min, max, machineID));
        } else {
            String companyName = machineIdtxt.getText();
            Inventory.addPart(new Outsourced(id, name, price, inv, min, max, companyName));
        }


        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }

    private int genPartId(int someNum) {
        Random rand = new Random(someNum);
        return rand.nextInt(1000);

    }

    @FXML
    void onActionNavHome(ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }


    public void initialize() {


    }


}
