package bookstore;


/* 
* Class Book is used to create a book. In order for a book to be created successfully 
* the parameters entered in the constructor have to be entered in the exact order
* they appear in the console (for now as this will change when i implement swing gui).
* This class also allows you to get the title, authors name, id and category of the book.
* info for a book is Title, author, price, category, image, etc 
*/

	public class Book {
		
		
		private static Book instance = null;
		   private Book() {
		      // Exists only to defeat instantiation.
		   }

		   public static Book getInstance() {
		      if(instance == null) {
		         instance = new Book();
		      }
		      return instance;
		   }
		
		
		private String title;
		private String author;
	
		private String price;
		private String category;
		//private String image; (need to add in an image)

	
	public Book(String title, String author, String price, String category/*, String image */){
		this.setTitle(title);
		this.author = author;
		this.price = price;
		this.category = category;
		//this.image = image;
	}
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	

	public String getPrice(){
		return price;
	}
	
	public String getCategory(){
		return category;
	}
	
	public String toString(){
		
	   	return "Title: " + getTitle() + "\n" + "Author: " + getAuthor() + "\n" + "\n" +  "Price: " + getPrice() + "\n" +  "Book Category: " + getCategory();
   		
		}




	}
