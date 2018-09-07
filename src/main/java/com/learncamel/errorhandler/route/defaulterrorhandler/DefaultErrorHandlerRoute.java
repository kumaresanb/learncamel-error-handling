package com.learncamel.errorhandler.route.defaulterrorhandler;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import com.learncamel.errorhandler.bean.DataModifier;

public class DefaultErrorHandlerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		
		 //errorHandler(defaultErrorHandler());
  		 //errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliverDelay(3000).retryAttemptedLogLevel(LoggingLevel.WARN));
  		 errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliverDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.WARN));
		 from("direct:exception")
         .bean(new DataModifier(), "map")
         .to("log:?level=INFO&showBody=true")
         .to("mock:errorqueue");
	}

}
