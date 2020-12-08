package Controller;

/**
 * Sample Skeleton for 'Modify_product.fxml' Controller Class
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddProductController {

    Stage stage;
    Parent scene;

    public Button addProductButton;
    public Button cancelAddProductButton;
    public Button removeProdButton;
    public Button saveButton;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }

    @FXML
    void onActionNavHome(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }
}
