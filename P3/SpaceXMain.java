import java.io.*;
import java.util.*;

public class SpaceXMain {
    public static void main(String[] args) {
	int c, r;
	Scanner sc = new Scanner(System.in);
	c = sc.nextInt();
	r = sc.nextInt();
	int[][] roads = new int[r][3];
	int[] cities = new int[c];
	for (int i=0; i<r; i++) {
	    for (int j=0; j<3; j++) {
		roads[i][j] = sc.nextInt();
	    }
	}
	for (int i=0; i<c; i++) {
	    cities[i] = sc.nextInt();
	}
	ElectricityGrid eg = new ElectricityGrid(c, r, roads, cities);
	eg.setGridPlan();
	System.out.println(eg.getCost());
    }
}
