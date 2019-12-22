/**@author Daniel Mingey
// Assignment 2
// djm189*/


/** CS 0445 Spring 2018 (Adapted  from Dr. John Ramirez's assignment code)
 This is a partial implementation of the ReallyLongHex class.  You need to
 complete the implementations of the remaining methods.  Also, for this class
 to work, you must complete the implementation of the LinkedDS class.
 See additional comments below.
*/

import java.lang.*;

public class ReallyLongHex 	extends LinkedDS<Character> 
							implements Comparable<ReallyLongHex>
{
	// Instance variables are inherited.  You may not add any new instance variables
	
	// Default constructor
	private ReallyLongHex()
	{
		super();
	}

	// Note that we are adding the digits here in the END. This results in the 
    // MOST significant digit first in the chain.  
    // It is assumed that String s is a valid representation of an
	// unsigned integer with no leading zeros.
	public ReallyLongHex(String s)
	{
		super();
		char c;
		// Iterate through the String, getting each character and adding it 
        // at the end of the list.  
		for (int i = 0; i < s.length(); i++)
		{
			c = s.charAt(i);
			if ((('0' <= c) && (c <= '9')) || (('A' <= c) && (c <= 'F')))
			{
				this.addItem(c);
			}
			else throw new NumberFormatException("Illegal digit " + c);
		}
	}

	// Simple call to super to copy the nodes from the argument ReallyLongHex
	// into a new one.
	public ReallyLongHex(ReallyLongHex rightOp)
	{
		super(rightOp);
	}
	
	// Method to put digits of number into a String.  We traverse the chain 
    // to add the digits to a StringBuilder. 
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (numOfEntries > 0)
		{
			sb.append("0x");
			for (Node curr = firstNode; curr != null; 
					curr = curr.getNextNode())
			{
				sb.append(curr.getData());
			}
		}
		return sb.toString();
	}

	// You must implement the methods below.  See the descriptions in the
	// assignment sheet
	
	/**Method to add two hexadecimal numbers together*/
	public ReallyLongHex add(ReallyLongHex rightOp)
	{
		
		//reversing both 	
		this.reverse();
		rightOp.reverse();
		

		String Sanswer = "";

		int dec_car = 0;
		int dec_sum = 0;

		int x=1, z=1;
		int a_n, b_n; 

		//loop to go through all of the numbers
		while(x<=rightOp.size() || z<=this.size()) {
			if(x<=rightOp.size()) {
				a_n = Character.getNumericValue(rightOp.getEntry(x));
			}
			//might need to add zeros if one is greater
			else {
				a_n = 0;
			}
			if(z<=this.size()) {
				b_n = Character.getNumericValue(this.getEntry(z));
			}
			//might need to add zeros if one is greater
			else {
				b_n = 0;
			}

			//algebra to determine the sum and carry 
			dec_sum = a_n + b_n + dec_car;
			dec_car = (dec_sum - (dec_sum-16))/16;
			dec_sum = dec_sum - (dec_car*16);

			//if its less than 20 its hex value deosnt change
			if(dec_sum<10) {
				Sanswer = Integer.toString(dec_sum) + Sanswer;
			}
			else {
				//the char value + 55 equals the hex value
				Sanswer = (char)(dec_sum + 55) + Sanswer;
			}


			x++;
			z++;
		}

		Sanswer = dec_car + Sanswer;

		//reversing them back again
		rightOp.reverse();
		this.reverse();

		ReallyLongHex answer_RLH = new ReallyLongHex(Sanswer);
		return answer_RLH;
	

		
		
		
		
	}
	
	/**method to made a hex string from the decimal value*/
	public String hexString(int n)
	{
		String answer;
		if(n<10)
		{
			answer = Integer.toString(n);
		}
		else
		{
			answer = (char)(n+55)+"";
		}
		return answer;
	}
	
	/**method to perform the carry*/
	public void getOne(int i)
	{
		if(i!=this.size())
		{
			int x = Integer.parseInt(String.valueOf((this.getEntry(i))));
			int xNext = Integer.parseInt(String.valueOf((this.getEntry(i+1))));
			if(xNext==0)
			{
				//recursion
				getOne(i+1);
			}
			x = Integer.parseInt(String.valueOf((this.getEntry(i))));
			xNext = Integer.parseInt(String.valueOf((this.getEntry(i+1))));
			
			
			if(xNext!=0)
			{
				 getNodeAt(i+1).setData(xNext-1);
				 getNodeAt(i).setData(x+16);
				 
			}
		}
		else{
			throw new ArithmeticException("Invalid Difference -- Negative Number");
		}
	}

	
	/**method to subtract two hexadecimal numbers, returns the difference*/
	public ReallyLongHex subtract(ReallyLongHex rightOp)
	{	
	
			
		this.reverse();
		rightOp.reverse();
		String s = "";
		
		int botLength = rightOp.size();
		int i=1;
		
		
		while(i<=botLength)
		{

			int x = Integer.parseInt(String.valueOf((this.getEntry(i))));
			int y = Integer.parseInt(String.valueOf((rightOp.getEntry(i))));
			
			if((x-y)<0)
			{
				
				getOne(i);
			}
			
			
			
			x = Integer.parseInt(String.valueOf((this.getEntry(i))));
			y = Integer.parseInt(String.valueOf((rightOp.getEntry(i))));
			s = hexString(x-y)+s;
			i++;
			
		}
		
		for(int j=i;j<=this.size();j++)
		{
			int z = Integer.parseInt(String.valueOf(this.getEntry(j)));
			s = hexString(z)+s;
		}
		
		this.reverse();
		rightOp.reverse();
		
		ReallyLongHex answer_RLH = new ReallyLongHex(s);
		
		
		return answer_RLH;
			
		
	}

	/**method to compare two Hex's, will return 1 for greater than, 0 for equal, -1 for less than*/
	public int compareTo(ReallyLongHex rOp)
	{
		double sum1 = 0;
		double sum2 = 0;
		
		for(int i=1;i<=this.size();i++)
			sum1 = sum1 + Integer.parseInt(String.valueOf(this.getEntry(i)));
		
		for(int i=1;i<=rOp.size();i++)
			sum2 = sum2 + Integer.parseInt(String.valueOf(rOp.getEntry(i)));		
		
		if((sum1-sum2)>0)
		{
			return 1;
		}
		else if ((sum1-sum2)==0)
		{
			return 0;
		}
		else
		{
			return -1;
		}

	}

	/**will return true if theyre equal, false if they arent*/
	public boolean equals(Object rightOp)
	{
		int x = compareTo((ReallyLongHex)rightOp);
		if(x==0)
			return true;
		
		
		return false;
		
		
	}

	/** method that multiplies the hex by 16 num times*/
	public void mult16ToThe(int num)
	{
		char c = '0';
		for(int i=0;i<num;i++)
		{
			this.addItem(c);
		}
	}

	/**method to divide the hex by 16 num times*/
	public void div16ToThe(int num)
	{
		rightShift(num);
	}
}
