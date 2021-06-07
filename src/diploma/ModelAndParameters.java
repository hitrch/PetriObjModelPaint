package diploma;

import PetriObj.PetriObjModel;
import java.util.ArrayList;

/**
 *
 * @author vladi
 */
public class ModelAndParameters {
    private PetriObjModel model;
    private ArrayList<Double> parameters = new ArrayList<>();
    
    public ModelAndParameters() {
        
    }
    
    public ModelAndParameters(PetriObjModel model, ArrayList<Double> parameters) {
        this.model = model;
        this.parameters = parameters;
    }
    
    public PetriObjModel getModel() {
        return this.model;
    }
    
    public ArrayList<Double> getParameters() {
        return this.parameters;
    }
}
