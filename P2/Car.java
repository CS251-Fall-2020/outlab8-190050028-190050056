public class Car extends Vehicle {

    Car(String rno, String manu, String own) {
	super(rno, manu, own);
    }

    public void checkPollutionStatus() {
	if (co2<=15.0 && co<=0.5 && hc<=750.0) pollutionStatus = "PASS";
	else pollutionStatus = "FAIL";
    }
}
