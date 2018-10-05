package com.learncamel.errorhandler.route.onexception.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.errorhandler.route.onexception.OnExceptionHandlerRoute;

public class OnExceptionHandlerRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new OnExceptionHandlerRoute();
	}

	@Test(expected = RuntimeException.class)
	public void onExceptionTest() {
		String expectedOutput = "323*kumar*12SEP2018";
		String input = null;
		String output = template.requestBody("direct:exception", input, String.class);
		assertEquals(expectedOutput, output);
	}

	@Test
	public void onExceptionHandeldTest() {
		String request = null;
		String expected = "Exception happened in the route.";
		String responce = template.requestBody("direct:exception", request, String.class);
		assertEquals(expected, responce);
	}

	@Test
	public void onExceptionCheck_ignored() {
		String request = null;
		String expected = null;
		final String responce = template.requestBody("direct:exception", request, String.class);
		System.out.println("Responce is :" + responce);
		assertEquals(expected, responce);
	}
}
