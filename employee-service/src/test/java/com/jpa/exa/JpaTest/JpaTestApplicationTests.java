package com.jpa.exa.JpaTest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jpa.employeeservice.entity.Employee;


public class JpaTestApplicationTests {
	
public static void main(String[] args) throws URISyntaxException {
	RestTemplate template = new RestTemplate();
	final String baseUrl = "http://localhost:8086/employee";
	URI uri = new URI(baseUrl);

//Employee employee = new Employee(null, "Seva", 30, "M", LocalDate.now(),LocalDateTime.now(),"AR12326");

	ResponseEntity<String> result = template.postForEntity(uri, null,
			String.class);
	System.out.println(result);
}


}
