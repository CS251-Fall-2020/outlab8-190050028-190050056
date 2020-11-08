// Used links:
// 1) https://www.tutorialspoint.com/java/java_files_io.htm
// 2) https://stackoverflow.com/questions/304268/getting-a-files-md5-checksum-in-java
// 3) https://www.geeksforgeeks.org/md5-hash-in-java/
// 4) https://www.javatpoint.com/java-jfilechooser
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class MD5 {

    public static String getMD5(String str) {
	try {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    byte[] msg = md.digest(str.getBytes());
	    BigInteger no = new BigInteger(1, msg);

	    String hashtext = no.toString(16);
	    while (hashtext.length()<32) {
		hashtext = "0"+hashtext;
	    }

	    return hashtext;
	}
	catch (NoSuchAlgorithmException e) {
	    return "";
	}
    }

    public static String[][] getResults(File fl) {
	ArrayList<String[]> results = new ArrayList<String[]>();
	FileReader in = null;
	try {
	    in = new FileReader(fl);
	    try {
		BufferedReader br = new BufferedReader(in);
		String line;
		while(true) {
		    try {
			line = br.readLine();
			if (line != null) {
			    String[] arr = line.split("\t-\t");
			    arr[0] = arr[0].strip();
			    arr[1] = arr[1].strip();
			    if (getMD5(arr[0]).equals(arr[1])) arr[1] = "verified";
			    else arr[1] = "not verified";
			    results.add(arr);
			}
			else break;
		    }
		    catch (IOException ex){
			break;
		    }
		}
		br.close();
	    }
		catch (IOException ex) {
		}
	}
	catch (FileNotFoundException ex) {
	    System.out.println("File not found!");
	}
	String[][] res = new String[results.size()][2];
	return results.toArray(res);
    }

	public static void main(String[] args) {
	    File fl = new File("MD5sums");
	    String[][] results = MD5.getResults(fl);
	    for (String[] row : results)
		System.out.println(row[1]);
	}
}
   
