public class Truck extends Vehicle {
    Truck(String rno, String manu, String own) {
	super(rno, own, manu);
    }

    public void checkPollutionStatus() {
	if (getco2()<=25.0 && getco()<=0.8 && gethc()<=1000.0) setPollutionStatus("PASS");
	else setPollutionStatus("FAIL");
    }
}
