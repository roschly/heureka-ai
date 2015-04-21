package heureka.app;

public class Node {

	public State state;
	public Node parent;
	public Action action;
	public int pathCost;
	
	public Node(){}
	
	public Node(State state, Node parent, Action action, int pathCost){
		this.state = state;
		this.parent = parent;
		this.action = action;
		this.pathCost = pathCost;
	}
	
	public void childNode(Problem problem, Node parent, Action action){
		this.state = problem.result(parent.state, action);
		this.parent = parent;
		this.action = action;
		this.pathCost = parent.pathCost + problem.stepCost(parent.state, action);
	}

}
