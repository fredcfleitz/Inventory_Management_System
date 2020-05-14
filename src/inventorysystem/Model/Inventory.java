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
public class Inventory {
    
    /**
     *
     */
    private static ObservableList<Part> allParts=FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts=FXCollections.observableArrayList();
    
    public static int start = 1;
    
    public static Part selectedPart;
    public static Product selectedProduct;
    public static int selectedIndex = 1;
    
    public static void addPart(Part Part){
        allParts.add(Part);
        
    }
    
    public static void deletePart(Part Part){
        allParts.remove(Part);
    }
    
    public static void updatePart(int index, Part Part){
        allParts.set(index, Part);
    }
    
    public static Part lookupPart(int partId){
        for (Part p:allParts){
            if (p.getId() == partId){
                return p;
            }
        }
        return null;
    }
    
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> searchPart=FXCollections.observableArrayList();
        for (Part p:allParts){
            if (p.getName().contains(partName)){
                searchPart.add(p);
            }
            
        }
        return searchPart;
    }
    
    public static void addProduct(Product Product){
        allProducts.add(Product);
        
    }
    
    public static void deleteProduct(Product Product){
        allProducts.remove(Product);
    }
    
    public static void updateProduct(int index, Product Product){
        allProducts.set(index, Product);
    }
    
    public static Product lookupProduct(int productId){
        for (Product p:allProducts){
            if (p.getId() == productId){
                return p;
            }
        }
        return null;
    }
    
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> searchProduct=FXCollections.observableArrayList();
        for (Product p:allProducts){
            if (p.getName().contains(productName)){
                searchProduct.add(p);
            }
            
        }
        return searchProduct;
    }
    
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }
    
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }
    
}
