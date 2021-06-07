package diploma;

import PetriObj.ArcIn;
import PetriObj.ArcOut;
import PetriObj.ExceptionInvalidNetStructure;
import PetriObj.ExceptionInvalidTimeDelay;
import PetriObj.PetriNet;
import PetriObj.PetriP;
import PetriObj.PetriSim;
import PetriObj.PetriT;
import java.util.ArrayList;
/**
 *
 * @author vladi
 */
public class Crossover extends PetriSim implements RoadPart {
    private int numberOfParameters;
    private ArrayList<ArrayList<Integer>> intersections = new ArrayList<>();
    private double crossoverTime;
    
    public Crossover(double crossoverTime) throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
        super(createNetcrossoverWithTimeDelays(crossoverTime));
        this.crossoverTime = crossoverTime;
        this.numberOfParameters = 1;
    }
    
    public void addIntersection(int crossroadPositionInList, int crossroadPlace, int crossoverPlace) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(crossroadPositionInList);
        list.add(crossroadPlace);
        list.add(crossoverPlace);
        this.intersections.add(list);
    }
    
    @Override
    public int getNumberOfParameters() {
        return this.numberOfParameters;
    }
    
    @Override
    public ArrayList<Double> getParameters() {
        ArrayList<Double> parameters = new ArrayList<>();
        parameters.add(crossoverTime);
        return parameters;
    }
    
    public ArrayList<ArrayList<Integer>> getIntersections() {
        return this.intersections;
    }
    
    public double getCrossoverTime() {
        return this.crossoverTime;
    }
    
    public void setCrossoverTime(double time) {
        this.crossoverTime = time;
    }
    
    public int getStartPosition1() {
        return 2;
    }
    
    public int getEndPosition1() {
        return 0;
    }
    
    public int getStartPosition2() {
        return 1;
    }
    
    public int getEndPosition2() {
        return 3;
    }
    
    public int getQueuePosition1() {
        return 8;
    }
    
    public int getQueuePosition2() {
        return 7;
    }
    
    public PetriNet createNetcrossover() throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
        return createNetcrossoverWithTimeDelays(this.crossoverTime);
    }
    
    public static PetriNet createNetcrossoverWithTimeDelays(double crossoverTime) throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
	ArrayList<PetriP> d_P = new ArrayList<>();
	ArrayList<PetriT> d_T = new ArrayList<>();
	ArrayList<ArcIn> d_In = new ArrayList<>();
	ArrayList<ArcOut> d_Out = new ArrayList<>();
	d_P.add(new PetriP("WcrossoverIncome",0));
	d_P.add(new PetriP("WcrossoverOutcome",0));
	d_P.add(new PetriP("EcrossoverOutcome",0));
	d_P.add(new PetriP("EcrossoverIncome",0));
	d_P.add(new PetriP("P5",0));
	d_P.add(new PetriP("P6",0));
	d_P.add(new PetriP("P7",0));
	d_P.add(new PetriP("P8",100));
	d_P.add(new PetriP("P3",100));
	d_P.add(new PetriP("P9",0));
	d_T.add(new PetriT("T6",crossoverTime));
	d_T.get(0).setDistribution("unif", d_T.get(0).getTimeServ());
	d_T.get(0).setParamDeviation(20.0);
	d_T.add(new PetriT("T2",crossoverTime));
	d_T.get(1).setDistribution("unif", d_T.get(1).getTimeServ());
	d_T.get(1).setParamDeviation(20.0);
	d_T.add(new PetriT("T3",0.0));
	d_T.add(new PetriT("T4",0.0));
	d_T.add(new PetriT("T5",0.0));
	d_T.add(new PetriT("T3",0.0));
	d_In.add(new ArcIn(d_P.get(8),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(2),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(6),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(6),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(9),d_T.get(0),1));
	d_In.add(new ArcIn(d_P.get(9),d_T.get(2),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(3),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(9),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(5),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(3),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(0),d_P.get(0),1));
	d_Out.add(new ArcOut(d_T.get(0),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(4),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(6),1));
	PetriNet d_Net = new PetriNet("crossover",d_P,d_T,d_In,d_Out);
	PetriP.initNext();
	PetriT.initNext();
	ArcIn.initNext();
	ArcOut.initNext();

	return d_Net;
    }
}
