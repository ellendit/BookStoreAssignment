package bookstore;


/* 
* Class Book is used to create a book. In order for a book to be created successfully 
* the parameters entered in the constructor have to be entered in the exact order
* they appear in the console (for now as this will change when i implement swing gui).
* This class also allows you to get the title, authors name, id and category of the book.
* info for a book is Title, author, price, category, image, etc 
*/

	public class Book {
		private String title;
		private String authorFirstName;
		private String authorLastName;
		private String authorName;
		private int id;
		private char category;
		//private String image; (need to add in an image)

	
	public Book(String title, String authorFirstName, String authorLastName, int id, char category/*, String image */){
		this.title = title;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.id = id;
		this.category = category;
		//this.image = image;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthorName(){
		authorName = authorFirstName + " " + authorLastName;//links together the authors first name and the second name and assigns it to authorName
		return authorName;
	}

	public String getAuthorFirstName(){
		return authorFirstName;
	}

	public String getAuthorLastName(){
		return authorLastName;
	}

	public int getId(){
		return id;
	}
	
	public char getCategory(){
		return category;
	}
	
	public String toString(){
		
	   	return "Title: " + getTitle() + "\n" + "Author First Name: " + getAuthorFirstName() + "\n" +  "Author Surname: " + getAuthorLastName() + "\n" +  "Book ID: " + getId() + "\n" +  "Book Category: " + getCategory();
   		
		}
	}
