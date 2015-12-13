
public class TreeNode <T> implements Comparable 
{
	T value; // makes value general so it can be any type.
	int count;
	TreeNode<T> next; 
	
	TreeNode(T symbol)
	{
		value = symbol;
		
	}
	
	void setLeftChild()
	{
		
	}
	
	void setRightChild()
	{
		
	}
	
	void getLeftChild()
	{
		
	}
	
	void getRightChild()
	{
		
	}
	
	public String toString()
	{
		String string = (String)value;
		return string;
	}
	
	int compare(TreeNode<T> node)
	{
		int compared = String.valueOf(value).compareTo(node.toString());
		return compared;
	}
	
	
}
