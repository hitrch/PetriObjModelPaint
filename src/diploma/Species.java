/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diploma;

import java.util.ArrayList;

/**
 *
 * @author vladi
 */
public class Species {
    private ArrayList<Double> parameters = new ArrayList<>();
    private double result;
    
    public Species(ArrayList<Double> parameters, double result) {
        this.parameters = parameters;
        this.result = result;
    }
    
    public ArrayList<Double> getParameters() {
        return this.parameters;
    }
    
    public double getResult(){
        return this.result;
    }
}
