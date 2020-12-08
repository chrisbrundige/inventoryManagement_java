package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;


public class MainViewController {


    Stage stage;
    Parent scene;


    @FXML
    private TextField partSearchBox;

    @FXML
    private TextField productSearchBox;

    @FXML
    private Button navToAddParts;

    @FXML
    private TableView<Part> partsTableView;

    @FXML
    private TableColumn<Part, Integer> partIdCol;

    @FXML
    private TableColumn<Part, String> partNameCol;

    @FXML
    private TableColumn<Part, Integer> part_invCol;

    @FXML
    private TableColumn<Part, Double> cost_partCol;

    @FXML
    private TableView<Product> productsTableView;

    @FXML
    private TableColumn<Product, Integer> productIdCol;

    @FXML
    private TableColumn<Product, String> prodNameCol;

    @FXML
    private TableColumn<Product, Integer> prod_invCol;

    @FXML
    private TableColumn<Product, Double> prod_priceCol;

    @FXML
    void deleteProduct(ActionEvent event) {

    }

    @FXML
    void onActionDelete(ActionEvent event) {


        Part me = partsTableView.getSelectionModel().getSelectedItem();
        Inventory.getAllParts().remove(me);


    }

    @FXML
    void onActionExit(ActionEvent event) {

        System.exit(0);
    }


    @FXML
    void onActionNavToAddParts(ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/Add_Part.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @FXML
    void onActionNavToModifyParts(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Modify_part_view.fxml"));
        loader.load();

        ModifyPartController MPController = loader.getController();
        MPController.receivePart(partsTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.showAndWait();


    }

    @FXML
    void onActionNavToAddProduct(ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/Add_product_view.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }


    @FXML
    void onActionNavToModifyProduct(ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/Modify_product_view.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }


    public void searchPart() {


        FilteredList<Part> filteredParts = new FilteredList<>(Inventory.getAllParts(), b -> true);
        partsTableView.setItems(filteredParts);

        partSearchBox.textProperty().addListener((observable, oldValue, newValue) ->
                filteredParts.setPredicate(part -> {
                    if (newValue == null || newValue.isEmpty()) return true;
                    else
                        return String.valueOf(part.getId()).contains(newValue) || part.getName().toLowerCase().contains(newValue);
                }));

    }


    public void searchProduct() {


        FilteredList<Product> filteredProducts = new FilteredList<>(Inventory.getAllProducts(), b -> true);
        productsTableView.setItems(filteredProducts);

        productSearchBox.textProperty().addListener((observable, oldValue, newValue) ->
                filteredProducts.setPredicate(product -> {
                    if (newValue == null || newValue.isEmpty()) return true;
                    else
                        return String.valueOf(product.getId()).contains(newValue) || product.getName().toLowerCase().contains(newValue);
                }));

    }


    public void initialize() {


        //Search method also provides mechanism for initial data insertion.
        searchPart();
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        part_invCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        cost_partCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        searchProduct();
        productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        prod_invCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prod_priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


    }


}