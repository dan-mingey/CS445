/**@author Daniel Mingey
// Assignment 2
// djm189*/


public class LinkedDS<T> implements Reorder, PrimQ<T> 
{
	public Node firstNode;
	public int numOfEntries;
	
	//constructor
	public LinkedDS ()
	{
		initializeDataFields();
	}
	
	//copy constructor
	public LinkedDS (LinkedDS c)
	{
		initializeDataFields();
		Node current = c.firstNode;
		
		while(current!=null)
		{
			addItem((T)current.data);
			current = current.next;
		}
		
	}
	
	/**initializes the variables*/
	public void initializeDataFields()
	{
		firstNode=null;
		numOfEntries=0;
	}
	
	
	/** Add a new Object to end of the PrimQ<T>.  If
	// all goes well, return true.  */
	public boolean addItem(T newEntry)
	{
		Node newnode = new Node(newEntry);
	
		
		if(empty())
		{
			firstNode = newnode;
		}
		else
		{
			Node lastnode = getLastNode();
			lastnode.setNextNode(newnode);
			
		}
		numOfEntries++;
		return true;
		
	}
	
	/**retrieves the last node in the linked list*/
	public Node getLastNode()
	{
		Node current = firstNode;
		while(current.next!=null)
		{
			current = current.next;
		}
		return current;
	}
	
	/**retrieves a node at the given position (GIVEN TO US)*/
	public Node getNodeAt(int givenPosition)
	{
		assert !empty() && (1 <= givenPosition) && (givenPosition <= numOfEntries);
		Node<T> currentNode = firstNode;
		
      // Traverse the chain to locate the desired node
      // (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		
		assert currentNode != null;
      
		return currentNode;
	} // end getNodeAt
	
	/**retrieves the Data at a given position, using the getNodeAt function which was given to us*/
	public T getEntry(int position)
	{
		if((position>0)&&(position<=numOfEntries))
		{
			
			assert !empty();
			return (T)getNodeAt(position).data;
		}
		else {
			throw new IndexOutOfBoundsException("Position not allowed");
		}
	}
	
	
	
	// Remove and return the "oldest" item in the PrimQ.  If the PrimQ
	// is empty, return null.
	/**
	*removes an item and returns it*/
	public T removeItem()
	{
		Node<T> temp;
		
		
		if(empty())
		{
			return null;
		}
		temp  = firstNode;
		firstNode = temp.next;
		numOfEntries--;
		return temp.getData();
		
	}
	
	// Return true if the PrimQ is empty, and false otherwise
	
	/**
	*returns true if empty, false if not empty*/
	public boolean empty()
	{
	return(numOfEntries==0);
	}
	
	// Return the number of items currently in the PrimQ
	
	/**
	*returns the size*/
	public int size()
	{
		return numOfEntries;
	}
	

	// Reset the PrimQ to empty status by reinitializing the variables
	// appropriately
	
	/**
	*clears everything*/
	public void clear()
	{
		firstNode=null;
	}
	
	
	// Logically reverse the data in the Reorder object so that the item
	// that was logically first will now be logically last and vice
	// versa.  The physical implementation of this can be done in 
	// many different ways, depending upon how you actually implemented
	// your physical LinkedDS<T> class
	
