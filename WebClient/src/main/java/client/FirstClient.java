package client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class FirstClient {
	public static void main(String[] args) {

		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());

		Response response = target.path("rest").path("book").request()
				.accept(MediaType.TEXT_PLAIN).get(Response.class);
		System.out.println(response.toString());

		// String respPlain = target.path("rest").path("book").request()
		// .accept(MediaType.TEXT_PLAIN).get(String.class);
		// System.out.println(respPlain);

		String respXml = target.path("rest").path("book").request()
				.accept(MediaType.TEXT_XML).get(String.class);
		System.out.println(respXml);

		// String respHtml = target.path("rest").path("book").request()
		// .accept(MediaType.TEXT_HTML).get(String.class);
		// System.out.println(respHtml);
	}

	private static URI getBaseURI() {

		return UriBuilder.fromUri("http://localhost:8080/WebServer").build();

	}
}
