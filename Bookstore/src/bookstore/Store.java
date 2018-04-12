package bookstore;

import java.util.ArrayList;
import java.util.Scanner;

import bookstore.Book;
import bookstore.Item;
import bookstore.User;

/* 
* The Store class is the driver class and provides the admin with menus to navigate through the Store, and to provide them with 
* useful functionality. It allows the admin to add an item to the store and delete an item from the store provided that
* some conditions have been met which are outlined below (this will change when i do my swing gui and database functionality).
* It also provides the admin the ability to buy a book.
* Store administrator is also able to view a full list of the users and the Items in 
* order to see which items have been bought.
* Currently each book has a stock of 1 - this will change and be stock levels will be able to be altered by the admin only.
* 
*/
public class Store {


	private static ArrayList<Book> books;  // an arrayList of books

	private static ArrayList<Item> items;  // an arrayList of items

	static ArrayList<User> users;  // an arrayList of users


	private final static int MAX_CATALOGUE = 10; //sets the MAX CATALOGUE to the value of 10


	private final static int MAX_USERS = User.MAX_USERS; //sets the MAX_USERS of this class to the MAX_USERS from the User Class


	public static void initialiseStore() {


		books = new ArrayList<Book>(MAX_CATALOGUE);  

		items = new ArrayList<Item>(MAX_CATALOGUE); 

		users = new ArrayList<User>(MAX_USERS);  
 

//Initialise the store catalogue with 5 sample books  **this will be changed when i connect the project to a database)

		books.add(new Book

				("A Tale of Two Cities", "Charles", "Dickens",  11111111, 'F'));

		books.add(new Book

				("The Lord of the Rings", "John R. R.", "Tolkien", 22222222, 'F'));

		books.add(new Book

				("A Brief History of Time", "Stephen", "Hawking",  33333333, 'N'));

		books.add(new Book

				("Java Concepts", "Cay S.", "Horstmann",  44444444, 'N'));

		books.add(new Book

				("Moneyball", "Michael", "Lewis",  55555555, 'S'));



		for (int i = 0; i < 5; i++) {

			int bookID = books.get(i).getId();

			items.add(new Item(bookID));

		}

//Initialise the store membership accounts with 4 users

		users.add(new User("Joe", "Bloggs", "joe@hotmail.com", "joe123", "101 St Johns Street, London", "card"));

		users.add(new User("Bill", "Gates", "bill.G8s@gmail.com", "Bill123", "78 Rathmines Rd, Dublin", "card")); 

		users.add(new User("Henry", "Ford", "fordHen@outlook.com", "Henry", "18 Firhouse Abbey, Dublin", "card"));

		users.add(new User("Grace", "Kelly", "graceKelly123@hotmail.com", "gk18", "12 View Rise, Dublin", "card")); 

	}




	public static void main (String[] args) {


		initialiseStore();


		Scanner scan = new Scanner(System.in);

		int menuOption = 0;


		while (true) {

			clearConsole();

			System.out.println("Please Make a selection:");

			System.out.println("[1] Buy item");

			System.out.println("[2] Search for item(s) in Store");

			System.out.println("[3] Store Administration"); 

			System.out.println("[0] Exit"); 

			System.out.print("Enter your choice > ");

//the user input is scanned and menuOption is set to this value

			menuOption = scan.nextInt();


			switch(menuOption) {

			case 0: System.exit(0);

			break; 

			case 1: buyItemMenu();

			break;

			case 2: searchItems();

			break;

			case 3: storeAdminMenu();

			break; 

			default:

				System.out.print("You have input an invalid option. ");

				System.out.println("press enter to continue.");

				pauseMe();

				break;

			} 

		} 

	}



	private static void clearConsole() {

		for (int i=0; i < 100; i++) {

			System.out.println("");

		}

	} 



	private static void pauseMe() {

		Scanner scan = new Scanner(System.in);


		System.out.println("press enter to continue."); 

		scan.nextLine();
 


	}



