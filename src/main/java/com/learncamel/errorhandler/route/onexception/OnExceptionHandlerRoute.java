package com.learncamel.errorhandler.route.onexception;

import java.sql.SQLException;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import com.learncamel.errorhandler.bean.DataModifier;
import com.learncamel.errorhandler.processor.GenerateErrorResponseProcessor;

public class OnExceptionHandlerRoute  extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//onException(RuntimeException.class,Exception.class).maximumRedeliveries(2).redeliverDelay(5000).backOffMultiplier(2).log(LoggingLevel.INFO, "Exception in Bean caught here");
	
		onException(SQLException.class).log(LoggingLevel.INFO, "Exception in Bean caught here");
		onException(RuntimeException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new GenerateErrorResponseProcessor()).log(LoggingLevel.WARN, "Exception in Processor caught here");
		onException(RuntimeException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new GenerateErrorResponseProcessor()).to("kafka:errortopic").log(LoggingLevel.WARN, "Exception in Processor caught here");

		
		

        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");

	}

}
