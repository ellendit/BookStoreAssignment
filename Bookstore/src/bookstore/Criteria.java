package bookstore;

import java.util.List;

public interface Criteria {
	public List<Book> meetCriteria(List<Book> books);

}
