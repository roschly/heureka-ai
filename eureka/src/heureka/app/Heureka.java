package heureka.app;

import java.util.*;

import org.jgrapht.*;
import org.jgrapht.graph.*;
/*
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
*/

public class Heureka {
	
	public static void main(String args[]){
		
		DirectedGraph<String, DefaultEdge> directedGraph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		SimpleDirectedWeightedGraph<String, DefaultEdge> directedWGraph = new SimpleDirectedWeightedGraph<String, DefaultEdge>(DefaultEdge.class);
		
		directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");
        directedGraph.addVertex("d");
        directedGraph.addVertex("e");
        directedGraph.addVertex("f");
        directedGraph.addVertex("g");
        directedGraph.addVertex("h");
        directedGraph.addVertex("i");
        directedGraph.addEdge("a", "b");
        directedGraph.addEdge("b", "d");
        directedGraph.addEdge("d", "c");
        directedGraph.addEdge("c", "a");
        directedGraph.addEdge("e", "d");
        directedGraph.addEdge("e", "f");
        directedGraph.addEdge("f", "g");
        directedGraph.addEdge("g", "e");
        directedGraph.addEdge("h", "e");
        directedGraph.addEdge("i", "h");
		
		
		// Hardcoded data
		List<Road> data = new ArrayList<Road>();
		List<Coord> uniqueCoords = new ArrayList<Coord>();
		
		// city map
		data.add( new Road(10, 70, "Vestervoldgade", 20, 50) );
		data.add( new Road(20, 50, "Vestervoldgade", 35, 35) );
		data.add( new Road(35, 35, "Vestervoldgade", 20, 50) );
		data.add( new Road(20, 50, "Vestervoldgade", 10, 70) );

		// initial and goal nodes
		Coord initial, goal;
		
		
		// convert city map data to graph AND table of road names with coordinate
		
		uniqueCoords = findUniqueCoords(data);
		//System.out.println(uniqueCoords.get(4).toString());
		
		
		
		PriorityQueue<Integer> frontier = new PriorityQueue<Integer>();
		//Node node = new Node();
		
		
		
		frontier.add(5);
		
		
		frontier.add(2);
		frontier.add(20);
		frontier.add(4);
		frontier.add(1);
		frontier.add(3);
		
		
		//System.out.print(frontier.peek() + " ");
		//frontier.forEach( (n) -> System.out.print(n + " ") );
		//frontier.forEach( (n) -> { if(n == 5){ n = 21; System.out.print(n + " "); }  } );
		//System.out.print(frontier.peek());
		//System.out.println(frontier.size());
		
		System.out.println(frontier.peek());
		
		for ( Iterator<Integer> iterator = frontier.iterator(); iterator.hasNext(); ){
			
			Integer bla = iterator.next();
			
			if (bla == 2){
				iterator.remove();
			}
			
		}
		
		System.out.println(frontier.peek());
		
	
				
	}
	

	
	
	// find unique coords
	// Input: List of roads. Return: List of unique coords
	public static List<Coord> findUniqueCoords(List<Road> roads){
		
		List<Coord> coords = new ArrayList<Coord>();
		
		for (Road road : roads){
			coords.add(road.firstCoord);
			coords.add(road.secondCoord);
		}
		
		HashSet<Coord> set = new HashSet<>(coords);
		ArrayList<Coord> uniqueCoords = new ArrayList<>(set);
		
		System.out.println(uniqueCoords.size());
		
		return uniqueCoords;
	}
	
	public static Solution uniformCostSearch(Problem problem){
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
