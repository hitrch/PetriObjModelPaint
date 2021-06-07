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
public class Netpart2 extends PetriSim implements RoadPart {
    private int numberOfParameters;
    private double trafficLightTime1;
    private double trafficLightTime2;
    private int positionBetweenRedAndGreenLights;
    
    public Netpart2() throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
        super(createNetpart2WithTimedelays(60.0, 60.0));
        this.trafficLightTime1 = 60.0;
        this.trafficLightTime2 = 60.0;
        this.numberOfParameters = 2;
        this.positionBetweenRedAndGreenLights = 1;
    }
    
    public Netpart2(double trafficLightTime1, double trafficLightTime2) throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
        super(createNetpart2WithTimedelays(trafficLightTime1, trafficLightTime2));
        this.trafficLightTime1 = trafficLightTime1;
        this.trafficLightTime2 = trafficLightTime2;
        this.numberOfParameters = 2;
        this.positionBetweenRedAndGreenLights = 1;
    }
    
    @Override
    public int getNumberOfParameters() {
        return this.numberOfParameters;
    }
    
    @Override
    public ArrayList<Double> getParameters() {
        ArrayList<Double> parameters = new ArrayList<>();
        parameters.add(trafficLightTime1);
        parameters.add(trafficLightTime2);
        return parameters;
    }
    
    public int getPositionBetweenRedAndGreenLights() {
        return this.positionBetweenRedAndGreenLights;
    }
    
    public double getTrafficLightTime1() {
        return this.trafficLightTime1;
    }
    
    public double getTrafficLightTime2() {
        return this.trafficLightTime2;
    }
    
    public void setTrafficLightTime1(double time) {
        this.trafficLightTime1 = time;
    }
    
    public void setTrafficLightTime2(double time) {
        this.trafficLightTime2 = time;
    }
    
    public ArrayList<String> getQueue() {
        ArrayList<String> queues = new ArrayList<>();
        queues.add("P9");
        queues.add("P10");
        queues.add("P16");
        queues.add("P17");
        queues.add("P29");
        queues.add("P30");
        
        return queues;
    }
    
    public int getTopPositionNumber() {
        return 12;
    }
    
    public int getLeftPositionNumber() {
        return 32;
    }
    
    public int getRightPositionNumber() {
        return 19;
    }
    
    public int getTopPositionIncomeNumber() {
        return 10;
    }
    
    public int getLeftPositionIncomeNumber() {
        return 30;
    }
    
    public int getRightPositionIncomeNumber() {
        return 17;
    }
    
    public int getLeftPositionQueue() {
        return 35;
    }
    
    public int getTopPositionQueue() {
        return 34;
    }
    
    public int getRightPositionQueue() {
        return 33;
    }
    
    public PetriNet createNetpart2() throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
        return createNetpart2WithTimedelays(this.trafficLightTime1, this.trafficLightTime2);
    }
    
    public static PetriNet createNetpart2WithTimedelays(double trafficLightTime1, double trafficLightTime2) throws ExceptionInvalidNetStructure, ExceptionInvalidTimeDelay {
	ArrayList<PetriP> d_P = new ArrayList<>();
	ArrayList<PetriT> d_T = new ArrayList<>();
	ArrayList<ArcIn> d_In = new ArrayList<>();
	ArrayList<ArcOut> d_Out = new ArrayList<>();
	d_P.add(new PetriP("P1",1));
	d_P.add(new PetriP("P2",0));
	d_P.add(new PetriP("P3",0));
	d_P.add(new PetriP("P4",0));
	d_P.add(new PetriP("P5",1));
	d_P.add(new PetriP("P6",0));
	d_P.add(new PetriP("P7",1));
	d_P.add(new PetriP("P8",1));
	d_P.add(new PetriP("P9",0));
	d_P.add(new PetriP("P10",0));
	d_P.add(new PetriP("P11",0));
	d_P.add(new PetriP("P12",1));
	d_P.add(new PetriP("North2",0));
	d_P.add(new PetriP("P14",1));
	d_P.add(new PetriP("P15",1));
	d_P.add(new PetriP("P16",0));
	d_P.add(new PetriP("P17",0));
	d_P.add(new PetriP("CrossoverIncome2",0));
	d_P.add(new PetriP("P19",1));
	d_P.add(new PetriP("East2",0));
	d_P.add(new PetriP("P21",0));
	d_P.add(new PetriP("P22",1));
	d_P.add(new PetriP("P23",0));
	d_P.add(new PetriP("P24",1));
	d_P.add(new PetriP("P25",0));
	d_P.add(new PetriP("P26",0));
	d_P.add(new PetriP("P27",1));
	d_P.add(new PetriP("P28",1));
	d_P.add(new PetriP("P29",0));
	d_P.add(new PetriP("P30",0));
	d_P.add(new PetriP("P31",0));
	d_P.add(new PetriP("P32",1));
	d_P.add(new PetriP("West2",0));
	d_P.add(new PetriP("QueueAvivable2",1));
	d_P.add(new PetriP("QueueAvivable1",1));
	d_P.add(new PetriP("QueueAvivable3",1));
	d_T.add(new PetriT("T1",trafficLightTime1));
	d_T.add(new PetriT("T2",trafficLightTime1));
	d_T.add(new PetriT("T3",5.0));
	d_T.add(new PetriT("T4",5.0));
	d_T.add(new PetriT("T5",6.0));
	d_T.get(4).setDistribution("unif", d_T.get(4).getTimeServ());
	d_T.get(4).setParamDeviation(2.0);
	d_T.get(4).setPriority(1);
	d_T.add(new PetriT("T6",6.0));
	d_T.get(5).setDistribution("unif", d_T.get(5).getTimeServ());
	d_T.get(5).setParamDeviation(2.0);
	d_T.get(5).setPriority(1);
	d_T.add(new PetriT("T7",0.0));
	d_T.add(new PetriT("T8",0.0));
	d_T.add(new PetriT("T9",10.0));
	d_T.get(8).setDistribution("exp", d_T.get(8).getTimeServ());
	d_T.get(8).setParamDeviation(0.0);
	d_T.add(new PetriT("T10",6.0));
	d_T.get(9).setDistribution("unif", d_T.get(9).getTimeServ());
	d_T.get(9).setParamDeviation(2.0);
	d_T.get(9).setPriority(1);
	d_T.add(new PetriT("T11",6.0));
	d_T.get(10).setDistribution("unif", d_T.get(10).getTimeServ());
	d_T.get(10).setParamDeviation(2.0);
	d_T.get(10).setPriority(1);
	d_T.add(new PetriT("T12",6.0));
	d_T.get(11).setDistribution("unif", d_T.get(11).getTimeServ());
	d_T.get(11).setParamDeviation(2.0);
	d_T.get(11).setPriority(1);
	d_T.add(new PetriT("T13",0.0));
	d_T.add(new PetriT("T14",0.0));
	d_T.add(new PetriT("T15",10.0));
	d_T.get(14).setDistribution("exp", d_T.get(14).getTimeServ());
	d_T.get(14).setParamDeviation(0.0);
	d_T.add(new PetriT("T16",0.0));
	d_T.get(15).setPriority(1);
	d_T.add(new PetriT("T17",0.0));
	d_T.get(16).setPriority(1);
	d_T.add(new PetriT("T18",5.0));
	d_T.add(new PetriT("T19",0.0));
	d_T.add(new PetriT("T20",0.0));
	d_T.add(new PetriT("T21",0.0));
	d_T.get(20).setPriority(1);
	d_T.add(new PetriT("T22",5.0));
	d_T.add(new PetriT("T23",0.0));
	d_T.add(new PetriT("T24",0.0));
	d_T.add(new PetriT("T25",6.0));
	d_T.get(24).setDistribution("unif", d_T.get(24).getTimeServ());
	d_T.get(24).setParamDeviation(2.0);
	d_T.get(24).setPriority(1);
	d_T.add(new PetriT("T26",6.0));
	d_T.get(25).setDistribution("unif", d_T.get(25).getTimeServ());
	d_T.get(25).setParamDeviation(2.0);
	d_T.get(25).setPriority(1);
	d_T.add(new PetriT("T27",6.0));
	d_T.get(26).setDistribution("unif", d_T.get(26).getTimeServ());
	d_T.get(26).setParamDeviation(2.0);
	d_T.get(26).setPriority(1);
	d_T.add(new PetriT("T28",0.0));
	d_T.add(new PetriT("T29",0.0));
	d_T.add(new PetriT("T30",10.0));
	d_T.get(29).setDistribution("exp", d_T.get(29).getTimeServ());
	d_T.get(29).setParamDeviation(0.0);
	d_In.add(new ArcIn(d_P.get(3),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(21),d_T.get(17),1));
	d_In.add(new ArcIn(d_P.get(24),d_T.get(22),1));
	d_In.add(new ArcIn(d_P.get(0),d_T.get(2),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(2),1));
	d_In.add(new ArcIn(d_P.get(26),d_T.get(24),1));
	d_In.add(new ArcIn(d_P.get(28),d_T.get(24),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(24),1));
	d_In.get(8).setInf(true);
	d_In.add(new ArcIn(d_P.get(2),d_T.get(0),1));
	d_In.add(new ArcIn(d_P.get(13),d_T.get(10),1));
	d_In.add(new ArcIn(d_P.get(15),d_T.get(10),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(10),1));
	d_In.get(12).setInf(true);
	d_In.add(new ArcIn(d_P.get(9),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(5),1));
	d_In.get(15).setInf(true);
	d_In.add(new ArcIn(d_P.get(6),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(8),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(25),d_T.get(4),1));
	d_In.get(18).setInf(true);
	d_In.add(new ArcIn(d_P.get(17),d_T.get(12),1));
	d_In.add(new ArcIn(d_P.get(28),d_T.get(26),1));
	d_In.add(new ArcIn(d_P.get(26),d_T.get(26),1));
	d_In.add(new ArcIn(d_P.get(22),d_T.get(26),1));
	d_In.get(22).setInf(true);
	d_In.add(new ArcIn(d_P.get(5),d_T.get(26),1));
	d_In.get(23).setInf(true);
	d_In.add(new ArcIn(d_P.get(11),d_T.get(8),1));
	d_In.add(new ArcIn(d_P.get(20),d_T.get(15),1));
	d_In.add(new ArcIn(d_P.get(15),d_T.get(15),1));
	d_In.get(26).setInf(true);
	d_In.add(new ArcIn(d_P.get(27),d_T.get(25),1));
	d_In.add(new ArcIn(d_P.get(29),d_T.get(25),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(25),1));
	d_In.get(29).setInf(true);
	d_In.add(new ArcIn(d_P.get(31),d_T.get(29),1));
	d_In.add(new ArcIn(d_P.get(10),d_T.get(7),1));
	d_In.add(new ArcIn(d_P.get(17),d_T.get(13),1));
	d_In.add(new ArcIn(d_P.get(25),d_T.get(23),1));
	d_In.add(new ArcIn(d_P.get(30),d_T.get(28),1));
	d_In.add(new ArcIn(d_P.get(10),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(23),d_T.get(21),1));
	d_In.add(new ArcIn(d_P.get(14),d_T.get(11),1));
	d_In.add(new ArcIn(d_P.get(16),d_T.get(11),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(11),1));
	d_In.get(39).setInf(true);
	d_In.add(new ArcIn(d_P.get(13),d_T.get(9),1));
	d_In.add(new ArcIn(d_P.get(15),d_T.get(9),1));
	d_In.add(new ArcIn(d_P.get(18),d_T.get(14),1));
	d_In.add(new ArcIn(d_P.get(20),d_T.get(18),1));
	d_In.add(new ArcIn(d_P.get(22),d_T.get(19),1));
	d_In.add(new ArcIn(d_P.get(20),d_T.get(16),1));
	d_In.add(new ArcIn(d_P.get(16),d_T.get(16),1));
	d_In.get(46).setInf(true);
	d_In.add(new ArcIn(d_P.get(15),d_T.get(20),1));
	d_In.get(47).setInf(true);
	d_In.add(new ArcIn(d_P.get(24),d_T.get(20),1));
	d_In.add(new ArcIn(d_P.get(30),d_T.get(27),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(33),d_T.get(5),1));
	d_In.get(51).setInf(true);
	d_In.add(new ArcIn(d_P.get(33),d_T.get(25),1));
	d_In.get(52).setInf(true);
	d_In.add(new ArcIn(d_P.get(33),d_T.get(24),1));
	d_In.get(53).setInf(true);
	d_In.add(new ArcIn(d_P.get(35),d_T.get(4),1));
	d_In.get(54).setInf(true);
	d_In.add(new ArcIn(d_P.get(35),d_T.get(10),1));
	d_In.get(55).setInf(true);
	d_In.add(new ArcIn(d_P.get(35),d_T.get(11),1));
	d_In.get(56).setInf(true);
	d_In.add(new ArcIn(d_P.get(34),d_T.get(9),1));
	d_In.get(57).setInf(true);
	d_In.add(new ArcIn(d_P.get(34),d_T.get(26),1));
	d_In.get(58).setInf(true);
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(4),1));
	d_Out.add(new ArcOut(d_T.get(17),d_P.get(20),1));
	d_Out.add(new ArcOut(d_T.get(22),d_P.get(25),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(1),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(5),1));
	d_Out.add(new ArcOut(d_T.get(24),d_P.get(26),1));
	d_Out.add(new ArcOut(d_T.get(24),d_P.get(19),1));
	d_Out.add(new ArcOut(d_T.get(0),d_P.get(0),1));
	d_Out.add(new ArcOut(d_T.get(10),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(10),d_P.get(32),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(19),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(32),1));
	d_Out.add(new ArcOut(d_T.get(12),d_P.get(15),1));
	d_Out.add(new ArcOut(d_T.get(26),d_P.get(26),1));
	d_Out.add(new ArcOut(d_T.get(26),d_P.get(12),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(11),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(10),1));
	d_Out.add(new ArcOut(d_T.get(15),d_P.get(21),1));
	d_Out.add(new ArcOut(d_T.get(25),d_P.get(27),1));
	d_Out.add(new ArcOut(d_T.get(25),d_P.get(19),1));
	d_Out.add(new ArcOut(d_T.get(29),d_P.get(31),1));
	d_Out.add(new ArcOut(d_T.get(29),d_P.get(30),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(9),1));
	d_Out.add(new ArcOut(d_T.get(13),d_P.get(16),1));
	d_Out.add(new ArcOut(d_T.get(23),d_P.get(23),1));
	d_Out.add(new ArcOut(d_T.get(28),d_P.get(29),1));
	d_Out.add(new ArcOut(d_T.get(6),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(21),d_P.get(24),1));
	d_Out.add(new ArcOut(d_T.get(11),d_P.get(14),1));
	d_Out.add(new ArcOut(d_T.get(11),d_P.get(32),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(12),1));
	d_Out.add(new ArcOut(d_T.get(14),d_P.get(18),1));
	d_Out.add(new ArcOut(d_T.get(14),d_P.get(17),1));
	d_Out.add(new ArcOut(d_T.get(18),d_P.get(22),1));
	d_Out.add(new ArcOut(d_T.get(19),d_P.get(21),1));
	d_Out.add(new ArcOut(d_T.get(16),d_P.get(21),1));
	d_Out.add(new ArcOut(d_T.get(20),d_P.get(23),1));
	d_Out.add(new ArcOut(d_T.get(27),d_P.get(28),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(3),1));
	PetriNet d_Net = new PetriNet("netpart2",d_P,d_T,d_In,d_Out);
	PetriP.initNext();
	PetriT.initNext();
	ArcIn.initNext();
	ArcOut.initNext();

	return d_Net;
    }
}
