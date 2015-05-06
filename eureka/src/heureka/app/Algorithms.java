package heureka.app;

import java.util.Comparator;

public class Algorithms {
	
	public static Solution aStarSearch(ClauseProblem problem){
		
		//Comparator<Node> comparator = new PathCostComparator(); // uniform-cost-search
		Comparator<Node> comparator = new TotalCostComparator();
		
		Node node = new Node();
		node.state = problem.initialState;
		node.pathCost = 0.0;
		NodePriorityQueue<Node> frontier = new NodePriorityQueue<Node>(10, comparator);
		frontier.add(node);
		StateSet<State> explored = new StateSet<State>();
				
		do {
			node = frontier.poll();
			if (problem.goalTest(node.state) == true ) {
				return new Solution(node);
			}
			else {
				explored.add(node.state);
				
				for (Action action : problem.actions(node.state)){
					
					Node child = new Node();
					child.childNode(problem, node, action);
					
					if ( !explored.containsState(child.state) && !frontier.containsState(child.state) ){
						frontier.add(child);
					}
					else {
						frontier.replaceForHigherPathCost(child);
					}
				}
			}
		} while ( frontier.isEmpty() == false );
		
		return new Solution();
	}	
}
