
package diploma;

import PetriObj.ExceptionInvalidNetStructure;
import PetriObj.ExceptionInvalidTimeDelay;
import PetriObj.PetriObjModel;
import PetriObj.PetriSim;
import static diploma.NameEnum.NETPART1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 *
 * @author vladi
 */
public class Analysis {
    public static int id = 1;
    
    public static void main(String[] args) throws ExceptionInvalidTimeDelay, ExceptionInvalidNetStructure, IOException, CloneNotSupportedException {
        System.out.print("Вас вітає ");
        System.out.println("Інформаційна система оптимізації параметрів управління дорожнім рухом на транспортній ділянці");
        useDefault();
    }
    
    public static void useDefault() throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay, CloneNotSupportedException {
        int populationAmount = 20;
        ArrayList<Double> parameters = new ArrayList<>();
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(60.0);
        parameters.add(100.0);
        parameters.add(100.0);
        parameters.add(100.0);
        parameters.add(100.0);
        parameters.add(100.0);
        parameters.add(100.0);
        parameters.add(100.0);
        TransportModel model = getDefaultModel(parameters);
        doOptimization(populationAmount, model, false);
    }
    
    public static TransportModel getDefaultModel(ArrayList<Double> parameters) 
            throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
        TransportModel transportModel = new TransportModel();
        
        Netpart3 net3 = new Netpart3(parameters.get(0), parameters.get(1));
        Netpart1 net1 = new Netpart1(parameters.get(2), parameters.get(3));
        Netpart2 net2_1 = new Netpart2(parameters.get(4), parameters.get(5));
        net2_1.setName("netpart2_1");
        Netpart2 net2_2 = new Netpart2(parameters.get(6), parameters.get(7));
        Netpart2 net2_3 = new Netpart2(parameters.get(8), parameters.get(9));
        Netpart2 net2_4 = new Netpart2(parameters.get(10), parameters.get(11));
        Crossover c_1 = new Crossover(parameters.get(12));
        Crossover c_2 = new Crossover(parameters.get(13));
        Crossover c_3 = new Crossover(parameters.get(14));
        Crossover c_4 = new Crossover(parameters.get(15));
        Crossover c_5 = new Crossover(parameters.get(16));
        Crossover c_6 = new Crossover(parameters.get(17));
        Crossover c_7 = new Crossover(parameters.get(18));
        
        transportModel.addCrossroad(net3, net3.getNumberOfParameters());
        transportModel.addCrossroad(net1, net1.getNumberOfParameters());
        transportModel.addCrossroad(net2_1, net2_1.getNumberOfParameters());
        transportModel.addCrossroad(net2_2, net2_2.getNumberOfParameters());
        transportModel.addCrossroad(net2_3, net2_3.getNumberOfParameters());
        transportModel.addCrossroad(net2_4, net2_4.getNumberOfParameters());
        
        c_1.addIntersection(0, net3.getTopPositionNumber(), c_1.getStartPosition1());
        c_1.addIntersection(1, net1.getBotPositionIncomeNumber(), c_1.getEndPosition1());
        c_1.addIntersection(1, net1.getBotPositionNumber(), c_1.getStartPosition2());
        c_1.addIntersection(0, net3.getTopPositionIncomeNumber(), c_1.getEndPosition2());
        c_1.addIntersection(0, net3.getTopPositionQueue(), c_1.getQueuePosition1());
        c_1.addIntersection(1, net1.getBotPositionQueue(), c_1.getQueuePosition2());
        
        c_2.addIntersection(0, net3.getRightPositionNumber(), c_2.getStartPosition1());
        c_2.addIntersection(2, net2_1.getLeftPositionIncomeNumber(), c_2.getEndPosition1());
        c_2.addIntersection(2, net2_1.getLeftPositionNumber(), c_2.getStartPosition2());
        c_2.addIntersection(0, net3.getRightPositionIncomeNumber(), c_2.getEndPosition2());
        c_2.addIntersection(0, net3.getRightPositionQueue(), c_2.getQueuePosition1());
        c_2.addIntersection(2, net2_1.getLeftPositionQueue(), c_2.getQueuePosition2());
        
