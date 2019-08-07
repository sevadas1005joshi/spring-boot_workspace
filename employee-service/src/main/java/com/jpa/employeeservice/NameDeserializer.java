package com.jpa.employeeservice;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NameDeserializer extends JsonDeserializer<String>{

	@Override
	public String deserialize(JsonParser p, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
	String firstTwoChars = p.getText().substring(0, 2);
	if(firstTwoChars.equalsIgnoreCase("AR")){
		return p.getText();
	}else{
		throw new RuntimeException("Invalid Name format");
	}
	}

}
