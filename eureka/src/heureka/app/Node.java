package heureka.app;

public class Node {

	public State state;
	public Node parent;
	public Action action;
	public Double pathCost;
	public Double heuristicCost;
	public Double totalCost;
	
	public Node(){}
	
	public Node(State state, Node parent, Action action, Double pathCost){
		this.state = state;
		this.parent = parent;
		this.action = action;
		this.pathCost = pathCost;
	}
	
	public void childNode(ClauseProblem problem, Node parent, Action action){
		this.state = problem.result(parent.state, action);
		this.parent = parent;
		this.action = action;
		this.pathCost = parent.pathCost + problem.stepCost(parent.state, action);
		//this.heuristicCost = problem.heuristicFunction(this.state);
		//this.totalCost = this.pathCost + this.heuristicCost;
	}
	
	public Double costFunction(){
		return this.pathCost + this.heuristicCost;
	}

}
