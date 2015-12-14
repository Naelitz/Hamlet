// This class will sort the list by adding the new 
// word to the beginning of the list. If the word already 
// exists in the list then when current finds it, 
// previous will get currents link and link will move to first.
public class SelfAdjustingList<T> extends LinkedList<T>
{
		static SelfAdjustingList<String> link = new SelfAdjustingList<>();
		static int totalCount = 0;
		static int count = 0;
		static int comparisons = 0;
		
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
		void add(Node<T> node)
		{
			current = first; // start traversing from the beginning of the list. 
			previous = null;

			if (first == null)	// If the list is empty just add the node. 
			{
				nodeAdd(node);
			}

			else
			{
				current = first;
				
				// if the first node is the same as the new node
				// just increase the count and return. 
				comparisons++;
				if (first.value.equals(node.value.toString()))
				{
					first.count++;
					return;
				}
				
				// While not at the end of the list continue to traverse until you 
				// find the correct node. 
				else while (current.getLink() != null)
				{
					// If the correct node is found then add to the count
					// move the node to the front of the list and correct
					// the links. 
					comparisons++;
					if (current.value.equals(node.value.toString()))
					{
						current.count++;
						referenceChange+=2;
						previous.setLink(current.getLink());
						current.setLink(first);
						first = current;
						return;
					}
					else
						{
							previous = current;
						
							current = current.getLink();
						}
				}
				nodeAdd(node);
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



