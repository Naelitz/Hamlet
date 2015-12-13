
public class SortedLinkedList
{
	static LinkedList<String> link = new LinkedList<>();
	
	static void createList(String line)
	{
		line = line.replaceAll("\\p{Punct}", "");
		
		for(String s : line.split(" "))
		{
			if(s.isEmpty()) continue;
			link.selfAdjustAdd(new Node<String>(s.toLowerCase()));
		}
		
		
	}
}
