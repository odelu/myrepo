package com.realpage.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

	@GetMapping("/hello")
	public String getWish() {
		return "welcome to Test application";
	}
}
