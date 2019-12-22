//Daniel Mingey 
//djm189
//4108215
//Assignment 1
//CS 445 Sherif

public class Snap
{
	
	public static void main(String[] args)
	{
		int nPlayers = 0;
		int nRounds = 0;
		
		//creating deck and snapPool as multiDS card objects
		MultiDS<Card> deck = new MultiDS<Card>(52);
		MultiDS<Card> snapPool = new MultiDS<Card>(52);

		Card card_1 = new Card(Card.Suits.Diamonds, Card.Ranks.Two);
		Card card_2 = new Card(Card.Suits.Hearts, Card.Ranks.Two);
		Card card_3 = new Card(Card.Suits.Clubs, Card.Ranks.Two);
		Card card_4 = new Card(Card.Suits.Spades, Card.Ranks.Two);
		Card card_5 = new Card(Card.Suits.Diamonds, Card.Ranks.Three);
		Card card_6 = new Card(Card.Suits.Hearts, Card.Ranks.Three);
		Card card_7 = new Card(Card.Suits.Clubs, Card.Ranks.Three);
		Card card_8 = new Card(Card.Suits.Spades, Card.Ranks.Three);
		Card card_9 = new Card(Card.Suits.Diamonds, Card.Ranks.Four);
		Card card_10 = new Card(Card.Suits.Hearts, Card.Ranks.Four);
		Card card_11 = new Card(Card.Suits.Clubs, Card.Ranks.Four);
		Card card_12 = new Card(Card.Suits.Spades, Card.Ranks.Four);
		Card card_13 = new Card(Card.Suits.Diamonds, Card.Ranks.Five);
		Card card_14 = new Card(Card.Suits.Hearts, Card.Ranks.Five);
		Card card_15 = new Card(Card.Suits.Clubs, Card.Ranks.Five);
		Card card_16 = new Card(Card.Suits.Spades, Card.Ranks.Five);
		Card card_17 = new Card(Card.Suits.Diamonds, Card.Ranks.Six);
		Card card_18 = new Card(Card.Suits.Hearts, Card.Ranks.Six);
		Card card_19 = new Card(Card.Suits.Clubs, Card.Ranks.Six);
		Card card_20 = new Card(Card.Suits.Spades, Card.Ranks.Six);
		Card card_21 = new Card(Card.Suits.Diamonds, Card.Ranks.Seven);
		Card card_22 = new Card(Card.Suits.Hearts, Card.Ranks.Seven);
		Card card_23 = new Card(Card.Suits.Clubs, Card.Ranks.Seven);
		Card card_24 = new Card(Card.Suits.Spades, Card.Ranks.Seven);
		Card card_25 = new Card(Card.Suits.Diamonds, Card.Ranks.Eight);
		Card card_26 = new Card(Card.Suits.Hearts, Card.Ranks.Eight);
		Card card_27 = new Card(Card.Suits.Clubs, Card.Ranks.Eight);
		Card card_28 = new Card(Card.Suits.Spades, Card.Ranks.Eight);
		Card card_29 = new Card(Card.Suits.Diamonds, Card.Ranks.Nine);
		Card card_30 = new Card(Card.Suits.Hearts, Card.Ranks.Nine);
		Card card_31 = new Card(Card.Suits.Clubs, Card.Ranks.Nine);
		Card card_32 = new Card(Card.Suits.Spades, Card.Ranks.Nine);
		Card card_33 = new Card(Card.Suits.Diamonds, Card.Ranks.Ten);
		Card card_34 = new Card(Card.Suits.Hearts, Card.Ranks.Ten);
		Card card_35 = new Card(Card.Suits.Clubs, Card.Ranks.Ten);
		Card card_36 = new Card(Card.Suits.Spades, Card.Ranks.Ten);
		Card card_37 = new Card(Card.Suits.Diamonds, Card.Ranks.Jack);
		Card card_38 = new Card(Card.Suits.Hearts, Card.Ranks.Jack);
		Card card_39 = new Card(Card.Suits.Clubs, Card.Ranks.Jack);
		Card card_40 = new Card(Card.Suits.Spades, Card.Ranks.Jack);
		Card card_41 = new Card(Card.Suits.Diamonds, Card.Ranks.Queen);
		Card card_42 = new Card(Card.Suits.Hearts, Card.Ranks.Queen);
		Card card_43 = new Card(Card.Suits.Clubs, Card.Ranks.Queen);
		Card card_44 = new Card(Card.Suits.Spades, Card.Ranks.Queen);
		Card card_45 = new Card(Card.Suits.Diamonds, Card.Ranks.King);
		Card card_46 = new Card(Card.Suits.Hearts, Card.Ranks.King);
		Card card_47 = new Card(Card.Suits.Clubs, Card.Ranks.King);
		Card card_48 = new Card(Card.Suits.Spades, Card.Ranks.King);
		Card card_49 = new Card(Card.Suits.Diamonds, Card.Ranks.Ace);
		Card card_50 = new Card(Card.Suits.Hearts, Card.Ranks.Ace);
		Card card_51 = new Card(Card.Suits.Clubs, Card.Ranks.Ace);
		Card card_52 = new Card(Card.Suits.Spades, Card.Ranks.Ace);
		
		
		deck.addItem(card_1);
		deck.addItem(card_2);
		deck.addItem(card_3);
		deck.addItem(card_4);
		deck.addItem(card_5);
		deck.addItem(card_6);
		deck.addItem(card_7);
		deck.addItem(card_8);
		deck.addItem(card_9);
		deck.addItem(card_10);
		deck.addItem(card_11);
		deck.addItem(card_12);
		deck.addItem(card_13);
		deck.addItem(card_14);
		deck.addItem(card_15);
		deck.addItem(card_16);
		deck.addItem(card_17);
		deck.addItem(card_18);
		deck.addItem(card_19);
		deck.addItem(card_20);
		deck.addItem(card_21);
		deck.addItem(card_22);
		deck.addItem(card_23);
		deck.addItem(card_24);
		deck.addItem(card_25);
		deck.addItem(card_26);
		deck.addItem(card_27);
		deck.addItem(card_28);
		deck.addItem(card_29);
		deck.addItem(card_30);
		deck.addItem(card_31);
		deck.addItem(card_32);
		deck.addItem(card_33);
		deck.addItem(card_34);
		deck.addItem(card_35);
		deck.addItem(card_36);
		deck.addItem(card_37);
		deck.addItem(card_38);
		deck.addItem(card_39);
		deck.addItem(card_40);
		deck.addItem(card_41);
		deck.addItem(card_42);
		deck.addItem(card_43);
		deck.addItem(card_44);
		deck.addItem(card_45);
		deck.addItem(card_46);
		deck.addItem(card_47);
		deck.addItem(card_48);
		deck.addItem(card_49);
		deck.addItem(card_50);
		deck.addItem(card_51);
		deck.addItem(card_52);
		
		
		if(args.length != 2) {
			System.out.println("Usage: program <#rounds> <#players (2-7)>");
			return;
		}
		
		if(Integer.parseInt(args[1])<2 || Integer.parseInt(args[1]) > 7) {
			System.out.println("Usage: program <#rounds> <#players (2-7)>");
			return;
		}
		
		
		
		nRounds = Integer.parseInt(args[0]);
		nPlayers = Integer.parseInt(args[1]);

		System.out.println(nRounds + " " + nPlayers);
		
		Players[] players = new Players[nPlayers];
		
		for(int i=0;i<nPlayers;i++)
		{
			players[i] = new Players();
		}
		
		//shuffle the deck
		deck.shuffle();
		
		//dealing out an even amount of cards to each player
		for(int i=0;i<52-52%nPlayers;i++)
		{
			players[i%nPlayers].faceDown.addItem(deck.removeItem());
		}
		
		//printing out each players facedown deck
		for(int i=0;i<nPlayers;i++)
		{
			System.out.println("Here is Player "+(i+1)+"'s facedown pile: \n"+players[i].faceDown.toString()+"\n");
		}
		
		//adding the remaining items in the deck to the snappool
		while(!deck.empty())
		{
			snapPool.addItem(deck.removeItem());
		}
		
		
		boolean gameOver = false;
		int round = 0;
		while(!gameOver && (round<nRounds)) {
			
			//every player moves one card up
			boolean match = false;
			System.out.println("\nRound: #"+round);
			
			//Flipping over card and resetting match and snap variables
			for(int i=0;i<nPlayers;i++)
			{
				if(players[i]!=null)
				{
				players[i].faceUp.addItem(players[i].faceDown.removeItem());
				players[i].match=0;
				players[i].snapGuess=1;
				
				}
			}

			
			//check for matches
			for(int i=0;i<nPlayers-1;i++)
			{
				for(int j=i+1;j<nPlayers;j++)
				{
					if(players[i]!=null&&players[j]!=null)
					{
					if(players[i].faceUp.top().compareTo(players[j].faceUp.top())==0)
					{
						System.out.println("\nPlayer "+(i+1)+": "+players[i].faceUp.top()+"\n"+"Player "+(j+1)+": "+players[j].faceUp.top());
						match=true;
						System.out.println("\nTheres a Match!\n");
						players[i].match=1;
						players[j].match=1;
					}}
				}
			}
			 
			
			//probability of the players snapping this round
			if(match)
			{
				for(int i=0;i<nPlayers;i++)
				{
					int x = (int) (Math.random()*100);
					if(x<40)
					{
						if(players[i]!=null)
					{
						players[i].snapGuess=2;
						System.out.println("Player "+(i+1)+ " correctly says snap");
					}}
				}
			} 
			else
			{
				for(int i=0;i<nPlayers;i++)
				{
					int x = (int) (Math.random()*100);
					if(players[i]!=null)
					{
					if(x==1)
					{
						players[i].snapGuess=3;
						System.out.println("Player "+(i+1)+ " incorrectly says snap");
						while(!players[i].faceUp.empty())
						{
							snapPool.addItem(players[i].faceUp.removeItem());
						}
						
					}}
				}
			}
					
			
			//seeing if more than one player correctly snapped
			int correctSnap=0;
			for(int i=0;i<nPlayers;i++)
			{
				if(players[i]!=null)
				{
				if(match=true && players[i].snapGuess==2)
				{
					correctSnap++;
				}}
			}
			
			//if only person called snap correctly
			if(correctSnap==1)
			{
				for(int i=0;i<nPlayers;i++)
				{
					if(players[i]!=null)
					{
					if(players[i].snapGuess==2)
					{
						players[i].match=2;
					}}
				}
			}
			
			//the winner gets the cards from the faceup piles of the other matches, and the snapPool
			for(int i=0;i<nPlayers;i++)
			{ 
				if(players[i]!=null)
				{
				if(players[i].match==2)
				{
					for(int j=0;j<nPlayers;j++)
					{
						if(players[j]!=null)
						{
						if(players[j].match==1)
						{
							players[j].faceDown.shuffle();
							snapPool.shuffle();
							while(!players[j].faceUp.empty())
							{
								players[i].faceDown.addItem(players[j].faceUp.removeItem());
								
							}
							System.out.println("Player "+(j+1)+"'s cards are going to Player "+(i+1));
							while(!snapPool.empty())
							{
								players[i].faceDown.addItem(snapPool.removeItem());
							}
							
						}}
					}
				}}
				
		
			}
			
			//adding cards to the faceDown deck if there is none left
			for (int i=0;i<nPlayers;i++)
			{
				if(players[i]!=null)
				{
				if(players[i].faceDown.empty() && !players[i].faceUp.empty())
				{
					players[i].faceUp.shuffle();
					while(!players[i].faceUp.empty())
					{
						players[i].faceDown.addItem(players[i].faceUp.removeItem());
					}
				}}
			}
			
			
			//getting rid of players who ran out of cards
			for(int i=0;i<nPlayers;i++)
			{
				if(players[i]!=null)
				{
				if(players[i].faceDown.empty()&& players[i].faceUp.empty())
				{
					players[i]=null;
				}}
			}
			
			gameOver = false;
			round++;
		}

		System.out.println("After "+nRounds+" Rounds: \n\n");
		
		//Printing out how many cards each players has
		for(int i=0;i<nPlayers;i++)
		{
			if(players[i]!=null)
			{
				System.out.println("Player "+(i+1)+" finished with "+(players[i].faceUp.size()+players[i].faceDown.size())+" cards");
			}
			else {
				System.out.println("Player "+(i+1)+" finished with 0 cards");
			}
		}
		System.out.println("\nThe snap pool finished with "+(snapPool.size())+" cards");
		
	
		//finding out which player has the maximum cards
		int max=0;
		int max_loc=0;
		for(int i=0;i<nPlayers;i++)
		{
			if(players[i]!=null)
			{
				if(max<(players[i].faceUp.size()+players[i].faceDown.size()))
				{
					max = (players[i].faceUp.size()+players[i].faceDown.size());
					max_loc = i;
				}
			}
			
		}
		
		//printing out the winner
		System.out.println("\nPlayer "+(max_loc+1)+" wins with "+max+" cards\n");

	}
}
	
	
	
	
