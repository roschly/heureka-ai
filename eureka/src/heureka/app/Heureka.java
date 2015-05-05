package heureka.app;

public class Heureka {
	
	public static void main(String args[]){
		
		ClauseProblem problem = new ClauseProblem();
		Solution s = Algorithms.uniformCostSearch(problem);
		System.out.println(s.exists);
		
		
	}
}
