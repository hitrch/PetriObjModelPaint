package diploma;

import PetriObj.ArcIn;
import PetriObj.ArcOut;
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
public class Netpart3 extends PetriSim implements RoadPart {
    private int numberOfParameters;
    private double trafficLightTime1;
    private double trafficLightTime2;
    private int positionBetweenRedAndGreenLights;
    
    public Netpart3() throws ExceptionInvalidTimeDelay {
        super(createNetpart3WithTimedelays(60.0, 60.0));
        this.trafficLightTime1 = 60.0;
        this.trafficLightTime2 = 60.0;
        this.numberOfParameters = 2;
        this.positionBetweenRedAndGreenLights = 1;
    }
    
    public Netpart3(double trafficLightTime1, double trafficLightTime2) throws ExceptionInvalidTimeDelay {
        super(createNetpart3WithTimedelays(trafficLightTime1, trafficLightTime2));
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
        queues.add("P10");
        queues.add("P11");
        queues.add("P12");
        queues.add("P63");
        queues.add("P64");
        queues.add("P61");
        queues.add("P62");
        queues.add("P34");
        queues.add("P35");
        queues.add("P36");
        queues.add("P46");
        queues.add("P47");
        queues.add("P48");
        queues.add("P17");
        queues.add("P56");
        queues.add("P59");
        queues.add("P22");
        queues.add("P23");
        queues.add("P24");
        queues.add("P29");
        queues.add("P28");
        queues.add("P40");
        
        
        return queues;
    }
    
    public int getTopPositionNumber() {
        return 54;
    }
    
    public int getBotPositionNumber() {
        return 38;
    }
    
    public int getLeftPositionNumber() {
        return 50;
    }
    
    public int getRightPositionNumber() {
        return 26;
    }
    
    public int getTopPositionIncomeNumber() {
        return 12;
    }
    
    public int getBotPositionIncomeNumber() {
        return 36;
    }
    
    public int getLeftPositionIncomeNumber() {
        return 48;
    }
    
    public int getRightPositionIncomeNumber() {
        return 24;
    }
    
    public int getLeftPositionQueue() {
        return 55;
    }
    
    public int getTopPositionQueue() {
        return 56;
    }
    
    public int getRightPositionQueue() {
        return 57;
    }
    
    public int getBotPositionQueue() {
        return 58;
    }
    
    public PetriNet createNetpart3() throws ExceptionInvalidTimeDelay {
        return createNetpart3WithTimedelays(this.trafficLightTime1, this.trafficLightTime2);
    }
    
