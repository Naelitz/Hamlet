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
		//If tree is empty set root.
		if (first == null) 
			{
				first = node;
				referenceChange+=1;
			}
		//else compare and search tree for corrent leaf location.
		else
			{	
				do
				{
					compared = current.compare(node);
					comparisons+=1;
					//If the compared node is the same increment count.
					if(compared == 0)current.count+=1;
					//If it is greater then compared node follow branch right
					//if that branch is empty place leaf.
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
					//If it is less then compared node follow branch left
					//if that branch is empty place leaf.
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
	//This will recursively add the count value of every node in the tree.
	int sum(TreeNode<T> node)
	{
		//Add the count of the current node called
		int result = node.count;
		distinct+=1;
		//If branches are not empty call those as well.
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
