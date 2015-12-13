// This list will sort itself by using a bubble method.
// New words will be added to the front of the list, and 
// words that already exist within the list will be moved forward
// one when current finds it. When current finds the word 
// a current will get previous link but previous will be following 
// two behind and previous will link to current.
public class SelfAdjustingBubble extends LinkedList
{
	static LinkedList<String> link = new LinkedList<>();
	
	static void createList(String line)
	{
		line = line.replaceAll("\\p{Punct}", "");
		
		for(String s : line.split(" "))
		{
			if (s.isEmpty()) continue;
			
			link.selfAdjustBubbleAdd(new Node<String>(s.toLowerCase()));
		}
		
	}
	
	@Override
	public void add(Node<T> node)
	{
		
	}
}
