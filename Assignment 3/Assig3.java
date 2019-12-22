/**
@author Daniel Mingey 
Peoplesoft: 4108215
username: djm189

Data Structures 445
Recursion Assignment 


*/
import java.io.*;
import java.util.*;

public class Assig3 {

	//head node to keep tack of first word
	Node head;
	//array of words the user inputs
	String[] words;
	
	public static void main(String[] args)
	{
		new Assig3();
	}
	
	public Assig3() {
		
		//ALL GIVEN DOWN TO LINE 80
		Scanner inScan = new Scanner(System.in);
		File inFile;
		String filename, phrase="";
		Scanner fReader;
		
		
		while (true)
		{
			try {
				System.out.println("Please enter grid filename: ");
				filename = inScan.nextLine();
				inFile = new File(filename);
				fReader = new Scanner(inFile);
				
				break;
			}
			catch (IOException e)
			{
				System.out.println("Problem "+e);
			}
		}
		
		String [] dims = fReader.nextLine().split(" ");
		int rows = Integer.parseInt(dims[0]);
		int cols = Integer.parseInt(dims[1]);
		char [][] theBoard = new char[rows][cols];
		
		for(int i=0;i<rows;i++)
		{
			String rowString = fReader.nextLine();
			for (int j=0;j<cols;j++)
			{
				theBoard[i][j] = Character.toLowerCase(rowString.charAt(j));
			}
		}
		
		for(int i=0;i<rows;i++)
		{
			for (int j=0;j<cols;j++)
			{
				System.out.print(theBoard[i][j]+" ");
			}
			System.out.println(); 
		}
		
		System.out.println("Please enter the phrase to search for: ");
		phrase = inScan.nextLine().toLowerCase();
		words = phrase.split(" ");
		
		
		
		//my code begins
		/**making a node for each word inputed, and assigned each Node's word variable to a word
		*/
		head = new Node();
		head.word = words[0];
		Node temp = head;
		if(words.length>1)
		{
			
			for(int i=1;i<words.length;i++)
			{
				temp.next = new Node();
				temp = temp.next;
				temp.word = words[i];
				
			}
		}
		
		boolean found;
		
		/**
		
		loop to cycle through multiple searches
		
		*/
		while(!(phrase.equals("")))
		{
			found = false;
			
			//loop to call findWord on every spot in the circle
			for(int r = 0;(r < rows && !found);r++)
			{
				for(int c = 0; (c < cols && !found); c++)
				{ 
					found = findWord(r, c, head, theBoard);
				}
			}
			
			//printing whethere or not the phrase was found
			if(found)
			{
				System.out.println("The phrase "+phrase);
				System.out.println("was found");
				printWords();
			}
			else {
			
				System.out.println("The phrase "+phrase);
				System.out.println("was not found");
				
			}
			
			//making the board lower case again
			for(int i=0;i<rows;i++)
			{
				for (int j=0;j<cols;j++)
				{
					System.out.print(theBoard[i][j]+" ");
					theBoard[i][j] = Character.toLowerCase(theBoard[i][j]);
				}
				System.out.println(); 
			}
			
			
			//getting another phrase to search for from the user
			System.out.println("Please enter the phrase to search for: ");
			phrase = inScan.nextLine().toLowerCase();
			words = phrase.split(" ");
			head = new Node();
			head.word = words[0];
			temp = head;
			if(words.length>1)
			{
				
				for(int i=1;i<words.length;i++)
				{
					temp.next = new Node();
					temp = temp.next;
					temp.word = words[i];
					
				}
			}
		}
		
		
		
		
	}
	
	/**
	
	Function to printout the words and their locations once it was found 
	
	*/
	
