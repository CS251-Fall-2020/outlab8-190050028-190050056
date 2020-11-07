public class Vehicle{
    private String regNo;
    private String manufacturer;
    private String owner;
    private double co2;
    private double co;
    private double hc;
    private String pollutionStatus;

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

    public void setPollutionStatus(String pstat) {
	pollutionStatus = pstat;
    }

    public String getStatus() {
	return pollutionStatus;
    }

    public String getregNo() {
	return regNo;
    }

    public double getco2() {
	return co2;
    }

    public double getco() {
	return co;
    }

    public double gethc() {
	return hc;
    }

    public String toString() {
	String str = "Reg No: " + regNo + "\nManufacturer" + manufacturer;
	str = str + "\nOwner: " + owner + "Pollution Status: " + pollutionStatus + "\n";
	return str;
    }

    
}
