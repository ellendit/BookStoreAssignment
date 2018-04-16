package bookstore;

public class NullUser extends AbstractUser{

	 @Override
	   public String getUsername() {
	      return "Not Available in User Database";
	   }

	   @Override
	   public boolean isNil() {
	      return true;
	   }
	
}
