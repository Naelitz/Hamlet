
public class SortedLinkedList<T> extends LinkedList<T>
{
	static SortedLinkedList<String> link = new SortedLinkedList<>();
	
	static void createList(String line)
	{
		line = line.replaceAll("\\p{Punct}", "");
		
		for(String s : line.split(" "))
		{
			if(s.isEmpty()) continue;
			link.add(new Node<String>(s.toLowerCase()));
		}
		
		
	}
	
	@Override
	void add(Node<T> node)
	{
		current = first;	// Starts searching the list from the beginning.
		previous = null;

		if (length == 0)	// if the list is empty just add the new node. 
		{
			nodeAdd(node);
		}

		else
		{
			// Compares the new node to the first node if the new node comes first 
			// then add node to the front of the list. 
			int compFirst = node.value.toString().compareToIgnoreCase(first.value.toString());
			if (compFirst > 0)
			{
				nodeAdd(node);
			}

			else
			{
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
	}
	
	void nodeAdd(Node<T> node)
	{
		node.setLink(first);
		node.count++;
		first = node;
		length++;
	}
}