	/**
	*reverses the data*/
	public void reverse()
	{
		
		Node prev, current, next;

		prev = null;
		current = firstNode;
		while(current != null){  	  
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		firstNode = prev;
	}

	// Remove the logical last item of the DS and put it at the 
	// front.  As with reverse(), this can be done physically in
	// different ways depending on the underlying implementation.  
	
	//does NOT delete
	
	/**
	*shifts the data to the left num times without deleting the nodes*/
	public void shiftRight()
	{
		
		Node lastnode = getLastNode();
		Node current = firstNode;
		Node tempfirst = firstNode;
		
		while(current.next!=lastnode)
			current = current.next;
		
		lastnode.next = tempfirst;
		current.next=null;
		firstNode = lastnode;
		
		
		
		
		
		
		
		
	
		
	}

	// Remove the logical first item of the DS and put it at the
	// end.  As above, this can be done in different ways.
	
	//does NOT delete
	/**
	*shifts the data to the left num times without deleting the nodes*/
	public void shiftLeft()
	{
		
		Node current = firstNode;
		Node lastnode = getLastNode();
		lastnode.next = current;
		firstNode = current.next;
		current.next=null;
		
	}
	
	// Shift the contents of the DS num places to the left (assume the beginning 
	// is the leftmost node), removing the leftmost num nodes.  For example, if 
	// a list has 8 nodes in it (numbered from 1 to 8), a leftShift of 3 would 
	// shift out nodes 1, 2 and 3 and the old node 4 would now be node 1.  
	// If num <= 0 leftShift should do nothing and if num >= the length of the 
	// list, the result should be an empty list.
	
	//deletes the nodes
	/**
	*shifts the data to the left num times*/
	public void leftShift(int num)
	{
		for(int i=0;i<num;i++)
		{
		
		Node current = firstNode.next;
		firstNode = current;
		numOfEntries--;
		
		}
	}
	
	// Same idea as leftShift above, but in the opposite direction.  For example, 
	// if a list has 8 nodes in it (numbered from 1 to 8) a rightShift of 3 would 
	// shift out nodes 8, 7 and 6 and the old node 5 would now be the last node
	// in the list.  If num <= 0 rightShift should do nothing and if num >= the 
	// length of the list, the result should be an empty list.
	
	//deletes the nodes
	/**
	*shifts the data to the right num times */
	public void rightShift(int num)
	{
		for(int i=0;i<num;i++)
		{
			Node lastnode = getLastNode();
			Node current = firstNode;
			while(current.next!=lastnode)
			{
				current = current.next;
			}
			current.next=null;
			numOfEntries--;
		}
			
	}
	
	// In this method you will still shift the contents of the list num places to 
	// the left, but rather than removing nodes from the list you will simply change 
	// their ordering in a cyclic way.  For example, if a list has 8 nodes in it 
	// numbered from 1 to 8), a leftRotate of 3 would shift nodes 1, 2 and 3 to the
	// end of the list, so that the old node 4 would now be node 1, and the old nodes 
	// 1, 2 and 3 would now be nodes 6, 7 and 8 (in that order).  The rotation should 
	// work modulo the length of the list, so, for example, if the list is length 8 then
	// a leftRotate of 10 should be equivalent to a leftRotate of 2.  If num < 0, the 
	// rotation should still be done but it will in fact be a right rotation rather than
	// a left rotation.
	
	//does NOT delete
	/**
	*rotates the data to the left num times*/
	public void leftRotate(int num)
	{
		if(num<0)
		{
			rightRotate((-1)*num);
		}
		else
		{
			for(int i=0;i<num;i++)
			{
				
				shiftLeft();

			}
		}
		
		
		
	}

	// Same idea as leftRotate above, but in the opposite direction.  For example, if a list 
	// has 8 nodes in it (numbered from 1 to 8), a rightRotate of 3 would shift nodes 8, 7 and 
	// 6 to the beginning of the list, so that the old node 8 would now be node 3, the old node 
	// 7 would now be node 2 and the old node 6 would now be node 1.  The behavior for num > the 
	// length of the list and for num < 0 should be analogous to that described above for leftRotate.
	
	//does NOT delete
	/**
	* rotates the data to the right num times */
	public void rightRotate(int num)
	{
		if(num<0)
		{
			leftRotate((-1)*num);
		}
		else
		{
			for(int i=0;i<num;i++)
			{
				
				shiftRight();
				
			}
		}
		
	}
	/**
	*returns a string of the data */
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		
		Node current = firstNode;;
		b.append(" "+current.getData()+" ");
		while(current.getNextNode()!=null)
		{
			current = current.getNextNode();
			b.append(" "+current.getData()+" ");
		}
		return b.toString();
	}
		
		
		
}
	


