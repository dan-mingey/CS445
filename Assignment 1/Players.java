//Daniel Mingey 
//djm189
//4108215
//Assignment 1
//CS 445 Sherif


public class Players {

	private int numPlayers;
	MultiDS<Card> faceUp;
	MultiDS<Card> faceDown;
	int snapGuess, match;
	int count=0;
	
	
	//constructor
	public Players(int n)
	{
		numPlayers = n;
	}
	
	
	public Players()
	{
		//face up and facedown decks for each players
		faceUp = new MultiDS<>(52);
		faceDown= new MultiDS<>(52);
		
		//snapGuess: 1 for no guess, 2 for correct guess, 3 for incorrect guess
		snapGuess = 1;
		
		//match: 0 if the player doesnt have a match that round, 1 if they do have a match, 2 if they won the round
		match=0;
	}
	
	
}