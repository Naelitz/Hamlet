// This class will sort the list by adding the new 
// word to the beginning of the list. If the word already 
// exists in the list then when current finds it, 
// previous will get currents link and link will move to first.
public class SelfAdjustingList
{
		static LinkedList<String> link = new LinkedList<>();
		static int totalCount = 0;
		static int count = 0;
		
		static void createList(String line)
		{
			line = line.replaceAll("\\p{Punct}", "");
			
			for(String s : line.split(" "))
			{
				if (s.isEmpty()) continue;
				
				link.selfAdjustAdd(new Node<String>(s.toLowerCase()));
			}
			
			
		}
	}



