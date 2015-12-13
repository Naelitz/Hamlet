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
	void add(Node<T> node)
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
	
	void nodeAdd(Node<T> node)
	{
		node.setLink(first);
		node.count++;
		first = node;
		length++;
	}
}
