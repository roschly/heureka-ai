package heureka.app;



public class Heureka {
	
	public static void main(String args[]){
		
		ClauseProblem problem = new ClauseProblem();
		Solution s = Algorithms.aStarSearch(problem);
		
		if (s.exists){
			System.out.println("Solution found!");
			s.printSolution();
		}
		else {
			System.out.println("No solution");
		}
	}
}
