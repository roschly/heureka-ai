package heureka.inference.app;

import java.util.HashSet;
import java.util.Set;

public class Astar {
	
	public static Solution AStar(Problem problem){
		Clause clause = new Clause();
		clause.state = problem.initialState;
		clause.gScore = 0;
		NodePriorityQueue<Clause> frontier = new NodePriorityQueue<Clause>();
		frontier.add(clause);
		Set<String> explored = new HashSet<String>();
				
		do {
			clause = frontier.poll();
			if (problem.goalTest(clause.state) == true ) {
				return new Solution(clause);
			}
			else {
				explored.add(clause.state);
				for (Action action : problem.actions(clause.state)){
					Clause child = new Clause();
					child.childClause(clause);
					if (!explored.contains(child.state) && !frontier.containsState(child.state) ){
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
