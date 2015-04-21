package heureka.app;

import java.util.ArrayList;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;


public class RouteProblem extends Problem {

	private SimpleDirectedWeightedGraph<String, DefaultEdge> dwg = 
			new SimpleDirectedWeightedGraph<String, DefaultEdge>(DefaultEdge.class);

	
	public RouteProblem(){
		dwg.addVertex("a");
		dwg.addVertex("b");
		dwg.addVertex("c");
		dwg.addEdge("a", "b");
		
		DefaultEdge e = dwg.addEdge("");
		
		dwg.setEdgeWeight(e, 1);
		
	}
	
	public Boolean goalTest(State s){
		return false;
	}
	
	public ArrayList<Action> actions(State state){
		return new ArrayList<Action>();
	}
	
	public int stepCost(State state, Action action){
		
		
		
		return 0;
	}
	
	public State result(State state, Action action){
		return new State();
	}
}
