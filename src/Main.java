
// Created by David Naelitz
// Nov 10 2015
// created for EECS
// This program will use four sorting algorithms and 
// compare them to see which sort will work faster.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
	// Shows Main where to find the text document.
	static String FILE_NAME = "C:/Users/david_000/Downloads/DavidNaelitzWorkspace/EECS-2500NaelitzDavid/HamletLists/Hamlet/src/Hamlet.txt";

	static LinkedList<String> link = new LinkedList<>();
	static FileReader fileReader;
	static SortedLinkedList<String> sorted;
	static SelfAdjustingList<String> selfAdjust;
	static SelfAdjustingBubble<String> selfBubble;
	static BinaryTree<String> bTree;
	static int count = 0;
	static int totalCount = 0;

	public static void main(String[] args) throws IOException
	{
		// This initializes a string to send line by line
		// to the linked list.
		String line = null;

		// FileReader reads text files in the default encoding.
		// This will open a BufferedReader as well and as long as
		// there is another line to read it will continue to send
		// one line at a time to be parsed and split into words.

		try
		{
			// Will create start time for overhead.
			long timerStart = System.currentTimeMillis();
			FileReader fileReader = new FileReader(FILE_NAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// Sends one line of the text file at a time to be parsed
			// and to eliminate punctuation.
			while ((line = bufferedReader.readLine()) != null)
			{
				calcOverhead(line);
			}

			System.out.println("The Overhead is " + (System.currentTimeMillis() - timerStart) + " ms.");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creates a new FileReader to go back to an unsorted version
		// of the document. This try block starts the creation
		// of the unsorted list.
		try
		{
			// Resets both variables so the counts will not carry over.
			count = 0;
			totalCount = 0;

			// Starts timer for unsorted list.
			long unsortStart = System.currentTimeMillis();
			fileReader = new FileReader(FILE_NAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// While there is another line in the text field send it to
			// be parsed and put into linked list.
			while ((line = bufferedReader.readLine()) != null)
			{
				createList(line);

			}

			// Goes through the list once it is complete and takes count
			// of the individual nodes as well as how many times each node has
			// been counted.
			while (link.first != null)
			{
				totalCount += link.first.count;
				count++;
				link.remove();
			}
			System.out.print("Total Count: " + totalCount);
			System.out.println(" Count: " + count);

			System.out.println("The unsorted list took " + (System.currentTimeMillis() - unsortStart) + " ms.");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// This try block reopens hamlet to try the first sorted list
		// This list will be in alphabetical order.
		try
		{
			totalCount = 0;
			count = 0;

			// This will be the start time for the alphabetical sort.
			long abcStart = System.currentTimeMillis();
			fileReader = new FileReader(FILE_NAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null)
			{
				sorted.createList(line);

			}

			// while the sorted list is not empty traverse the list and
			// count the nodes and time each node was used.
			while (sorted.link.first != null)
			{
				totalCount += sorted.link.first.count;
				count++;
				sorted.link.remove();
			}
			System.out.print("Total Count: " + totalCount);
			System.out.println(" Count: " + count);

			System.out
					.println("The alphabetically sorted list took " + (System.currentTimeMillis() - abcStart) + " ms.");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// This will create the Front self adjusting list.
		try
		{
			count = 0;
			totalCount = 0;
			// Will be used as start time of self adjusting list.
			long selfAdjustStart = System.currentTimeMillis();
			fileReader = new FileReader(FILE_NAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// while the file has another line of input continue to
			// create nodes and parse each line.
			while ((line = bufferedReader.readLine()) != null)
			{
				selfAdjust.createList(line);

			}
			System.out.println("Self Adjusting Sort took " + (System.currentTimeMillis() - selfAdjustStart) + " ms.");

			// while the list is not empty continue to count.
			while (selfAdjust.link.first != null)
			{
				totalCount += selfAdjust.link.first.count;
				count++;
				// Because this is one of the self sorting lists this
				// makes sure to print off the first 100 words along
				// with the number of times that word was used.
				if (count <= 100)
				{
					System.out.println(selfAdjust.link.first.value.toString());
					System.out.println(" <- word count: " + selfAdjust.link.first.count);
				}
				selfAdjust.link.remove();
			}
			System.out.println(totalCount);
			System.out.println(count);

		}

		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// This will create the self bubble sorting list.
		try
		{
			count = 0;
			totalCount = 0;
			
			// this will be the start time for the bubble sort list.
			long selfBubbleStart = System.currentTimeMillis();
			fileReader = new FileReader(FILE_NAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// while there is still input continue to create the list.
			while ((line = bufferedReader.readLine()) != null)
			{
				selfBubble.createList(line);

			}
			System.out.println("Bubble test took " + (System.currentTimeMillis() - selfBubbleStart) + " ms.");

			// while the list is not empty continue to count.
			while (selfBubble.link.first != null)
			{
				totalCount += selfBubble.link.first.count;
				count++;
				// Because this is one of the self sorting lists this
				// makes sure to print off the first 100 words along
				// with the number of times that word was used.
				if (count <= 100)
				{
					System.out.println(selfBubble.link.first.value.toString());
					System.out.println(" <- Word Count: " + selfBubble.link.first.count);
				}
				selfBubble.link.remove();
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			count = 0;
			totalCount = 0;
			
			// this will be the start time for the bubble sort list.
			long bTreeStart = System.currentTimeMillis();
			fileReader = new FileReader(FILE_NAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// while there is still input continue to create the list.
			while ((line = bufferedReader.readLine()) != null)
			{
				bTree.createList(line);

			}
			System.out.println("BTREE " + (System.currentTimeMillis() - bTreeStart) + " ms.");

			// while the list is not empty continue to count.
			bTree.link.stat();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void calcOverhead(String line)
	{
		line = line.replaceAll("\\p{Punct}", "");

		for (String s : line.split(" "))
		{

		}
	}

	static void createList(String line)
	{
		line = line.replaceAll("\\p{Punct}", "");

		for (String s : line.split(" "))
		{

			if (s.isEmpty())continue;
			
			else if (link.length == 0)
				link.add(new Node<String>(s.toLowerCase()));
			else if (link.doesNotExist(s.toLowerCase()))
				link.add(new Node<String>(s.toLowerCase()));
		}

	}

}
