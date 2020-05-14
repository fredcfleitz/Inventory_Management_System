/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem.Model;

/**
 *
 * @author Fred
 */
public abstract class Part {
    
    private int id;
    private String name;
    private double price;
    private int stock;
    private int Max;
    private int min;
    
    public Part(int startId, String startName, double startPrice, int startStock, int startMin, int startMax){
        
        id = startId;
        name = startName;
        price = startPrice;
        stock = startStock;
        Max = startMax;
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
        Max = newMax;
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
        return Max;
    }
    
}
