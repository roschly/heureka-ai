package heureka.inference.app;

public class InferenceDriver {
	public static void main(String[] args) {
		InferenceProblem IProblem = new InferenceProblem();
		
		Solution s = Astar.AStar(IProblem);
		
		System.out.println(s.toString());
	}

}
