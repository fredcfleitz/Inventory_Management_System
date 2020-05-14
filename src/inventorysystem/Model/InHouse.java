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
public class InHouse extends Part {
    
    private int machineId;
    
    public InHouse(int startId, String startName, double startPrice, int startStock, int startMin, int startMax, int startMachineId) {
        super(startId, startName, startPrice, startStock, startMin, startMax);
        
        machineId = startMachineId;
        
    }
    
    public void setMachineId(int newMachineId){
        machineId = newMachineId;
    }
    
    public int getMachineId(){
        return machineId;
    }
    
}
