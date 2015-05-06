package heureka.app;

import java.util.Comparator;

public class Heureka {
	
	public static void main(String args[]){
		
		ClauseProblem problem = new ClauseProblem();
		Solution s = Algorithms.aStarSearch(problem);
		System.out.println(s.exists);
		
		
	}
}
