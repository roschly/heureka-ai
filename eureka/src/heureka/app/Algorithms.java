package heureka.app;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Algorithms {
	
	public static Solution uniformCostSearch(ClauseProblem problem){
		
		Comparator<Node> comparator = new PathCostComparator();
		
		Node node = new Node();
		node.state = problem.initialState;
		node.pathCost = 0.0;
		NodePriorityQueue<Node> frontier = new NodePriorityQueue<Node>(10, comparator);
		frontier.add(node);
		Set<State> explored = new HashSet<State>();
				
		do {
			node = frontier.poll();
			if (problem.goalTest(node.state) == true ) {
				return new Solution(node);
			}
			else {
				explored.add(node.state);
				System.out.println(explored.toString());
				System.out.println("Explored: " + node.state.toString());
				// Actions
				for (Action action : problem.actions(node.state)){
					
					Node child = new Node();
					
					child.childNode(problem, node, action);
					System.out.println(explored.toString());
					
					//System.out.println("Her: " + explored.contains(child.state)  );
					if ( !explored.contains(child.state) && !frontier.containsState(child.state) ){
						System.out.println("HEY: ");
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
	
	public static Solution aStarSearch(ClauseProblem problem){
		
		Comparator<Node> comparator = new TotalCostComparator();
	
		Node node = new Node();
		node.state = problem.initialState;
		node.pathCost = 0.0;
		NodePriorityQueue<Node> frontier = new NodePriorityQueue<Node>(10, comparator);
		frontier.add(node);
		Set<String> explored = new HashSet<String>();
				
		do {
			node = frontier.poll();
			if (problem.goalTest(node.state) == true ) {
				return new Solution(node);
			}
			else {
				explored.add(node.state);
				System.out.println("Explored: " + node.state);
				// Actions
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
