package bookstore;

import java.util.ArrayList;
import java.util.List;

public class CriteriaAuthor implements Criteria{

	@Override
	public List<Book> meetCriteria(List<Book> books){
		List<Book> authorBooks = new ArrayList<Book>();
		
		for (Book book: books) {
			if(book.getAuthor().equalsIgnoreCase("Roddy Doyle")) {
				authorBooks.add(book);
			}
		}
		return authorBooks;
	}
}
