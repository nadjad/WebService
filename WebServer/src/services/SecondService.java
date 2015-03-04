package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Book;

@Path("/book")
public class SecondService {
	// This method is called if XMLis request
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Book getXML() {
		Book book = new Book();
		book.setTitle("Gone with the wind");
		book.setAuthor("Margaret Mitchell");
		return book;
	}

	// This can be used to test the integration with the browser
	@GET
	@Produces({ MediaType.TEXT_XML })
	public Book getHTML() {
		Book book = new Book();
		book.setTitle("Gone with the wind");
		book.setAuthor("Margaret Mitchell");
		return book;
	}
}
