package Main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {




        Parent root = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
        primaryStage.setTitle("Inventory Management system");
        primaryStage.setScene(new Scene(root, 800, 1200));
        primaryStage.show();

       /**SAMPLE DATA*/

        Part a1 = new InHouse(1, "Part A1", 2.99, 10, 5, 100, 101);
        Part a2 = new InHouse(3, "Part A2", 4.99, 11, 5, 100, 103);
        Part b = new InHouse(2, "Part B ", 3.99, 9, 5, 100, 102);
        Part d10 = new Outsourced(908, "d10 ", 3.99, 9, 5, 100, "Acme");
        Part Narcan = new Outsourced(211, "Narcan ", 3.99, 9, 5, 100, "Rudy labs");
        Product jumpBag = new Product(98,"Jumpbag",399.99,9,1,3);
        Product db64 = new Product(102,"Drug box",199.99,4,1,9);


        Inventory.addPart(a1);
        Inventory.addPart(a2);
        Inventory.addPart(b);
        Inventory.addPart(d10);
        Inventory.addPart(Narcan);
        Inventory.addProduct(jumpBag);
        Inventory.addProduct(db64);


    }
}