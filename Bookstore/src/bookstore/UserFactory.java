package bookstore;

public class UserFactory {

	 public static final String[] usernames = {"leanneRay", "hannahM"}; //using static data because no database connection

	   public static AbstractUser getUser(String username){
	   
	      for (int i = 0; i < usernames.length; i++) {
	         if (usernames[i].equalsIgnoreCase(username)){
	            return new RealUser(username);
	         }
	      }
	      return new NullUser();
	   }
	
}
