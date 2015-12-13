//This class will implement a Binary Search Tree to sort words
//in a text document in alphabetical order. Using compareTo if the 
//number is < 0 then branch left, if number is > 0 branch right.
//If the number is ==0 then increment count. 
public class BinaryTree<T> extends LinkedList<T>
{
	TreeNode<T> first;
	int length = 0;
	TreeNode<T> current;	
	TreeNode<T> leftChild;
	TreeNode<T> rightChild;
	static BinaryTree<String> link = new BinaryTree<>();
	
	static void createList(String line)
	{
		line = line.replaceAll("\\p{Punct}", "");
		
		for(String s : line.split(" "))
		{
			if (s.isEmpty()) continue;
			
			link.add(new TreeNode<String>(s.toLowerCase()));
		}
		
	}
	
	void add(TreeNode<T> node)
	{
		current = first;
		if (current == null) first = node;
		else if (current.compareTo(node))
	}
	
	void nodeAdd(TreeNode<T> node)
	{
		if (node)
	}
}
