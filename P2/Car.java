public class Car extends Vehicle {

    Car(String rno, String manu, String own) {
	super(rno, own, manu);
    }

    public void checkPollutionStatus() {
	if (getco2()<=15.0 && getco()<=0.5 && gethc()<=750.0) setPollutionStatus("PASS");
	else setPollutionStatus("FAIL");
    }
}
