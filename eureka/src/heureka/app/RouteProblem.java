package heureka.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;


public class RouteProblem extends Problem {

	private SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> dwg = 
			new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

	public String initialState;
	public String goalState;
	public HashMap<String, Coord> coords = new HashMap<String, Coord>();
	
	public RouteProblem(){
		
		/*
		// Test data without heuristic
		this.setInitialState("A");
		this.setGoalState("F");
		
		dwg.addVertex("A");
		dwg.addVertex("B");
		dwg.addVertex("C");
		dwg.addVertex("D");
		dwg.addVertex("E");
		dwg.addVertex("F");
		
		DefaultWeightedEdge AB = dwg.addEdge("A", "B");
		DefaultWeightedEdge AC = dwg.addEdge("A", "C");
		DefaultWeightedEdge BD = dwg.addEdge("B", "D");
		DefaultWeightedEdge CD = dwg.addEdge("C", "E");
		DefaultWeightedEdge DE = dwg.addEdge("D", "E");
		DefaultWeightedEdge EF = dwg.addEdge("E", "F");
		
		dwg.setEdgeWeight(AB, 1);
		dwg.setEdgeWeight(AC, 1);
		dwg.setEdgeWeight(BD, 3);
		dwg.setEdgeWeight(CD, 1);
		dwg.setEdgeWeight(DE, 1);
		dwg.setEdgeWeight(EF, 1);
		*/
		
		/*
		// 1: Test data with heuristic
		this.setInitialState("A");
		this.setGoalState("D");

		this.coords.put("A", new Coord(2.0, 2.0) );
		this.coords.put("B", new Coord(1.0, 3.0) );
		this.coords.put("C", new Coord(3.0, 1.0) );
		this.coords.put("D", new Coord(2.0, 5.0) );
		
		dwg.addVertex("A");
		dwg.addVertex("B");
		dwg.addVertex("C");
		dwg.addVertex("D");
		
		DefaultWeightedEdge AB = dwg.addEdge("A", "B");
		DefaultWeightedEdge AC = dwg.addEdge("A", "C");
		DefaultWeightedEdge BD = dwg.addEdge("B", "D");
		DefaultWeightedEdge CD = dwg.addEdge("C", "D");
		
		dwg.setEdgeWeight(AB, this.straightLineDistance( this.coords.get("A"), this.coords.get("B") ));
		dwg.setEdgeWeight(AC, this.straightLineDistance( this.coords.get("A"), this.coords.get("C") ));
		dwg.setEdgeWeight(BD, this.straightLineDistance( this.coords.get("B"), this.coords.get("D") ));
		dwg.setEdgeWeight(CD, this.straightLineDistance( this.coords.get("C"), this.coords.get("D") ));
		*/
		
		// 2: Test data with heuristic
		this.setInitialState("A");
		this.setGoalState("D");

		this.coords.put("A", new Coord(2.0, 2.0) );
		this.coords.put("B", new Coord(1.0, 3.0) );
		this.coords.put("C", new Coord(3.0, 1.0) );
		this.coords.put("D", new Coord(2.0, 5.0) );
		
		dwg.addVertex("A");
		dwg.addVertex("B");
		dwg.addVertex("C");
		dwg.addVertex("D");
		
		DefaultWeightedEdge AB = dwg.addEdge("A", "B");
		DefaultWeightedEdge AC = dwg.addEdge("A", "C");
		//DefaultWeightedEdge BD = dwg.addEdge("B", "D");
		DefaultWeightedEdge CD = dwg.addEdge("C", "D");
		
		dwg.setEdgeWeight(AB, this.straightLineDistance( this.coords.get("A"), this.coords.get("B") ));
		dwg.setEdgeWeight(AC, this.straightLineDistance( this.coords.get("A"), this.coords.get("C") ));
		//dwg.setEdgeWeight(BD, this.straightLineDistance( this.coords.get("B"), this.coords.get("D") ));
		dwg.setEdgeWeight(CD, this.straightLineDistance( this.coords.get("C"), this.coords.get("D") ));
				
	}
	
	public void setInitialState(String state){
		this.initialState = state;
	}
	
	public void setGoalState(String state){
		this.goalState = state;
	}
	
	public Boolean goalTest(String state){
		return goalState.equals(state);
	}
	
	public ArrayList<Action> actions(String state){
		
		ArrayList<Action> neighbors = new ArrayList<Action>();
		Set<DefaultWeightedEdge> outEdges = dwg.outgoingEdgesOf(state);
				
		for (DefaultWeightedEdge edge : outEdges){
			neighbors.add( new Action ("Go", dwg.getEdgeTarget(edge)) );
		}
		
		return neighbors;
	}
	
	public Double stepCost(String state, Action action){
		return dwg.getEdgeWeight( dwg.getEdge(state, action.result) );
	}
	
	public String result(String state, Action action){
		if (action.type.equals("Go")){
			return action.result;
		}
		return "";
	}
	
	public Double heuristicFunction(String state){
		// straight line distance
		// from state to goalState
		
		// get coords from hashmap
		Coord stateCoord = this.coords.get(state);
		Coord goalCoord = this.coords.get(this.goalState);
		
		return this.straightLineDistance(stateCoord, goalCoord);
	}
	
	// Straight Line Distance
	public Double straightLineDistance(Coord c1, Coord c2){
		return Math.sqrt( Math.pow( (c1.x - c2.x), 2) + Math.pow( (c1.y - c2.y), 2) );
	}
	
}
