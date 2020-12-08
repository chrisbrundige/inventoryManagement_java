/**
 * class Inventory.java
 *
 * @author CHRIS BRUNDIGE
 * @author CHRIS BRUNDIGE
 * @author CHRIS BRUNDIGE
 * @author CHRIS BRUNDIGE
 * @author CHRIS BRUNDIGE
 * @author CHRIS BRUNDIGE
 * @author CHRIS BRUNDIGE
 * @author CHRIS BRUNDIGE
 */

/**
 * @author CHRIS BRUNDIGE
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Part;

import java.util.ArrayList;

public class Inventory {
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();



    private static ObservableList<Part> partSingleton = FXCollections.observableArrayList();
    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();



    /** special methods*/

    public static ObservableList<Part> getPartSingleton() {
        return partSingleton;
    }

    public static void setPartSingleton(ObservableList<Part> partSingleton) {
        Inventory.partSingleton = partSingleton;
    }

    public static void addPart(Part newPart) {
        allParts.add(newPart);

    }

    public static ObservableList<Part> getAllParts() {

        return allParts;

    }



    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    public Part lookupPart(int partId) {

        return null;


    }

    public Product lookupProduct(int productId) {
        return null;
    }

    public ObservableList<Part> lookupPart(String partName) {

        return null;

    }

    public Product lookupProduct(String productName) {

        return null;

    }

    public Part updatePart(int index, Part selectedPart) {
        return null;

    }

    public Product updateProduct(int index, Product newProduct) {

        return null;

    }

    public boolean deletePart(Part selectedProduct) {

        return true;
    }

    public boolean deleteProduct(Product selectedProduct) {

        return true;

    }

    public static ObservableList<Product> getAllProducts() {

        return allProducts;

    }


}
