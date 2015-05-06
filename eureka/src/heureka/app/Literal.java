package heureka.app;

public class Literal {
	public String letter;
	public Integer sign;
	
	public Literal(String strLit){
		if ( strLit.startsWith("-") ){
			this.letter = strLit.substring(1);
			this.sign = -1;
		}
		else {
			this.letter = strLit;
			this.sign = 1;
		}
	}
	
	public Boolean negates(Literal lit){
		if (this.letter.equals(lit.letter) && this.sign != lit.sign){
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean customEquals(Literal lit){
		if (this.letter.equals( lit.letter ) && this.sign == lit.sign){
			return true;
		}
		else {
			return false;
		}
	}
}
