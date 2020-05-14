/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Fred
 */
public class Product {
    
    private ObservableList<Part> associatedParts=FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int max;
    private int min;
    
    
    public Product(int startId, String startName, double startPrice, int startStock, int startMin, int startMax){
        
        id = startId;
        name = startName;
        price = startPrice;
        stock = startStock;
        max = startMax;
        min = startMin;
       
    }
    
    public void setId(int newId){
        id = newId;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setPrice(double newPrice){
        price = newPrice;
    }
    
    public void setStock(int newStock){
        stock = newStock;
    }
    
    public void setMin(int newMin){
        min = newMin;
    }
    
    public void setMax(int newMax){
        max = newMax;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getStock(){
        return stock;
    }
    
    public int getMin(){
        return min;
    }
    
    public int getMax(){
        return max;
    }
    
    public void addAssociatedPart(Part Part){
        this.associatedParts.add(Part);
    }
    
    public void deleteAssociatedPart(Part Part){
        this.associatedParts.remove(Part);
    }
    
    public ObservableList<Part> getAllAssociatedParts(){
        return this.associatedParts;
    }
    
}