	public static void buyItemMenu() {


		if (users.size() <= 0) {

			clearConsole();

			System.out.println("The store user accounts are empty. "); 

			pauseMe();

			return;

		}


		if (items.size() <= 0) {

			clearConsole();

			System.out.println("The store's catalogue is empty. "); 

			System.out.println("There are no items available to buy. ");

			pauseMe();

			return;

		}


		Scanner scan = new Scanner(System.in);

		int menuOption = 0;


		while (true) { 

			clearConsole();

			System.out.println("Please Make a selection:");

			System.out.println("1.[1] Buy item from Store "); 

			System.out.println("1.[2] List all items in store");

			System.out.println("1.[3] Return to previous menu");

			System.out.print("Enter your choice > ");


			menuOption = scan.nextInt();


			switch(menuOption) { 

			case 1: buyItemFromStore();

			break;

			case 2: printItems();

			break; 

			case 3: return;

			default:

				System.out.print("You have inputted an invalid option. ");

				pauseMe();

				break;

			}

		}

	}



	public static void storeAdminMenu() {

		Scanner scan = new Scanner(System.in);

		int menuOption = 0;


		while (true) { 

			clearConsole();

			System.out.println("Please Make a selection:");

			System.out.println("4.[1] Add Item."); 

			System.out.println("4.[2] Delete Item."); 

			System.out.println("4.[3] List Items."); 

			System.out.println("4.[4] List Users.");

			System.out.println("4.[5] Return to previous menu.");

			System.out.print("Enter your choice > ");


			menuOption = scan.nextInt();


			switch(menuOption) { 

			case 1: addItem();

			break;

			case 2: deleteItem();

			break; 

			case 3: printItems();

			break;

			case 4: printUsers();

			break;

			case 5: return; 

			default:

				System.out.print("You have inputted an invalid option. ");

				pauseMe();

				break;

			}

		}

	}



//addItem() Adds an item to the store if the store is not at maximum capacity

	public static void addItem(){


		if(items.size() != MAX_CATALOGUE){

//Take in the Title of the book

			System.out.println("Please enter the Item Title > ");

			Scanner scanName = new Scanner(System.in);

			String itemTitle = scanName.nextLine();
//While the item title length is equal to 0, repeat this step so the user has to enter the title of the book

			while(itemTitle.length() == 0){

				System.out.println("The Title of the book can't be blank \n");

				System.out.println("Please enter the Item Title > ");

				scanName = new Scanner(System.in);

				itemTitle = scanName.nextLine();

			}
//Take in the  name of the Author

			System.out.println("First name of author > ");

			Scanner scanAuthor = new Scanner(System.in);

			String authorName = scanAuthor.nextLine();
//While the item author name length is equal to 0, repeat this step so the user has to enter the authors name

			while(authorName.length() == 0){

				System.out.println("The First name of the author can't be blank \n");

				System.out.println("First name of author > ");

				scanAuthor = new Scanner(System.in);

				authorName = scanAuthor.nextLine();

			}

//Take in the surname of the author

			System.out.println("Surname name of author > ");

			Scanner scanSurname = new Scanner(System.in);

			String authorLastName = scanSurname.nextLine();
//While the item author Surname length is equal to 0, repeat this step so the user has to enter the authors Surname

			while(authorLastName.length() == 0){

				System.out.println("The First name of the author can't be blank \n");

				System.out.println("First name of author > ");

				scanSurname = new Scanner(System.in);

				authorLastName = scanSurname.nextLine();

			}


			System.out.println("Please enter Book ID > ");

			Scanner scanBookId = new Scanner(System.in);

			int bookId = scanBookId.nextInt();

			String bookLength = new Integer(bookId).toString();//parse the bookId to a string so we could get the length of the integter.
//While the book id is less than 8 digits in length, repeat this step so the user has to enter the correct book id

			while(bookLength.length() < 8){

				System.out.println("The Id of the Item has to be 8 digits long \n");

				System.out.println("Please enter Book ID > ");

				scanBookId = new Scanner(System.in);

				bookId = scanBookId.nextInt();

				bookLength = new Integer(bookId).toString();

			}


			System.out.println("Category of book ([F]iction, [N]on-fiction, [B]iography, or [S]port) > ");

			Scanner scanCategory = new Scanner(System.in);

			char category = scanCategory.nextLine().charAt(0);
//While the catgory is not equal to capital F, N, B, S and Lower case f,n,b,s then repeat this step

			while(category != 'F' && category != 'f' && category != 'N' && category != 'n' && category != 'B' && category != 'b' && category != 'S' && category != 's'){

				System.out.println(" Please enter a single letter for the Category \n");

				System.out.println("Category of book ([F]iction, [N]on-fiction, [B]iography, or [S]port) > ");

				scanCategory = new Scanner(System.in);

				category = scanCategory.nextLine().charAt(0);

			}


			System.out.println("Item Name : " + itemTitle + "\n FirstName : " + authorName + "\n Surname : " + authorLastName + "\n Book ID : " + bookId + "\n Category : " + category + "\n");

//Add the new book created with the user input, to the Array of Books

			books.add(new Book

					(itemTitle, authorName, authorLastName,  bookId, category));
//Add the book to the Items Array using the Book id

			items.add(new Item(bookId));

			System.out.println("This is the name of the item : " + itemTitle);

			pauseMe();

		}else{

			System.out.println("The Store catalogue is full. The store catalogue limit is " + MAX_CATALOGUE + " items. ");

			pauseMe();

		}


	}//end Method

//deleteItem() is used to delete an item from the items array and to delete
//the corresponding book from the book array when certain conditions are met

