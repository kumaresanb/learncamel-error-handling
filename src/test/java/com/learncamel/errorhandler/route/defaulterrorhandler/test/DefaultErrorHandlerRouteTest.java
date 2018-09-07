package com.learncamel.errorhandler.route.defaulterrorhandler.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.errorhandler.route.defaulterrorhandler.DefaultErrorHandlerRoute;

public class DefaultErrorHandlerRouteTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new DefaultErrorHandlerRoute();
	}
	
	@Test(expected=RuntimeException.class)
	public void exceptionCheck() {
		String expectedOutput="323*kumar*12SEP2018";
		String input=null;
		String output=template.requestBody("direct:exception",input,String.class);
		assertEquals(expectedOutput,output);
	}

}
