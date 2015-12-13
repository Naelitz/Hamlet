// This is used to make the linked list. This class handles 
// the add methods for all the different linked lists.

public class LinkedList<T> // makes a general class
{
	Node<T> first;
	int length = 0;
	Node<T> current;	// Keeps track of the node being looked at.
	Node<T> previous;	// Keeps track of the node ahead of current.

	LinkedList()
	{

	}

	// This will add a node to the front of the list.
	public void add(Node<T> node)
	{
		node.setLink(first);
		node.count++;
		first = node;
		length++;

	}

	// This will remove the first node from the list and shorten the length of the
	// list.
	void remove()
	{
		first = first.getLink();
		length--;
	}

	// This checks to see if the node already exists in the list.
	boolean doesNotExist(String s)
	{
		current = first;
		while (current.getLink() != null)
		{
			if (current.value.equals(s))
			{
				current.count++;
				return false;
			}
			current = current.getLink();
		}
		return true;
	}

	// This controls adding a node to the list in alphabetical order.
	void alphabeticalAdd(Node<T> node)
	{
		current = first;	// Starts searching the list from the beginning.
		previous = null;

		if (length == 0)	// if the list is empty just add the new node. 
		{
			add(node);
		}

		else
		{
			// Compares the new node to the first node if the new node comes first 
			// then add node to the front of the list. 
			int compFirst = node.value.toString().compareToIgnoreCase(first.value.toString());
			if (compFirst > 0)
			{
				add(node);
			}

			else
				do // Used a do while to make sure execution happens atleast once. 
				{
					// Compares the new node to the current node.
					int comp = node.value.toString().compareTo(current.value.toString());
					
					// If the new node is the same as current node then compareTo will return
					// a zero this means they are the same just increase counter and return. 
					if (comp == 0)
					{
						current.count++;
						return;
					}
					
					// If the new node comes before the current node then backtrack one
					// and insert after previous node and corrent links. 
					else if (comp > 0)
					{
						node.setLink(previous.getLink());
						previous.setLink(node);
						return;
					} 
					
					// If the new node comes after the current node then compareTo will return
					// a number less then 0 so keep traversing the list. 
					else if (comp < 0)
					{
						previous = current;
						current = current.getLink();
					}

				} while (current != null);
		}
	}

	
	// This method will take care of adding a new node and putting the most recent
	// node at the beginning of the list. 
	void selfAdjustAdd(Node<T> node)
	{
		current = first; // start traversing from the beginning of the list. 
		previous = null;

		if (first == null)	// If the list is empty just add the node. 
		{
			add(node);
		}

		else
		{
			current = first;
			
			// if the first node is the same as the new node
			// just increase the count and return. 
			if (first.value.equals(node.value.toString()))
			{
				first.count++;
				return;
			}
			
			// While not at the end of the list continue to traverse until you 
			// find the correct node. 
			while (current.getLink() != null)
			{
				// If the correct node is found then add to the count
				// move the node to the front of the list and correct
				// the links. 
				if (current.value.equals(node.value.toString()))
				{
					current.count++;
					previous.setLink(current.getLink());
					current.setLink(first);
					first = current;
					return;
				}
				previous = current;
				current = current.getLink();
			}
			add(node);
		}
	}

	// This handles adding nodes to a list with a bubble method. 
	void selfAdjustBubbleAdd(Node<T> node)
	{
		{
			current = first;	// Starts at front of the list.
			previous = null;
			Node<T> previousSquared = null; // extra previous to stay two behind
											// for when a node needs to bubble up.

			// if the list is empty just add the node. 
			if (first == null)
			{
				add(node);
			}

			else
			{
				current = first;
				
				// If the first node is the same just increase count.
				if (first.value.equals(node.value.toString()))
				{
					first.count++;
					return;
				}
				
				// If the second node matches increase count
				// set previous node link to current and set current link to previous.
				if (current.value.equals(node.value.toString()) && previousSquared == null 
						&& previous != null)
				{
					current.count++;
					previous.setLink(current.getLink());
					current.setLink(previous);
					first = current;
					previousSquared = current;
					return;
				}
				
				// If not at the end of the list continue to traverse the list.
				while (current.getLink() != null)
				{
					// If the current node is the same as the new node and neither of the previous
					// nodes are null then increase count, bubble up one, and return. 
					if (current.value.equals(node.value.toString()) && previousSquared != null)
					{
						current.count++;						// increase count of node
						previous.setLink(current.getLink());	// previous goes down list one
						current.setLink(previous);				// current now refers to previous
						previousSquared.setLink(current);		// 2nd previous now refers to current
						return;
					}
				
					previousSquared = previous;
					previous = current;
					current = current.getLink();
				}
				add(node);
				
			}
		}
	}
}
