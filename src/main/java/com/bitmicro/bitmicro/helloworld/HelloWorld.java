package com.bitmicro.bitmicro.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping(path= "/hello-world")
	public String hello()
	{
		return "Hello 8bitmiCro";
	}
	
	@GetMapping(path= "/hello-world-bean")
	public HelloWorldBean helloworldbean()
	{
		return new HelloWorldBean("8 bit micro");
	}
	
	@GetMapping(path= "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloworldpathvaribale(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("8 bit micro, %s",name));
	}
}
