package singletondesignpattern;

import java.util.HashMap;
import java.util.Map;

public class Library {
	//private HashMap books;
	private HashMap<String, Integer> BOOKS = new HashMap<String, Integer>();
	private static Library library;



private Library() {}

public static Library getInstance()
{
	if(library == null) {
		System.out.println("Creating our library. Time to begin reading");
		library = new Library();
	}
	return library;
}

public boolean checkoutBook(String bookName)
{
	if(BOOKS.containsKey(bookName))
	{
		int copies = BOOKS.get(bookName);
		if(copies >= 1)
		{
			BOOKS.put(bookName, copies-1);
			System.out.println(bookName + " was succesfullu checked out");
			return true;
		}
		else
		{
			System.out.println("Sorry, " + bookName + " is not in stock");
		}
		
	}
	return false;
}

public void checkInBook(String bookName, int numToAdd)
{
	if(BOOKS.containsKey(bookName))
	{
		int copies = BOOKS.get(bookName);
		BOOKS.put(bookName,  copies + numToAdd);
	}
	else
	{
		BOOKS.put(bookName, numToAdd);
	}
	System.out.println( bookName +"was added to the library");
}

public void displayBooks()
{
	System.out.println("Inventory: ");
	for(Map.Entry<String, Integer>entry : BOOKS.entrySet()) 
	{
		System.out.println("-" + entry.getKey() + ", copies: " + entry.getValue());
	}
}

}