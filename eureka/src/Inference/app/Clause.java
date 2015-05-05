package Inference.app;

import java.util.ArrayList;
import java.util.List;

public class Clause {
	public int ID;
	public String state;
	public String[] positive;
	public String[]	negative;
	public Clause parent;
	public List<Integer> IDs = new ArrayList<Integer>();
	public double gScore;
	public double hScore;
	
	public Clause(){}
	
	public Clause(String[] positive, String[] negative, int id){
		this.positive = positive;
		this.negative = negative;
		this.ID = id;
		this.state = this.toString();
		this.gScore = 0;
		this.hScore = positive.length + negative.length;
	}
	
	public void childClause(Clause parent){
		this.parent = parent;
		this.IDs.addAll(parent.IDs);
		if(true){
			this.IDs.add(ID);
		}
		this.gScore = parent.gScore + 1;
		this.state = this.toString();
	}
	
	public String toString(){
		String s = "";
		if(positive.length>0) {
			for(String L : positive){
				s+=L +" ";
			}
		} if(negative.length>0){
			s+="<";
			for(String L : positive){
				s+=L +" ";
			}
			return s;
		}
		return s;
	}

	public double getfScore() {
		return gScore + hScore;
	}

}
