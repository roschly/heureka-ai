package heureka.app;

public class Road {
	
	public String name;
	public Coord firstCoord, secondCoord;
	
	public Road(int a, int b, String roadName, int x, int y){
		this.name = roadName;
		this.firstCoord = new Coord(a, b);
		this.secondCoord = new Coord(x, y);
	}	

	public Coord[] getCoords(){
		return new Coord[]{this.firstCoord, secondCoord};
	}
}

