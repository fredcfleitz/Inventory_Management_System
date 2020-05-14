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
public class Outsourced extends Part {
    
    
    private String companyName;

    public Outsourced(int startId, String startName, double startPrice, int startStock, int startMin, int startMax, String startCompanyName) {
        super(startId, startName, startPrice, startStock, startMin, startMax);
        
        companyName = startCompanyName;
        
    }
    
    public void setCompanyName(String newCompanyName){
        companyName = newCompanyName;
    }
    
    public String getCompanyName(){
        return companyName;
    }

}
