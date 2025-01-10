package com.test;

import com.test.model.ProgrammingJoke;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
public class SpringApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiTestApplication.class, args);

		String url = "https://v2.jokeapi.dev/joke/Programming";

		HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE)));
		WebClient.Builder builder = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient));

		ProgrammingJoke programmingJoke = builder.build()
				.get()
				.uri(url)
				.retrieve()
				.bodyToMono(ProgrammingJoke.class)
				.block();


		System.out.println(programmingJoke);
	}

}
