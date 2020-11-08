import java.util.*;

public class ElectricityGrid {
    private int noOfCities;
    private int noOfRoads;
    private int cost;
    private int[] powerPlantCities;
    private int[][] gridNetwork;
    private int[] minCostNode;
    private int[][] roadCost;
    private int[] cityCost;
    

    ElectricityGrid() {
	noOfCities = 0;
	noOfRoads = 0;
	cost = 0;
	powerPlantCities = null;
	gridNetwork = null;
    }

    ElectricityGrid(int cities, int roads, int[][] wireCost, int[] powerPlantCost) {
	minCostNode = new int[cities];
	for (int i=0; i<cities; i++) minCostNode[i] = i;
	Arrays.sort(wireCost, new Comparator<int[]>() {
		public int compare(final int[] arr1, final int[] arr2) {
		    return arr1[2] - arr2[2];
		}
	});
	noOfCities = cities;
	noOfRoads = roads;
	roadCost = wireCost;
	cityCost = powerPlantCost;
    }

    public void setGridPlan() {
	ArrayList<int[]> gridn = new ArrayList<int[]>();
	for (int[] edge : roadCost) {
	    int u = edge[0]-1, v = edge[1]-1;
	    while (u != minCostNode[u])
		u = minCostNode[u];
	    while (v != minCostNode[v])
		v = minCostNode[v];
	    if (u == v)
		continue;
	    if (cityCost[v]>=cityCost[u] && cityCost[v]>edge[2]) {
		int[] m = {edge[0], edge[1]};
		gridn.add(m);
		int a = edge[1]-1, temp;
		while (true) {
		    temp = minCostNode[a];
		    minCostNode[a] = u;
		    a = temp;
		    if (a==v) break;
		}
		cost+=edge[2];
	    }
            else if (cityCost[u]>cityCost[v] && cityCost[u]>edge[2]) {
		int[] m = {edge[0], edge[1]};
		gridn.add(m);
		int a = edge[0]-1, temp;
		while (true) {
		    temp = minCostNode[a];
		    minCostNode[a] = v;
		    a = temp;
		    if (a==u) break;
		}
		cost+=edge[2];
	    }
	}
	ArrayList<Integer> powerp = new ArrayList<Integer>();
	for (int i=0; i<noOfCities; i++) {
	    if (minCostNode[i]==i) {
		powerp.add(i+1);
		cost+=cityCost[i];
	    }
	}
	gridNetwork = new int[gridn.size()][2];
	gridNetwork = gridn.toArray(gridNetwork);
	powerPlantCities = new int[powerp.size()];
	int ind = 0;
	for (int city : powerp) {
		powerPlantCities[ind] = city;
		ind++;
	}
    }

    public int[][] getGridNetwork() {
	int[][] network = new int[gridNetwork.length][2];
	for (int i = 0; i < gridNetwork.length; i++) {
	    for (int j = 0; j < 2; j++)
		network[i][j] = gridNetwork[i][j];
	}
	return network;
    }
    
    public int[] getPowerPlantCities() {
	int[] cities = powerPlantCities.clone();
	return cities;
    }
    
    public int getCost() {
	return cost;
    }
    
    public int getNoOfCities() {
	return noOfCities;
    }
    
    public int getNoOfRoads() {
	return noOfRoads;
    }

}
