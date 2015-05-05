package heureka.app;

public class Coord {
	public Double x;
	public Double y;
	
	public Coord(Double x, Double y){
		this.x = x;
		this.y = y;
	}
	
	public Coord(Integer x, Integer y){
		this.x = (double) x;
		this.y = (double) y;
	}
	

}
