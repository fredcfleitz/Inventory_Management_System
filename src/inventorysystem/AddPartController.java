/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import inventorysystem.Model.InHouse;
import inventorysystem.Model.Inventory;
import inventorysystem.Model.Outsourced;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Fred
 */
public class AddPartController implements Initializable {

    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     */
    
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
    private TextField companyField;
    
    @FXML
    private RadioButton inhouse;
    
    @FXML
    private RadioButton outsourced;
    
    private ToggleGroup partGroup;
    
    @FXML
    private Label company_MachineId;
    
    @FXML
    public void cancelButton(ActionEvent event) throws IOException{
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
        
        if (Integer.parseInt(maxField.getText()) >= Integer.parseInt(minField.getText())){
            if (this.partGroup.getSelectedToggle().equals(this.inhouse)){
            InHouse newpart = new InHouse(Integer.parseInt(idField.getText()),nameField.getText(),Double.parseDouble(priceField.getText()),Integer.parseInt(stockField.getText()),Integer.parseInt(minField.getText()),Integer.parseInt(maxField.getText()),Integer.parseInt(companyField.getText()));
            Inventory.addPart(newpart);
        } else {
            Outsourced newpart = new Outsourced(Integer.parseInt(idField.getText()),nameField.getText(),Double.parseDouble(priceField.getText()),Integer.parseInt(stockField.getText()),Integer.parseInt(minField.getText()),Integer.parseInt(maxField.getText()),companyField.getText());
            Inventory.addPart(newpart);
        }
            Scene defaultScene = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(defaultScene);
            window.show();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Max less than min");
            alert.setContentText("The max value must be greater than or equal to the min value.");

            alert.showAndWait();
        }
        
    }
    
    public void inHouseSelect() {
        this.company_MachineId.setText("Machine ID");
    }
    
    public void outsourcedSelect() {
        this.company_MachineId.setText("Company Name");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        partGroup = new ToggleGroup();
        this.inhouse.setToggleGroup(partGroup);
        this.outsourced.setToggleGroup(partGroup);
        this.inhouse.setSelected(true);
    }    
    
}
