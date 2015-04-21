package heureka.app;

import java.util.HashSet;
import java.util.Set;

public class Astar {
	
	public static Solution AStar(Problem problem){
		Node node = new Node();
		node.state = problem.initialState;
		node.gScore = 0;
		NodePriorityQueue<Node> frontier = new NodePriorityQueue<Node>();
		frontier.add(node);
		Set<State> explored = new HashSet<State>();
				
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
					if ( !explored.contains(child.state) && !frontier.containsState(child.state) ){
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