        c_3.addIntersection(0, net3.getLeftPositionNumber(), c_3.getStartPosition1());
        c_3.addIntersection(3, net2_2.getRightPositionIncomeNumber(), c_3.getEndPosition1());
        c_3.addIntersection(3, net2_2.getRightPositionNumber(), c_3.getStartPosition2());
        c_3.addIntersection(0, net3.getLeftPositionIncomeNumber(), c_3.getEndPosition2());
        c_3.addIntersection(0, net3.getLeftPositionQueue(), c_3.getQueuePosition1());
        c_3.addIntersection(3, net2_2.getRightPositionQueue(), c_3.getQueuePosition2());
        
        c_4.addIntersection(3, net2_2.getTopPositionNumber(), c_4.getStartPosition1());
        c_4.addIntersection(4, net2_3.getRightPositionIncomeNumber(), c_4.getEndPosition1());
        c_4.addIntersection(4, net2_3.getRightPositionNumber(), c_4.getStartPosition2());
        c_4.addIntersection(3, net2_2.getTopPositionIncomeNumber(), c_4.getEndPosition2());
        c_4.addIntersection(3, net2_2.getTopPositionQueue(), c_4.getQueuePosition1());
        c_4.addIntersection(4, net2_3.getRightPositionQueue(), c_4.getQueuePosition2());
        
        c_5.addIntersection(4, net2_3.getTopPositionNumber(), c_5.getStartPosition1());
        c_5.addIntersection(1, net1.getLeftPositionIncomeNumber(), c_5.getEndPosition1());
        c_5.addIntersection(1, net1.getLeftPositionNumber(), c_5.getStartPosition2());
        c_5.addIntersection(4, net2_4.getTopPositionIncomeNumber(), c_5.getEndPosition2());
        c_5.addIntersection(4, net2_3.getTopPositionQueue(), c_5.getQueuePosition1());
        c_5.addIntersection(1, net1.getLeftPositionQueue(), c_5.getQueuePosition2());
        
        c_6.addIntersection(1, net1.getRightPositionNumber(), c_6.getStartPosition1());
        c_6.addIntersection(5, net2_4.getTopPositionIncomeNumber(), c_6.getEndPosition2());
        c_6.addIntersection(5, net2_4.getTopPositionNumber(), c_6.getStartPosition2());
        c_6.addIntersection(1, net1.getRightPositionIncomeNumber(), c_6.getEndPosition2());
        c_6.addIntersection(1, net1.getRightPositionQueue(), c_6.getQueuePosition1());
        c_6.addIntersection(5, net2_4.getTopPositionQueue(), c_6.getQueuePosition2());
        
        c_7.addIntersection(2, net2_1.getTopPositionNumber(), c_7.getStartPosition1());
        c_7.addIntersection(5, net2_4.getLeftPositionIncomeNumber(), c_7.getEndPosition1());
        c_7.addIntersection(5, net2_4.getLeftPositionNumber(), c_7.getStartPosition2());
        c_7.addIntersection(2, net2_1.getTopPositionIncomeNumber(), c_7.getEndPosition2());
        c_7.addIntersection(2, net2_1.getTopPositionQueue(), c_7.getQueuePosition1());
        c_7.addIntersection(5, net2_4.getLeftPositionQueue(), c_7.getQueuePosition2());
        
        transportModel.addCrossover(c_1, c_1.getNumberOfParameters());
        transportModel.addCrossover(c_2, c_2.getNumberOfParameters());
        transportModel.addCrossover(c_3, c_3.getNumberOfParameters());
        transportModel.addCrossover(c_4, c_4.getNumberOfParameters());
        transportModel.addCrossover(c_5, c_5.getNumberOfParameters());
        transportModel.addCrossover(c_6, c_6.getNumberOfParameters());
        transportModel.addCrossover(c_7, c_7.getNumberOfParameters());
    
