//This class will implement a Binary Search Tree to sort words
//in a text document in alphabetical order. Using compareTo if the 
//number is < 0 then branch left, if number is > 0 branch right.
//If the number is ==0 then increment count. 
public class BinaryTree<T>
{
	int distinct = 0;
	int totalCount = 0;
	int comparisons = 0;
	int addedNodes = 0;
	
	
	TreeNode<T> first;
	int length = 0;
	TreeNode<T> current;
	int referenceChange;
	int compared;
	
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
		if (first == null) 
			{
				first = node;
				referenceChange+=1;
			}
		else
			{
				compared = current.compare(node);	
				comparisons+=1;
				
				do
				{
					compared = current.compare(node);
					comparisons+=1;
					if(compared == 0)current.count+=1;
					else if(compared > 0)
					{
						if(current.getRightChild() == null)
						{
							current.setRightChild(node);
							referenceChange+=1;
							break;
						}
						else 
							{
								current = current.getRightChild();
								comparisons+=1;
							}
					}
					else if(compared < 0)
					{
						if(current.getLeftChild() == null)
						{
							current.setLeftChild(node);
							referenceChange+=1;
							break;
						}
						else 
						{
							current = current.getLeftChild();
							comparisons+=1;
						}
					}
				}while (compared != 0);
			}
		
	}
	
	void stat()
	{
		System.out.print("Comparisons made: " + comparisons);
		System.out.print(" Refrence changes: " + referenceChange);
		System.out.print(" Total words: " + sum(first));
		System.out.print(" Distinct words: " + distinct);
		
	}
	
	int sum(TreeNode<T> node)
	{
		int result = node.count;
		distinct+=1;
		if(node.getLeftChild() != null)
		{
			result += sum(node.getLeftChild());
		}
		if(node.getRightChild() != null)
		{
			result += sum(node.getRightChild());
		}
		return result;
	}
	
	
}
