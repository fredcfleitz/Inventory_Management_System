/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fred
 */
public class AddProductController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private ObservableList<Part> associatedPartsList=FXCollections.observableArrayList();
    
    @FXML
    private TableView<Part> partsTable;
    
    @FXML
    private TableView<Part> associatedPartsTable;
    
    @FXML
    private TableColumn<Part, Integer> idColumn;
    
    @FXML
    private TableColumn<Part, String> nameColumn;
    
    @FXML
    private TableColumn<Part, Integer> stockColumn;
    
    @FXML
    private TableColumn<Part, Double> priceColumn;
    
    @FXML
    private TableColumn<Part, Integer> associatedIdColumn;
    
    @FXML
    private TableColumn<Part, String> associatedNameColumn;
    
    @FXML
    private TableColumn<Part, Integer> associatedStockColumn;
    
    @FXML
    private TableColumn<Part, Double> associatedPriceColumn;
    
    @FXML
    private TextField partSearchBar;
    
    @FXML
    private TextField idField;
    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField stockField;
    
    @FXML
    private TextField priceField;
    
    @FXML
    private TextField maxField;
    
    @FXML
    private TextField minField;
    
    @FXML
    public void cancelButton(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel Confirmation");
        alert.setHeaderText("Confirm cancel");
        alert.setContentText("Are you sure you want to cancel and return to the inventory screen?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Scene defaultScene = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(defaultScene);
            window.show();
        } else {
            
        }
        
        
    }
    
    public void addButton(ActionEvent event) throws IOException{
        associatedPartsList.add(partsTable.getSelectionModel().getSelectedItem());
        associatedPartsTable.setItems(associatedPartsList);
    }
    
    public void searchButton(ActionEvent event) throws IOException{
        partsTable.setItems(Inventory.lookupPart(partSearchBar.getText()));
    }
    
    public void addProductButton(ActionEvent event) throws IOException{
        
        if (Integer.parseInt(maxField.getText()) >= Integer.parseInt(minField.getText())){
        
            Product newProduct = new Product(Integer.parseInt(idField.getText()),nameField.getText(),Double.parseDouble(priceField.getText()),Integer.parseInt(stockField.getText()),Integer.parseInt(minField.getText()),Integer.parseInt(maxField.getText()));
            for(Part p:associatedPartsList){
                newProduct.addAssociatedPart(p);
            }
            Inventory.addProduct(newProduct);


            Scene defaultScene = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(defaultScene);
            window.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Max less than min");
            alert.setContentText("The max value must be greater than or equal to the min value.");

            alert.showAndWait();
        }
        
        
    }
    
    public void deletePartButton(ActionEvent event) throws IOException{
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Part Confirmation");
        alert.setHeaderText("Confirm part deletion");
        alert.setContentText("Are you sure you want to delete this part?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            associatedPartsList.remove(associatedPartsTable.getSelectionModel().getSelectedItem());
            associatedPartsTable.setItems(associatedPartsList);
        } else {
            
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        partsTable.setItems(Inventory.getAllParts());
        
        associatedIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        associatedNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        associatedStockColumn.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        associatedPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }    
    
}
