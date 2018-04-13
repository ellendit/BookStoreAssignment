package bookstore;


/*Class Item is used to create a item. In order for a item to be created successfully 
* the parameters entered in the constructor have to be entered in the exact order
* they appear.(this will change when i implement swing gui)
* This class also allows you to get the itemId, userID that bought the item
* and if the item is out of stock or not.
*/

public class Item {
		
		private int id;
		private boolean isOutOfStock;
		private int userID;
		public Item(int bookID){
		this.id = bookID;//the Class variable id get set to the bookId passed in the parameter
		this.userID = 0;//the Class variable userId gets set to 0
		this.isOutOfStock = false;//the class variable outOfStock gets set to false

		}

		
		public void buyItem(int userID){
	

			if(isOutOfStock() == false){//if the item is in stock
	
				isOutOfStock = true;//set the value of outOfStock to true

				this.userID = userID;//set the class variable userID to the value of the userID passed as a parameter

				//System.out.println("Your book has been bought \n");

			}else{

				System.out.println("This item is unavailable to buy as it is out of Stock ");

			}
			//User buys an item from the store
		}
	

		public int getId(){

			return id;

		}

		public int getUserId(){

			return userID;

		}


		public boolean isOutOfStock(){

			return isOutOfStock;

		}
}