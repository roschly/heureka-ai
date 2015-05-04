package heureka.app;

import java.util.ArrayList;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;


public class RouteProblem extends Problem {

	private SimpleDirectedWeightedGraph<String, DefaultEdge> dwg = 
			new SimpleDirectedWeightedGraph<String, DefaultEdge>(DefaultEdge.class);
	private String goalState;

	
	public RouteProblem(){
		dwg.addVertex("a");
		dwg.addVertex("b");
		dwg.addVertex("c");
		dwg.addEdge("a", "b");
		
	}
	public Boolean goalTest(String s){
		if(s.equals(getGoalState())) {
			return true;
		}
		else return false;
	}
	
	public ArrayList<Action> actions(String string){
		return new ArrayList<Action>();
	}
	
	public int stepCost(String string, Action action){
		
		
		
		return 0;
	}
	
	public String result(String string, Action action){
		return new String();
	}
	
	public String getGoalState() {
		return goalState;
	}
}
