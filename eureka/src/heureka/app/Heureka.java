package heureka.app;

public class Heureka {
	
	public static void main(String args[]){
		
		
		RouteProblem problem = new RouteProblem("E", "L");
		Solution s = Algorithms.aStarSearch(problem);
		
		if (s.exists){
			System.out.println("Solution found!");
			System.out.println("Path:");
			//printPathVertices(s);
			printPathRoadNames(s, problem);
			
		}
		else {
			System.out.println("No solution");
		}
		
		
		
		
	}
	
	public static void printPathRoadNames(Solution solution, RouteProblem problem){
		for (String edge : solution.getEdgeTrace()){
			String roadName = problem.roadNames.get(edge);
			System.out.println(roadName);
		}
	}
	
	public static void printPathVertices(Solution solution){
		for (String vertex : solution.getPath()){
			System.out.print(vertex + " ");
		}
	}
}
