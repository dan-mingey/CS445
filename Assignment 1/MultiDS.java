//Daniel Mingey 
//djm189
//4108215
//Assignment 1
//CS 445 Sherif

public class MultiDS<T> implements PrimQ<T>, Reorder {
	
	private T[] array;
	private int size, entries=0;
	
	
	
	
	public MultiDS(int s)
	{
		size=s;
		this.array = (T[]) new Object[size];
		
	}
	
	//PRIMQ METHODS
	
	// Add a new Object to the PrimQ<T> in the next available location.  If
	// all goes well, return true.  If there is no room in the PrimQ for
	// the new item, return false (you should NOT resize it)
	
	//@param item , the item to be added
	//@return true if successful false if unsuccessful
	public boolean addItem(T item)
	{
		if(entries<size)
		{
			array[entries] = item;
			entries++;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	// Remove and return the "oldest" item in the PrimQ.  If the PrimQ
	// is empty, return null.
	//
	//@return T , returns the oldest item in the array
	public T removeItem()
	{
		
		
		if(entries==0)
		{
			return null;
		}
		else
		{
			T temp = array[0];
			for(int i=0;i<size-1;i++)
			{
				array[i] = array[i+1];
			}
			array[entries-1]=null;
			entries--;
			return temp;
		}
		
		
	}
	
	// Returns the "oldest" item in the PrimQ.  If the PrimQ
	// is empty, return null.
	//@return T , returns the oldest item in the PrimQ
	public T top()
	{
		if(entries==0)
		{
			return null;
		}
		else
		{
			return array[entries-1];
		}
	}
		
	// Return true if the PrimQ is full, and false otherwise
	//@return boolean , true if full false if not full
	public boolean full()
	{
		if(entries==size)
		{
			return true;
		}else{
			return false;
		}
		
	}
	
	// Return true if the PrimQ is empty, and false otherwise
	//@return boolean , true if empty false if not empty
	public boolean empty()
	{
		if(entries==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Return the number of items currently in the PrimQ
	//@return int , returns the size of the array
	public int size()
	{
		return entries;
	}

	// Reset the PrimQ to empty status by reinitializing the variables
	// appropriately
	public void clear()
	{
		for(int i = 0; i<entries; i++)
		{
			array[i]=null;
		}
		entries=0;
	}
	
	
	//REORDER METHODS
	// Logically reverse the data in the Reorder object so that the item
	// that was logically first will now be logically last and vice
	// versa.  The physical implementation of this can be done in 
	// many different ways, depending upon how you actually implemented
	// your physical MultiDS<T> class
	public void reverse()
	{ 
		
		
		
		int j = entries-1;
		for(int i=0;i<entries/2;i++)
		{
			T tempvalue = (T) array[i];
			array[i] = array[j-i];
			array[j-i] = tempvalue;
			
			
		}

		
		
	}

	// Remove the logical last item of the DS and put it at the 
	// front.  As with reverse(), this can be done physically in
	// different ways depending on the underlying implementation.  
	public void shiftRight()
	{
		
		
		int j = entries-1;
		T tempvalue = (T) array[entries-1];
		for(int i=0;i<entries-1;i++)
		{
			array[j] = array[j-1];
			j--;
		}
		array[0] = tempvalue;

	}

	// Remove the logical first item of the DS and put it at the
	// end.  As above, this can be done in different ways.
	public void shiftLeft()
	{
		//fix this stuff
		T tempvalue = array[0];
		
		
		
		for(int i=0;i<entries-1;i++)
		{
			array[i] = array[i+1];
		}
		array[entries-1] = tempvalue;
	}
	
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		
		for(int i =0;i<entries;i++)
		{
			b.append(array[i]+" ");
		}
		
		return b.toString();
	}
	
	public void shuffle()
	{
		
		for(int i=0;i<entries;i++)
		{
			int r =((int)(Math.random()*(entries-i))) + i;
			
			T tempvalue = array[r];
			array[r] = array[i];
			array[i] = tempvalue;
		}
	}
	// Reorganize the items in the object in a pseudo-random way.  The exact
	// way is up to you but it should utilize a Random object (see Random in 
	// the Java API).  Thus, after this operation the "oldest" item in the
	// DS could be arbitrary.
}