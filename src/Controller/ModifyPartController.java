package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Part;

import java.io.IOException;

public class ModifyPartController {

    Stage stage;
    Parent scene;


    @FXML
    private TextField modPartMachineId;

    @FXML
    private Label isInhouse;

    @FXML
    private RadioButton radioInHouse;

    @FXML
    private RadioButton radioOutSource;

    @FXML
    private TextField modID;

    @FXML
    private TextField modPartMin;

    @FXML
    private TextField modPartMax;

    @FXML
    private TextField modPartName;

    @FXML
    private TextField modPartInv;

    @FXML
    private TextField modPartCost;

    @FXML
    private ToggleGroup modPartIO;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelModPart;

    @FXML
    void onActionNavHome(ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @FXML
    void navToAdd(ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/Add_product_view.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @FXML
    private void modify(Part part) {

        part.setId(Integer.parseInt(modID.getText()));
        part.setName(modPartName.getText());
        part.setStock(Integer.parseInt(modPartInv.getText()));
        part.setPrice(Double.parseDouble(modPartCost.getText()));
        part.setMax(Integer.parseInt(modPartMax.getText()));
        part.setMin(Integer.parseInt(modPartMin.getText()));


    }

    @FXML
    private void onActionSave(ActionEvent event, Part part) {

        modify(part);


    }


    @FXML
    void changeIHLabel() {

        if (!radioInHouse.isSelected()) isInhouse.setText("Company");
        else isInhouse.setText("Machine id");

    }

    public void receivePart(Part part) {

        modID.setText(String.valueOf(part.getId()));
        modPartName.setText(part.getName());
        modPartInv.setText(String.valueOf(part.getStock()));
        modPartCost.setText(String.valueOf(part.getPrice()));
        modPartMax.setText(String.valueOf(part.getMax()));
        modPartMin.setText(String.valueOf(part.getMin()));
        if (part instanceof InHouse) {
            radioInHouse.setSelected(true);
            modPartMachineId.setText(String.valueOf(((InHouse) part).getMachineID()));
        } else {

            modPartMachineId.setText(String.valueOf(((Outsourced) part).getCompanyName()));
            radioOutSource.setSelected(true);


        }
        changeIHLabel();
    }


    @FXML
    void initialize() {


    }


}