import java.util.*;
public class PhobiaHashTable {
	private ArrayList<Phobias>[] table;
	//default constructor of hash table
	public PhobiaHashTable()
	{
		//26 buckets for each letter of alphabet
		table = new ArrayList[26];
		for(int i = 0; i<table.length; i++)
		{
			table[i] = new ArrayList<Phobias>();
		}
	}
	//method which calculates index based on a passed in phobia
	private int calculateIndex(Phobias aPhobias)
	{
		int index = 0;
		index = aPhobias.getName().toLowerCase().charAt(0) - 'a';//subtracts ascii value by a's so they are on same level and you don't have something above 25
		return index;	
	}
	//method which calculates index based on a passed in string of the key
	private int calculateIndex(String key)
	{
		int index = 0;
		index = key.toLowerCase().charAt(0) - 'a';//subtracts ascii value by a's so they are on same level and you don't have something above 25
		return index;
	}
	//method which adds a passed in phobia to the the appropriate bucket
	public void add(Phobias aPhobias)
	{
		int index = calculateIndex(aPhobias);
		table[index].add(aPhobias);
	}
	//method which removes a phobia if the name and description match
	public void remove(String name, String description)
	{
		int index = calculateIndex(name);
		//creates a temp phobia which will be used to compare to the phobias in the bucket
		Phobias temp = new Phobias();
		temp.setName(name);
		temp.setDescription(description);
		boolean found = false;
		//goes through bucket and checks if any of the phobias are identical
		for(Phobias p : table[index])
		{
			if(temp.equals(p))//case where phobias match so it removes it
			{
				table[index].remove(p);
				System.out.println("Removed!");
				found = true;
				break;
			}
		}
		if(!found)//case where the phobia searched was not found
		{
			System.out.println("Phobia not found");
		}
	}
	//method which takes a string of the name and will output the corresponding description
	public void lookup(String name)
	{
		int index = calculateIndex(name);
		boolean found = false;
		//goes through index bucket and if it finds a matching name, provides corresponding description
		for(Phobias p : table[index])
		{
			if(name.equalsIgnoreCase(p.getName()))//case where names match
			{
				System.out.println("The description of "+name+" is: "+p.getDescription());
				found = true;
				break;
			}
		}
		if(!found)//case where no matching names were found
		{
			System.out.println("Phobia not found");
		}
	}
	//method which runs through entire table and prints every phobia inside it
	public void printHashTable()
	{
		for(int i=0; i<table.length; i++)//for loop going through each bucket
		{
			for(Phobias p : table[i])//for loop finding each phobia in the current bucket
			{
				System.out.println(p.toString());
			}
		}
	}
	
}
