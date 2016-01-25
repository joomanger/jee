package com.isd.test;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.junit.Assert;
import org.junit.Test;

public class UriBuilderTest {
	@Test
	public void uriBuilder() {

		URI uri = UriBuilder.fromUri("http://localhost:8080").path("book").queryParam("title", "Hello_World")
				.queryParam("author", "Jordan").build();
		Assert.assertEquals("http://localhost:8080/book?title=Hello_World&author=Jordan", uri.toString());
		System.out.println(uri.toString());

		uri = UriBuilder.fromUri("http://localhost:8080").path("book").matrixParam("title", "Hello_World")
				.matrixParam("author", "Gordon").build();
		Assert.assertEquals("http://localhost:8080/book;title=Hello_World;author=Gordon", uri.toString());
		System.out.println(uri.toString());
		// throw new IllegalAccessError();
	}
}
