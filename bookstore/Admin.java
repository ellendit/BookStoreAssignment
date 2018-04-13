package bookstore;

import java.util.Random;

//this data will be added to the database for login purposes.......................could create new admins for new stores.

/*
 * Class Admin is used to create an admin. In order for an admin to be created successfully 
 * the parameters entered in the constructor have to be entered in the exact order
 * they appear. 
*/

public class Admin {

private String firstName;
private String lastName;
private String userName;
private int id;
private String email;
private String password;


public Admin(String firstName, String lastName, String email, String password){
	this.firstName = firstName;
	this.lastName = lastName;
	Random rand = new Random();//create an instance of class Random called rand
	int num = rand.nextInt(999);//create a variable called num, and set the value the value to a random number below 999
	this.id = num;//the value of the Class id(this.id) is set to the num, the random number generated
	this.setEmail(email);
	this.setPassword(password);

}
public String getName(){
userName = firstName + " " + lastName;//links together the users first name and the second name and assigns it to userName
return userName;
}

public int getId(){
return id;
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

}
