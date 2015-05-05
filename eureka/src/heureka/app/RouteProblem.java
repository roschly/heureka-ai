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
	public HashMap<String, String> roadNames = new HashMap<String, String>();
	
	public RouteProblem(String initialState, String goalState){
		
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
		
		/*
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
		*/
		
		// Project data
		this.setInitialState( initialState );
		this.setGoalState( goalState );
		
		this.roadNames.put("AB", "Vestervoldgade");
		this.roadNames.put("BD", "Vestervoldgade");
		this.roadNames.put("DB", "Vestervoldgade");
		this.roadNames.put("BA", "Vestervoldgade");
		this.roadNames.put("AE", "SktPedersStraede");
		this.roadNames.put("EH", "SktPedersStraede");
		this.roadNames.put("KH", "SktPedersStraede");
		this.roadNames.put("BG", "Studiestraede");
		this.roadNames.put("MG", "Studiestraede");
		this.roadNames.put("DI", "Vestergade");
		this.roadNames.put("IN", "Vestergade");
		this.roadNames.put("JL", "Noerregade");
		this.roadNames.put("LK", "Noerregade");
		this.roadNames.put("KM", "Noerregade");
		this.roadNames.put("MN", "Noerregade");
		this.roadNames.put("GI", "Larsbjoernsstraede");
		this.roadNames.put("GE", "Larsbjoernsstraede");
		this.roadNames.put("CE", "TeglgaardsStraede");
		this.roadNames.put("HF", "LarslejStraede");
		this.roadNames.put("AC", "Noerrevoldgade");
		this.roadNames.put("CF", "Noerrevoldgade");
		this.roadNames.put("FJ", "Noerrevoldgade");
		this.roadNames.put("JF", "Noerrevoldgade");
		this.roadNames.put("FC", "Noerrevoldgade");
		this.roadNames.put("CA", "Noerrevoldgade");
		
		
		
		

		this.coords.put("A", new Coord(10, 70));
		this.coords.put("B", new Coord(20, 50));
		this.coords.put("C", new Coord(25, 100));
		this.coords.put("D", new Coord(35, 35));
		this.coords.put("E", new Coord(35, 80));
		this.coords.put("F", new Coord(35, 120));
		this.coords.put("G", new Coord(45, 70));
		this.coords.put("H", new Coord(50, 90));
		this.coords.put("I", new Coord(55, 55));
		this.coords.put("J", new Coord(60, 150));
		this.coords.put("K", new Coord(65, 100));
		this.coords.put("L", new Coord(65, 110));
		this.coords.put("M", new Coord(70, 85));
		this.coords.put("N", new Coord(80, 70));
		
		dwg.addVertex("A");
		dwg.addVertex("B");
		dwg.addVertex("C");
		dwg.addVertex("D");
		dwg.addVertex("E");
		dwg.addVertex("F");
		dwg.addVertex("G");
		dwg.addVertex("H");
		dwg.addVertex("I");
		dwg.addVertex("J");
		dwg.addVertex("K");
		dwg.addVertex("L");
		dwg.addVertex("M");
		dwg.addVertex("N");
		
		DefaultWeightedEdge AB = dwg.addEdge("A", "B");
		DefaultWeightedEdge BD = dwg.addEdge("B", "D");
		DefaultWeightedEdge DB = dwg.addEdge("D", "B");
		DefaultWeightedEdge BA = dwg.addEdge("B", "A");
		DefaultWeightedEdge AE = dwg.addEdge("A", "E");
		
		DefaultWeightedEdge EH = dwg.addEdge("E", "H");
		DefaultWeightedEdge KH = dwg.addEdge("K", "H");
		DefaultWeightedEdge BG = dwg.addEdge("B", "G");
		DefaultWeightedEdge MG = dwg.addEdge("M", "G");
		DefaultWeightedEdge DI = dwg.addEdge("D", "I");
		
		DefaultWeightedEdge IN = dwg.addEdge("I", "N");
		DefaultWeightedEdge JL = dwg.addEdge("J", "L");
		DefaultWeightedEdge LK = dwg.addEdge("L", "K");
		DefaultWeightedEdge KM = dwg.addEdge("K", "M");
		DefaultWeightedEdge MN = dwg.addEdge("M", "N");
		
		DefaultWeightedEdge GI = dwg.addEdge("G", "I");
		DefaultWeightedEdge GE = dwg.addEdge("G", "E");
		DefaultWeightedEdge CE = dwg.addEdge("C", "E");
		DefaultWeightedEdge HF = dwg.addEdge("H", "F");
		DefaultWeightedEdge AC = dwg.addEdge("A", "C");
		
		DefaultWeightedEdge CF = dwg.addEdge("C", "F");
		DefaultWeightedEdge FJ = dwg.addEdge("F", "J");
		DefaultWeightedEdge JF = dwg.addEdge("J", "F");
		DefaultWeightedEdge FC = dwg.addEdge("F", "C");
		DefaultWeightedEdge CA = dwg.addEdge("C", "A");
		
		
		dwg.setEdgeWeight(AB, this.straightLineDistance( this.coords.get("A"), this.coords.get("B") ));
		dwg.setEdgeWeight(BD, this.straightLineDistance( this.coords.get("B"), this.coords.get("D") ));
		dwg.setEdgeWeight(DB, this.straightLineDistance( this.coords.get("D"), this.coords.get("B") ));
		dwg.setEdgeWeight(BA, this.straightLineDistance( this.coords.get("B"), this.coords.get("A") ));
		dwg.setEdgeWeight(AE, this.straightLineDistance( this.coords.get("A"), this.coords.get("E") ));

		dwg.setEdgeWeight(EH, this.straightLineDistance( this.coords.get("E"), this.coords.get("H") ));
		dwg.setEdgeWeight(KH, this.straightLineDistance( this.coords.get("K"), this.coords.get("H") ));
		dwg.setEdgeWeight(BG, this.straightLineDistance( this.coords.get("B"), this.coords.get("G") ));
		dwg.setEdgeWeight(MG, this.straightLineDistance( this.coords.get("M"), this.coords.get("G") ));
		dwg.setEdgeWeight(DI, this.straightLineDistance( this.coords.get("D"), this.coords.get("I") ));

		dwg.setEdgeWeight(IN, this.straightLineDistance( this.coords.get("I"), this.coords.get("N") ));
		dwg.setEdgeWeight(JL, this.straightLineDistance( this.coords.get("J"), this.coords.get("L") ));
		dwg.setEdgeWeight(LK, this.straightLineDistance( this.coords.get("L"), this.coords.get("K") ));
		dwg.setEdgeWeight(KM, this.straightLineDistance( this.coords.get("K"), this.coords.get("M") ));
		dwg.setEdgeWeight(MN, this.straightLineDistance( this.coords.get("M"), this.coords.get("N") ));

		dwg.setEdgeWeight(GI, this.straightLineDistance( this.coords.get("G"), this.coords.get("I") ));
		dwg.setEdgeWeight(GE, this.straightLineDistance( this.coords.get("G"), this.coords.get("E") ));
		dwg.setEdgeWeight(CE, this.straightLineDistance( this.coords.get("C"), this.coords.get("E") ));
		dwg.setEdgeWeight(HF, this.straightLineDistance( this.coords.get("H"), this.coords.get("F") ));
		dwg.setEdgeWeight(AC, this.straightLineDistance( this.coords.get("A"), this.coords.get("C") ));

		dwg.setEdgeWeight(CF, this.straightLineDistance( this.coords.get("C"), this.coords.get("F") ));
		dwg.setEdgeWeight(FJ, this.straightLineDistance( this.coords.get("F"), this.coords.get("J") ));
		dwg.setEdgeWeight(JF, this.straightLineDistance( this.coords.get("J"), this.coords.get("F") ));
		dwg.setEdgeWeight(FC, this.straightLineDistance( this.coords.get("F"), this.coords.get("C") ));
		dwg.setEdgeWeight(CA, this.straightLineDistance( this.coords.get("C"), this.coords.get("A") ));


				
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
		Coord stateCoord = this.coords.get(state);
		Coord goalCoord = this.coords.get(this.goalState);
		
		return this.straightLineDistance(stateCoord, goalCoord);
	}
	
	public Double straightLineDistance(Coord c1, Coord c2){
		return Math.sqrt( Math.pow( (c1.x - c2.x), 2) + Math.pow( (c1.y - c2.y), 2) );
	}
	
}
