import java.io.*;
import java.util.*;

class PollutionCheck {
    public static void main(String[] args) {
	FileReader vehicles = null, pollution = null, queries = null;
	BufferedReader veh = null, poll = null, quer = null;
	try {
	    vehicles = new FileReader(args[0]);
	    pollution = new FileReader(args[1]);
	    queries = new FileReader(args[2]);
	    try {
		veh = new BufferedReader(vehicles);
		poll = new BufferedReader(pollution);
		quer = new BufferedReader(queries);
		ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
		ArrayList<String> reg = new ArrayList<String>();
		while (true) {
		    String line = veh.readLine();
		    if (line == null)
			break;
		    String[] fields = line.split(",");
		    Vehicle v;
		    if (fields[3].strip() == "Car") {
			v = new Car(fields[0], fields[1], fields[2]);
		    }
		    else {
			v = new Truck(fields[0], fields[1], fields[2]);
		    }
		    arr.add(v);
		    reg.add(fields[0]);
		}
		while (true) {
		    String line = poll.readLine();
		    if (line == null)
			break;
		    String[] fields = line.split(",");
		    int i = reg.indexOf(fields[0].strip());
		    arr.get(i).setValues(Double.parseDouble(fields[1].strip()), Double.parseDouble(fields[2].strip()), Double.parseDouble(fields[3].strip()));
		}
		while (true) {
		    String line = quer.readLine();
		    if (line == null)
			break;
		    int i = reg.indexOf(line.strip());
		    if (i == -1)
			System.out.println("NOT REGISTERED");
		    else
			System.out.println(arr.get(i).getStatus());
		}
	    }
	    catch (IOException ex) {
		System.out.println("Trouble opening file!");
	    }
	}	
	catch (FileNotFoundException ex) {
	    System.out.println("File not found!");
	}
    }
}
