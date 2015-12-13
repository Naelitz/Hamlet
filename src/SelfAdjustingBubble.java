// This list will sort itself by using a bubble method.
// New words will be added to the front of the list, and 
// words that already exist within the list will be moved forward
// one when current finds it. When current finds the word 
// a current will get previous link but previous will be following 
// two behind and previous will link to current.
public class SelfAdjustingBubble<T> extends LinkedList<T>
{
	static SelfAdjustingBubble<String> link = new SelfAdjustingBubble<>();
	
	static void createList(String line)
	{
		line = line.replaceAll("\\p{Punct}", "");
		
		for(String s : line.split(" "))
		{
			if (s.isEmpty()) continue;
			
			link.add(new Node<String>(s.toLowerCase()));
		}
		
	}
	
	@Override
	public void add(Node<T> node)
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
}
