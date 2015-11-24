//Team_SKT_Concentration -- Leo Au-Yeung, Sungbin Kim
//APCS1 pd10
//HW36 -- Some Folks Call It a Memory
//2015-11-23

import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

public class Concentration {
	
    //instance variables
    private Tile[][] _board = new Tile[4][4];     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private static final String[] WORDS = { // the immutable list of words
	"marin", "bengi", "faker", "easyhoon",
	"scout", "bang", "wolf", "kkoma"
    };  
    private String[] _words;     //list of unique Strings used for Tile vals
    private static int _numRows = 4;
	
	
    //insert constructor and methods here
    public Concentration() {

	// allocate memory for _words based on the size of WORDS
	_words = new String[WORDS.length * 2];

	// Copy elements of WORDS, each with frequency of two
	int c = 0; // counter for indexes of WORDS
	for( int i = 0; i < (WORDS.length * 2); i += 2 ) {
	    _words[i] = WORDS[c];
	    _words[i + 1] = WORDS[c];
	    c++;
	}

	// Copy elements of _words into _board
	c = 0; // consecutive integer to count _words indexes
	for( Tile[] t: _board ) {
	    for( int i = 0; i < t.length; i++ ) {
		t[i] = new Tile( _words[c] );
		c++;
	    }
	}

	// shuffles the elements inside board
	shuffle( _board );
	
	_numberFaceUp = 0;
			
    }
    	
    //scrambling function -- still needs to be changed 
    public void shuffle( Tile[][] t ) {
	for (Tile[] s : t) {
	    for (Tile x : s) {
		swap( x, t [(int)(Math.random() * t.length)] [(int)(Math.random() * t[0].length)]);
	    }
	}
    }
    private void swap( Tile i, Tile j ) {
	String temp1 = i.getFace();
	String temp2 = j.getFace();
	i.setFace( temp2 );
	j.setFace( temp1 );
    }

    public static void printA( Tile[][] a ) { 
	String s = "==========ARRAY==========\n";
	int c = 0;
	for( Tile[] t: a ) {
	    s += "Row " + c + ": [";	    
	    for( Tile j: t ) {
		s += j.getFace() + ","; 		
	    }
	    s = s.substring(0,s.length() - 1) + "]\n"; //cuts off the trailing comma	    
	    c += 1;
	}
	System.out.println(s);	
    }
	
    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	//game.play();
	printA( game._board );
    
    }
	
}//end class Concentration

