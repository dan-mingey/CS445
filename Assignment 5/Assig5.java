import java.io.*;
import java.util.*;

/** Daniel Mingey
 * 	University of Pittsburgh
 * 	CS 445 Assignment 5
 * 
 * 
 */
public class Assig5 {

	//global variables
	int choice = 4;
	BinaryNode<Character> head;
	String code = "temporary string";
	StringBuilder sb = new StringBuilder();
	StringBuilder b = new StringBuilder();
	StringBuilder c = new StringBuilder();
	int sbIndex = 0;
	int bIndex = 0;
	char[] letterArray;
	int letterCount = 0;
	int count = 0;
	String[] codeArray;
	String searchString;
	boolean foundString;
	boolean foundCode;
	
	
	
	public static void main(String[] args)
	{
		new Assig5(args[0]);
	}
	
	public Assig5(String filename) 
	{
		Scanner inScan = new Scanner(System.in);
	
		
		try {
			File fileIn = new File(filename);
			Scanner fileReader;
			fileReader = new Scanner(fileIn);
			//creating the tree
			head = createTree(fileReader);
		} catch (FileNotFoundException e) {
		
			System.out.println("exception: "+e);
		}
		
		//array of the letters
		letterArray = new char[letterCount];
		//array of the code for each letter
		codeArray = new String[letterCount];
		
		
		System.out.println("\nPlease Choose from the following: \n1)Encode a text string\n2)Decode a Huffman String\n3)Quit");
		choice = inScan.nextInt();
		
		//main loop
		do {
		
		
		
		for(int i=0;i<letterArray.length;i++)
		{
			retrieveCharacters(head);
			sb.delete(0, sbIndex);
			createTable(head, letterArray[i]);
			codeArray[i] = code;
		}
		
		// Encode a text String
		if(choice == 1)
		{
			
			
				
			
			
			System.out.println("Enter a String from the following Characters");
			for(int i=0;i<letterArray.length;i++)
			{	
				System.out.print(letterArray[i]);
			}
			System.out.println();
			inScan = new Scanner(System.in);
			searchString = inScan.nextLine();
			char [] searchStringArray = new char [searchString.length()];
			
			for(int i = 0;i<searchString.length();i++)
			{
				searchStringArray[i] = searchString.charAt(i);
				//prints the code if the letters match with the letters in the letters in the letterArray
				printCode(searchStringArray[i]);
			}
			if(!foundString)
			{
				System.out.println("There was an error in your test string");
			}
		}
		
		// Decode from a Huffman String
		if(choice==2)
		{
			System.out.println("Here is the table: ");
			
			for(int i=0;i<letterArray.length;i++)
			{	
				System.out.println(letterArray[i]+ "  :  "+codeArray[i]);
			}
			
			System.out.println("Please enter a Huffman String (one line, no spaces)");
			inScan = new Scanner(System.in);
			String huffString = inScan.nextLine();
			char[] huffStringArray = new char[huffString.length()];
			for(int i=0; i<huffString.length();i++)
			{
				huffStringArray[i] = huffString.charAt(i);
				printLetters(huffStringArray[i]);
				
					
		
				
			}
		}
		System.out.println("\nPlease Choose from the following: \n1) Encode a text string\n2)Decode a Huffman String\n3)Quit");
		inScan = new Scanner(System.in);
		choice = inScan.nextInt();
		
		
		} while(choice != 3);
		
		System.out.println("Goodbye!");
	}
	
	/**prints the letters from a given huffman string */
	public void printLetters(char c)
	{
		
		b.append(c);
		bIndex++;
		for(int i=0;i<codeArray.length;i++)
		{
			
			if(codeArray[i].equals(b.toString()))
			{
				foundCode = true;
				System.out.print(letterArray[i]);
				b.delete(0, bIndex);
				bIndex=0;
				
			}
			
		}
		
		
	}
	
	/**prints the code for a given character*/
	public void printCode(char ch)
	{
		
		for(int i=0;i<letterArray.length;i++)
		{
			if(letterArray[i]==ch)
			{
				foundString = true;
				System.out.println(codeArray[i]);
				break;
			}
			else
			{
				foundString = false;
			}
		}
	}
	
	/**creates the huffman tree */
	public BinaryNode<Character> createTree(Scanner inScan)
	{
		BinaryNode<Character> node = null;
		String[] nodes = inScan.nextLine().split(" ");
		char nodeType = nodes[0].charAt(0);
		
		if(nodeType =='I')
		{
			
			node = new BinaryNode<Character> ('\0');
			node.setLeftChild(createTree(inScan));
			node.setRightChild(createTree(inScan));
		}
		else {
	
			letterCount++;
			return new BinaryNode<Character> (nodes[1].charAt(0));
		}
		return node;
	}
	
	/**retrieve a character and adds it to the letter array in alphabetical order*/
	public void retrieveCharacters(BinaryNode<Character> node)
	{
		
		if(node != null)
		{
			if(node.getData()=='\0')
			{
				retrieveCharacters(node.getLeftChild());
				retrieveCharacters(node.getRightChild());
			}
			else
			{
				letterArray[Character.getNumericValue(node.getData())-10] = node.getData();
			
			}
		}
	}
	
	/**Creates the huffman table */
	public void createTable(BinaryNode<Character> node, char c)
	{
	
		if(node != null)
		{
			if(node.getData().compareTo('\0')==0)
			{
				
				sb.append("0");
				sbIndex++;
				createTable(node.getLeftChild(), c);
				sb.deleteCharAt(sb.length()-1);
				sbIndex--;
				
				sb.append("1");
				sbIndex++;
				createTable(node.getRightChild(), c);
				sb.deleteCharAt(sb.length()-1);
				sbIndex--;
			} 
			else if (node.getData().compareTo(c)==0)
			{
				
				code  = sb.toString();
			}
			
		}
			
	}
}



