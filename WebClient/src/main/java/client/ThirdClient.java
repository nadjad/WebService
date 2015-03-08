package client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class ThirdClient {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		// WebResource target = client.resource(getBaseURI());
		// create one todo
		model.Book book = new model.Book("7", "morometii", "un gushter");
		// ClientResponse response =
		// target.path("rest").path("todos").path(book.getId()).request()
		// .accept(MediaType.APPLICATION_XML).put(ClientResponse.class, book);
		//
		// Response response =
		// target.path("rest").path("book").request().accept(MediaType.TEXT_PLAIN).get(Response.class);

		// Return code should be 201 == created resource
		// System.out.println(response.getStatus());
		// Get the Todos
		System.out.println(target.path("rest").path("books").request().accept(MediaType.TEXT_XML).get(String.class));
		// Get JSON for application
		// System.out.println(target.path("rest").path("books").request().accept(MediaType.APPLICATION_JSON)
		// .get(String.class));
		// Get XML for application
		System.out.println(target.path("rest").path("books").request().accept(MediaType.APPLICATION_XML)
				.get(String.class));

		// Get the Todo with id 1
		System.out.println(target.path("rest").path("books/1").request().accept(MediaType.APPLICATION_XML)
				.get(String.class));
		// get Todo with id 1
		target.path("rest").path("books/1").request().delete();
		// Get the all todos, id 1 should be deleted
		System.out.println(target.path("rest").path("books").request().accept(MediaType.APPLICATION_XML)
				.get(String.class));

		// create a Todo
		// Form form = new Form();
		// form.add("id", "4");
		// form.add("summary", "Demonstration of the client lib for forms");
		// response =
		// target.path("rest").path("todos").type(MediaType.APPLICATION_FORM_URLENCODED)
		// .post(ClientResponse.class, form);
		// System.out.println("Form response " +
		// response.getEntity(String.class));
		// // Get the all todos, id 4 should be created
		System.out.println(target.path("rest").path("books").request().accept(MediaType.APPLICATION_XML)
				.get(String.class));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/WebServer").build();
	}
}
