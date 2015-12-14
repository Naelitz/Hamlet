// This list will sort itself by using a bubble method.
// New words will be added to the front of the list, and 
// words that already exist within the list will be moved forward
// one when current finds it. When current finds the word 
// a current will get previous link but previous will be following 
// two behind and previous will link to current.
public class SelfAdjustingBubble<T> extends LinkedList<T>
{
	static SelfAdjustingBubble<String> link = new SelfAdjustingBubble<>();
	static long comparisons = 0;
	
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
		{
			current = first;	// Starts at front of the list.
			previous = null;
			Node<T> previousSquared = null; // extra previous to stay two behind
											// for when a node needs to bubble up.

			// if the list is empty just add the node. 
			if (first == null)
			{
				nodeAdd(node);
			}

			else
			{
				current = first;
				
				// If the first node is the same just increase count.
				comparisons++;
				if (first.value.equals(node.value.toString()))
				{
					first.count++;
					return;
				}
				
				// If the second node matches increase count
				// set previous node link to current and set current link to previous.
				comparisons++;
				if (current.value.equals(node.value.toString()) && previousSquared == null 
						&& previous != null)
				{
					current.count++;
					referenceChange+=2;
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
					comparisons++;
					if (current.value.equals(node.value.toString()) && previousSquared != null)
					{
						current.count++;						// increase count of node
						referenceChange+=3;
						previous.setLink(current.getLink());	// previous goes down list one
						current.setLink(previous);				// current now refers to previous
						previousSquared.setLink(current);		// 2nd previous now refers to current
						return;
					}
				
					previousSquared = previous;
					previous = current;
					current = current.getLink();
				}
				nodeAdd(node);
				
			}
		}
	}
	
	void nodeAdd(Node<T> node)
	{
		node.setLink(first);
		referenceChange++;
		node.count++;
		first = node;
		length++;
	}
}
