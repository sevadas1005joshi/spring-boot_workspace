package com.jpa.employeeservice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<LocalDateTime>{

	@Override
	 public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			    throws IOException, JsonProcessingException {
		
				String dateString = jp.getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			    return LocalDateTime.parse(dateString, formatter);
			  }

}
