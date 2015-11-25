//Team Alpacas -- Leo Au-Yeung, (old buddy) Sungbin Kim, Yanlin Ma
//APCS1 pd10
//HW36 (Revised) -- Some Folks Call It a Memory
//2015-11-24

import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

public class Concentration {
	
    //instance variables
    private Tile[][] _board = new Tile[4][4];     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private static final String[] WORDS = { // the immutable list of words
		"marin", "bengi", "faker", "easy",
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
	
    //scrambling function
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
	
	//prints out a temporary board to show user how coordinates are labeled
	public void boardnums() {
        int[][] temp = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("\nWelcome to Team Alpacas' game of Concentration!\n");
		System.out.println("The following board shows you how the tiles in the game are numbered: \n");
        String s = "==========TILE NUMBERS==========\n";
        System.out.print(s);
        for (int r=0; r<temp.length; r++){
            for (int c=0; c<temp[r].length; c++){
                System.out.print(temp[r][c]+"\t");
			}
            System.out.println();
		}
        System.out.println();
		System.out.println("To win the game, match every card with its identical match!\n");
		System.out.println("Good luck, and have fun!\n");
	}
	
	//prints out board
    public static void print ( Tile[][] a ) {
        String s = "==========BOARD==========\n";
        System.out.print(s);
        for (int r=0; r<a.length; r++){
            for (int c=0; c<a[r].length; c++){
                System.out.print(a[r][c]+"\t");
			}
            System.out.println();
		}
        System.out.println();
	}
	
	//prompts for tile1
	public int prompt1() {
		int tile;
		System.out.print("Input valid first tile to flip over (1-16): ");
		tile = Keyboard.readInt();
		return tile;
	}
	
	//prompts for tile2
	public int prompt2() {
		int tile;
		System.out.print("Input valid second tile to flip over (1-16): ");
		tile = Keyboard.readInt();
		return tile;
	}
	
	//plays the game!
	public void play() {
		boardnums();
		//checks to see if all cards are face up
		while (_numberFaceUp != 16) {
			int tile1 = -1;
			int tile2 = -1;
			int tile1r = -1;
			int tile1c = -1;
			int tile2r = -1;
			int tile2c = -1;
			
			//Prompts user for inputs
			while (tile1 == tile2 || tile1 <= 0 || tile2 <= 0 || _board[tile1r][tile1c].isFaceUp() || _board[tile2r][tile2c].isFaceUp()) {
				tile1 = prompt1();
				tile2 = prompt2();
				
				//Changes integers into tile coordinates
				tile1r = (tile1 - 1) / 4;
				tile1c = (tile1 - 1) % 4;
				tile2r = (tile2 - 1) / 4;
				tile2c = (tile2 - 1) % 4;
				
				try {
					if (tile1 == tile2) {
						System.out.println("\nYou cannot pick the same tile! Try again.");
					}
					if (_board[tile1r][tile1c].isFaceUp()) {
						System.out.println("\nFirst tile is already face up! Try again.");
					}
					if (_board[tile2r][tile2c].isFaceUp()) {
						System.out.println("\nSecond tile is already face up! Try again.");
					}
				}
				catch (Exception e) {
					System.out.println("\nInvalid input (Input is not an integer between 1 and 16), please try again.");
				}
				System.out.println();
			}
			
			//Flips over the two tiles
			_board[tile1r][tile1c].flip();
			_board[tile2r][tile2c].flip();
			print(_board);
			
			//Checks if they are the same
			if (_board[tile1r][tile1c].equals(_board[tile2r][tile2c]) ) {
				_numberFaceUp += 2;
			}
			else {
			    _board[tile1r][tile1c].flip();
			    _board[tile2r][tile2c].flip();
			}
		}
		System.out.println("Congratulations, you won!\n");
		System.out.println("Game functionality provided by Team Alpacas: ");
		System.out.println("Leo Au-Yeung & Sungbin Kim & Yanlin Ma\n");
	}
	
	//DO NOT MODIFY main()
	public static void main(String[] args){
		Concentration game = new Concentration();
		game.play();
	}
	
}//end class Concentration
