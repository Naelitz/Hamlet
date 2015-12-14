
public class TreeNode <T>
{
	T value; // makes value general so it can be any type.
	int count = 1; 
	TreeNode<T> leftChild;
	TreeNode<T> rightChild;
	
	TreeNode(T symbol)
	{
		value = symbol;
		leftChild = null;
		rightChild = null;
		
	}
	
	void setLeftChild(TreeNode<T> node)
	{
		leftChild = node;
	}
	
	void setRightChild(TreeNode<T> node)
	{
		rightChild = node;
	}
	
	TreeNode<T> getLeftChild()
	{
		return leftChild;
	}
	
	TreeNode<T> getRightChild()
	{
		return rightChild;
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
