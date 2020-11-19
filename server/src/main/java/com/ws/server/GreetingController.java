package com.ws.server;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/state")
	public List<State> state(@RequestParam(value = "abbreviation", defaultValue = "") String abbreviation) {

		ObjectMapper mapper = new ObjectMapper();
		List<State> stateList = new ArrayList();
		List<State> oneList = new ArrayList();
		
		try {
			// JSON file to Java object
		   stateList = mapper.readValue(new File("C:\\Users\\tbrichacek\\Documents\\workspace-spring-tool-suite-4-4.4.2.RELEASE\\server\\src\\main\\resources\\state.json"), new TypeReference<List<State>>() {});
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		if (abbreviation.equals("")) {
			return stateList;
		}
		else {
			for (State s : stateList) {
				if(s.getAbbreviation().equals(abbreviation)) {
					oneList.add(s);
				}
			}
			return oneList;
		}
	}
	
	@GetMapping("/tim")
	public List<Merchant> merchant(@RequestParam(value = "name", defaultValue = "") String name) {

		ObjectMapper mapper = new ObjectMapper();
		List<Merchant> merchantList = new ArrayList();
		List<Merchant> oneList = new ArrayList();
		
		try {
			// JSON file to Java object
		   merchantList = mapper.readValue(new File("C:\\Users\\tbrichacek\\Documents\\workspace-spring-tool-suite-4-4.4.2.RELEASE\\server\\src\\main\\resources\\merchant.json"), new TypeReference<List<Merchant>>() {});
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		if (name.equals("")) {
			for (Merchant m : merchantList) {
				System.out.print(m.toString());
			}
			
			return merchantList;
		}
		else {
			for (Merchant m : merchantList) {
				if(m.getName().equals(name)) {
					oneList.add(m);
				}
			}
			return oneList;
		}
	}
}