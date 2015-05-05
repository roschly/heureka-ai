package heureka.app;

public class Heureka {
	
	public static void main(String args[]){
		
		RouteProblem problem = new RouteProblem();
		Solution s = Algorithms.aStarSearch(problem);
		System.out.println(s.exists);
		
		
	}
}
