
public class Node <T>
{
	T value; // makes value general so it can be any type.
	int count = 1;
	Node<T> next; 
	
	Node(T symbol)
	{
		value = symbol; // Gives the node a value or symbol.
	}
	
	void setLink(Node<T> n) // links to the next node
	{
		next = n;
	}
	
	Node<T> getLink()
	{
		return next; // returns the next node.
	}
	
	public String toString()
	{
		String string = (String)value;
		return string;
	}
	
	
}