	public static void deleteItem(){
//If the users isnt empty

		if(!items.isEmpty()){

			Scanner scan = new Scanner(System.in);//Create a scanner

			System.out.println("Please enter the ID of the Item to be deleted > ");

			int idOfItem = scan.nextInt(); // Scan the user input and assign it to the int idOfItem
//If the item with the id passed in by the user is in the store
//Calls isItemInLibrary(int Id) from Store

			if(isItemInStore(idOfItem)){
//For each of the books in the books array

				for(int i = 0; i < books.size(); i++){

					books.get(i).getId();//get the id of the book

					if(idOfItem == books.get(i).getId()){//if the idOfItam passed in by the user is equal to the book id

						if(items.get(i).isOutOfStock() == false){//if the book is not out of stock , calls isOutOfStock from Item

							items.remove(i);//remove the item from the items array

							books.remove(i);//remove the book from the books array

							System.out.println("This is the id of the book to be deleted : " + idOfItem + "\n");


							pauseMe();

						}

					}

				}

				printItems(); //Calls printItems() from Store

			}else{

				System.out.println("The item with ID : " + idOfItem + " cannot be deleted as it does not exist!!");

			}

		}else{

			System.out.println("The store catalogue is empty or the Item with this id does not exist ");

		}

		pauseMe();

	}//end method

//printItems() prints out a list of all the items in the Items array

	public static void printItems(){

//if the items array is empty then print out a message to say so

		if(items.isEmpty()){

			System.out.println(" \n There are no items in the Store \n");

		}else{//otherwise

			System.out.println("\n This is a list of all the Items \n");
//for each of the items in the items array

			for (int i = 0; i < items.size(); i++){

				System.out.println("Book name : " + books.get(i).getTitle() + "\n");//get the item title and print it out

				System.out.println("Item: " + items.get(i).getId()+ "\n");//get the item id and print it out

				System.out.println("Out of Stock: " + items.get(i).isOutOfStock()+ "\n");//print out if the item is on loan or not

				System.out.println("User ID: " + items.get(i).getUserId()+ "\n");//print out the user id of the item

				System.out.println("----------------------------------");

			}

			pauseMe();

		}

	}//end Method

//printUsers() prints out a list of all the Users in the Users array

	public static void printUsers(){
//If the users array is empty

		if(users.isEmpty()){

			System.out.println("\n The store's user account are empty \n");

		}

		else{//otherwise do this

			System.out.println("\n This is a list of all the Users \n");
//for each of the users in the users array print out the user

			for (int i = 0; i < users.size(); i++){

				System.out.println("User" + users.get(i)+ "\n");

			}

		}

		pauseMe();

	}//end Method


//buyItemFromStore() allows a user to buy an item from the store
//when certain conditions are met, Like if the item exists, the user exists and 
//the item is not out of stock. This method will also produce a message to indicate to 
//the store admin that a condition has not been met.

