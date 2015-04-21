package heureka.app;

public class Coord {

	public int x, y;
	
	public Coord(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Boolean equals(Coord a){
		if (this.x == a.x && this.y == a.y){
			return true;
		}
		
		return false;
	}
	
	public String toString(){
		return "(X,Y): " + "(" + this.x + "," + this.y + ")";
	}
	
}
