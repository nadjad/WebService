package model;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import dao.BookDAO;

public class BookResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;

	public BookResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}

	// Application integration
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Book getBook() {
		Book book = BookDAO.instance.getModel().get(id);
		if (book == null)
			throw new RuntimeException("Get: book with " + id + " not found");
		return book;
	}

	// for the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public Book getBookHTML() {
		Book book = BookDAO.instance.getModel().get(id);
		if (book == null)
			throw new RuntimeException("Get: book with " + id + " not found");
		return book;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putBook(JAXBElement<Book> book) {
		Book b = book.getValue();
		return putAndGetResponse(b);
	}

	@DELETE
	public void deleteBook() {
		Book b = BookDAO.instance.getModel().remove(id);
		if (b == null)
			throw new RuntimeException("Delete: Todo with " + id + " not found");
	}

	private Response putAndGetResponse(Book book) {
		Response res;
		if (BookDAO.instance.getModel().containsKey(book.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		BookDAO.instance.getModel().put(book.getId(), book);
		return res;
	}
}
