public class Truck extends Vehicle {
    Truck(String rno, String manu, String own) {
	super(rno, manu, own);
    }

    public void checkPollutionStatus() {
	if (co2<=25.0 && co<=0.8 && hc<=1000.0) pollutionStatus = "PASS";
	else pollutionStatus = "FAIL";
    }
}
