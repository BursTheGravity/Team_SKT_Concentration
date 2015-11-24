//Team_SKT_Concentration -- Leo Au-Yeung, Sungbin Kim
//APCS1 pd10
//HW36 -- Some Folks Call It a Memory
//2015-11-23

import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

public class Concentration {
	
	//instance variables
	private Tile[][] _board;     //storage for 4x4 grid of Tiles.
	private int _numberFaceUp;   //count of Tiles with faces visible
	private String[] _words;     //list of unique Strings used for Tile vals
	private static int _numRows = 4;
	
	
	//insert constructor and methods here
	public Concentration() {
		_words = {"marin","bengi","faker","easyhoon","scout","bang","wolf","kkoma"};
		_board = //???;
		_numberFaceUp = 0;
			
		}
	}
	
	//scrambling function -- still needs to be changed 
	public void shuffle( Tile[][] t ) {
		for (String[] s : t) {
			for (String x : s) {
				swap( x , t [(int)(Math.random() * t.length] [(int)(Math.random() * t[0].length)]));
			}
		}
	}
	private void swap( int i, int j ) {
		String temp1 = _words[i];
		String temp2 = _words[j];
		_words[i] = temp2;
		_words[j] = temp1;
	}
	
	
	//DO NOT MODIFY main()
	public static void main(String[] args){
		Concentration game = new Concentration();
		game.play();
	}
	
}//end class Concentration