	public void printWords() {
		Node temp = head;
		temp = head;
		
		while(temp!=null)
		{
			System.out.println(temp.word+": ("+temp.rowStart+","+temp.colStart+") to ("+temp.rowEnd+","+temp.colEnd+")");
			temp = temp.next;
		}
	}
	
	
	/**
	
	@param r is the row
	
	*/
	public boolean findWord(int r, int c, Node current, char [][] bo)
	{
		
		
		// Check boundary conditions
		if (r >= bo.length || r < 0 || c >= bo[0].length || c < 0)
		{
			
			return false;
		}
		else {
			boolean answer;
				if(current==head)
				{
					
					answer = findWordRight(r, c, current, bo);
					if(!answer)
					{answer = findWordDown(r, c, current, bo);}
					if(!answer)
					{answer = findWordLeft(r, c, current, bo);}
					if(!answer)
					{answer = findWordUp(r, c, current, bo);}
				
				}
				else
				{
					
					answer = findWordRight(r, c+1, current, bo);
					if(!answer)
					{answer = findWordDown(r+1, c, current, bo);}
					if(!answer)
					{answer = findWordLeft(r, c-1, current, bo);}
					if(!answer)
					{answer = findWordUp(r-1, c, current, bo);}
				}
				
				
				
				
				return answer;
			}
			
			
		}
	
	
	
	
	
	
	public boolean findWordRight(int r, int c, Node current, char [][] bo)
	{
	
		//checks the dimensions
		if (r >= bo.length || r < 0 || (c+current.word.length()-1) >= bo[0].length || c < 0)
		{
			return false;
		}
		
		//loops through to check if the characters to the right match the word, will return false if it doesnt match
		int letter=0;
		boolean result = true;
		int i;
		for (i=c;i<(c+current.word.length());i++)
		{
			
			if(bo[r][i]!=current.word.charAt(letter))
			{
				
				return false;
			}
			letter++;
		}
		
		//it matches! so set the start and end locations
		current.setStarts(r, c);
		current.setEnds(r, i-1);
		
		//Recursize call to find word, gotta get the next word(s) and see if they can be found or not 
		if(current.next!=null)
		{
			result =  findWord(current.rowEnd,current.colEnd,current.next, bo);
		} 
		
		//if it found the other words, capitalize them of the current word !
		if(result)
		{
			for (i=c;i<(c+current.word.length());i++)
			{
				bo[r][i] = Character.toUpperCase(bo[r][i]);
			}
		}
		
		//should only return true
		return result;
		
			
					
		}
		
		
		
	
	public boolean findWordDown(int r, int c, Node current, char [][] bo)
	{
		
		//checks the dimensions
		if ((r+current.word.length()-1) >= bo.length || r < 0 || c >= bo[0].length || c < 0)
		{
			
			return false;
		}
		
		//loops through to check if the characters to the right match the word, will return false if it doesnt match
		int letter=0;
		boolean result = true;
		int i;
		for (i=r;i<(r+current.word.length());i++)
		{
			
			if(bo[i][c]!=current.word.charAt(letter))
			{
				
				return false;
			}
			letter++;
		}
		//it matches! so set the start and end locations
		current.setStarts(r, c);
		current.setEnds(i-1, c);
		
		//Recursize call to find word, gotta get the next word(s) and see if they can be found or not 
		if(current.next!=null)
		{
			result =  findWord(current.rowEnd,current.colEnd,current.next, bo);
		} 
		
		//if it found the other words, capitalize them of the current word !
		if(result)
		{
			for (i=r;i<(r+current.word.length());i++)
			{
				bo[i][c] = Character.toUpperCase(bo[i][c]);
			}
		}
		
		
		return result;
		
		}
		
		
		
		
		
	public boolean findWordLeft(int r, int c, Node current, char [][] bo)
	{
		
		//checks the dimensions
		
		if (r >= bo.length || r < 0 || c >= bo[0].length || (c-current.word.length()+1) < 0)
		{
			
			return false;
		}
		
		//loops through to check if the characters to the right match the word, will return false if it doesnt match
		int letter=0;
		boolean result = true;
		int i;
		for (i=c;i>(c-current.word.length());i--)
		{
			
			if(bo[r][i]!=current.word.charAt(letter))
			{
				
				return false;
			}
			letter++;
		}
		//it matches! so set the start and end locations
		current.setStarts(r, c);
		current.setEnds(r, i+1);
		
		//Recursize call to find word, gotta get the next word(s) and see if they can be found or not 
		if(current.next!=null)
		{
			result =  findWord(current.rowEnd,current.colEnd,current.next, bo);
		} 
		
		//if it found the other words, capitalize them of the current word !
		if(result)
		{
			for (i=c;i>(c-current.word.length());i--)
			{
				bo[r][i] = Character.toUpperCase(bo[r][i]);
			}
		}
		
		
		return result;
	}
		
	public boolean findWordUp(int r, int c, Node current, char [][] bo)
	{
		//checks the dimensions
		
		if (r >= bo.length || (r-current.word.length()+1) < 0 || c >= bo[0].length || c < 0)
		{
			
			return false;
		}
		
		//loops through to check if the characters to the right match the word, will return false if it doesnt match
		int letter=0;
		boolean result = true;
		int i;
		for (i=r;i>(r-current.word.length());i--)
		{
			
			if(bo[i][c]!=current.word.charAt(letter))
			{
				
				return false;
			}
			letter++;
		}
		//it matches! so set the start and end locations
		current.setStarts(r, c);
		current.setEnds(i+1,c);
		
		//Recursize call to find word, gotta get the next word(s) and see if they can be found or not 
		if(current.next!=null)
		{
			result =  findWord(current.rowEnd,current.colEnd,current.next, bo);
		} 
		
		//if it found the other words, capitalize them of the current word !
		if(result)
		{
			for (i=r;i>(r-current.word.length());i--)
			{
				bo[i][c] = Character.toUpperCase(bo[i][c]);
			}
		}
		
		
		return result;
		
		}
		
		
		
}

// custome node class to keep track the word its currently looking for 
class Node 
{
	int rowStart,rowEnd,colStart,colEnd;
	Node next;
	String word;
	public Node()
	{
		next  = null;
	}
	
	
	public void setEnds(int r, int c)
	{
		rowEnd = r;
		colEnd = c;
	}
	public void setStarts(int r, int c)
	{
		rowStart = r;
		colStart = c;
	}
}