	public static void buyItemFromStore(){ 


		Scanner bookScan = new Scanner(System.in);//Create a scanner to scan a book

		int itemIdentifier = 0;

		System.out.println("Please enter the name of the book you want to lend! \n");

		String bookName = bookScan.nextLine();//sets the value of the bookName variable to the value inputed by the user
//while the length of the bookName is equal to zero, repeat this step so 
//that the user has to enter the name of the book

		while(bookName.length() == 0){

			System.out.println("You cant leave the book name blank!");

			System.out.println("Please enter the name of the book you want to lend! \n");

			bookScan = new Scanner(System.in);

			bookName = bookScan.nextLine();

		}


		System.out.println("Please enter the Id of the User > ");

		Scanner userScan = new Scanner(System.in);//create a new scanner

		int userIdentifier = userScan.nextInt();//set the value of the userIdentifier variable to the input of the user

		int counter = 0;//set the value of the counter variable to zero

//for each of the books in the books array

		for(int i = 0; i < books.size(); i++){
//if the book name entered by the user is equal to the book title in the array.
//and the user is in the users array

			if(bookName.equals(books.get(i).getTitle()) && isUserInStore(userIdentifier)){
//for each of the users in the array

				for(int num = 0; num < users.size(); num++){

//If the iten is not on loan

					if(items.get(i).isOutOfStock() == false){//calls isOutOfStock from Item
//increment the counter variable to indicate that a book has been borrowed

						counter++;

//if the user id entered by the admin is equal to the id of the user in the array

						if(userIdentifier == users.get(num).getId()){

//if the user has borrowed less than 3 books

							if(users.get(num).getNumOfItemsBought() < 3){//calls getNumOfItemsBought() from User

								items.get(i).buyItem(userIdentifier);//borrow the item using the users id, calls borrowItem(int userID) from Item
//print messages to indicate the book was borrowed

								System.out.println("Item has been bought : " + bookName);

								System.out.println("The User that bought it is : " + items.get(i).getUserId());

							}

						}


					}

				}

			}

		}

//if the counter that gets incremented when a book is bought is equal to zero
//then print this message

		if(counter == 0){

			System.out.println("We did not find a match for either the user id, or the book title");

		}

		pauseMe();


	}//end Method

//searchItems() allows admin to search for a particular item in the store.

	public static void searchItems(){
//items in the array get() the Book title and if the String entered matches the title then match

		System.out.println("Please enter the title of the book you want to view > ");

		Scanner scan = new Scanner(System.in);//create a new scanner

		String searchInput = scan.nextLine();//set the value of the searchInput variable to the value of the scanned input 

		String myString = "";//create a local variable called myString
//while the search inputed by the user is left blank , repeat this step so
//that the admin has to enter some text

		while(searchInput.length() == 0){

			System.out.println("The Search can't be blank \n");

			System.out.println("Please enter the title of the book you are looking for > ");

			scan = new Scanner(System.in);

			searchInput = scan.nextLine();

		}


		int numOfItemsFound = 0;//create a local variable called numOfItemsFound and set the value to 0.

//if the items array is NOT empty

		if(!items.isEmpty()){
//for each of the books in the array, get the title

			for(int i = 0; i < books.size(); i++){

				myString = books.get(i).getTitle();//set the value of the myString variable to the book title

//if the title found matches the search input or starts with the search input
//increment the numOfItemsFound and print each book found

				if(searchInput.matches(myString) || myString.startsWith(searchInput)){

					numOfItemsFound++;//increment the number of items variable by 1

					System.out.println("System has found a match for this book :  \n");
//Prints the book that was found

					System.out.println("Book Title: " + books.get(i).getTitle()+ "\n");

					System.out.println("Author Name : " + books.get(i).getAuthorFirstName()+ " " + books.get(i).getAuthorLastName() + "\n");

					System.out.println("Book Id : " + books.get(i).getId()+ "\n");

					System.out.println("Category : " + books.get(i).getCategory()+ "\n");
//include stock value


					System.out.println("Your search is complete");

				}

			}

//if the number of books found is equal to zero print the meassage
//else print number of books found

			if(numOfItemsFound == 0){

				System.out.println("We could not find a book that matches that description");

			}else{

				System.out.println("Found " + numOfItemsFound + " items in total");

			}
//if the items array is empty then print the message

		}else{

			System.out.println("The Store has no items in it");

		}

		pauseMe();


	}//end Method

//isUserInStore(int userID) checks if the user id entered in the parameter exists in the user array
//return true if it does and return false if it doesnt

	public static boolean isUserInStore(int userID){

		for(int i = 0; i < users.size();){
//If the parameter entered(userID) is equal to any of the users in the array
//return true otherwise return false

			if(userID == users.get(i).getId()){

				return true;


			}

			i++;//increment i by 1

		}

		return false;

	}//end Method

//isItemInStore(int itemID) checks if the item id entered as a parameter exists if the array.
//return true of t does and return false if it doesnt

	public static boolean isItemInStore(int itemID){ 

		for(int i = 0; i < items.size();){
//If the parameter entered is equal to any of the item id's
//in the array then return true

			if(itemID == items.get(i).getId()){

				return true;


			}

			i++;

		}

		return false;

	}//end Method

}//end Class
