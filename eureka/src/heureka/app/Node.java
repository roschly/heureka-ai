package heureka.app;

public class Node {

	public State state;
	public Node parent;
	public Action action;
	public double gScore;
	public double hScore;
	
	public Node(){}
	
	public Node(State state, Node parent, Action action, double gScore){
		this.state = state;
		this.parent = parent;
		this.action = action;
		this.gScore = gScore;
	}
	
	public void childNode(Problem problem, Node parent, Action action){
		this.state = problem.result(parent.state, action);
		this.parent = parent;
		this.action = action;
		this.gScore = parent.gScore + problem.stepCost(parent.state, action);
		this.hScore = RouteProblem.StraightLineD(this.state, RouteProblem.getGoalState());
	}

	public int getfScore() {
		// TODO Auto-generated method stub
		return gScore + hScore;
	}

}
