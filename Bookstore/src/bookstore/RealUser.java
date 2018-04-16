package bookstore;

public class RealUser extends AbstractUser{
	
	public RealUser(String username) {
	      this.username = username;		
	   }
	   
	   @Override
	   public String getUsername() {
	      return username;
	   }
	   
	   @Override
	   public boolean isNil() {
	      return false;
	   }

}
