package bookstore;

import java.util.Random;

/*
 * Class User is used to create a user. In order for a user to be created successfully 
 * the parameters entered in the constructor have to be entered in the exact order
 * they appear(these conditions will change when i implement my database and swing gui).
 * This class also allows you to get the firstName, lastName, userName, id, number of books bought
 * email, password, shippingAddress, payment.
*/

public class User {

	private String firstName;
	private String lastName;
	private String userName;
	private int id;
	private int numOfItemsBought;
	private String email;
	private String password;
	private String shippingAddress;
	private String payment;
	final static int MAX_USERS = 15;


	public User(String firstName, String lastName, String email, String password, String shippingAddress, String payment){
	
		this.firstName = firstName;
	
		this.lastName = lastName;
	
		Random rand = new Random();//create an instance of class Random called rand
	
		int num = rand.nextInt(999);//create a variable called num, and set the value the value to a random number below 999
	
		this.id = num;//the value of the Class id(this.id) is set to the num, the random number generated
	
		this.setEmail(email);
	
		this.setPassword(password);
	
		this.setShippingAddress(shippingAddress);
	
		this.setPayment(payment);

	}

	public String getName(){

		userName = firstName + " " + lastName;//links together the users first name and the second name and assigns it to userName

		return userName;

	}


	public int getId(){

		return id;

	}

	public int getNumOfItemsBought(){

		return numOfItemsBought;

	}

	public String getEmail() {
	
		return email;

	}

	public void setEmail(String email) {
	
		this.email = email;

	}

	public String getPassword() {
	
		return password;

	}

	public void setPassword(String password) {
	
		this.password = password;

	}

	public String getShippingAddress() {
	
		return shippingAddress;

	}

	public void setShippingAddress(String shippingAddress) {
	
		this.shippingAddress = shippingAddress;

	}

	public String getPayment() {
	
		return payment;

	}

	public void setPayment(String payment) {
	
		this.payment = payment;

	}


}
