//Written by Austin Hetherington

import java.util.Scanner;
public class PhobiasFrontEnd {

	public static void main(String[] args) {
		System.out.println("Welcome to the fear hash table!");
		PhobiaHashTable phobia = new PhobiaHashTable();
		boolean exit = false;
		Scanner keyboard = new Scanner(System.in);
		//main interface while loop which exits when user selects the exit choice
		while(!exit)
		{
			System.out.println("\nEnter\n1. To add a fear\n2. To remove a fear\n3. To look up a fear\n4. Print all fears\n5. Quit");
			int choice = keyboard.nextInt();
			//add phobia choice
			if(choice==1)
			{
				keyboard.nextLine();
				System.out.println("What is the fear’s name");
				String name = keyboard.nextLine();
				System.out.println("Description of fear");
				String desc = keyboard.nextLine();
				//creates phobia to be added to hash table
				Phobias n = new Phobias();
				n.setName(name);
				n.setDescription(desc);
				phobia.add(n);
			}
			//remove phobia choice
			else if(choice==2)
			{
				keyboard.nextLine();
				System.out.println("What is the name of the fear you would like to remove?");
				String name = keyboard.nextLine();
				System.out.println("What is the description of the fear you would like to remove?");
				String desc = keyboard.nextLine();
				phobia.remove(name, desc);
			}
			//look up phobia choice
			else if(choice==3)
			{
				keyboard.nextLine();
				System.out.println("What is the name of the fear you would like to look up?");
				String name = keyboard.nextLine();
				phobia.lookup(name);
			}
			//print all phobias in hash table choice
			else if(choice==4)
			{
				phobia.printHashTable();
			}
			//exit program choice
			else if(choice==5)
			{
				System.out.println("Goodbye Fears!");
				exit=true;
			}
			else System.out.println("That was an invalid selection. Please try again.");
		}

	}

}
