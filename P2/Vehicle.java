public class Vehicle{
    protected String regNo;
    protected String manufacturer;
    protected String owner;
    protected double co2;
    protected double co;
    protected double hc;
    protected String pollutionStatus;

    public Vehicle(String rno, String manu, String own) {
	regNo = rno;
	owner = own;
	manufacturer = manu;
	pollutionStatus = "PENDING";
    }

    public void setValues (double cdi, double cmono, double hyc) {
	co2 = cdi;
	co = cmono;
	hc = hyc;
	checkPollutionStatus();
    }

    public void checkPollutionStatus() {
    }

    public String getStatus() {
	return pollutionStatus;
    }

    public String getregNo() {
	return regNo;
    }

    public String toString() {
	String str = "Reg No: " + regNo + "\nManufacturer: " + manufacturer;
	str = str + "\nOwner: " + owner + "\nPollution Status: " + pollutionStatus + "\n";
	return str;
    }

    
}
