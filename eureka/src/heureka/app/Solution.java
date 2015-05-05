package heureka.app;


import java.util.ArrayList;

public class Solution {
	
	public Boolean exists;
	public ArrayList<String> trace = new ArrayList<String>();

	public Solution(){
		this.exists = false; 
	}
	
	public Solution(Node node) {
		this.exists = true;
		
		Node currentNode = node;
		
		while (currentNode != null){
			this.trace.add(currentNode.state);
			currentNode = currentNode.parent;
		}
	}
	
	public ArrayList<String> getEdgeTrace(){
		ArrayList<String> edges = new ArrayList<String>();
		
		String nrVertices = "";
		
		for (int i = this.trace.size() - 1; i >= 0; i--){
			
			nrVertices += this.trace.get(i);
			if (nrVertices.length() == 2){
				edges.add(nrVertices);
				nrVertices = this.trace.get(i);
			}
		}
		
		return edges;
	}
	
	public ArrayList<String> getPath(){
		ArrayList<String> path = new ArrayList<String>();	
		for (int i = this.trace.size() - 1; i >= 0; i--){
			path.add( this.trace.get(i) );
		}
		
		return path;
	}

}