        return transportModel;
    }
    
    public static ArrayList<Double> doOptimization(int populationAmount, TransportModel model, boolean useInfoFromCameras) throws ExceptionInvalidTimeDelay, ExceptionInvalidTimeDelay, ExceptionInvalidNetStructure, CloneNotSupportedException {
        int turns = 1;
        int failures = 0;
        double currentBest, previousBest;
        ArrayList<Double> bestAnswer;
        double criteriaStart, criteriaBest;
        previousBest = -1;
        
        HashMap<ArrayList<Double>, Double> population = createPopulation(populationAmount, model, useInfoFromCameras);
        
        criteriaStart = getBestValue(population);
        
        do {
            ArrayList<Double> cutPopulation = new ArrayList<>();
            population.entrySet().stream()
                .sorted(Map.Entry.<ArrayList<Double>, Double>comparingByValue().reversed())
                    .forEach(x -> cutPopulation.add(x.getValue()));
            
            ArrayList<Double> list = new ArrayList<>();
            
            for(int k = 0; k < populationAmount/2; k++) {
                list.add(cutPopulation.get(cutPopulation.size() - (k+1)));
            }
            
            //extracting extra n/2 population members
            HashMap<ArrayList<Double>, Double> tempPopulation = new HashMap<>();
            
            for (Entry<ArrayList<Double>, Double> entry : population.entrySet()) {
                    for(int i = 0; i<list.size();i++) {
                        
                        if (entry.getValue().equals(list.get(i))) {
                            tempPopulation.put(entry.getKey(), entry.getValue());
                            break;
                        }
                    }
            }
            
            population = tempPopulation;
            
            //creating n/2 population members
            while (population.size() != populationAmount){
                int rand1 = (new Random()).nextInt(populationAmount/2);
                
                int rand2 = 0;
                do{
                    rand2 = (new Random()).nextInt(populationAmount/2);
                } while (rand1 == rand2);

                
                ArrayList<Double> parent1 = new ArrayList<>();
                ArrayList<Double> parent2 = new ArrayList<>();
                
                for (Entry<ArrayList<Double>, Double> entry : population.entrySet()) {
                    
                    if (entry.getValue().equals(list.get(rand1))) {
                        parent1 = entry.getKey();
                    }
                    
                    if (entry.getValue().equals(list.get(rand2))) {
                        parent2 = entry.getKey();
                    }
                }
                
                //TODO here must be implementation of traffic lights time duration not seperating
                do{
                    rand1 = (new Random()).nextInt(model.getNumberOfParameters());
                } while (!fitsCriteria(rand1, model));
                
                //crossover
                ArrayList<Double> descendant1 = new ArrayList<>();
                for(int j = 0; j<rand1; j++) {
                    descendant1.add(parent1.get(j));
                }
                
                for(int j = rand1; j<parent2.size(); j++) {
                    descendant1.add(parent2.get(j));
                }
                
                ArrayList<Double> descendant2 = new ArrayList<>();
                for(int j = 0; j<rand1; j++) {
                    descendant2.add(parent2.get(j));
                }
                
                for(int j = rand1; j<parent2.size(); j++) {
                    descendant2.add(parent1.get(j));
                }
                
                //mutation
                for(int j = 0; j < model.getNumberOfCrossroadsParamameters(); j++) {
                    double rand = Math.random();
                    
                    if(rand >= 0.5) {
                        double randomForDeffereSide = Math.random();
                        int coefficient;
                        
                        if(randomForDeffereSide >= 0.5) {
                            coefficient = 1;
                        } else {
                            coefficient = -1;
                        }
                        
                        if(descendant1.get(j) >= 10) {
                            descendant1.set(j, coefficient + descendant1.get(j));
                        }
                    }
                }
                
                for(int j = 0; j < model.getNumberOfCrossroadsParamameters(); j++) {
                    double rand = Math.random();
                    
                    if(rand >= 0.5) {
                        double randomForDeffereSide = Math.random();
                        int coefficient;
                        
                        if(randomForDeffereSide >= 0.5) {
                            coefficient = 1;
                        } else {
                            coefficient = -1;
                        }
                        
                        if(descendant2.get(j) >= 10) {
                            descendant2.set(j, coefficient + descendant2.get(j));
                        }
                    }
                }
                
                double result1 = getSpecies(model, descendant1, useInfoFromCameras).getResult();
                double result2 = getSpecies(model, descendant2, useInfoFromCameras).getResult();
                
                if(!population.containsKey(descendant1)) {
                    population.put(descendant1, result1);
                }
                    
                if(!population.containsKey(descendant2) && population.size() < populationAmount) {
                    population.put(descendant2, result2);
                }
            }
            
            ArrayList<Double> temp = new ArrayList<>();
            population.entrySet().stream()
                .sorted(Map.Entry.<ArrayList<Double>, Double>comparingByValue().reversed())
                    .forEach(x -> temp.add(x.getValue()));
            
            turns++;
            System.out.println(temp.get(temp.size() - 1) + "    " + temp.get(temp.size() - 2));
            
            currentBest = temp.get(temp.size() - 1);
            criteriaBest = currentBest;
            
            if(currentBest == previousBest) {
                failures++;
            } else {
                failures = 0;
            }
            
            previousBest = currentBest;
        } while (failures <= 30);
        
        System.out.println("turns = " + (turns -1));
        
            population.entrySet().stream()
                .sorted(Map.Entry.<ArrayList<Double>, Double>comparingByValue().reversed())
                    .forEach(x -> System.out.println(x));
            
            bestAnswer = getKeyByValue(population, criteriaBest);
            bestAnswer.add(criteriaStart);
            bestAnswer.add(criteriaBest);
            return bestAnswer;
    }
    
    private static double getBestValue(HashMap<ArrayList<Double>, Double> population) {
        double value = Double.MAX_VALUE;
        
        for(Map.Entry<ArrayList<Double>, Double> entry : population.entrySet()) {
            if(entry.getValue() < value) {
                value = entry.getValue();
            }
        }
        
        return value;
    }
    
    public static ArrayList<Double> getKeyByValue(HashMap<ArrayList<Double>, Double> population, double value) {
        for(Map.Entry<ArrayList<Double>, Double> entry : population.entrySet()) {
            if(entry.getValue() == value) {
                return entry.getKey();
            }
        }
        
        return null;
    }
    
    public static boolean fitsCriteria(int value, TransportModel model) throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay  {
        if(value == 0 || value == model.getNumberOfParameters()) {
            return false;
        }
        
        ArrayList<Integer> placesInBetweenGreenAndRedLights = getPlacesInBetweenGreenAndRedLights(model);
        return placesInBetweenGreenAndRedLights.stream().noneMatch((v) -> (v == value));
    }
    
    public static ArrayList<Integer> getPlacesInBetweenGreenAndRedLights(TransportModel model) throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        
        for(PetriSim p : model.getCrossroadsList()) {
            switch((new TransportModel()).getName(p.getName())) {
                case NETPART1: {
                    arr.add(i + ((Netpart1) p).getPositionBetweenRedAndGreenLights());
                    i += ((Netpart1) p).getNumberOfParameters();
                    break;
                }
                case NETPART2: {
                    arr.add(i + ((Netpart2) p).getPositionBetweenRedAndGreenLights());
                    i += ((Netpart2) p).getNumberOfParameters();
                    break;
                }
                case NETPART3: {
                    arr.add(i + ((Netpart3) p).getPositionBetweenRedAndGreenLights());
                    i += ((Netpart3) p).getNumberOfParameters();
                    break;
                }
            }
        }
        
        return arr;
    }
    
    public static HashMap<ArrayList<Double>, Double> createPopulation(int populationAmount, TransportModel model, boolean useInfoFromCameras) 
            throws ExceptionInvalidTimeDelay, ExceptionInvalidNetStructure, CloneNotSupportedException  {
        HashMap<ArrayList<Double>, Double> population = new HashMap<>();
        
        for(int i = 0; i < populationAmount; i++) {
            Species species = getSpecies(model, null, useInfoFromCameras);
            population.put(species.getParameters(), species.getResult());
            System.out.println(species.getParameters() + "    " + species.getResult());
        }
        
        return population;
    }
    
    public static Species getSpecies(TransportModel model, ArrayList<Double> list, boolean useInfoFromCameras) throws ExceptionInvalidTimeDelay, ExceptionInvalidNetStructure, CloneNotSupportedException {
        double response = 0.0;
        int n = 4;
        ModelAndParameters modelAndParameters;
        
        if(list == null) {
            modelAndParameters = model.getModelWithApproximateParameters();
        } else {
            modelAndParameters = model.getModelWithParameters(list);
        }
        
        for(int i = 0; i < n; i++) {
            PetriObjModel newModel = modelAndParameters.getModel();
            newModel.setIsProtokol(false);
            response += newModel.analyse(1800, model.getInfoFromCameras(), useInfoFromCameras);
            Analysis.id = 1;
        }
        
        return new Species(modelAndParameters.getParameters(), response/n);
    }
}
