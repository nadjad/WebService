package dao;

import java.util.HashMap;
import java.util.Map;

import model.Book;

public enum BookDAO {
	instance;

	private Map<String, Book> contentProvider = new HashMap<String, Book>();

	private BookDAO() {

		Book book = new Book("1", "Rest for dummies", "Learn REST");
		contentProvider.put("1", book);
		Book book2 = new Book("2", "Learn Rest", "Learn REST");
		contentProvider.put("1", book);
		contentProvider.put("2", book2);

	}

	public Map<String, Book> getModel() {
		return contentProvider;
	}

}
