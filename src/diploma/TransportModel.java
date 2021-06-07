/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diploma;

import PetriObj.ExceptionInvalidNetStructure;
import PetriObj.ExceptionInvalidTimeDelay;
import PetriObj.PetriObjModel;
import PetriObj.PetriSim;
import java.util.ArrayList;

/**
 *
 * @author vladi
 */

public class TransportModel {
    private ArrayList<Double> infoFromCameras = new ArrayList<>();
    private ArrayList<PetriSim> crossroadsList = new ArrayList<>();
    private ArrayList<PetriSim> crossoversList = new ArrayList<>();
    private int numberOfParameters = 0;
    
    public TransportModel() {
        
    }
    
    public void addCrossroad(PetriSim part, int numberOfParameters) {
        this.crossroadsList.add(part);
        this.numberOfParameters += numberOfParameters;
    }
    
    public void addCrossover(PetriSim part, int numberOfParameters) {
        crossoversList.add(part);
        this.numberOfParameters += numberOfParameters;
    }
    
    public ModelAndParameters getModelWithApproximateParameters() throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay, CloneNotSupportedException {
        ArrayList<Double> listWithParameters = getParameters();
        
        ArrayList<PetriSim> alternativeCrossroadsList = cloneList(crossroadsList);
        ArrayList<PetriSim> alternativeCrossoversList = cloneList(crossoversList);
        ArrayList<PetriSim> list = new ArrayList<>();
        
        for (PetriSim roadPart : alternativeCrossroadsList) {
            switch(getName(roadPart.getName())) {
                case NETPART1: {
                    ((Netpart1) roadPart).setTrafficLightTime1(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    ((Netpart1) roadPart).setTrafficLightTime2(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    break;
                }
                case NETPART2: {
                    ((Netpart2) roadPart).setTrafficLightTime1(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    ((Netpart2) roadPart).setTrafficLightTime2(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    break;
                }
                case NETPART3: {
                    ((Netpart3) roadPart).setTrafficLightTime1(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    ((Netpart3) roadPart).setTrafficLightTime2(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    break;
                }
            }
            
        }
        
        for (PetriSim roadPart : alternativeCrossoversList) {
            ((Crossover) roadPart).setCrossoverTime(listWithParameters.get(0));
            listWithParameters.remove(0);
        }
        
        for (PetriSim roadPart : alternativeCrossroadsList) {
            list.add(roadPart);
        }
        
        for (PetriSim roadPart : alternativeCrossoversList) {
            for(int i = 0; i < ((Crossover) roadPart).getIntersections().size(); i++) {
                list.get(
                        ((Crossover) roadPart).
                                getIntersections().
                                get(i).get(0))
                        .getNet()
                        .getListP()[((Crossover) roadPart).getIntersections().get(i).get(1)] 
                    = roadPart.getNet().getListP()[((Crossover) roadPart).getIntersections().get(i).get(2)];
            }
            
            list.add(roadPart);
        }
        
        listWithParameters = getListFromNets(alternativeCrossroadsList);
        listWithParameters.addAll(getListFromNets(alternativeCrossoversList));
        return new ModelAndParameters(new PetriObjModel(list), listWithParameters);
    }
    
    public ModelAndParameters getModelWithParameters(ArrayList<Double> array) throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay, CloneNotSupportedException {
        ArrayList<Double> listWithParameters = new ArrayList<>(array);
        ArrayList<PetriSim> alternativeCrossroadsList = cloneList(crossroadsList);
        ArrayList<PetriSim> alternativeCrossoversList = cloneList(crossoversList);
        ArrayList<PetriSim> list = new ArrayList<>();
        
        for (PetriSim roadPart : alternativeCrossroadsList) {
            switch(getName(roadPart.getName())) {
                case NETPART1: {
                    ((Netpart1) roadPart).setTrafficLightTime1(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    ((Netpart1) roadPart).setTrafficLightTime2(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    break;
                }
                case NETPART2: {
                    ((Netpart2) roadPart).setTrafficLightTime1(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    ((Netpart2) roadPart).setTrafficLightTime2(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    break;
                }
                case NETPART3: {
                    ((Netpart3) roadPart).setTrafficLightTime1(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    ((Netpart3) roadPart).setTrafficLightTime2(Math.floor(Math.random()*listWithParameters.get(0)) + 5);
                    listWithParameters.remove(0);
                    break;
                }
            }
        }
        
        for (PetriSim roadPart : alternativeCrossoversList) {
            ((Crossover) roadPart).setCrossoverTime(listWithParameters.get(0));
            listWithParameters.remove(0);
        }
        
        for (PetriSim roadPart : alternativeCrossroadsList) {
            list.add(roadPart);
        }
        
        for (PetriSim roadPart : alternativeCrossoversList) {
            for(int i = 0; i < ((Crossover) roadPart).getIntersections().size(); i++) {
                list.get(
                        ((Crossover) roadPart).
                                getIntersections().
                                get(i).get(0))
                        .getNet()
                        .getListP()[((Crossover) roadPart).getIntersections().get(i).get(1)] 
                    = roadPart.getNet().getListP()[((Crossover) roadPart).getIntersections().get(i).get(2)];
            }
            
            list.add(roadPart);
        }
        
        listWithParameters = getListFromNets(alternativeCrossroadsList);
        listWithParameters.addAll(getListFromNets(alternativeCrossoversList));
        
        return new ModelAndParameters(new PetriObjModel(list), listWithParameters);
    }
    
    private ArrayList<Double> getListFromNets(ArrayList<PetriSim> nets) {
        ArrayList<Double> parameters = new ArrayList<>();
        
        for(PetriSim part : nets) {
            switch(getName(part.getName())) {
                case NETPART1: {
                    parameters.addAll(((Netpart1) part).getParameters());
                    break;
                }
                case NETPART2: {
                    parameters.addAll(((Netpart2) part).getParameters());
                    break;
                }
                case NETPART3: {
                    parameters.addAll(((Netpart3) part).getParameters());
                    break;
                }
                case CROSSOVER: {
                    parameters.addAll(((Crossover) part).getParameters());
                    break;
                }
            }
            
        }
        
        return parameters;
    }
    
    private ArrayList<Double> getParameters() {
        ArrayList<Double> parameters = new ArrayList<>();
        
        for (PetriSim roadPart : crossroadsList) {
            switch(getName(roadPart.getName())) {
                case NETPART1: {
                    parameters.add(((Netpart1) roadPart).getTrafficLightTime1()); 
                    parameters.add(((Netpart1) roadPart).getTrafficLightTime2()); 
                    break;
                }
                case NETPART2: {
                    parameters.add(((Netpart2) roadPart).getTrafficLightTime1()); 
                    parameters.add(((Netpart2) roadPart).getTrafficLightTime2()); 
                    break;
                }
                case NETPART3: {
                    parameters.add(((Netpart3) roadPart).getTrafficLightTime1()); 
                    parameters.add(((Netpart3) roadPart).getTrafficLightTime2()); 
                    break;
                }
            }
        }
        
        for (PetriSim roadPart : crossoversList) {
            switch(getName(roadPart.getName())) {
                case CROSSOVER: {
                    parameters.add(((Crossover) roadPart).getCrossoverTime());
                    break;
                }
            }
        }
        
        return parameters;
    }
    
    public ArrayList<PetriSim> cloneList(ArrayList<PetriSim> list) throws CloneNotSupportedException, ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
        ArrayList<PetriSim> clone = new ArrayList<>();
        
        for (PetriSim roadPart : list) {
            switch(getName(roadPart.getName())) {
                case NETPART1: {
                    Netpart1 net = new Netpart1(((Netpart1) roadPart).getTrafficLightTime1(), ((Netpart1) roadPart).getTrafficLightTime2());
                    net.setName(((Netpart1) roadPart).getName());
                    clone.add(net);
                    break;
                }
                case NETPART2: {
                    Netpart2 net = new Netpart2(((Netpart2) roadPart).getTrafficLightTime1(), ((Netpart2) roadPart).getTrafficLightTime2());
                    net.setName(((Netpart2) roadPart).getName());
                    clone.add(net);
                    break;
                }
                case NETPART3: {
                    Netpart3 net = new Netpart3(((Netpart3) roadPart).getTrafficLightTime1(), ((Netpart3) roadPart).getTrafficLightTime2());
                    net.setName(((Netpart3) roadPart).getName());
                    clone.add(net);
                    break;
                }
                case CROSSOVER: {
                    Crossover net = new Crossover(((Crossover) roadPart).getCrossoverTime());
                    net.setName(((Crossover) roadPart).getName());
                    clone.add(net);
                    break;
                }
            }
        }
        
        return clone;
    }
    
    public int getNumberOfParameters() {
        return this.numberOfParameters;
    }
    
    public NameEnum getName(String name) {
        if(name.contains("crossover")) {
            return NameEnum.CROSSOVER;
        }
        
        if(name.contains("netpart1")) {
            return NameEnum.NETPART1;
        }
        
        if(name.contains("netpart2")) {
            return NameEnum.NETPART2;
        }
        
        if(name.contains("netpart3")) {
            return NameEnum.NETPART3;
        }
        
        return NameEnum.NOTFOUND;
    }
    
    public int getNumberOfCrossroadsParamameters() {
        int number = 0;
        
        for (PetriSim roadPart : crossroadsList) {
            switch(getName(roadPart.getName())) {
                case NETPART1: {
                    number++;
                    break;
                }
                case NETPART2: {
                    number++;
                    break;
                }
                case NETPART3: {
                   number++;
                    break;
                }
            }
        }
        
        return number;
    }
    
    public ArrayList<PetriSim> getCrossroadsList() {
        return this.crossroadsList;
    }
    
    public ArrayList<Double> getInfoFromCameras() {
        return this.infoFromCameras;
    }
    
    public void setInfoFromCameras(ArrayList<Double> info) {
        this.infoFromCameras = info;
    }
}
