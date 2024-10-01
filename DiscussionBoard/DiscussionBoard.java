import java.util.Scanner;

public class DiscussionBoard {

	public static void main(String[] args) {



		Scanner kbd = new Scanner(System.in);
		String[] discussion = new String[10];
		String[] name = new String[10];
		String answer;

		//keep track of post amount as we go

		int postAmount = 0;


		boolean running = true;

		System.out.println("Welcome to the Discussion Board Program");
		

		while (running) {
			
			System.out.println("(1)Post new message");
			System.out.println("(2)Print all posts");
			System.out.println("(3)Print all posts in reverse order");
			System.out.println("(4)Print number of posts entered so far");
			System.out.println("(5)Print all posts from a user");
			System.out.println("(6)Print the number of vowels across all posts");
			System.out.println("(7)Perform a search of posts containing a given word (case sensitive)");
			System.out.println("(8)Perform a search of posts containing a given word (case insensitive");
			System.out.println("(9)End Program.");

			System.out.println("Select an option from the above menu. (1-9)");
			int selection = kbd.nextInt();

			kbd.nextLine();

			if (selection == 1) {
				// Check if the discussion board is full
				
				if (postAmount >= 10) {
					System.out.println("Error: Discussion board is full. Cannot add more posts.");
					break;
				} else if (postAmount < 10) {
					do{
						System.out.println("Enter your name:");
						String tempName = kbd.nextLine();
					
						System.out.println("Enter your discussion post message:");
						String tempDiscussion = kbd.nextLine();
					
						name[postAmount] = tempName;
						discussion[postAmount] = tempDiscussion;
			
						// Print the post immediately
						System.out.println(name[postAmount] + " says: " + discussion[postAmount]);
						postAmount++; // Increment post count
			
						do{
							System.out.println("Do you want to add another post? (yes/no)");
							answer = kbd.nextLine();
							if (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
								System.out.println("Invalid response. Please enter yes or no.");
							} 
						} while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
					} while (answer.equalsIgnoreCase("yes") && postAmount < 10);
					// Continue looping until a valid response is received
				}
			} else if (selection == 2) {

				//task 2 - print all posts

				//iterate through their posts
				if (postAmount == 0){
					System.out.println("No posts to display.");
				} else {
					for (int i = 0; i < postAmount; i++) {
						System.out.println(name[i] + " says: " + discussion[i]);
					}
				}
			
			} else if (selection == 3) {
				//task 3
				//print all posts in reverse order
				System.out.println("Printing all posts in reverse order: ");

				//iterate through all posts starting from last and decrement
				if (postAmount == 0){
					System.out.println("No posts to display.");
				} else {
					for (int i = postAmount - 1; i >= 0; i--) {
						System.out.println(name[i] + " says: " + discussion[i]);
					}
				}
				
			} else if (selection == 4) {
				//task 4
				//amount of posts
				
			
				System.out.println ("number of posts entered so far: " + postAmount);

			} else if (selection == 5){
				//start by searching the name

				System.out.println("Enter a name to search for all their posts:");
				String searchName = kbd.nextLine();

				//close kbd to prevent resource leak
				//kbd.close();

				if (postAmount == 0){
					System.out.println("No posts found.");
				} else {
					//print all their posts
					System.out.println("Posts from " + searchName + ":");

					boolean foundPost = false;	//flag to see if post exists

					//iterate through their posts
					for (int i = 0; i < postAmount; i++) {
						//cases, if discussion isnt empty and the name matches 
						if (discussion[i] != null && name[i] != null && name[i].toLowerCase().startsWith(searchName.toLowerCase())) {
							System.out.println(name[i] + " says: " + discussion[i]);
							foundPost = true;
						}
					}

					if (!foundPost) {
						System.out.println("No posts found by " + searchName);
					}
				}

			} else if (selection == 6) {
				//task 6
				//count vowels across all posts
				int totalVowels = 0;

				String vowels = "aeiouAEIOU";

				if (postAmount == 0){
					System.out.println("No posts found.");
				} else {
					for (int i = 0; i < postAmount; i++){
						String posts = discussion[i];
						for(int j=0; j<posts.length(); j++){
							//go through each letter of a post
							char letter = posts.charAt(j);
							//see if the character matches up to a vowel
							if (vowels.indexOf(letter) != -1){
								totalVowels++;
							}
						}
					}
	
					if (totalVowels > 0) {
						System.out.println("Amount of vowels across all posts " + totalVowels);
					} else {
						System.out.println("No vowels found across all posts.");
					}
				}

			} else if (selection == 7){
				//task 7
				//find a post with the word in it
				System.out.println("Please enter the word you are searching for.");
				String searchWord = kbd.nextLine();

				if (postAmount == 0){
					System.out.println("No posts found.");
				} else {
					//if the word exists across the posts, found will be true
					boolean found = false; 

					for (int i = 0; i < postAmount; i++) {
						if (discussion[i].contains(searchWord)) { // Check if the word is a substring in any of the posts
							System.out.println(name[i] + " says: " + discussion[i]);
							//word exists
							found = true;
						}
					}
					//case where its not substring or not found
					if (!found){
						System.out.println("No posts were found containing the word " + searchWord);
					}
		
				}
			
			} else if (selection == 8) {
			
				//task 8
				//apply the same logic but have it case insensitive, converting any input words to lowercase
				boolean found = false;

				System.out.println("Please enter the word you are searching for.");
				String searchWord = kbd.nextLine();

				if (postAmount == 0){
					System.out.println("No posts found.");
				} else {

    				String lowerCaseSearchWord = searchWord.toLowerCase(); // Convert the search word to lowercase

    				for (int i = 0; i < postAmount; i++) {
        				String lowerCasePost = discussion[i].toLowerCase(); // Convert each post to lowercase

        				if (lowerCasePost.contains(lowerCaseSearchWord)) { // Check if the word is a substring
            				System.out.println(name[i] + " says: " + discussion[i]);
            				found = true;
        				}
    				}

    				if (!found) {
        			System.out.println("No posts found containing the word: " + searchWord);
    				}
				}

			} else if (selection == 9) {
				System.out.println("Exiting program.");
				//exit the main loop
				running = false;

			} else {
				System.out.println("Invalid selection. Please enter a number 1-9.");
			}
		}

		//close scanner
		kbd.close();

	}
}