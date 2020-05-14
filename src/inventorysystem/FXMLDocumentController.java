/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import inventorysystem.Model.InHouse;
import inventorysystem.Model.Inventory;
import inventorysystem.Model.Part;
import inventorysystem.Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Fred
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TableView<Part> partsTable;
    
    @FXML
    private TableColumn<Part, Integer> idColumn;
    
    @FXML
    private TableColumn<Part, String> nameColumn;
    
    @FXML
    private TableColumn<Part, Integer> stockColumn;
    
    @FXML
    private TableColumn<Part, Double> priceColumn;
    
    @FXML
    private TextField partSearchBar;
    
    @FXML
    private TableView<Product> productsTable;
    
    @FXML
    private TableColumn<Part, Integer> productIdColumn;
    
    @FXML
    private TableColumn<Part, String> productNameColumn;
    
    @FXML
    private TableColumn<Part, Integer> productStockColumn;
    
    @FXML
    private TableColumn<Part, Double> productPriceColumn;
    
    @FXML
    private TextField productSearchBar;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    public void addPartButton(ActionEvent event) throws IOException{
        Scene addPartScene = new Scene(FXMLLoader.load(getClass().getResource("AddPart.fxml")));
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(addPartScene);
        window.show();
        
        
    }
    
    public void modifyPartButton(ActionEvent event) throws IOException{
        
        Inventory.selectedPart = partsTable.getSelectionModel().getSelectedItem();
        Inventory.selectedIndex = partsTable.getSelectionModel().getSelectedIndex();
        
        Scene modifyPartScene = new Scene(FXMLLoader.load(getClass().getResource("ModifyPart.fxml")));
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(modifyPartScene);
        window.show();
        
        
    }
    
    public void deletePartButton(ActionEvent event) throws IOException{
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Part Confirmation");
        alert.setHeaderText("Confirm part deletion");
        alert.setContentText("Are you sure you want to delete this part?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Inventory.selectedPart = partsTable.getSelectionModel().getSelectedItem();
        
            Inventory.deletePart(Inventory.selectedPart);
        } else {
        }
        
        
        
    }
    
    public void deleteProductButton(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Product Confirmation");
        alert.setHeaderText("Confirm product deletion");
        alert.setContentText("Are you sure you want to delete this product?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Inventory.deleteProduct(productsTable.getSelectionModel().getSelectedItem());
        } else{
            
        }
    }
    
    public void addProductButton(ActionEvent event) throws IOException{
        Scene addPartScene = new Scene(FXMLLoader.load(getClass().getResource("AddProduct.fxml")));
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(addPartScene);
        window.show();
        
        
    }
    
    public void modifyProductButton(ActionEvent event) throws IOException{
        
        Inventory.selectedProduct = productsTable.getSelectionModel().getSelectedItem();
        Inventory.selectedIndex = productsTable.getSelectionModel().getSelectedIndex();
        
        Scene modifyProductScene = new Scene(FXMLLoader.load(getClass().getResource("ModifyProduct.fxml")));
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(modifyProductScene);
        window.show();
        
        
    }
    
    public void searchPartButton(ActionEvent event) throws IOException{
        partsTable.setItems(Inventory.lookupPart(partSearchBar.getText()));
    }
    
    public void searchProductButton(ActionEvent event) throws IOException{
        productsTable.setItems(Inventory.lookupProduct(productSearchBar.getText()));
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        partsTable.setItems(Inventory.getAllParts());
        
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        productStockColumn.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        productsTable.setItems(Inventory.getAllProducts());
        
    }    
    
}
