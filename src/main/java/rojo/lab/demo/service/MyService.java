package rojo.lab.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import rojo.lab.demo.annotation.ApiGenTag;

@Service
public class MyService {
	@ApiGenTag(path="/hello",method = RequestMethod.POST)
	public String handle() {
		return "Hello";
	}
}
