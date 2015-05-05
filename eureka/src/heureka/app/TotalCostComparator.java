package heureka.app;

import java.util.Comparator;

public class TotalCostComparator implements Comparator<Node> {

	@Override
	public int compare(Node node1, Node node2){
		
		if (node1.totalCost < node2.totalCost){
			return -1;
		}
		else if (node1.totalCost > node2.totalCost){
			return 1;
		}
		else {
			return 0;
		}
		
	}
}