    public static PetriNet createNetpart3WithTimedelays(double trafficLightTime1, double trafficLightTime2) throws ExceptionInvalidTimeDelay { 
        ArrayList<PetriP> d_P = new ArrayList<>();
	ArrayList<PetriT> d_T = new ArrayList<>();
	ArrayList<ArcIn> d_In = new ArrayList<>();
	ArrayList<ArcOut> d_Out = new ArrayList<>();
	d_P.add(new PetriP("P1",0));
	d_P.add(new PetriP("P2",1));
	d_P.add(new PetriP("P3",0));
	d_P.add(new PetriP("P4",0));
	d_P.add(new PetriP("P5",1));
	d_P.add(new PetriP("P6",0));
	d_P.add(new PetriP("P7",1));
	d_P.add(new PetriP("P8",1));
	d_P.add(new PetriP("P9",1));
	d_P.add(new PetriP("P10",0));
	d_P.add(new PetriP("P11",0));
	d_P.add(new PetriP("P12",0));
	d_P.add(new PetriP("P13",0));
	d_P.add(new PetriP("P14",1));
	d_P.add(new PetriP("P15",0));
	d_P.add(new PetriP("P16",3));
	d_P.add(new PetriP("P17",0));
	d_P.add(new PetriP("P18",1));
	d_P.add(new PetriP("P19",1));
	d_P.add(new PetriP("P20",1));
	d_P.add(new PetriP("P21",1));
	d_P.add(new PetriP("P22",0));
	d_P.add(new PetriP("P23",0));
	d_P.add(new PetriP("P24",0));
	d_P.add(new PetriP("P25",0));
	d_P.add(new PetriP("P26",1));
	d_P.add(new PetriP("East1",0));
	d_P.add(new PetriP("P28",0));
	d_P.add(new PetriP("P29",0));
	d_P.add(new PetriP("P30",3));
	d_P.add(new PetriP("P31",1));
	d_P.add(new PetriP("P32",1));
	d_P.add(new PetriP("P33",1));
	d_P.add(new PetriP("P34",0));
	d_P.add(new PetriP("P35",0));
	d_P.add(new PetriP("P36",0));
	d_P.add(new PetriP("P37",0));
	d_P.add(new PetriP("P38",1));
	d_P.add(new PetriP("South1",0));
	d_P.add(new PetriP("P40",0));
	d_P.add(new PetriP("P41",3));
	d_P.add(new PetriP("P42",3));
	d_P.add(new PetriP("P43",1));
	d_P.add(new PetriP("P44",1));
	d_P.add(new PetriP("P45",1));
	d_P.add(new PetriP("P46",0));
	d_P.add(new PetriP("P47",0));
	d_P.add(new PetriP("P48",0));
	d_P.add(new PetriP("CrossoverIncome1",0));
	d_P.add(new PetriP("P50",1));
	d_P.add(new PetriP("West1",0));
	d_P.add(new PetriP("P52",1));
	d_P.add(new PetriP("P53",1));
	d_P.add(new PetriP("P54",1));
	d_P.add(new PetriP("North1",0));
	d_P.add(new PetriP("QueueAvivable1",1));
	d_P.add(new PetriP("QueueAvivable2",1));
	d_P.add(new PetriP("QueueAvivable3",1));
	d_P.add(new PetriP("QueueAvivable4",1));
	d_P.add(new PetriP("P55",3));
	d_P.add(new PetriP("P56",0));
	d_P.add(new PetriP("P57",1));
	d_P.add(new PetriP("P59",0));
	d_P.add(new PetriP("P58",3));
	d_P.add(new PetriP("P60",1));
	d_P.add(new PetriP("P61",0));
	d_P.add(new PetriP("P62",0));
	d_P.add(new PetriP("P63",0));
	d_P.add(new PetriP("P64",0));
	d_T.add(new PetriT("T1",trafficLightTime1));
	d_T.add(new PetriT("T2",5.0));
	d_T.add(new PetriT("T3",trafficLightTime1));
	d_T.add(new PetriT("T4",5.0));
	d_T.add(new PetriT("T5",10.0));
	d_T.get(4).setDistribution("exp", d_T.get(4).getTimeServ());
	d_T.get(4).setParamDeviation(0.0);
	d_T.add(new PetriT("T6",0.0));
	d_T.add(new PetriT("T7",0.0));
	d_T.add(new PetriT("T8",0.0));
	d_T.add(new PetriT("T9",7.0));
	d_T.get(8).setDistribution("unif", d_T.get(8).getTimeServ());
	d_T.get(8).setParamDeviation(2.0);
	d_T.get(8).setPriority(1);
	d_T.add(new PetriT("T10",7.0));
	d_T.get(9).setDistribution("unif", d_T.get(9).getTimeServ());
	d_T.get(9).setParamDeviation(2.0);
	d_T.get(9).setPriority(1);
	d_T.add(new PetriT("T11",7.0));
	d_T.get(10).setDistribution("unif", d_T.get(10).getTimeServ());
	d_T.get(10).setParamDeviation(2.0);
	d_T.get(10).setPriority(1);
	d_T.add(new PetriT("T12",7.0));
	d_T.get(11).setDistribution("unif", d_T.get(11).getTimeServ());
	d_T.get(11).setParamDeviation(2.0);
	d_T.get(11).setPriority(1);
	d_T.add(new PetriT("T13",7.0));
	d_T.get(12).setDistribution("unif", d_T.get(12).getTimeServ());
	d_T.get(12).setParamDeviation(2.0);
	d_T.get(12).setPriority(1);
	d_T.add(new PetriT("T14",0.0));
	d_T.get(13).setPriority(1);
	d_T.add(new PetriT("T15",0.0));
	d_T.get(14).setPriority(1);
	d_T.add(new PetriT("T16",7.0));
	d_T.get(15).setDistribution("unif", d_T.get(15).getTimeServ());
	d_T.get(15).setParamDeviation(2.0);
	d_T.get(15).setPriority(1);
	d_T.add(new PetriT("T17",7.0));
	d_T.get(16).setDistribution("unif", d_T.get(16).getTimeServ());
	d_T.get(16).setParamDeviation(2.0);
	d_T.add(new PetriT("T18",0.0));
	d_T.add(new PetriT("T19",0.0));
	d_T.add(new PetriT("T20",10.0));
	d_T.get(19).setDistribution("exp", d_T.get(19).getTimeServ());
	d_T.get(19).setParamDeviation(0.0);
	d_T.add(new PetriT("T21",0.0));
	d_T.add(new PetriT("T22",0.0));
	d_T.add(new PetriT("T23",0.0));
	d_T.add(new PetriT("T24",7.0));
	d_T.get(23).setDistribution("unif", d_T.get(23).getTimeServ());
	d_T.get(23).setParamDeviation(2.0);
	d_T.get(23).setPriority(1);
	d_T.add(new PetriT("T25",3.0));
	d_T.get(24).setDistribution("unif", d_T.get(24).getTimeServ());
	d_T.get(24).setParamDeviation(2.0);
	d_T.get(24).setPriority(1);
	d_T.add(new PetriT("T26",3.0));
	d_T.get(25).setDistribution("unif", d_T.get(25).getTimeServ());
	d_T.get(25).setParamDeviation(2.0);
	d_T.get(25).setPriority(1);
	d_T.add(new PetriT("T27",3.0));
	d_T.get(26).setDistribution("unif", d_T.get(26).getTimeServ());
	d_T.get(26).setParamDeviation(2.0);
	d_T.get(26).setPriority(1);
	d_T.add(new PetriT("T28",4.0));
	d_T.get(27).setDistribution("unif", d_T.get(27).getTimeServ());
	d_T.get(27).setParamDeviation(2.0);
	d_T.get(27).setPriority(1);
	d_T.add(new PetriT("T29",4.0));
	d_T.get(28).setDistribution("unif", d_T.get(28).getTimeServ());
	d_T.get(28).setParamDeviation(2.0);
	d_T.get(28).setPriority(1);
	d_T.add(new PetriT("T30",4.0));
	d_T.get(29).setDistribution("unif", d_T.get(29).getTimeServ());
	d_T.get(29).setParamDeviation(2.0);
	d_T.get(29).setPriority(1);
	d_T.add(new PetriT("T31",4.0));
	d_T.get(30).setDistribution("unif", d_T.get(30).getTimeServ());
	d_T.get(30).setParamDeviation(2.0);
	d_T.get(30).setPriority(1);
	d_T.add(new PetriT("T32",4.0));
	d_T.get(31).setDistribution("unif", d_T.get(31).getTimeServ());
	d_T.get(31).setParamDeviation(2.0);
	d_T.add(new PetriT("T33",4.0));
	d_T.get(32).setDistribution("unif", d_T.get(32).getTimeServ());
	d_T.get(32).setParamDeviation(2.0);
	d_T.add(new PetriT("T35",10.0));
	d_T.get(33).setDistribution("exp", d_T.get(33).getTimeServ());
	d_T.get(33).setParamDeviation(0.0);
	d_T.add(new PetriT("T36",0.0));
	d_T.add(new PetriT("T37",0.0));
	d_T.add(new PetriT("T38",0.0));
	d_T.add(new PetriT("T39",7.0));
	d_T.get(37).setDistribution("unif", d_T.get(37).getTimeServ());
	d_T.get(37).setParamDeviation(2.0);
	d_T.get(37).setPriority(1);
	d_T.add(new PetriT("T40",7.0));
	d_T.get(38).setDistribution("unif", d_T.get(38).getTimeServ());
	d_T.get(38).setParamDeviation(2.0);
	d_T.get(38).setPriority(1);
	d_T.add(new PetriT("T41",7.0));
	d_T.get(39).setDistribution("unif", d_T.get(39).getTimeServ());
	d_T.get(39).setParamDeviation(2.0);
	d_T.get(39).setPriority(1);
	d_T.add(new PetriT("T42",7.0));
	d_T.get(40).setDistribution("unif", d_T.get(40).getTimeServ());
	d_T.get(40).setParamDeviation(2.0);
	d_T.get(40).setPriority(1);
	d_T.add(new PetriT("T43",7.0));
	d_T.get(41).setDistribution("unif", d_T.get(41).getTimeServ());
	d_T.get(41).setParamDeviation(2.0);
	d_T.get(41).setPriority(1);
	d_T.add(new PetriT("T44",7.0));
	d_T.get(42).setDistribution("unif", d_T.get(42).getTimeServ());
	d_T.get(42).setParamDeviation(2.0);
	d_T.get(42).setPriority(1);
	d_T.add(new PetriT("T45",7.0));
	d_T.get(43).setDistribution("unif", d_T.get(43).getTimeServ());
	d_T.get(43).setParamDeviation(2.0);
	d_T.get(43).setPriority(1);
	d_T.add(new PetriT("T50",10.0));
	d_T.get(44).setDistribution("exp", d_T.get(44).getTimeServ());
	d_T.get(44).setParamDeviation(0.0);
	d_T.add(new PetriT("T51",0.0));
	d_T.add(new PetriT("T52",0.0));
	d_T.add(new PetriT("T53",0.0));
	d_T.add(new PetriT("T55",3.0));
	d_T.get(48).setDistribution("unif", d_T.get(48).getTimeServ());
	d_T.get(48).setParamDeviation(2.0);
	d_T.get(48).setPriority(1);
	d_T.add(new PetriT("T56",7.0));
	d_T.get(49).setDistribution("unif", d_T.get(49).getTimeServ());
	d_T.get(49).setParamDeviation(2.0);
	d_T.get(49).setPriority(1);
	d_T.add(new PetriT("T57",7.0));
	d_T.get(50).setDistribution("unif", d_T.get(50).getTimeServ());
	d_T.get(50).setParamDeviation(2.0);
	d_T.get(50).setPriority(1);
	d_T.add(new PetriT("T58",7.0));
	d_T.get(51).setDistribution("unif", d_T.get(51).getTimeServ());
	d_T.get(51).setParamDeviation(2.0);
	d_T.get(51).setPriority(1);
	d_In.add(new ArcIn(d_P.get(35),d_T.get(40),1));
	d_In.add(new ArcIn(d_P.get(32),d_T.get(40),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(40),1));
	d_In.get(2).setInf(true);
	d_In.add(new ArcIn(d_P.get(56),d_T.get(40),1));
	d_In.get(3).setInf(true);
	d_In.add(new ArcIn(d_P.get(21),d_T.get(24),1));
	d_In.add(new ArcIn(d_P.get(18),d_T.get(24),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(24),1));
	d_In.get(6).setInf(true);
	d_In.add(new ArcIn(d_P.get(29),d_T.get(24),1));
	d_In.add(new ArcIn(d_P.get(47),d_T.get(51),1));
	d_In.add(new ArcIn(d_P.get(44),d_T.get(51),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(51),1));
	d_In.get(10).setInf(true);
	d_In.add(new ArcIn(d_P.get(58),d_T.get(51),1));
	d_In.get(11).setInf(true);
	d_In.add(new ArcIn(d_P.get(24),d_T.get(21),1));
	d_In.add(new ArcIn(d_P.get(23),d_T.get(26),1));
	d_In.add(new ArcIn(d_P.get(20),d_T.get(26),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(26),1));
	d_In.get(15).setInf(true);
	d_In.add(new ArcIn(d_P.get(40),d_T.get(26),1));
	d_In.add(new ArcIn(d_P.get(17),d_T.get(30),1));
	d_In.add(new ArcIn(d_P.get(16),d_T.get(30),1));
	d_In.add(new ArcIn(d_P.get(57),d_T.get(30),1));
	d_In.get(19).setInf(true);
	d_In.add(new ArcIn(d_P.get(5),d_T.get(30),1));
	d_In.get(20).setInf(true);
	d_In.add(new ArcIn(d_P.get(47),d_T.get(50),1));
	d_In.add(new ArcIn(d_P.get(44),d_T.get(50),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(50),1));
	d_In.get(23).setInf(true);
	d_In.add(new ArcIn(d_P.get(63),d_T.get(50),1));
	d_In.add(new ArcIn(d_P.get(42),d_T.get(48),1));
	d_In.add(new ArcIn(d_P.get(45),d_T.get(48),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(48),1));
	d_In.get(27).setInf(true);
	d_In.add(new ArcIn(d_P.get(15),d_T.get(48),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(33),d_T.get(37),1));
	d_In.add(new ArcIn(d_P.get(30),d_T.get(37),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(37),1));
	d_In.get(33).setInf(true);
	d_In.add(new ArcIn(d_P.get(55),d_T.get(37),1));
	d_In.get(34).setInf(true);
	d_In.add(new ArcIn(d_P.get(21),d_T.get(23),1));
	d_In.add(new ArcIn(d_P.get(18),d_T.get(23),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(23),1));
	d_In.get(37).setInf(true);
	d_In.add(new ArcIn(d_P.get(56),d_T.get(23),1));
	d_In.get(38).setInf(true);
	d_In.add(new ArcIn(d_P.get(61),d_T.get(31),1));
	d_In.add(new ArcIn(d_P.get(60),d_T.get(31),1));
	d_In.add(new ArcIn(d_P.get(57),d_T.get(31),1));
	d_In.get(41).setInf(true);
	d_In.add(new ArcIn(d_P.get(5),d_T.get(31),1));
	d_In.get(42).setInf(true);
	d_In.add(new ArcIn(d_P.get(67),d_T.get(42),1));
	d_In.add(new ArcIn(d_P.get(58),d_T.get(42),1));
	d_In.get(44).setInf(true);
	d_In.add(new ArcIn(d_P.get(36),d_T.get(13),1));
	d_In.add(new ArcIn(d_P.get(24),d_T.get(22),1));
	d_In.add(new ArcIn(d_P.get(22),d_T.get(25),1));
	d_In.add(new ArcIn(d_P.get(19),d_T.get(25),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(25),1));
	d_In.get(49).setInf(true);
	d_In.add(new ArcIn(d_P.get(41),d_T.get(25),1));
	d_In.add(new ArcIn(d_P.get(39),d_T.get(27),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(27),1));
	d_In.get(52).setInf(true);
	d_In.add(new ArcIn(d_P.get(55),d_T.get(27),1));
	d_In.get(53).setInf(true);
	d_In.add(new ArcIn(d_P.get(53),d_T.get(27),1));
	d_In.add(new ArcIn(d_P.get(49),d_T.get(44),1));
	d_In.add(new ArcIn(d_P.get(9),d_T.get(9),1));
	d_In.add(new ArcIn(d_P.get(6),d_T.get(9),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(9),1));
	d_In.get(58).setInf(true);
	d_In.add(new ArcIn(d_P.get(58),d_T.get(9),1));
	d_In.get(59).setInf(true);
	d_In.add(new ArcIn(d_P.get(66),d_T.get(16),1));
	d_In.add(new ArcIn(d_P.get(56),d_T.get(16),1));
	d_In.get(61).setInf(true);
	d_In.add(new ArcIn(d_P.get(36),d_T.get(35),1));
	d_In.add(new ArcIn(d_P.get(28),d_T.get(29),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(29),1));
	d_In.get(64).setInf(true);
	d_In.add(new ArcIn(d_P.get(55),d_T.get(29),1));
	d_In.get(65).setInf(true);
	d_In.add(new ArcIn(d_P.get(51),d_T.get(29),1));
	d_In.add(new ArcIn(d_P.get(64),d_T.get(32),1));
	d_In.add(new ArcIn(d_P.get(62),d_T.get(32),1));
	d_In.add(new ArcIn(d_P.get(57),d_T.get(32),1));
	d_In.get(69).setInf(true);
	d_In.add(new ArcIn(d_P.get(5),d_T.get(32),1));
	d_In.get(70).setInf(true);
	d_In.add(new ArcIn(d_P.get(12),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(33),d_T.get(38),1));
	d_In.add(new ArcIn(d_P.get(30),d_T.get(38),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(38),1));
	d_In.get(74).setInf(true);
	d_In.add(new ArcIn(d_P.get(56),d_T.get(38),1));
	d_In.get(75).setInf(true);
	d_In.add(new ArcIn(d_P.get(36),d_T.get(14),1));
	d_In.add(new ArcIn(d_P.get(12),d_T.get(7),1));
	d_In.add(new ArcIn(d_P.get(65),d_T.get(15),1));
	d_In.add(new ArcIn(d_P.get(56),d_T.get(15),1));
	d_In.get(79).setInf(true);
	d_In.add(new ArcIn(d_P.get(12),d_T.get(17),1));
	d_In.add(new ArcIn(d_P.get(36),d_T.get(36),1));
	d_In.add(new ArcIn(d_P.get(48),d_T.get(46),1));
	d_In.add(new ArcIn(d_P.get(9),d_T.get(8),1));
	d_In.add(new ArcIn(d_P.get(6),d_T.get(8),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(8),1));
	d_In.get(85).setInf(true);
	d_In.add(new ArcIn(d_P.get(55),d_T.get(8),1));
	d_In.get(86).setInf(true);
	d_In.add(new ArcIn(d_P.get(24),d_T.get(20),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(25),d_T.get(19),1));
	d_In.add(new ArcIn(d_P.get(10),d_T.get(10),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(10),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(10),1));
	d_In.get(93).setInf(true);
	d_In.add(new ArcIn(d_P.get(58),d_T.get(10),1));
	d_In.get(94).setInf(true);
	d_In.add(new ArcIn(d_P.get(11),d_T.get(12),1));
	d_In.add(new ArcIn(d_P.get(8),d_T.get(12),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(12),1));
	d_In.get(97).setInf(true);
	d_In.add(new ArcIn(d_P.get(57),d_T.get(12),1));
	d_In.get(98).setInf(true);
	d_In.add(new ArcIn(d_P.get(35),d_T.get(41),1));
	d_In.add(new ArcIn(d_P.get(32),d_T.get(41),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(41),1));
	d_In.get(101).setInf(true);
	d_In.add(new ArcIn(d_P.get(57),d_T.get(41),1));
	d_In.get(102).setInf(true);
	d_In.add(new ArcIn(d_P.get(43),d_T.get(49),1));
	d_In.add(new ArcIn(d_P.get(46),d_T.get(49),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(49),1));
	d_In.get(105).setInf(true);
	d_In.add(new ArcIn(d_P.get(59),d_T.get(49),1));
	d_In.add(new ArcIn(d_P.get(0),d_T.get(0),1));
	d_In.add(new ArcIn(d_P.get(13),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(2),d_T.get(2),1));
	d_In.add(new ArcIn(d_P.get(12),d_T.get(18),1));
	d_In.add(new ArcIn(d_P.get(37),d_T.get(33),1));
	d_In.add(new ArcIn(d_P.get(34),d_T.get(39),1));
	d_In.add(new ArcIn(d_P.get(31),d_T.get(39),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(39),1));
	d_In.get(114).setInf(true);
	d_In.add(new ArcIn(d_P.get(56),d_T.get(39),1));
	d_In.get(115).setInf(true);
	d_In.add(new ArcIn(d_P.get(48),d_T.get(45),1));
	d_In.add(new ArcIn(d_P.get(11),d_T.get(11),1));
	d_In.add(new ArcIn(d_P.get(8),d_T.get(11),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(11),1));
	d_In.get(119).setInf(true);
	d_In.add(new ArcIn(d_P.get(58),d_T.get(11),1));
	d_In.get(120).setInf(true);
	d_In.add(new ArcIn(d_P.get(48),d_T.get(47),1));
	d_In.add(new ArcIn(d_P.get(27),d_T.get(28),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(28),1));
	d_In.get(123).setInf(true);
	d_In.add(new ArcIn(d_P.get(55),d_T.get(28),1));
	d_In.get(124).setInf(true);
	d_In.add(new ArcIn(d_P.get(52),d_T.get(28),1));
	d_In.add(new ArcIn(d_P.get(12),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(68),d_T.get(43),1));
	d_In.add(new ArcIn(d_P.get(58),d_T.get(43),1));
	d_In.get(128).setInf(true);
	d_In.add(new ArcIn(d_P.get(36),d_T.get(34),1));
	d_Out.add(new ArcOut(d_T.get(40),d_P.get(32),1));
	d_Out.add(new ArcOut(d_T.get(40),d_P.get(54),1));
	d_Out.add(new ArcOut(d_T.get(24),d_P.get(18),1));
	d_Out.add(new ArcOut(d_T.get(24),d_P.get(28),1));
	d_Out.add(new ArcOut(d_T.get(51),d_P.get(44),1));
	d_Out.add(new ArcOut(d_T.get(51),d_P.get(38),1));
	d_Out.add(new ArcOut(d_T.get(21),d_P.get(22),1));
	d_Out.add(new ArcOut(d_T.get(26),d_P.get(20),1));
	d_Out.add(new ArcOut(d_T.get(26),d_P.get(39),1));
	d_Out.add(new ArcOut(d_T.get(30),d_P.get(17),1));
	d_Out.add(new ArcOut(d_T.get(30),d_P.get(15),1));
	d_Out.add(new ArcOut(d_T.get(30),d_P.get(26),1));
	d_Out.add(new ArcOut(d_T.get(50),d_P.get(44),1));
	d_Out.add(new ArcOut(d_T.get(50),d_P.get(62),1));
	d_Out.add(new ArcOut(d_T.get(48),d_P.get(42),1));
	d_Out.add(new ArcOut(d_T.get(48),d_P.get(16),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(5),1));
	d_Out.add(new ArcOut(d_T.get(37),d_P.get(30),1));
	d_Out.add(new ArcOut(d_T.get(37),d_P.get(50),1));
	d_Out.add(new ArcOut(d_T.get(23),d_P.get(18),1));
	d_Out.add(new ArcOut(d_T.get(23),d_P.get(54),1));
	d_Out.add(new ArcOut(d_T.get(31),d_P.get(61),1));
	d_Out.add(new ArcOut(d_T.get(31),d_P.get(59),1));
	d_Out.add(new ArcOut(d_T.get(31),d_P.get(26),1));
	d_Out.add(new ArcOut(d_T.get(42),d_P.get(38),1));
	d_Out.add(new ArcOut(d_T.get(13),d_P.get(66),1));
	d_Out.add(new ArcOut(d_T.get(22),d_P.get(23),1));
	d_Out.add(new ArcOut(d_T.get(25),d_P.get(19),1));
	d_Out.add(new ArcOut(d_T.get(25),d_P.get(27),1));
	d_Out.add(new ArcOut(d_T.get(27),d_P.get(40),1));
	d_Out.add(new ArcOut(d_T.get(27),d_P.get(50),1));
	d_Out.add(new ArcOut(d_T.get(27),d_P.get(53),1));
	d_Out.add(new ArcOut(d_T.get(44),d_P.get(49),1));
	d_Out.add(new ArcOut(d_T.get(44),d_P.get(48),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(38),1));
	d_Out.add(new ArcOut(d_T.get(16),d_P.get(54),1));
	d_Out.add(new ArcOut(d_T.get(35),d_P.get(34),1));
	d_Out.add(new ArcOut(d_T.get(29),d_P.get(29),1));
	d_Out.add(new ArcOut(d_T.get(29),d_P.get(50),1));
	d_Out.add(new ArcOut(d_T.get(29),d_P.get(51),1));
	d_Out.add(new ArcOut(d_T.get(32),d_P.get(64),1));
	d_Out.add(new ArcOut(d_T.get(32),d_P.get(63),1));
	d_Out.add(new ArcOut(d_T.get(32),d_P.get(26),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(9),1));
	d_Out.add(new ArcOut(d_T.get(38),d_P.get(30),1));
	d_Out.add(new ArcOut(d_T.get(38),d_P.get(54),1));
	d_Out.add(new ArcOut(d_T.get(14),d_P.get(65),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(11),1));
	d_Out.add(new ArcOut(d_T.get(15),d_P.get(54),1));
	d_Out.add(new ArcOut(d_T.get(17),d_P.get(67),1));
	d_Out.add(new ArcOut(d_T.get(36),d_P.get(35),1));
	d_Out.add(new ArcOut(d_T.get(46),d_P.get(46),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(50),1));
	d_Out.add(new ArcOut(d_T.get(20),d_P.get(21),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(0),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(4),1));
	d_Out.add(new ArcOut(d_T.get(19),d_P.get(25),1));
	d_Out.add(new ArcOut(d_T.get(19),d_P.get(24),1));
	d_Out.add(new ArcOut(d_T.get(10),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(10),d_P.get(38),1));
	d_Out.add(new ArcOut(d_T.get(12),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(12),d_P.get(26),1));
	d_Out.add(new ArcOut(d_T.get(41),d_P.get(32),1));
	d_Out.add(new ArcOut(d_T.get(41),d_P.get(26),1));
	d_Out.add(new ArcOut(d_T.get(49),d_P.get(43),1));
	d_Out.add(new ArcOut(d_T.get(49),d_P.get(60),1));
	d_Out.add(new ArcOut(d_T.get(0),d_P.get(1),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(12),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(3),1));
	d_Out.add(new ArcOut(d_T.get(18),d_P.get(68),1));
	d_Out.add(new ArcOut(d_T.get(33),d_P.get(36),1));
	d_Out.add(new ArcOut(d_T.get(33),d_P.get(37),1));
	d_Out.add(new ArcOut(d_T.get(39),d_P.get(31),1));
	d_Out.add(new ArcOut(d_T.get(39),d_P.get(54),1));
	d_Out.add(new ArcOut(d_T.get(45),d_P.get(45),1));
	d_Out.add(new ArcOut(d_T.get(11),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(11),d_P.get(38),1));
	d_Out.add(new ArcOut(d_T.get(47),d_P.get(47),1));
	d_Out.add(new ArcOut(d_T.get(28),d_P.get(41),1));
	d_Out.add(new ArcOut(d_T.get(28),d_P.get(50),1));
	d_Out.add(new ArcOut(d_T.get(28),d_P.get(52),1));
	d_Out.add(new ArcOut(d_T.get(6),d_P.get(10),1));
	d_Out.add(new ArcOut(d_T.get(43),d_P.get(38),1));
	d_Out.add(new ArcOut(d_T.get(34),d_P.get(33),1));
	PetriNet d_Net = new PetriNet("netpart3",d_P,d_T,d_In,d_Out);
	PetriP.initNext();
	PetriT.initNext();
	ArcIn.initNext();
	ArcOut.initNext();

	return d_Net;
    }
}
